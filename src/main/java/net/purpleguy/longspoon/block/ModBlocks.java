package net.purpleguy.longspoon.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purpleguy.longspoon.LongSpoon;

public class ModBlocks {

    public static final Block COMPRESSED_IRON_BLOCK = registerBlock("compressed_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(10.0f, 7.0f)));


    private static Block registerBlock(String name, Block block){

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(LongSpoon.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(LongSpoon.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }

    public static void registerModBlocks(){
        LongSpoon.LOGGER.info("registering custom block for " + LongSpoon.MOD_ID);
    }
}
