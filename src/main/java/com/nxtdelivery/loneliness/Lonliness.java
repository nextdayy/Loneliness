package com.nxtdelivery.loneliness;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import com.nxtdelivery.loneliness.command.LonelyCommand;
import com.nxtdelivery.loneliness.config.LonelyConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

@net.minecraftforge.fml.common.Mod(modid = Lonliness.MODID, name = Lonliness.NAME, version = Lonliness.VERSION)
public class Lonliness {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static Lonliness INSTANCE;
    public LonelyConfig config;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void onFMLInitialization(net.minecraftforge.fml.common.event.FMLInitializationEvent event) {
        config = new LonelyConfig();
        CommandManager.INSTANCE.registerCommand(LonelyCommand.class);
    }


    public static boolean shouldHideEntity(Entity entity) {
        if (!LonelyConfig.hideSelf && entity instanceof EntityPlayer) {
            if (Minecraft.getMinecraft().thePlayer == null) return false;
            final EntityPlayer player = (EntityPlayer) entity;
            if (!player.getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
                return true;
            }
        }
        switch (LonelyConfig.hideMode) {
            default:
            case 0:
                return false;
            case 1:
                return !(entity instanceof EntityPlayer);
            case 2:
                return entity instanceof EntityLiving;
            case 3:
                return true;
        }
    }
}
