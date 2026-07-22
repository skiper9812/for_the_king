package com.fortheking;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import com.fortheking.core.init.CoreCreativeTabs;
import com.fortheking.core.data.CoreAttachments;
import com.fortheking.weapons.init.WeaponBlocks;
import com.fortheking.weapons.init.WeaponItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(FortheKing.MODID)
public class FortheKing {
    public static final String MODID = "for_the_king";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FortheKing(IEventBus modEventBus, ModContainer modContainer) {
        // Register Core Systems
        CoreCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Register Modules
        WeaponBlocks.BLOCKS.register(modEventBus);
        WeaponItems.ITEMS.register(modEventBus);

        // Register Data Attachments
        CoreAttachments.ATTACHMENT_TYPES.register(modEventBus);
    }
}