 package com.besson.thirteenash;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.besson.thirteenash.block.ModBlocks.registerModBlocks;
import static com.besson.thirteenash.items.ModItemGroups.registerItemGroups;
import static com.besson.thirteenash.items.ModItems.registerItems;

 public class MinecraftEnhancedMod implements ModInitializer {
	public static final String MOD_ID = "minecraft_enhanced_mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		registerItems();
		registerItemGroups();
		registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}