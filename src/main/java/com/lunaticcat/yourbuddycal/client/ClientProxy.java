package com.lunaticcat.yourbuddycal.client;
import com.lunaticcat.yourbuddycal.client.renderer.entity.YourBuddyCalEntityRenderer;
import com.lunaticcat.yourbuddycal.entity.cals.ClassicCalEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy
{

    public static void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(ClassicCalEntity.class, manager -> new YourBuddyCalEntityRenderer<>(manager, new ClassicCalEntity<>(), 2.8F));
    }
}