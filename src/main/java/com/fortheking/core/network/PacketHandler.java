package com.fortheking.core.network;

import com.fortheking.FortheKing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = FortheKing.MODID)
public class PacketHandler {
    
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(FortheKing.MODID)
                .versioned("1.0.0");
                
        // Register packets here as we add them to modules
        // Example:
        // registrar.playBidirectional(
        //         MyCustomPacket.TYPE,
        //         MyCustomPacket.STREAM_CODEC,
        //         MyCustomPacket::handle
        // );
    }
}
