package com.skill347.firstmod.block;

import com.skill347.firstmod.FirstMod;
import com.skill347.firstmod.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block JP2_ORE = registerBlock("jp2ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE), UniformIntProvider.create(4, 10)));

    public static final Block JP2_DEEPSLATE_ORE = registerBlock("jp2deepslate_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE), UniformIntProvider.create(4, 10)));
    public static final Block JP2_BLOCK = registerBlock("jp2block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    private static void addBlocksToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(JP2_ORE);
        entries.add(JP2_DEEPSLATE_ORE);
        entries.add(JP2_BLOCK);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void ResgisterModBlocks() {
        FirstMod.LOGGER.debug("Registering modblock for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlocksToIngredientsTabItemGroup);
    }
}
