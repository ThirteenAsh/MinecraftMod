package com.besson.thirteenash.mixin;

import com.besson.thirteenash.effects.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class WoodenSwordSkillMixin {
    // 技能效果持续时间。Minecraft 20 tick = 1秒；这里是 5 秒
    private static final int SKILL_DURATION_TICKS = 20 * 5;
    // 技能冷却时间。这里是 10秒；如果想让效果和冷却不同步，只改这个值即可。
    private static final int SKILL_COOLDOWN_TICKS = 20 * 10;

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void minecraftEnhancedMod$useWoodenSwordSkill(World world, PlayerEntity user, Hand hand,
                                                          CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (!stack.isOf(Items.WOODEN_SWORD)) {
            return;
        }

        if (user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
            cir.setReturnValue(TypedActionResult.fail(stack));
            return;
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.WOODEN_SWORD_BATTLE_FOCUS,
                    SKILL_DURATION_TICKS,
                    // 状态效果等级。0 表示一级；本技能的具体数值写在 ModStatusEffects 的属性修饰器里。
                    0,
                    false,
                    true,
                    true));
        }

        user.getItemCooldownManager().set(stack.getItem(), SKILL_COOLDOWN_TICKS);
        cir.setReturnValue(TypedActionResult.success(stack, world.isClient()));
    }
}
