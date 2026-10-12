package com.bluelockmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class BlueLockMod implements ModInitializer {
    public static final String MOD_ID = "bluelockmod";

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModItems.register();
        ModEntities.register();
        ModItemGroup.register();

        // Quem estiver de chuteira ganha Velocidade II
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTicks() % 10 != 0) return;
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.CHUTEIRA)) {
                    player.addStatusEffect(new StatusEffectInstance(
                            StatusEffects.SPEED, 40, 1, true, false, true));
                }
            }
        });
    }
}
