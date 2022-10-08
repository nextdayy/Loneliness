package com.nxtdelivery.loneliness.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import com.nxtdelivery.loneliness.Loneliness;

@Command(value = Loneliness.MODID, description = "Access the " + Loneliness.NAME + " GUI.")
public class LonelyCommand {

    @Main
    private static void main() {
        Loneliness.INSTANCE.config.openGui();
    }
}