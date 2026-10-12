package com.bluelockmod.client;

import com.bluelockmod.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class BlueLockModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // desenha a bola voando usando a textura do item
        EntityRendererRegistry.register(ModEntities.BALL, FlyingItemEntityRenderer::new);
    }
}
