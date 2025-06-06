package com.pmadev.distanceattacks.item;

import com.pmadev.distanceattacks.DistanceAttacks;
import com.pmadev.distanceattacks.item.custom.RemoteMissileDevice;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DistanceAttacks.MOD_ID);

    public static final RegistryObject<Item> REMOTE_MISSILE_DEVICE =
            ITEMS.register("remote_missile_device", () -> new RemoteMissileDevice(new Item.Properties()
                    .stacksTo(1)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
