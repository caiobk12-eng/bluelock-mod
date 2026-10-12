package com.bluelockmod.entity;

import com.bluelockmod.ModEntities;
import com.bluelockmod.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/** A bola de futebol "chutada" pelo jogador. */
public class BallEntity extends ThrownItemEntity {

    public BallEntity(EntityType<? extends BallEntity> type, World world) {
        super(type, world);
    }

    public BallEntity(World world, LivingEntity owner) {
        super(ModEntities.BALL, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BALL;
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity target = result.getEntity();
        if (target instanceof LivingEntity living) {
            living.damage(getDamageSources().thrown(this, getOwner()), 6.0f);
            Vec3d v = getVelocity();
            living.takeKnockback(0.8, -v.x, -v.z);
        }
    }

    @Override
    protected void onCollision(HitResult result) {
        super.onCollision(result);
        if (!getWorld().isClient) {
            // a bola cai no chão pra você pegar de novo
            dropStack(new ItemStack(ModItems.BALL));
            discard();
        }
    }
}
