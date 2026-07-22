package com.fortheking.core.init;

import com.fortheking.FortheKing;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CoreEntities {
    // DeferredRegister for Entity Types
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FortheKing.MODID);

    // Register empty framework for now. Future custom entities will be registered here.
}
