package com.besson.thirteenash.datagen;

import com.besson.thirteenash.block.ModBlocks;
import com.besson.thirteenash.items.ModItemGroups;
import com.besson.thirteenash.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.CHAROITE_ORE, "紫龙晶矿石");

        translationBuilder.add(ModItems.CHAROITE, "紫龙晶");
        translationBuilder.add(ModItems.EXAMPLE_ITEM, "示例物品");
        translationBuilder.add(ModItems.ICON, "图标");
        translationBuilder.add(ModItems.CHERRY, "樱桃");
        translationBuilder.add(ModItems.CHAROITE_SWORD, "紫龙晶剑");
        translationBuilder.add(ModItems.RAINBOW, "彩虹");
        translationBuilder.add(ModItems.REDSTONE_SHOVEL, "红石铲");

        translationBuilder.add(ModItemGroups.FOOD_GROUP, "食物");
        translationBuilder.add(ModItemGroups.OTHER_GROUP, "其他物品");
        translationBuilder.add((ModItemGroups.TOOLS_GROUP), "工具");
        translationBuilder.add(ModItemGroups.TOTAL_GROUP, "所有项");
    }
}