package com.besson.thirteenash.items;

import com.besson.thirteenash.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.FoodComponent;

public class ModItems {

    // 定义樱桃的食物属性
    public static final FoodComponent CHERRY_FOOD = new FoodComponent.Builder()
            .hunger(3)                  // 恢复饥饿值 4
            .saturationModifier(0.3f)   // 饱和度 0.3
            .build();

    // 示例模组
    public static  final Item EXAMPLE_ITEM = registerItems("example_item",
            new Item(new Item.Settings().maxCount(64)));
    public static  final Item CHERRY = registerItems("cherry",
            new Item(new Item.Settings().maxCount(64)
                    .maxCount(64)            // 最大堆叠 64 个
                    .food(CHERRY_FOOD)   // 设置食物属性));
            ));

    // 基础注册方法
    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, id), item);
    }

    private static void addItemtoItemGroup(FabricItemGroupEntries entries){
        entries.add(EXAMPLE_ITEM);
        entries.add(CHERRY);

    }

    public static void registerItems(){

    }

}
