package com.lunaticcat.yourbuddycal.data;

import com.lunaticcat.yourbuddycal.YourBuddyCal;
import com.lunaticcat.yourbuddycal.data.loot_table.YourBuddyCalLootTableProvider;
import com.lunaticcat.yourbuddycal.data.recipe.YourBuddyCalRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = YourBuddyCal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class YourBuddyCalData
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();

        if(event.includeServer())
        {
            gen.addProvider(new YourBuddyCalBlockTagsProvider(gen));
            gen.addProvider(new YourBuddyCalItemTagsProvider(gen));
            gen.addProvider(new YourBuddyCalFluidTagsProvider(gen));
            gen.addProvider(new YourBuddyCalEntityTypeTagsProvider(gen));

            gen.addProvider(new YourBuddyCalRecipeProvider(gen));

            gen.addProvider(new YourBuddyCalLootTableProvider(gen));
            gen.addProvider(new YBCAvancementProvider(gen));
            gen.addProvider(new YourBuddyCalEnUsLanguageProvider(gen));
        }
    }
}