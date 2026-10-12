package com.bluelockmod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

/**
 * Metavisão: por 10s você enxerga todo mundo num raio de 20 blocos
 * (efeito Brilho), ganha Visão Noturna e um pouco de Velocidade.
 * Recarga de 30s.
 */
public class MetavisionItem extends Item {

    public MetavisionItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            List<LivingEntity> nearby = world.getEntitiesByClass(
                    LivingEntity.class, player.getBoundingBox().expand(20.0), e -> e != player);
            for (LivingEntity e : nearby) {
                e.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, false, false));
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, true));
            player.sendMessage(Text.translatable("message.bluelockmod.metavision"), true);
        }

        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.5f);
        player.getItemCooldownManager().set(this, 600);
        return TypedActionResult.success(stack, world.isClient());
    }
}
