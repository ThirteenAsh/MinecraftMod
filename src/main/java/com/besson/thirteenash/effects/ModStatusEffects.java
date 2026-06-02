package com.besson.thirteenash.effects;

import com.besson.thirteenash.MinecraftEnhancedMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    // 木剑技能：攻击速度 +35%。0.35D 对应 +35%；测试时可改为 0.10D、0.50D 等。
    private static final double WOODEN_SWORD_ATTACK_SPEED_BONUS = 0.35D;
    // 木剑技能：移动速度 +5%。0.05D 对应 +5%；测试时可改为 0.15D 等。
    private static final double WOODEN_SWORD_MOVEMENT_SPEED_BONUS = 0.05D;
    // 状态效果颜色，显示在物品栏效果图标背景等位置；不影响技能数值。
    private static final int WOODEN_SWORD_BATTLE_FOCUS_COLOR = 0xC28F3C;

    // 石剑技能“蓄力”的状态效果颜色；不影响技能数值。
    private static final int STONE_SWORD_CHARGE_COLOR = 0x8C8C8C;

    public static final StatusEffect WOODEN_SWORD_BATTLE_FOCUS = new WoodenSwordBattleFocusStatusEffect();
    public static final StatusEffect STONE_SWORD_CHARGE = new StoneSwordChargeStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "wooden_sword_battle_focus"),
                WOODEN_SWORD_BATTLE_FOCUS);
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "stone_sword_charge"),
                STONE_SWORD_CHARGE);
    }

    private static class WoodenSwordBattleFocusStatusEffect extends StatusEffect {
        private WoodenSwordBattleFocusStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, WOODEN_SWORD_BATTLE_FOCUS_COLOR);
            addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                    "d3d6ac8e-fac7-4bb4-b32f-fbba94062062",
                    WOODEN_SWORD_ATTACK_SPEED_BONUS,
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
            addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    "c4f32d91-2416-4c60-8414-f9142996b759",
                    WOODEN_SWORD_MOVEMENT_SPEED_BONUS,
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        }
    }

    private static class StoneSwordChargeStatusEffect extends StatusEffect {
        private StoneSwordChargeStatusEffect() {
            super(StatusEffectCategory.BENEFICIAL, STONE_SWORD_CHARGE_COLOR);
        }
    }
}
