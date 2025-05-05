package net.kszaczuch.cheese_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kszaczuch.cheese_mod.CheeseMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CheeseMod.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroups.items"))
                    .icon(() -> new ItemStack(ModItems.BLACK_PEPPER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BLACK_PEPPER);
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.RAW_CHEESE_BALL);
                        entries.add(ModItems.CHEESE_TEMPLATE);
    }).build());
    public static void registerModItemGroups() {
        CheeseMod.LOGGER.info("Registering Mod Item Groups");
    }
}
