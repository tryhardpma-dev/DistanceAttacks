package com.pmadev.distanceattacks.items;

import com.pmadev.distanceattacks.DistanceAttacks;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DistanceAttacks.MOD_ID);

    public static final RegistryObject<Item> REMOTE_MISSILE_DEVICE =
            ITEMS.register("remote_missile_device", () -> new Item(new Item.Properties()


            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
