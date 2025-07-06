package net.purpleguy.longspoon;

import net.fabricmc.api.ModInitializer;

import net.purpleguy.longspoon.item.ModItemGroups;
import net.purpleguy.longspoon.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongSpoon implements ModInitializer {
	public static final String MOD_ID = "longspoon";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

	}
}