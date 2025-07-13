package net.purpleguy.longspoon.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purpleguy.longspoon.LongSpoon;
import net.purpleguy.longspoon.item.custom.LongSpoonItem;

public class ModItems {
    public static final Item LONG_STICK = registerItem("long_stick", new Item(new FabricItemSettings()));
    public static final Item LONG_SPOON = registerItem("long_spoon",
            new LongSpoonItem(new FabricItemSettings().maxDamage(100)));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(LONG_STICK);

    }


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(LongSpoon.MOD_ID, name), item);

    }

    public static void registerModItems()
    {
        LongSpoon.LOGGER.info("Registering Mod Items For " + LongSpoon.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
