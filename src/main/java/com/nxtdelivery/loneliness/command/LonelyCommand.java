package com.nxtdelivery.loneliness.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import com.nxtdelivery.loneliness.Lonliness;

@Command(value = Lonliness.MODID, description = "Access the " + Lonliness.NAME + " GUI.")
public class LonelyCommand {

    @Main
    private static void main() {
        Lonliness.INSTANCE.config.openGui();
    }
}