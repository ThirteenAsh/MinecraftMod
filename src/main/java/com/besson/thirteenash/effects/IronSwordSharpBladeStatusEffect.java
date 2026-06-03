package com.besson.thirteenash.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IronSwordSharpBladeStatusEffect extends StatusEffect {
    // 铁剑技能“利刃”的状态效果颜色；不影响技能数值。
    private static final int COLOR = 0xD8D8D8;

    public IronSwordSharpBladeStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, COLOR);
    }
}
