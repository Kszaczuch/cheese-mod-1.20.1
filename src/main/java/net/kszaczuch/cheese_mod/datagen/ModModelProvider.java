package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.block.custom.BlackPepperCropBlock;
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

        blockStateModelGenerator.registerCrop(ModBlocks.BLACK_PEPPER_CROP, BlackPepperCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.BLACK_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHEESE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_TEMPLATE_WITH_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOUDA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOKED_GOUDA_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEDDAR_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOKED_CHEDDAR_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AGED_CHEDDAR_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PARMESAN_SLICE, Models.GENERATED);
    }
}
