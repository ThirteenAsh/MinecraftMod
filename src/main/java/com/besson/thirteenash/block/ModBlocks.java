package com.besson.thirteenash.block;

import com.besson.thirteenash.MinecraftEnhancedMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CHAROITE_ORE = register("charoite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(MinecraftEnhancedMod.MOD_ID, id), block);
    }
    // 注册方块对应的物品
    public static  void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MinecraftEnhancedMod.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));

    }
    public static void registerModBlocks() {
    }
}
