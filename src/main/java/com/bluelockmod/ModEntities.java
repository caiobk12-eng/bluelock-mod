package com.bluelockmod;

import com.bluelockmod.entity.BallEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static final EntityType<BallEntity> BALL = Registry.register(
            Registries.ENTITY_TYPE,
            BlueLockMod.id("ball"),
            EntityType.Builder.<BallEntity>create(BallEntity::new, SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build("ball"));

    public static void register() {
    }
}
