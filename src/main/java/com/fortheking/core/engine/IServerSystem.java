package com.fortheking.core.engine;

import net.minecraft.server.MinecraftServer;

/**
 * Interface for systems that require updating once per global server tick.
 */
public interface IServerSystem {
    
    /**
     * Called once per server tick.
     * @param server The Minecraft Server instance.
     */
    void tickServer(MinecraftServer server);
}
