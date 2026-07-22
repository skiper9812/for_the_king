package com.fortheking.core.init;

import com.fortheking.FortheKing;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CoreCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FortheKing.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAPONS_TAB = 
            CREATIVE_MODE_TABS.register("weapons_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.for_the_king.weapons"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            // .icon(() -> WeaponItems.SOME_WEAPON.get().getDefaultInstance()) // Set this later when we add an item
            .displayItems((parameters, output) -> {
                // Add items here later or let modules add their own items via events
            }).build());
}
