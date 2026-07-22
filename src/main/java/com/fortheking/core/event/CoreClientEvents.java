package com.fortheking.core.event;

import com.fortheking.FortheKing;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = FortheKing.MODID, value = Dist.CLIENT)
public class CoreClientEvents {
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        FortheKing.LOGGER.info("ForTheKing Core Client Setup");
    }
}
