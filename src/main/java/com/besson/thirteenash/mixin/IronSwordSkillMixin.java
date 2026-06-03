package com.besson.thirteenash.mixin;

import com.besson.thirteenash.effects.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class IronSwordSkillMixin {
    // 铁剑技能“利刃”有效时间。Minecraft 20 tick = 1秒；这里是 6秒。
    private static final int SHARP_BLADE_DURATION_TICKS = 20 * 6;
    // 铁剑技能冷却时间。这里是 12秒。
    private static final int SKILL_COOLDOWN_TICKS = 20 * 12;

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void minecraftEnhancedMod$useIronSwordSkill(World world, PlayerEntity user, Hand hand,
                                                        CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (!stack.isOf(Items.IRON_SWORD)) {
            return;
        }

        if (user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
            cir.setReturnValue(TypedActionResult.fail(stack));
            return;
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.IRON_SWORD_SHARP_BLADE,
                    SHARP_BLADE_DURATION_TICKS,
                    0,
                    false,
                    true,
                    true));
            // 利刃激活音效：使用暴击音效，音量/音调可按手感微调。
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, user.getSoundCategory(), 0.8F, 1.15F);
        }

        user.getItemCooldownManager().set(stack.getItem(), SKILL_COOLDOWN_TICKS);
        cir.setReturnValue(TypedActionResult.success(stack, world.isClient()));
    }
}
