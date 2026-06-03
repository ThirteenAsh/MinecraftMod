package com.besson.thirteenash.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedingStatusEffect extends StatusEffect {
    // 流血效果颜色；不影响技能数值。
    private static final int COLOR = 0xA10F0F;
    // 流血每秒结算一次。Minecraft 20 tick = 1秒。
    private static final int DAMAGE_INTERVAL_TICKS = 20;
    // 目标近似静止时，流血每秒造成的伤害。
    private static final float STILL_DAMAGE = 0.5F;
    // 目标移动时，流血每秒造成的伤害。
    private static final float MOVING_DAMAGE = 1.0F;
    // 水平速度平方超过该值时视为“移动”。调大可降低轻微抖动触发移动伤害的概率。
    private static final double MOVEMENT_THRESHOLD_SQUARED = 0.003D;

    public BleedingStatusEffect() {
        super(StatusEffectCategory.HARMFUL, COLOR);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % DAMAGE_INTERVAL_TICKS == 1;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) {
            return;
        }

        float damage = entity.getVelocity().horizontalLengthSquared() > MOVEMENT_THRESHOLD_SQUARED
                ? MOVING_DAMAGE
                : STILL_DAMAGE;
        entity.damage(entity.getDamageSources().generic(), damage);
    }
}
