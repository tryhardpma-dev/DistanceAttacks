package com.pmadev.distanceattacks.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketServerAttack {
    private int x;
    private int y;
    private int z;

    public PacketServerAttack(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PacketServerAttack(FriendlyByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    public void handle(Supplier<NetworkEvent.Context> context){
        context.get().enqueueWork(()->{
            ServerPlayer player = context.get().getSender();
            Level lvl = player.level();
            float powerTNT = 4.0f;
            boolean fireAfterExplosion = false;
            Level.ExplosionInteraction interaction = Level.ExplosionInteraction.TNT;
            lvl.explode(player, this.x + 0.5, this.y + 0.5, this.z + 0.5, powerTNT, interaction);
        });
        context.get().setPacketHandled(true);
    }
}
