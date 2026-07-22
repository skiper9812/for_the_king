package com.fortheking.core.util;

/**
 * Static math utilities for integer-based game logic.
 * Replaces the cw_math_lite datapack's power and root functions.
 * 
 * For floating-point trig/distance, use Vanilla's {@code net.minecraft.util.Mth}
 * and {@code Entity.distanceTo()} directly.
 */
public final class FTKMath {

    private FTKMath() {
        // Utility class, no instances
    }

    /**
     * Computes {@code base^exponent} using integer arithmetic.
     * Replaces the datapack function {@code math:power}.
     *
     * @param base     the base number
     * @param exponent the exponent (must be >= 0)
     * @return base raised to the power of exponent
     */
    public static int intPow(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative, got: " + exponent);
        }
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * Computes the integer square root of a value using Newton-Raphson iteration.
     * Returns the result scaled by 100 for 2-decimal precision (e.g. sqrt(2) = 141).
     * Replaces the datapack function {@code math:root}.
     *
     * @param value the value to take the square root of (must be >= 0)
     * @return the square root scaled by 100
     */
    public static int intSqrt(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cannot take square root of negative number: " + value);
        }
        if (value == 0) {
            return 0;
        }
        // Use Java's Math.sqrt for precision, then scale to match the datapack's
        // 2-decimal-place convention (result * 100)
        return (int) Math.round(Math.sqrt(value) * 100);
    }

    /**
     * Computes the integer square root without scaling.
     * Simply returns the floor of the true square root.
     *
     * @param value the value to take the square root of (must be >= 0)
     * @return the floor of the square root
     */
    public static int intSqrtFloor(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cannot take square root of negative number: " + value);
        }
        return (int) Math.sqrt(value);
    }

    /**
     * Clamps a value between a minimum and maximum.
     *
     * @param value the value to clamp
     * @param min   the minimum bound
     * @param max   the maximum bound
     * @return the clamped value
     */
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
