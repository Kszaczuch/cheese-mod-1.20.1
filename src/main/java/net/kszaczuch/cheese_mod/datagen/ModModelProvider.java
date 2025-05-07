package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLACK_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT   , Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHEESE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_TEMPLATE, Models.GENERATED);
    }
}
