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
public class StoneSwordSkillMixin {
    // 石剑技能“蓄力”持续时间。Minecraft 20 tick = 1秒；这里是 5秒。
    private static final int CHARGE_DURATION_TICKS = 20 * 5;
    // 石剑技能冷却时间。这里是 10秒；测试时可以临时改短。
    private static final int SKILL_COOLDOWN_TICKS = 20 * 10;

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void minecraftEnhancedMod$useStoneSwordSkill(World world, PlayerEntity user, Hand hand,
                                                         CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (!stack.isOf(Items.STONE_SWORD)) {
            return;
        }

        if (user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
            cir.setReturnValue(TypedActionResult.fail(stack));
            return;
        }

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.STONE_SWORD_CHARGE,
                    CHARGE_DURATION_TICKS,
                    0,
                    false,
                    true,
                    true));
            // 碎骨重击释放音效：使用穿上钻石盔甲的音效；音量/音调可按手感微调。
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, user.getSoundCategory(), 0.85F, 1.0F);
        }

        user.getItemCooldownManager().set(stack.getItem(), SKILL_COOLDOWN_TICKS);
        cir.setReturnValue(TypedActionResult.success(stack, world.isClient()));
    }
}
