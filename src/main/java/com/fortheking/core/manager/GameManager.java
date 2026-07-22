package com.fortheking.core.manager;

import com.fortheking.FortheKing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@EventBusSubscriber(modid = FortheKing.MODID)
public class GameManager {

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        // Replaces the legacy datapack 'system:init' load chain
        FortheKing.LOGGER.info("GameManager Initialized! Sub-systems will be loaded here.");

        // TODO: Initialize specific modules/systems (e.g., Weapons, Magic, Quests)
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        // Replaces the legacy datapack 'system:main' tick chain
        // This ticks once per server tick (20 times a second ideally)

        // TODO: Tick sub-systems that require updates
    }
}