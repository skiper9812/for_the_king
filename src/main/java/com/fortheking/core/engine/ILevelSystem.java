package com.fortheking.core.engine;

import net.minecraft.server.level.ServerLevel;

/**
 * Interface for systems that require updating once per level tick.
 * Useful for processing dimension-specific entities, blocks, and events.
 */
public interface ILevelSystem {
    
    /**
     * Called once per level tick, for each active server dimension.
     * @param level The ServerLevel currently being ticked.
     */
    void tickLevel(ServerLevel level);
}
