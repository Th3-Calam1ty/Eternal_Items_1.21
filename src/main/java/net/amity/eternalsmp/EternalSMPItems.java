package net.amity.eternalsmp;

import net.amity.eternalsmp.item.ModItemGroups;
import net.amity.eternalsmp.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EternalSMPItems implements ModInitializer {
	public static final String MOD_ID = "eternalsmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

	}
}