package com.fortheking.core.util;

import java.util.Random;

/**
 * A seedable, deterministic pseudo-random number generator.
 * Replaces the datapack functions {@code math:rng/lcg} and {@code math:rng/range}.
 *
 * The old datapack used a Linear Congruential Generator (LCG) with
 * a = 1103515245 and c = 12345 — which is the same algorithm {@link java.util.Random}
 * uses internally. This wrapper provides a cleaner API with the same deterministic behavior.
 */
public final class FTKRandom {

    private static final FTKRandom INSTANCE = new FTKRandom();

    private final Random random;

    public FTKRandom() {
        this.random = new Random();
    }

    public FTKRandom(long seed) {
        this.random = new Random(seed);
    }

    /**
     * Returns the shared global instance. Use this for general-purpose randomness.
     * For reproducible sequences, create a new {@code FTKRandom(seed)} instead.
     */
    public static FTKRandom global() {
        return INSTANCE;
    }

    /**
     * Returns a random integer in the range {@code [min, max]} (inclusive on both ends).
     * Replaces the datapack function {@code math:rng/range}.
     *
     * @param min the lower bound (inclusive)
     * @param max the upper bound (inclusive)
     * @return a random int between min and max
     */
    public int nextInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min (" + min + ") must be <= max (" + max + ")");
        }
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Returns a random integer from 0 (inclusive) to bound (exclusive).
     */
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Returns a random double between 0.0 (inclusive) and 1.0 (exclusive).
     */
    public double nextDouble() {
        return random.nextDouble();
    }

    /**
     * Returns a random boolean.
     */
    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    /**
     * Re-seeds the RNG for deterministic sequences.
     */
    public void setSeed(long seed) {
        random.setSeed(seed);
    }
}
