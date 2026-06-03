package com.besson.thirteenash.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RainbowItem extends Item {

    public RainbowItem() {
        super(new Item.Settings()
                .maxCount(1)
                .maxDamage(3) // 耐久 3 次，可在这里调整彩虹物品可使用次数。
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int remainingUses = stack.getMaxDamage() - stack.getDamage();

        tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.rainbow.description")
                .formatted(Formatting.AQUA));
        tooltip.add(Text.translatable("tooltip.minecraft_enhanced_mod.rainbow.uses", remainingUses, stack.getMaxDamage())
                .formatted(Formatting.GRAY));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            boolean wasRaining = serverWorld.isRaining() || serverWorld.isThundering();

            if (wasRaining) {
                // 只有在下雨或打雷时才改变天气。
                serverWorld.getServer().getOverworld().setWeather(0, 0, false, false);
                user.sendMessage(Text.translatable("message.minecraft_enhanced_mod.rainbow.clear_weather"), false);

                // 消耗耐久。
                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));

                if (stack.isEmpty()) {
                    user.sendMessage(Text.translatable("message.minecraft_enhanced_mod.rainbow.used_up"), false);
                }
            } else {
                // 天气已经是晴天，不消耗耐久。
                user.sendMessage(Text.translatable("message.minecraft_enhanced_mod.rainbow.already_clear"), false);
            }
        }

        return TypedActionResult.success(stack);
    }
}
