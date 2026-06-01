package com.besson.thirteenash.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public class WoodenSwordTooltipMixin {
    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void minecraftEnhancedMod$appendWoodenSwordSkillTooltip(ItemStack stack, World world, List<Text> tooltip,
                                                                    TooltipContext context, CallbackInfo ci) {
        if (stack.isOf(Items.WOODEN_SWORD)) {
            // 木剑标签页说明文本在语言文件里，修改数值后记得同步更新对应 tooltip 文案。
            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.wooden_sword_skill").formatted(Formatting.GRAY));
        }
    }
}
