package net.kszaczuch.cheese_mod.block.custom;

import net.kszaczuch.cheese_mod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlackPepperCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);

    public BlackPepperCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    int age = state.get(AGE);
    if (age == MAX_AGE) { // Sprawdza, czy roślina jest w pełni dojrzała
        if (!world.isClient) {
            // Upuszcza pieprz
            dropStack(world, pos, new ItemStack(ModItems.BLACK_PEPPER, 4 + world.random.nextInt(5)));
            // Resetuje wiek rośliny do 3
            world.setBlockState(pos, state.with(AGE, 2), 2);
        }
        return ActionResult.SUCCESS;
    }
    return super.onUse(state, world, pos, player, hand, hit);
}

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLACK_PEPPER;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
