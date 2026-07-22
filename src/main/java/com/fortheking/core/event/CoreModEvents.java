package com.fortheking.core.event;

import com.fortheking.FortheKing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = FortheKing.MODID)
public class CoreModEvents {
    
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        FortheKing.LOGGER.info("ForTheKing Core Common Setup");
        // Initialize network packets here later via event.enqueueWork if needed, 
        // though in NeoForge 21+ Payload handlers use RegisterPayloadHandlersEvent.
    }
}
