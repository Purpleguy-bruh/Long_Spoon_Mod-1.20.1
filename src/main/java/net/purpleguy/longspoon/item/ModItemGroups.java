package net.purpleguy.longspoon.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.purpleguy.longspoon.LongSpoon;
import net.purpleguy.longspoon.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup LONG_SPOON_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(LongSpoon.MOD_ID, "long_spoon"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.long_spoon"))
                    .icon(() -> new ItemStack(ModItems.LONG_STICK)).entries((displayContext, entries) -> {
                        entries.add(ModItems.LONG_STICK);
                        entries.add(ModBlocks.COMPRESSED_IRON_BLOCK);
                        entries.add(ModItems.LONG_SPOON);
                    }).build());

    public static void registerItemGroups(){

        LongSpoon.LOGGER.info("Registering Item Groups For" + LongSpoon.MOD_ID);
    }
}
