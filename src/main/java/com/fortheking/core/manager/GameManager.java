package com.fortheking.core.manager;

import com.fortheking.FortheKing;
import com.fortheking.core.engine.ILevelSystem;
import com.fortheking.core.engine.IServerSystem;
import com.fortheking.systems.traps.TrapSystem;
import com.fortheking.core.util.FTKMath;
import com.fortheking.core.util.FTKRandom;
import com.fortheking.systems.magic.MagicSystem;
import com.fortheking.systems.player.PlayerStatSystem;
import com.fortheking.systems.weapons.WeaponSystem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.minecraft.server.level.ServerLevel;

import java.util.ArrayList;
import java.util.List;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import com.fortheking.core.data.CoreAttachments;
import com.fortheking.core.data.PlayerData;

@EventBusSubscriber(modid = FortheKing.MODID)
public class GameManager {

    private static final List<IServerSystem> SERVER_SYSTEMS = new ArrayList<>();
    private static final List<ILevelSystem> LEVEL_SYSTEMS = new ArrayList<>();

    public static void registerServerSystem(IServerSystem system) {
        SERVER_SYSTEMS.add(system);
    }

    public static void registerLevelSystem(ILevelSystem system) {
        LEVEL_SYSTEMS.add(system);
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        // Replaces the legacy datapack 'system:init' load chain
        FortheKing.LOGGER.info("GameManager Initialized! Sub-systems will be loaded here.");

        // [US-04/05] Verify utility classes
        FortheKing.LOGGER.info("[FTKMath] intPow(3, 4) = {} (expected 81)", FTKMath.intPow(3, 4));
        FortheKing.LOGGER.info("[FTKMath] intSqrt(144) = {} (expected 1200)", FTKMath.intSqrt(144));
        FortheKing.LOGGER.info("[FTKRandom] nextInRange(1, 6) = {}", FTKRandom.global().nextInRange(1, 6));

        // Register default modular sub-systems
        registerLevelSystem(new PlayerStatSystem());
        registerLevelSystem(new MagicSystem());
        registerLevelSystem(new WeaponSystem());
        registerLevelSystem(new TrapSystem());

        FortheKing.LOGGER.info("Registered {} server systems and {} level systems.", SERVER_SYSTEMS.size(), LEVEL_SYSTEMS.size());
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        // Ticks once per global server tick (20 TPS)
        for (IServerSystem system : SERVER_SYSTEMS) {
            system.tickServer(event.getServer());
        }
    }

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        // Ticks per dimension (overworld, nether, end, etc.)
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            for (ILevelSystem system : LEVEL_SYSTEMS) {
                system.tickLevel(serverLevel);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            PlayerData data = event.getEntity().getData(CoreAttachments.PLAYER_DATA);
            FortheKing.LOGGER.info("Player {} logged in. Mana: {}/{}, Spell: {}",
                    event.getEntity().getName().getString(),
                    data.getCustomMana(),
                    data.getCustomMaxMana(),
                    data.getActiveSpell());
        }
    }
}
