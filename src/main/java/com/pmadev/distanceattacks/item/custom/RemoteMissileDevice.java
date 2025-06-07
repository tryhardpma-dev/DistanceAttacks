package com.pmadev.distanceattacks.item.custom;


import com.pmadev.distanceattacks.screen.InputScreenForAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RemoteMissileDevice extends Item {
    public RemoteMissileDevice(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if(pLevel.isClientSide) {
            Minecraft.getInstance().setScreen(new InputScreenForAttack());
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
