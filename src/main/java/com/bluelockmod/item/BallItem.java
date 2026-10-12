package com.bluelockmod.item;

import com.bluelockmod.entity.BallEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/** Clique direito = chutar a bola. */
public class BallItem extends Item {

    public BallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.6f, 0.8f);

        if (!world.isClient) {
            BallEntity ball = new BallEntity(world, player);
            ball.setItem(stack);
            ball.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 2.0f, 0.5f);
            world.spawnEntity(ball);
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        stack.decrementUnlessCreative(1, player);
        return TypedActionResult.success(stack, world.isClient());
    }
}
