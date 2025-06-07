package com.pmadev.distanceattacks.screen;

import com.pmadev.distanceattacks.network.ModNetworking;
import com.pmadev.distanceattacks.packet.PacketServerAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class InputScreenForAttack extends Screen {
    private EditBox xField;
    private EditBox yField;
    private EditBox zField;
    private Button ConfirmBtn;
    public InputScreenForAttack(){
        super(Component.literal("Configure for you attack"));
    }

    @Override
    protected void init() {
        int midX = width / 2;
        int midY = height / 2;

        xField = new EditBox(font, midX - 50, midY - 40, 100, 20, Component.literal("X"));
        xField.setResponder(value ->{
            try{
                Integer.parseInt(value);
                xField.setTextColor(0xFFFFFF);
            } catch (NumberFormatException e){
                xField.setTextColor(0xFF5555);
            }
        });
        yField = new EditBox(font, midX - 50, midY - 10, 100, 20, Component.literal("Y"));
        yField.setResponder(value ->{
            try{
                Integer.parseInt(value);
                yField.setTextColor(0xFFFFFF);
            } catch (NumberFormatException e){
                yField.setTextColor(0xFF5555);
            }
        });
        zField = new EditBox(font, midX - 50, midY + 20, 100, 20, Component.literal("Z"));
        zField.setResponder(value ->{
            try{
                Integer.parseInt(value);
                zField.setTextColor(0xFFFFFF);
            } catch (NumberFormatException e){
                zField.setTextColor(0xFF5555);
            }
        });

        ConfirmBtn = Button.builder(Component.literal("Confirm Attack"), button -> {
            try {
                int x = Integer.parseInt(xField.getValue());
                int y = Integer.parseInt(yField.getValue());
                int z = Integer.parseInt(zField.getValue());

                ModNetworking.CHANNEL.sendToServer(new PacketServerAttack(x, y, z));
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Your coordinates: " + x + ", " + y + ", " + z));
            } catch (NumberFormatException e) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Invalid coordinates! Please enter numbers."));
            }
        }).bounds(midX - 40, midY + 50, 80, 20).build();

        addRenderableWidget(xField);
        addRenderableWidget(yField);
        addRenderableWidget(zField);
        addRenderableWidget(ConfirmBtn);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        pGuiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        pGuiGraphics.drawString(this.font, "X:", xField.getX() - 15,xField.getY() + 5,0xFFFFFF);
        pGuiGraphics.drawString(this.font, "Y:", yField.getX() - 15,yField.getY() + 5,0xFFFFFF);
        pGuiGraphics.drawString(this.font, "Z:", zField.getX() - 15,zField.getY() + 5,0xFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}