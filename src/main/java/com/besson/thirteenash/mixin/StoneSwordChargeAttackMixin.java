package com.besson.thirteenash.mixin;

import com.besson.thirteenash.effects.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class StoneSwordChargeAttackMixin {
    // 蓄力期间攻击的基础额外伤害。
    private static final float EXTRA_DAMAGE = 1.0F;
    // 目标为亡灵生物时，再额外增加的伤害。
    private static final float UNDEAD_EXTRA_DAMAGE = 1.0F;
    // 命中后给目标施加的减速时间。Minecraft 20 tick = 1秒；这里是 2秒。
    private static final int SLOWNESS_DURATION_TICKS = 20 * 2;
    // 减速等级。0 表示缓慢 I。
    private static final int SLOWNESS_AMPLIFIER = 0;
    // 铁剑“利刃”下一次命中增加的伤害。
    private static final float IRON_SWORD_EXTRA_DAMAGE = 4.0F;
    // 铁剑命中后施加的流血时间。Minecraft 20 tick = 1秒；这里是 6秒。
    private static final int BLEEDING_DURATION_TICKS = 20 * 6;

    @Redirect(method = "attack",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    private boolean minecraftEnhancedMod$applyStoneSwordChargeDamage(Entity target, DamageSource source, float amount) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getWorld().isClient) {
            return target.damage(source, amount);
        }

        if (!(target instanceof LivingEntity livingTarget)) {
            return target.damage(source, amount);
        }

        boolean stoneSwordChargeActive = player.hasStatusEffect(ModStatusEffects.STONE_SWORD_CHARGE)
                && player.getMainHandStack().isOf(Items.STONE_SWORD);
        boolean ironSwordSharpBladeActive = player.hasStatusEffect(ModStatusEffects.IRON_SWORD_SHARP_BLADE)
                && player.getMainHandStack().isOf(Items.IRON_SWORD);

        if (!stoneSwordChargeActive && !ironSwordSharpBladeActive) {
            return target.damage(source, amount);
        }

        float modifiedAmount = amount;
        if (stoneSwordChargeActive) {
            modifiedAmount += EXTRA_DAMAGE;
            if (livingTarget.getGroup() == EntityGroup.UNDEAD) {
                modifiedAmount += UNDEAD_EXTRA_DAMAGE;
            }
        }

        if (ironSwordSharpBladeActive) {
            modifiedAmount += IRON_SWORD_EXTRA_DAMAGE;
        }

        boolean damaged = target.damage(source, modifiedAmount);
        if (!damaged) {
            return false;
        }

        if (stoneSwordChargeActive && livingTarget.isAlive()) {
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                    SLOWNESS_DURATION_TICKS,
                    SLOWNESS_AMPLIFIER,
                    false,
                    true,
                    true), player);
        }

        if (ironSwordSharpBladeActive) {
            player.removeStatusEffect(ModStatusEffects.IRON_SWORD_SHARP_BLADE);
            if (livingTarget.isAlive()) {
                livingTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEEDING,
                        BLEEDING_DURATION_TICKS,
                        0,
                        false,
                        true,
                        true), player);
            }
        }
        return damaged;
    }
}
