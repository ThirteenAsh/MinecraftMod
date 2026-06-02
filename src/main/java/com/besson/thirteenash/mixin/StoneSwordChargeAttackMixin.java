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

    @Redirect(method = "attack",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    private boolean minecraftEnhancedMod$applyStoneSwordChargeDamage(Entity target, DamageSource source, float amount) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getWorld().isClient || !player.hasStatusEffect(ModStatusEffects.STONE_SWORD_CHARGE)) {
            return target.damage(source, amount);
        }

        if (!player.getMainHandStack().isOf(Items.STONE_SWORD)) {
            return target.damage(source, amount);
        }

        if (!(target instanceof LivingEntity livingTarget)) {
            return target.damage(source, amount);
        }

        float extraDamage = EXTRA_DAMAGE;
        if (livingTarget.getGroup() == EntityGroup.UNDEAD) {
            extraDamage += UNDEAD_EXTRA_DAMAGE;
        }

        boolean damaged = target.damage(source, amount + extraDamage);
        if (damaged && livingTarget.isAlive()) {
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                    SLOWNESS_DURATION_TICKS,
                    SLOWNESS_AMPLIFIER,
                    false,
                    true,
                    true), player);
        }
        return damaged;
    }
}
