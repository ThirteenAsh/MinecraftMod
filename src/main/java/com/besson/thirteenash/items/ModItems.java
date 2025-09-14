package com.besson.thirteenash.items;

import com.besson.thirteenash.MinecraftEnhancedMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // 定义樱桃的食物属性
    public static final FoodComponent CHERRY_FOOD = new FoodComponent.Builder()
            .hunger(3)                  // 恢复饥饿值 4
            .saturationModifier(0.3f)   // 饱和度 0.3
            .build();

    // 示例模组
    public static final Item EXAMPLE_ITEM = registerItems("example_item",
            new Item(new Item.Settings().maxCount(64)));
    // 樱桃物品
    public static final Item CHERRY = registerItems("cherry",
            new Item(new Item.Settings().maxCount(64)
                    .maxCount(64)            // 最大堆叠 64 个
                    .food(CHERRY_FOOD)   // 设置食物属性));
            ));
    // 红石铲子
    public static final Item REDSTONE_SHOVEL = registerItems("redstone_shovel",
            new ShovelItem(RedstoneToolMaterial.INSTANCE, 1.5F, -3.0F,
                    new Item.Settings().maxCount(1)));
    // 彩虹物品
    public static final Item RAINBOW = new RainbowItem();
    public static void registerRainbowItems() {
        Registry.register(Registries.ITEM, new Identifier(MinecraftEnhancedMod.MOD_ID, "rainbow"), RAINBOW);
    }
    // 紫龙晶
    public static final Item CHAROITE = registerItems("charoite",
            new Item(new Item.Settings().maxCount(64)));
    // 紫龙晶剑
    public static final Item CHAROITE_SWORD = registerItems("charoite_sword",
            new SwordItem(CharoiteToolMaterial.INSTANCE, 3, -2.4F,
                    new Item.Settings().maxCount(1)));
    // 图标物品 仅作为图标使用
    public static final Item ICON = registerItems("icon",
            new Item(new Item.Settings()));

    // 基础注册方法
    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MinecraftEnhancedMod.MOD_ID, id), item);
    }


    public static void registerItems(){
        ModItems.registerRainbowItems();
    }

}
