package net.kszaczuch.cheese_mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kszaczuch.cheese_mod.CheeseMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLACK_PEPPER = registerItem("black_pepper", new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()));
    public static final Item RAW_CHEESE_BALL = registerItem("raw_cheese_ball", new Item(new FabricItemSettings()));
    public static final Item CHEESE_TEMPLATE = registerItem("cheese_template", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CheeseMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CheeseMod.LOGGER.info("Registering Mod Items");
    }
}