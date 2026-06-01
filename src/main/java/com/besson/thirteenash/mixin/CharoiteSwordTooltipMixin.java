package com.besson.thirteenash.mixin;

import com.besson.thirteenash.items.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public class CharoiteSwordTooltipMixin {
    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void minecraftEnhancedMod$appendCharoiteSwordSkillTooltip(ItemStack stack, World world, List<Text> tooltip,
                                                                      TooltipContext context, CallbackInfo ci) {
        if (stack.isOf(ModItems.CHAROITE_SWORD)) {
            // 紫龙晶剑技能说明文本在语言文件里，修改技能数值后记得同步更新对应 tooltip 文案。
            if (!Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.hold_shift")
                        .formatted(Formatting.GRAY));
                return;
            }

            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.title")
                    .formatted(Formatting.GOLD));
            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.use")
                    .formatted(Formatting.AQUA));
            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.effect")
                    .formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cost")
                    .formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cooldown")
                    .formatted(Formatting.GRAY));
        }
    }
}
