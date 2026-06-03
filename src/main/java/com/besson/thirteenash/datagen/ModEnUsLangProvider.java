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

        translationBuilder.add("tooltip.minecraft_enhanced_mod.rainbow.description",
                "Right-click during rain or thunder to clear the weather.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.rainbow.uses",
                "Uses left: %s/%s.");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.clear_weather",
                "Rainbow magic cleared the weather!");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.used_up",
                "The rainbow has been used up!");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.already_clear",
                "The weather is already clear.");

        translationBuilder.add(ModItemGroups.FOOD_GROUP, "Food Items");
        translationBuilder.add(ModItemGroups.OTHER_GROUP, "Other Items");
        translationBuilder.add(ModItemGroups.TOOLS_GROUP, "Tools");
        translationBuilder.add(ModItemGroups.TOTAL_GROUP, "All Items");

        translationBuilder.add("effect.minecraft_enhanced_mod.wooden_sword_battle_focus", "Lightness: Speed Up");
        translationBuilder.add("effect.minecraft_enhanced_mod.stone_sword_charge", "Charge: Bonus Hit");
        translationBuilder.add("effect.minecraft_enhanced_mod.iron_sword_sharp_blade", "Keen Edge: Next Hit");
        translationBuilder.add("effect.minecraft_enhanced_mod.bleeding", "Bleeding: Damage Over Time");
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

        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.hold_shift",
                "Hold Shift to view Stone Sword skill details.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.title",
                "Active Skill: Bonebreaker Smash");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.use",
                "Right-click to gain Charge for 5 seconds.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.effect",
                "While charged: attacks deal +1.0 damage and slow the target for 2 seconds.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.undead",
                "Against undead: +1.0 additional damage.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.cooldown",
                "Cooldown: 10 seconds.");

        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.hold_shift",
                "Hold Shift to view skill details.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.title",
                "Active Skill: Keen Edge");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.effect",
                "Right-click: next hit within 6s deals +4 damage.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.bleeding",
                "Bleed 6s: 0.5/s still, 1/s moving. Can kill.");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.cooldown",
                "Cooldown: 12 seconds.");

    }
}
