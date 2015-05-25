package com.mtesseract.advancedmod.client;

import com.mtesseract.advancedmod.network.MessageExplode;
import com.mtesseract.advancedmod.network.NetworkHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;


/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 11-05-15
 * Time: 16:21
 */
public class KeyInputHandler
{
    private Keybindings getPressedKey()
    {
        for(Keybindings key : Keybindings.values())
        {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Keybindings key = getPressedKey();
        if(key != null)
        {
            switch(key)
            {
                case EXPLODE:
                    NetworkHandler.sendToServer(new MessageExplode(3));
                    break;
                case EXPLODE_BIG:
                    NetworkHandler.sendToServer(new MessageExplode(10));
                    break;

            }
        }
    }
}
