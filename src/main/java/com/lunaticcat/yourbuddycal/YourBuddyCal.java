package com.lunaticcat.yourbuddycal;

import com.lunaticcat.yourbuddycal.client.ClientProxy;
import com.lunaticcat.yourbuddycal.entity.YBCEntityTypes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(YourBuddyCal.MOD_ID)
public class YourBuddyCal {
    public static final String MOD_ID = "yourbuddycal";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public YourBuddyCal(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        YBCEntityTypes.registerPlacements();
    }
    private void serverSetup(final FMLDedicatedServerSetupEvent event){
        LOGGER.info("YourBuddyCal server setup");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ClientProxy.init();
    }
}
