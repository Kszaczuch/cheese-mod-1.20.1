package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.SALT, RecipeCategory.MISC, ModBlocks.SALT_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHEESE_TEMPLATE, 4)
                .pattern("P P")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE_TEMPLATE)));
    }
}
