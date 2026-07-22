package com.fortheking.systems.player;

import com.fortheking.core.data.CoreAttachments;
import com.fortheking.core.data.PlayerData;
import com.fortheking.core.engine.ILevelSystem;
import com.fortheking.core.init.FTKAttributes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

/**
 * Handles per-tick player stat updates:
 *   - Mana regeneration
 *
 * Future: buff/debuff duration timers will be handled here.
 */
public class PlayerStatSystem implements ILevelSystem {

    // Mana regenerates 1 point every MANA_REGEN_INTERVAL ticks (~4 sec at 20 TPS)
    private static final int MANA_REGEN_INTERVAL = 80;

    // Internal tick counter per system instance (shared across all players)
    private int regenTick = 0;

    @Override
    public void tickLevel(ServerLevel level) {
        regenTick++;

        boolean doRegen = (regenTick % MANA_REGEN_INTERVAL == 0);

        for (ServerPlayer player : level.players()) {
            if (player.isSpectator() || player.isCreative()) continue;

            PlayerData data = player.getData(CoreAttachments.PLAYER_DATA);
            int maxMana = (int) player.getAttributeValue(FTKAttributes.MAX_MANA);

            // Sync maxMana from attribute into PlayerData if it drifts
            if (data.getCustomMaxMana() != maxMana) {
                data.setCustomMaxMana(maxMana);
            }

            // Passive mana regen (only if not at cap)
            if (doRegen && data.getCustomMana() < maxMana) {
                data.addMana(1);
            }
        }
    }
}
