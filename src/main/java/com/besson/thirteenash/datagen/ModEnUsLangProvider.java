package com.besson.thirteenash.datagen;

import com.besson.thirteenash.block.ModBlocks;
import com.besson.thirteenash.items.ModItemGroups;
import com.besson.thirteenash.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
// 数据生成 用于生成语言文件
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

        translationBuilder.add("effect.minecraft_enhanced_mod.wooden_sword_battle_focus", "Lightness");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.hold_shift",
                "Hold Shift to view Lightness skill details.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.title",
                "Active Skill: Gale Slash");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.use",
                "Right-click to activate.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.effect",
                "+35% attack speed and +5% movement speed for 5 seconds.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.cooldown",
                "Cooldown: 10 seconds.");

        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.hold_shift",
                "Hold Shift to view Charoite Sword skill details.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.title",
                "Active Skill: Dragon Breath");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.use",
                "Right-click to launch a dragon fireball.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.effect",
                "The fireball flies in the direction you are looking.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cost",
                "Durability cost: 20.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cooldown",
                "Cooldown: 1 second.");

    }
}
