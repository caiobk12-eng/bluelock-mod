package com.bluelockmod;

import com.bluelockmod.item.BallItem;
import com.bluelockmod.item.MetavisionItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item BALL = register("ball",
            new BallItem(new Item.Settings().maxCount(16)));

    public static final Item CHUTEIRA = register("chuteira",
            new ArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item METAVISION = register("metavision",
            new MetavisionItem(new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, BlueLockMod.id(name), item);
    }

    public static void register() {
        // só força o carregamento da classe
    }
}
