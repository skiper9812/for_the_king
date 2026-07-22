package com.fortheking.core.init;

import com.fortheking.FortheKing;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Central registry of all custom FTK Attributes.
 * Use these constants mod-wide for attribute lookups, e.g.:
 *   player.getAttributeValue(FTKAttributes.MAX_MANA)
 */
public class FTKAttributes {

    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, FortheKing.MODID);

    // -------------------------------------------------------------------------
    // Magic
    // -------------------------------------------------------------------------

    /** Maximum mana pool. Default 100, range [0, 1000]. */
    public static final Holder<Attribute> MAX_MANA = ATTRIBUTES.register("max_mana",
            () -> new RangedAttribute("attribute.fortheking.max_mana", 100.0, 0.0, 1000.0)
                    .setSyncable(true));

    /** Scalar multiplier for all magic damage dealt. Default 1.0, range [0, 100]. */
    public static final Holder<Attribute> MAGIC_POWER = ATTRIBUTES.register("magic_power",
            () -> new RangedAttribute("attribute.fortheking.magic_power", 1.0, 0.0, 100.0)
                    .setSyncable(true));

    // -------------------------------------------------------------------------
    // Combat / Defense
    // -------------------------------------------------------------------------

    /**
     * Fully custom armor rating, independent of vanilla generic.armor.
     * Uses our own reduction formula: finalDamage = max(0, damage - floor(armorRating * 0.5))
     * Range [0, 100]. Default 0.
     */
    public static final Holder<Attribute> ARMOR_RATING = ATTRIBUTES.register("armor_rating",
            () -> new RangedAttribute("attribute.fortheking.armor_rating", 0.0, 0.0, 100.0)
                    .setSyncable(true));

    // -------------------------------------------------------------------------
    // Registration
    // -------------------------------------------------------------------------

    /**
     * Called from the mod constructor. Registers the DeferredRegister and
     * manually attaches the EntityAttributeModificationEvent listener to the
     * mod event bus (required because IModBusEvent must use modEventBus.addListener
     * in NeoForge 26.x rather than the @EventBusSubscriber shortcut).
     */
    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
        modEventBus.addListener(FTKAttributes::onAttributeModification);
    }

    @SuppressWarnings("unchecked")
    private static void onAttributeModification(EntityAttributeModificationEvent event) {
        event.add(EntityTypes.PLAYER, MAX_MANA);
        event.add(EntityTypes.PLAYER, MAGIC_POWER);
        event.add(EntityTypes.PLAYER, ARMOR_RATING);
    }
}
