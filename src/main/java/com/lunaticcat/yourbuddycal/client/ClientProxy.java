package com.lunaticcat.yourbuddycal.client;
import com.lunaticcat.yourbuddycal.client.model.*;
import com.lunaticcat.yourbuddycal.client.renderer.entity.ShadowRenderer;
import com.lunaticcat.yourbuddycal.client.renderer.entity.YourBuddyCalEntityRenderer;
import com.lunaticcat.yourbuddycal.client.settings.YBCKeyHandler;
import com.lunaticcat.yourbuddycal.entity.EntityBigPart;
import com.lunaticcat.yourbuddycal.entity.cals.*;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy
{

    public static void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(ClassicCalEntity.class, manager -> new YourBuddyCalEntityRenderer<>(manager, new ClassicCalModel<>(), 2.8F));
        RenderingRegistry.registerEntityRenderingHandler(CalsPartEntity.class, manager -> new ShadowRenderer<>(manager, 1F));
        YBCKeyHandler.registerKeys();
    }
}