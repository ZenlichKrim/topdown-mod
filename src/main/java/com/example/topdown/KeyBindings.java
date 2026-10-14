package com.example.topdown;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public final class KeyBindings {
    public static KeyBinding toggleKey;

    private KeyBindings() {}

    public static void register() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.topdown.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F6,
                "category.topdown"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                TopDownState.toggle();
                if (client.player != null) {
                    client.player.sendMessage(
                            Text.literal("Top-Down: " + (TopDownState.isEnabled() ? "§aON" : "§cOFF")),
                            true
                    );
                }
            }
        });
    }
}
