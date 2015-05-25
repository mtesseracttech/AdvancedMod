package com.mtesseract.advancedmod.client;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 11-05-15
 * Time: 16:07
 */
public enum Keybindings
{
    EXPLODE("key.advancedmod.explode", Keyboard.KEY_G),
    EXPLODE_BIG("key.advancedmod.explodeBig", Keyboard.KEY_H);


    private final KeyBinding keybinding;

    Keybindings(String keyName, int defaultKeyCode)
    {
        keybinding = new KeyBinding(keyName, defaultKeyCode, "key.categories.advancedmod");
    }

    public KeyBinding getKeybind()
    {
        return keybinding;
    }

    public boolean isPressed()
    {
        return keybinding.isPressed();
    }

}
