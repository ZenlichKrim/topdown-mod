package com.example.topdown;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopDownMod implements ClientModInitializer {
    public static final String MOD_ID = "topdown";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        KeyBindings.register();
        LOGGER.info("[TopDown] Camera mod loaded. Press F6 to toggle.");
    }
}
