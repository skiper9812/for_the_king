package com.fortheking.core.init;

import com.fortheking.FortheKing;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class CoreEntityTags {

    // These tags map directly to the old datapack `#system:<name>` tags.
    // They are now placed in the `fortheking` namespace.
    public static final TagKey<EntityType<?>> ENEMIES = create("enemies");
    public static final TagKey<EntityType<?>> ANIMALS = create("animals");
    public static final TagKey<EntityType<?>> MONSTERS = create("monsters");
    public static final TagKey<EntityType<?>> MOVE = create("move");
    public static final TagKey<EntityType<?>> NOT_TARGET = create("not_target");
    public static final TagKey<EntityType<?>> NOT_FISHED = create("not_fished");
    public static final TagKey<EntityType<?>> LINN = create("linn");
    public static final TagKey<EntityType<?>> BURRIED_TREASURE = create("burried_treasure");

    private static TagKey<EntityType<?>> create(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(FortheKing.MODID, name));
    }
}
