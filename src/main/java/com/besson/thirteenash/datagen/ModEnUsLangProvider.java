package com.besson.thirteenash.datagen;

import com.besson.thirteenash.block.ModBlocks;
import com.besson.thirteenash.items.ModItemGroups;
import com.besson.thirteenash.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.CHAROITE_ORE, "Charoite Ore");

        translationBuilder.add(ModItems.CHAROITE, "Charoite");
        translationBuilder.add(ModItems.EXAMPLE_ITEM, "Example Item");
        translationBuilder.add(ModItems.ICON, "Icon");
        translationBuilder.add(ModItems.CHERRY, "Cherry");
        translationBuilder.add(ModItems.CHAROITE_SWORD, "Charoite Sword");
        translationBuilder.add(ModItems.RAINBOW, "Rainbow");
        translationBuilder.add(ModItems.REDSTONE_SHOVEL, "Redstone Shovel");

        translationBuilder.add(ModItemGroups.FOOD_GROUP, "Food Items");
        translationBuilder.add(ModItemGroups.OTHER_GROUP, "Other Items");
        translationBuilder.add(ModItemGroups.TOOLS_GROUP, "Tools");
        translationBuilder.add(ModItemGroups.TOTAL_GROUP, "All Items");

    }
}