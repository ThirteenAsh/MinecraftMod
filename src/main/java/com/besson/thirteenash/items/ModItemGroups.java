package com.besson.thirteenash.items;

import com.besson.thirteenash.MinecraftEnhancedMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {

    public static final RegistryKey<ItemGroup> TOOLS_GROUP = register("tools_group");
    public static final RegistryKey<ItemGroup> OTHER_GROUP = register("other_group");
    public static final RegistryKey<ItemGroup> FOOD_GROUP = register("other_group");
    public static final RegistryKey<ItemGroup> TOTAL_GROUP = register("other_group");
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MinecraftEnhancedMod.MOD_ID, id));
    }
    // 总分类
    public static void totalGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                TOTAL_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.minecraft_enhanced_mod.total_group"))
                        .icon(() -> new ItemStack(ModItems.REDSTONE_SHOVEL))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.REDSTONE_SHOVEL);
                            entries.add(ModItems.CHERRY);
                            entries.add(ModItems.EXAMPLE_ITEM);
                        })
                        .build());
    }
    // 工具分类
    public static void registerToolsGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                TOOLS_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.minecraft_enhanced_mod.tools_group"))
                        .icon(() -> new ItemStack(ModItems.REDSTONE_SHOVEL))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.REDSTONE_SHOVEL);
                        })
                        .build());
    }
    // 其他分类
    public static void registerOtherGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                OTHER_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.minecraft_enhanced_mod.other_group"))
                        .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.CHERRY);
                            entries.add(ModItems.EXAMPLE_ITEM);
                                                    })
                        .build());
    }
    // 食物分类
    public static void registerFoodGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                FOOD_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.minecraft_enhanced_mod.food_group"))
                        .icon(() -> new ItemStack(ModItems.CHERRY))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.CHERRY);
                        })
                        .build());
    }
}

