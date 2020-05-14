package com.lunaticcat.yourbuddycal.client;
import com.lunaticcat.yourbuddycal.client.model.*;
import com.lunaticcat.yourbuddycal.client.renderer.entity.ShadowRenderer;
import com.lunaticcat.yourbuddycal.client.renderer.entity.YourBuddyCalEntityRenderer;
import com.lunaticcat.yourbuddycal.client.settings.YBCKeyHandler;
import com.lunaticcat.yourbuddycal.entity.cals.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy
{

    public static void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(ClassicCalEntity.class, manager -> new YourBuddyCalEntityRenderer<>(manager, new ClassicCalModel<>(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(CalsPartEntity.class, manager -> new ShadowRenderer<>(manager, 1F));
        YBCKeyHandler.registerKeys();
    }
}