package fi.natroutter.clickthroughreborn;

import net.fabricmc.api.ClientModInitializer;

public class ClickThroughReborn implements ClientModInitializer {
    @Override
    public void onInitializeClient() {}

    static public boolean isDyeOnSign = false;
    static public boolean needToSneakAgain = false;
}