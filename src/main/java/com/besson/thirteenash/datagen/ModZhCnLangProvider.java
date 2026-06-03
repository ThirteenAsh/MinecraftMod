package com.besson.thirteenash.datagen;

import com.besson.thirteenash.block.ModBlocks;
import com.besson.thirteenash.items.ModItemGroups;
import com.besson.thirteenash.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
// 用于生成中文语言文件
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

        translationBuilder.add("tooltip.minecraft_enhanced_mod.rainbow.description",
                "下雨或打雷时右键使用，可以让天气放晴。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.rainbow.uses",
                "剩余次数：%s/%s。");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.clear_weather",
                "彩虹的魔法让天气变晴了！");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.used_up",
                "彩虹已经消耗完了！");
        translationBuilder.add("message.minecraft_enhanced_mod.rainbow.already_clear",
                "呐，现在要开始放晴了~");

        translationBuilder.add(ModItemGroups.FOOD_GROUP, "食物");
        translationBuilder.add(ModItemGroups.OTHER_GROUP, "其他物品");
        translationBuilder.add((ModItemGroups.TOOLS_GROUP), "工具");
        translationBuilder.add(ModItemGroups.TOTAL_GROUP, "所有项");

        translationBuilder.add("effect.minecraft_enhanced_mod.wooden_sword_battle_focus", "轻盈：攻速与移速提升");
        translationBuilder.add("effect.minecraft_enhanced_mod.stone_sword_charge", "蓄力：增伤并减速");
        translationBuilder.add("effect.minecraft_enhanced_mod.iron_sword_sharp_blade", "利刃：下次攻击强化");
        translationBuilder.add("effect.minecraft_enhanced_mod.bleeding", "流血：持续失血");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.hold_shift",
                "按住 Shift 查看技能详情。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.title",
                "主动技能：疾风斩");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.use",
                "右键释放，获得效果“轻盈”。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.effect",
                "轻盈：5秒内攻击速度+35%，移动速度+5%。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.wooden_sword_skill.cooldown",
                "冷却：10秒。");

        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.hold_shift",
                "按住 Shift 查看紫龙晶剑技能详情。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.title",
                "主动技能：龙息弹");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.use",
                "右键释放，发射一枚龙息火球。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.effect",
                "龙息火球会沿准星方向高速飞行。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cost",
                "消耗耐久：20。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.charoite_sword_skill.cooldown",
                "冷却：5秒。");

        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.hold_shift",
                "按住 Shift 查看石剑技能详情。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.title",
                "主动技能：碎骨重击");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.use",
                "右键释放，获得5秒“蓄力”效果。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.effect",
                "蓄力期间攻击额外伤害+1.0，并使目标减速2秒。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.undead",
                "对亡灵生物：额外伤害再+1.0。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.stone_sword_skill.cooldown",
                "冷却：10秒。");

        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.hold_shift",
                "按住 Shift 查看技能详情。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.title",
                "主动技能：利刃");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.effect",
                "右键激活：6秒内下次命中+4伤害。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.bleeding",
                "附加流血6秒：静止0.5/s，移动1/s，可致死。");
        translationBuilder.add("tooltip.minecraft_enhanced_mod.iron_sword_skill.cooldown",
                "冷却：12秒。");
    }
}
