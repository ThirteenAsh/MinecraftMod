package com.besson.thirteenash.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StoneSwordChargeStatusEffect extends StatusEffect {
    // 石剑技能“蓄力”的状态效果颜色；不影响技能数值。
    private static final int COLOR = 0x8C8C8C;

    public StoneSwordChargeStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, COLOR);
    }
}
