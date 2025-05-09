package net.kszaczuch.cheese_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kszaczuch.cheese_mod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class CheeseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SALT_BLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_PEPPER_CROP, RenderLayer.getCutout());

    }
}
