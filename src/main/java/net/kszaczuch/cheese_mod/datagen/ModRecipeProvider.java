package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.ShapelessRecipe;
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
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOUDA_SLICE, 4)
                        .input(ModBlocks.GOUDA_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.GOUDA_CHEESE_WHEEL), conditionsFromItem(ModBlocks.GOUDA_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.GOUDA_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SMOKED_GOUDA_SLICE, 4)
                        .input(ModBlocks.SMOKED_GOUDA_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.SMOKED_GOUDA_CHEESE_WHEEL), conditionsFromItem(ModBlocks.SMOKED_GOUDA_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.SMOKED_GOUDA_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEDDAR_SLICE, 4)
                        .input(ModBlocks.CHEDDAR_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.CHEDDAR_CHEESE_WHEEL), conditionsFromItem(ModBlocks.CHEDDAR_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEDDAR_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SMOKED_CHEDDAR_SLICE, 4)
                        .input(ModBlocks.SMOKED_CHEDDAR_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.SMOKED_CHEDDAR_CHEESE_WHEEL), conditionsFromItem(ModBlocks.SMOKED_CHEDDAR_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.SMOKED_CHEDDAR_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.AGED_CHEDDAR_SLICE, 4)
                        .input(ModBlocks.AGED_CHEDDAR_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.AGED_CHEDDAR_CHEESE_WHEEL), conditionsFromItem(ModBlocks.AGED_CHEDDAR_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.AGED_CHEDDAR_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PARMESAN_SLICE, 4)
                        .input(ModBlocks.PARMESAN_CHEESE_WHEEL)
                        .criterion(hasItem(ModBlocks.PARMESAN_CHEESE_WHEEL), conditionsFromItem(ModBlocks.PARMESAN_CHEESE_WHEEL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.PARMESAN_SLICE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE_TEMPLATE_WITH_CHEESE)
                        .input(ModItems.CHEESE_TEMPLATE)
                        .input(ModItems.RAW_CHEESE_BALL)
                        .criterion(hasItem(ModItems.CHEESE_TEMPLATE), conditionsFromItem(ModItems.CHEESE_TEMPLATE))
                        .criterion(hasItem(ModItems.RAW_CHEESE_BALL), conditionsFromItem(ModItems.RAW_CHEESE_BALL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE_TEMPLATE_WITH_CHEESE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHEESE_TEMPLATE, 4)
                .pattern("P P")
                .pattern("PPP")
                .input('P', ItemTags.PLANKS)
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE_TEMPLATE)));
    }
}
