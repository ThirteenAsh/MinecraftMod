package com.besson.thirteenash.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RainbowItem extends Item {

    public RainbowItem() {
        super(new Item.Settings()
                .maxCount(1)
                .maxDamage(3) // 耐久 3 次
        );
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            boolean wasRaining = serverWorld.isRaining() || serverWorld.isThundering();

            if (wasRaining) {
                // 只有在下雨或打雷时才改变天气
                serverWorld.getServer().getOverworld().setWeather(0, 0, false, false);
                user.sendMessage(Text.literal("彩虹的魔法让天气变晴了！"), false);

                // 消耗耐久
                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));

                if (stack.isEmpty()) {
                    user.sendMessage(Text.literal("彩虹已经消耗完了！"), false);
                }
            } else {
                // 天气已经晴天，不消耗耐久，也不显示消息
                user.sendMessage(Text.literal("现在已经是晴天了！"), false);
            }
        }

        return TypedActionResult.success(stack);
    }


}
