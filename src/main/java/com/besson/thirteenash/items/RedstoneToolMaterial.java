package com.besson.thirteenash.items;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RedstoneToolMaterial implements ToolMaterial {
    public static final RedstoneToolMaterial INSTANCE = new RedstoneToolMaterial();

    @Override
    public int getDurability() {
        return 250; // 耐久度
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0F; // 挖掘速度
    }

    @Override
    public float getAttackDamage() {
        return 1.5F; // 攻击伤害加成
    }

    @Override
    public int getMiningLevel() {
        return 2; // 铁等级 (能挖铁、金、红石)
    }

    @Override
    public int getEnchantability() {
        return 15; // 附魔能力
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.REDSTONE); // 使用红石粉修复
    }
}
