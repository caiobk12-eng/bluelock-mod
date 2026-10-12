package com.bluelockmod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static final ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BALL))
            .displayName(Text.translatable("itemGroup.bluelockmod.main"))
            .entries((context, entries) -> {
                entries.add(ModItems.BALL);
                entries.add(ModItems.CHUTEIRA);
                entries.add(ModItems.METAVISION);
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, BlueLockMod.id("main"), MAIN);
    }
}
