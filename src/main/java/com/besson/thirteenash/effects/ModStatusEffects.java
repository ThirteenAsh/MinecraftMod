package com.besson.thirteenash.effects;

import com.besson.thirteenash.MinecraftEnhancedMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect WOODEN_SWORD_BATTLE_FOCUS = new WoodenSwordBattleFocusStatusEffect();
    public static final StatusEffect STONE_SWORD_CHARGE = new StoneSwordChargeStatusEffect();
    public static final StatusEffect IRON_SWORD_SHARP_BLADE = new IronSwordSharpBladeStatusEffect();
    public static final StatusEffect BLEEDING = new BleedingStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "wooden_sword_battle_focus"),
                WOODEN_SWORD_BATTLE_FOCUS);
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "stone_sword_charge"),
                STONE_SWORD_CHARGE);
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "iron_sword_sharp_blade"),
                IRON_SWORD_SHARP_BLADE);
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(MinecraftEnhancedMod.MOD_ID, "bleeding"),
                BLEEDING);
    }
}
