package com.pmadev.distanceattacks.item;

import com.pmadev.distanceattacks.DistanceAttacks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModeCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DistanceAttacks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DISTANCE_ATTACKS_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("distance_attacks_items_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REMOTE_MISSILE_DEVICE.get()))
                            .title(Component.translatable("creativetab.distancemod.distance_attacks_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.REMOTE_MISSILE_DEVICE.get());
                            })
                            .build()
            );


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
