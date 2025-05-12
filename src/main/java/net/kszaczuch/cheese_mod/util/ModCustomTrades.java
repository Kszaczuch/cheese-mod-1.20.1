package net.kszaczuch.cheese_mod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SALT, 5),
                            new ItemStack(ModItems.BLACK_PEPPER, 5),
                            5, 1, 0.1f));
                });
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.SUGAR_CANE, 25),
                            new ItemStack(ModItems.BLACK_PEPPER, 5),
                            5, 1, 0.1f));
                });
    }
}
