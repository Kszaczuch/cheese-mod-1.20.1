package net.kszaczuch.cheese_mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kszaczuch.cheese_mod.CheeseMod;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()));
    public static final Item RAW_CHEESE_BALL = registerItem("raw_cheese_ball", new Item(new FabricItemSettings()));
    public static final Item CHEESE_TEMPLATE = registerItem("cheese_template", new Item(new FabricItemSettings()));
    public static final Item CHEESE_TEMPLATE_WITH_CHEESE = registerItem("cheese_template_with_cheese", new Item(new FabricItemSettings()));

    public static final Item BLACK_PEPPER = registerItem("black_pepper",
            new AliasedBlockItem(ModBlocks.BLACK_PEPPER_CROP, new FabricItemSettings()));

    public static final Item GOUDA_SLICE = registerItem("gouda_slice", new Item(new FabricItemSettings().food(ModFoodComponents.GOUDA_SLICE)));
    public static final Item SMOKED_GOUDA_SLICE = registerItem("smoked_gouda_slice", new Item(new FabricItemSettings().food(ModFoodComponents.SMOKED_GOUDA_SLICE)));
    public static final Item CHEDDAR_SLICE = registerItem("cheddar_slice", new Item(new FabricItemSettings().food(ModFoodComponents.CHEDDAR_SLICE )));
    public static final Item SMOKED_CHEDDAR_SLICE = registerItem("smoked_cheddar_slice", new Item(new FabricItemSettings().food(ModFoodComponents.SMOKED_CHEDDAR_SLICE)));
    public static final Item AGED_CHEDDAR_SLICE = registerItem("aged_cheddar_slice", new Item(new FabricItemSettings().food(ModFoodComponents.AGED_CHEDDAR_SLICE)));
    public static final Item PARMESAN_SLICE = registerItem("parmesan_slice", new Item(new FabricItemSettings().food(ModFoodComponents.PARMESAN_SLICE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CheeseMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CheeseMod.LOGGER.info("Registering Mod Items");
    }
}