package net.kszaczuch.cheese_mod;

import net.fabricmc.api.ModInitializer;

import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.item.ModItemGroups;
import net.kszaczuch.cheese_mod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheeseMod implements ModInitializer {

	public static final String MOD_ID = "cheesemod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();
	}
}