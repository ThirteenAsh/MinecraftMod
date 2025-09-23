package com.besson.thirteenash.datagen;

import com.besson.thirteenash.block.ModBlocks;
import com.besson.thirteenash.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHAROITE_ORE, oreDrops(ModBlocks.CHAROITE_ORE, ModItems.CHAROITE));
    }
}