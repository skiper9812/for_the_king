package com.fortheking.core.data;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class PlayerData {
    
    public static final MapCodec<PlayerData> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.optionalFieldOf("customMana", 100).forGetter(PlayerData::getCustomMana),
            Codec.INT.optionalFieldOf("customMaxMana", 100).forGetter(PlayerData::getCustomMaxMana),
            Codec.INT.optionalFieldOf("magicLevel", 1).forGetter(PlayerData::getMagicLevel)
    ).apply(instance, PlayerData::new));

    private int customMana;
    private int customMaxMana;
    private int magicLevel;

    public PlayerData() {
        this(100, 100, 1);
    }

    public PlayerData(int customMana, int customMaxMana, int magicLevel) {
        this.customMana = customMana;
        this.customMaxMana = customMaxMana;
        this.magicLevel = magicLevel;
    }

    public int getCustomMana() { return customMana; }
    public void setCustomMana(int customMana) { this.customMana = Math.max(0, Math.min(customMana, this.customMaxMana)); }

    public int getCustomMaxMana() { return customMaxMana; }
    public void setCustomMaxMana(int customMaxMana) { this.customMaxMana = customMaxMana; }

    public int getMagicLevel() { return magicLevel; }
    public void setMagicLevel(int magicLevel) { this.magicLevel = magicLevel; }
}
