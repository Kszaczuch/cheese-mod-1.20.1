package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.block.custom.BlackPepperCropBlock;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SALT_BLOCK);

        addDrop(ModBlocks.SALT_ORE, saltOreDrops(ModBlocks.SALT_ORE, ModItems.SALT));

		BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BLACK_PEPPER_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(BlackPepperCropBlock.AGE, 5));
        addDrop(ModBlocks.BLACK_PEPPER_CROP, cropDrops(ModBlocks.BLACK_PEPPER_CROP, ModItems.BLACK_PEPPER, ModItems.BLACK_PEPPER, builder));

    }
    public LootTable.Builder saltOreDrops(Block drop, Item item) {
		return dropsWithSilkTouch(
			drop,
			(LootPoolEntry.Builder<?>)this.applyExplosionDecay(
				drop,
				ItemEntry.builder(item)
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 5.0F)))
					.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
			)
		);
	}
}
