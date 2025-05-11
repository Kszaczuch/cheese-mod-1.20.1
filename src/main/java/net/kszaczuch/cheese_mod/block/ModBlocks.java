package net.kszaczuch.cheese_mod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kszaczuch.cheese_mod.CheeseMod;
import net.kszaczuch.cheese_mod.block.custom.BlackPepperCropBlock;
import net.kszaczuch.cheese_mod.block.custom.CheeseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SALT_BLOCK = registerBlock("salt_block",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque()));
    public static final Block SALT_ORE = registerBlock("salt_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));

    public static final Block BLACK_PEPPER_CROP = Registry.register(Registries.BLOCK, new Identifier(CheeseMod.MOD_ID, "black_pepper_crop"),
            new BlackPepperCropBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));

    public static final Block GOUDA_CHEESE_WHEEL = registerBlock("gouda_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));
        public static final Block SMOKED_GOUDA_CHEESE_WHEEL = registerBlock("smoked_gouda_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));
            public static final Block CHEDDAR_CHEESE_WHEEL = registerBlock("cheddar_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));
                public static final Block SMOKED_CHEDDAR_CHEESE_WHEEL = registerBlock("smoked_cheddar_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));
                public static final Block AGED_CHEDDAR_CHEESE_WHEEL = registerBlock("aged_cheddar_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));
                    public static final Block PARMESAN_CHEESE_WHEEL = registerBlock("parmesan_cheese_wheel",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CheeseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CheeseMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CheeseMod.LOGGER.info("Registering Mod Blocks");
    }
}
