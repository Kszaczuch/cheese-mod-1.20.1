package net.kszaczuch.cheese_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static void offerSmoking(Consumer<RecipeJsonProvider> consumer, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
        for (ItemConvertible input : inputs) {
            CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), category, output, experience, cookingTime, RecipeSerializer.SMOKING)
                    .createSmoking(Ingredient.ofItems(input), category, output, experience, cookingTime)
                    .group(group)
                    .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                    .offerTo(consumer, new Identifier(FabricRecipeProvider.getRecipeName(output) + "_from_smoking_" + FabricRecipeProvider.getRecipeName(input)));
        }
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer, List.of(Items.MILK_BUCKET), RecipeCategory.FOOD, ModItems.RAW_CHEESE_BALL, 0f, 9000, "cheese");
        offerSmelting(consumer, List.of(ModItems.CHEESE_TEMPLATE_WITH_CHEESE), RecipeCategory.FOOD, ModBlocks.GOUDA_CHEESE_WHEEL, 5.0f, 18000, "cheese");
        offerSmelting(consumer, List.of(ModBlocks.GOUDA_CHEESE_WHEEL), RecipeCategory.FOOD, ModBlocks.PARMESAN_CHEESE_WHEEL, 5.0f, 18000, "cheese");
        offerSmelting(consumer, List.of(ModItems.CHEESE_TEMPLATE_WITH_CHEDDAR_CHEESE), RecipeCategory.FOOD, ModBlocks.CHEDDAR_CHEESE_WHEEL, 5.0f, 18000, "cheese");
        offerSmelting(consumer, List.of(ModBlocks.CHEDDAR_CHEESE_WHEEL), RecipeCategory.FOOD, ModBlocks.AGED_CHEDDAR_CHEESE_WHEEL, 5.0f, 18000, "cheese");
        offerSmoking(consumer, List.of(ModBlocks.GOUDA_CHEESE_WHEEL), RecipeCategory.FOOD, ModBlocks.SMOKED_GOUDA_CHEESE_WHEEL, 5.0f, 9000, "cheese");
        offerSmoking(consumer, List.of(ModBlocks.CHEDDAR_CHEESE_WHEEL), RecipeCategory.FOOD, ModBlocks.SMOKED_CHEDDAR_CHEESE_WHEEL, 5.0f, 9000, "cheese");

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
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_CHEDDAR_CHEESE_BALL)
                        .input(ModItems.RAW_CHEESE_BALL)
                        .input(ModItems.SALT)
                        .input(ModItems.BLACK_PEPPER)
                        .criterion(hasItem(ModItems.RAW_CHEESE_BALL), conditionsFromItem(ModItems.RAW_CHEESE_BALL))
                        .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
                        .criterion(hasItem(ModItems.BLACK_PEPPER), conditionsFromItem(ModItems.BLACK_PEPPER))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.RAW_CHEDDAR_CHEESE_BALL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE_TEMPLATE_WITH_CHEDDAR_CHEESE)
                        .input(ModItems.CHEESE_TEMPLATE)
                        .input(ModItems.RAW_CHEDDAR_CHEESE_BALL)
                        .criterion(hasItem(ModItems.CHEESE_TEMPLATE), conditionsFromItem(ModItems.CHEESE_TEMPLATE))
                        .criterion(hasItem(ModItems.RAW_CHEDDAR_CHEESE_BALL), conditionsFromItem(ModItems.RAW_CHEDDAR_CHEESE_BALL))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE_TEMPLATE_WITH_CHEDDAR_CHEESE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHEESE_TEMPLATE, 4)
                .pattern("P P")
                .pattern("SSS")
                .input('P', ItemTags.PLANKS)
                .input('S', ItemTags.WOODEN_SLABS)
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .criterion("has_slabs", conditionsFromTag(ItemTags.WOODEN_SLABS))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHEESE_TEMPLATE)));
    }
}
