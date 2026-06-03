package com.besson.thirteenash.effects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class WoodenSwordBattleFocusStatusEffect extends StatusEffect {
    // 木剑技能：攻击速度 +35%。0.35D 对应 +35%；测试时可改为 0.10D、0.50D 等。
    private static final double ATTACK_SPEED_BONUS = 0.35D;
    // 木剑技能：移动速度 +5%。0.05D 对应 +5%；测试时可改为 0.15D 等。
    private static final double MOVEMENT_SPEED_BONUS = 0.05D;
    // 状态效果颜色，显示在物品栏效果图标背景等位置；不影响技能数值。
    private static final int COLOR = 0xC28F3C;

    public WoodenSwordBattleFocusStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, COLOR);
        addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                "d3d6ac8e-fac7-4bb4-b32f-fbba94062062",
                ATTACK_SPEED_BONUS,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "c4f32d91-2416-4c60-8414-f9142996b759",
                MOVEMENT_SPEED_BONUS,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
