package com.fortheking.core.init;

import com.fortheking.FortheKing;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CoreBlockEntities {
    // DeferredRegister for Block Entity Types
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FortheKing.MODID);

    // Register empty framework for now. Future custom block entities will be registered here.
}
