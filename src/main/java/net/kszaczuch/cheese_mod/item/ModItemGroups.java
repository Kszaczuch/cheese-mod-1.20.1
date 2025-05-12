package net.kszaczuch.cheese_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kszaczuch.cheese_mod.CheeseMod;
import net.kszaczuch.cheese_mod.block.ModBlocks;
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
                        entries.add(ModItems.RAW_CHEDDAR_CHEESE_BALL);
                        entries.add(ModItems.CHEESE_TEMPLATE);
                        entries.add(ModItems.CHEESE_TEMPLATE_WITH_CHEESE);
                        entries.add(ModItems.CHEESE_TEMPLATE_WITH_CHEDDAR_CHEESE);
                        entries.add(ModBlocks.SALT_ORE);
                        entries.add(ModBlocks.SALT_BLOCK);
                        entries.add(ModBlocks.GOUDA_CHEESE_WHEEL);
                        entries.add(ModItems.GOUDA_SLICE);
                        entries.add(ModBlocks.SMOKED_GOUDA_CHEESE_WHEEL);
                        entries.add(ModItems.SMOKED_GOUDA_SLICE);
                        entries.add(ModBlocks.CHEDDAR_CHEESE_WHEEL);
                        entries.add(ModItems.CHEDDAR_SLICE);
                        entries.add(ModBlocks.SMOKED_CHEDDAR_CHEESE_WHEEL);
                        entries.add(ModItems.SMOKED_CHEDDAR_SLICE);
                        entries.add(ModBlocks.AGED_CHEDDAR_CHEESE_WHEEL);
                        entries.add(ModItems.AGED_CHEDDAR_SLICE);
                        entries.add(ModBlocks.PARMESAN_CHEESE_WHEEL);
                        entries.add(ModItems.PARMESAN_SLICE);
    }).build());
    public static void registerModItemGroups() {
        CheeseMod.LOGGER.info("Registering Mod Item Groups");
    }
}
