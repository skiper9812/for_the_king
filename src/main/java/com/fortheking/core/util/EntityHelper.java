package com.fortheking.core.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * Shared entity utility methods.
 * 
 * For simple distance checks, prefer using the Vanilla API directly:
 * {@code entityA.distanceTo(entityB)} or {@code entityA.position().distanceTo(entityB.position())}.
 * 
 * This class provides convenience methods for patterns that appear frequently
 * across multiple modules.
 */
public final class EntityHelper {

    private EntityHelper() {
        // Utility class, no instances
    }

    /**
     * Returns the distance between two entities.
     * Thin wrapper around Vanilla's {@code Entity.distanceTo()} for readability.
     *
     * @param a first entity
     * @param b second entity
     * @return the distance between a and b
     */
    public static double distanceBetween(Entity a, Entity b) {
        return a.distanceTo(b);
    }

    /**
     * Returns the horizontal (XZ-plane) distance between two entities,
     * ignoring the Y axis. Common in the datapacks for ground-based checks.
     *
     * @param a first entity
     * @param b second entity
     * @return the horizontal distance
     */
    public static double horizontalDistanceBetween(Entity a, Entity b) {
        double dx = a.getX() - b.getX();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dz * dz);
    }

    /**
     * Gets the entity's horizontal look direction as a normalized Vec3 (Y = 0).
     * Useful for projecting movement or spawning projectiles on the XZ plane.
     *
     * @param entity the entity
     * @return a normalized Vec3 representing the horizontal look direction
     */
    public static Vec3 lookDirectionXZ(Entity entity) {
        Vec3 look = entity.getLookAngle();
        Vec3 horizontal = new Vec3(look.x, 0, look.z);
        return horizontal.normalize();
    }
}
