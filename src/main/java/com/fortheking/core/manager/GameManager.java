package com.fortheking.core.manager;

import com.fortheking.FortheKing;
import com.fortheking.core.util.FTKMath;
import com.fortheking.core.util.FTKRandom;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import com.fortheking.core.data.CoreAttachments;
import com.fortheking.core.data.PlayerData;

@EventBusSubscriber(modid = FortheKing.MODID)
public class GameManager {

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        // Replaces the legacy datapack 'system:init' load chain
        FortheKing.LOGGER.info("GameManager Initialized! Sub-systems will be loaded here.");

        // [US-04/05] Verify utility classes
        FortheKing.LOGGER.info("[FTKMath] intPow(3, 4) = {} (expected 81)", FTKMath.intPow(3, 4));
        FortheKing.LOGGER.info("[FTKMath] intSqrt(144) = {} (expected 1200)", FTKMath.intSqrt(144));
        FortheKing.LOGGER.info("[FTKRandom] nextInRange(1, 6) = {}", FTKRandom.global().nextInRange(1, 6));

        // TODO: Initialize specific modules/systems (e.g., Weapons, Magic, Quests)
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        // Replaces the legacy datapack 'system:main' tick chain
        // This ticks once per server tick (20 times a second ideally)

        // TODO: Tick sub-systems that require updates
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            // Retrieve the data attachment from the player
            PlayerData data = event.getEntity().getData(CoreAttachments.PLAYER_DATA);

            // Log the current value
            FortheKing.LOGGER.info("Player {} logged in. Custom Mana: {}/{}",
                    event.getEntity().getName().getString(),
                    data.getCustomMana(),
                    data.getCustomMaxMana());

            // Modify it slightly to test persistence across logins!
            data.setCustomMana(data.getCustomMana() - 5);
        }
    }
}
