package com.nxtdelivery.loneliness.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Checkbox;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import com.nxtdelivery.loneliness.Lonliness;

public class LonelyConfig extends Config {

    @Dropdown(
            name = "Hiding",
            description = "Entity Hiding strategy to use.",
            subcategory = "Hiding",
            options = {"Hide Nothing", "Show only Players", "Hide anything alive", "Hide EVERYTHING."}
    )
    public static int hideMode = 1;

    @Checkbox(
            name = "Hide Self",
            subcategory = "Hiding"
    )
    public static boolean hideSelf = false;

    public LonelyConfig() {
        super(new Mod(Lonliness.NAME, ModType.UTIL_QOL), Lonliness.MODID + ".json");
        initialize();
    }
}

