package net.kszaczuch.cheese_mod.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GOUDA_SLICE = new FoodComponent.Builder().hunger(10).saturationModifier(0.75F).build();
    public static final FoodComponent SMOKED_GOUDA_SLICE = new FoodComponent.Builder().hunger(12).saturationModifier(0.75F).build();
    public static final FoodComponent CHEDDAR_SLICE = new FoodComponent.Builder().hunger(14).saturationModifier(0.75F).build();
    public static final FoodComponent SMOKED_CHEDDAR_SLICE = new FoodComponent.Builder().hunger(16).saturationModifier(0.75F).build();
    public static final FoodComponent AGED_CHEDDAR_SLICE = new FoodComponent.Builder().hunger(20).saturationModifier(0.75F).build();
    public static final FoodComponent PARMESAN_SLICE = new FoodComponent.Builder().hunger(14).saturationModifier(0.75F).build();
}
