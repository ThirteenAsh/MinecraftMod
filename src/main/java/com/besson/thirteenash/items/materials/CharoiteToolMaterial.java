package com.besson.thirteenash.items.materials;

import com.besson.thirteenash.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CharoiteToolMaterial implements ToolMaterial {

    public static final CharoiteToolMaterial INSTANCE = new CharoiteToolMaterial();

    @Override
    public int getDurability() {
        return 1800; // 耐久
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0f; // 挖掘速度，可比钻石稍快
    }

    @Override
    public float getAttackDamage() {
        return 3.5f; // 基础攻击力加成，SwordItem 会再加 3
    }

    @Override
    public int getMiningLevel() {
        return 3; // 钻石等级
    }

    @Override
    public int getEnchantability() {
        return 12; // 附魔能力
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.CHAROITE); // 假设你有 Charoite 锭
    }
}
