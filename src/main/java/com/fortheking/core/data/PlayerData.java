package com.fortheking.core.data;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class PlayerData {

    public static final MapCodec<PlayerData> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.optionalFieldOf("customMana", 100).forGetter(PlayerData::getCustomMana),
            Codec.INT.optionalFieldOf("customMaxMana", 100).forGetter(PlayerData::getCustomMaxMana),
            Codec.INT.optionalFieldOf("magicLevel", 1).forGetter(PlayerData::getMagicLevel),
            Codec.INT.optionalFieldOf("activeSpell", 0).forGetter(PlayerData::getActiveSpell)
    ).apply(instance, PlayerData::new));

    private int customMana;
    private int customMaxMana;
    private int magicLevel;
    /** ID of the currently active spell (0 = none). Maps to spell IDs defined per magic system. */
    private int activeSpell;

    public PlayerData() {
        this(100, 100, 1, 0);
    }

    public PlayerData(int customMana, int customMaxMana, int magicLevel, int activeSpell) {
        this.customMana = customMana;
        this.customMaxMana = customMaxMana;
        this.magicLevel = magicLevel;
        this.activeSpell = activeSpell;
    }

    public int getCustomMana() { return customMana; }
    public void setCustomMana(int value) { this.customMana = Math.max(0, Math.min(value, this.customMaxMana)); }
    public void addMana(int amount) { setCustomMana(this.customMana + amount); }
    public void removeMana(int amount) { setCustomMana(this.customMana - amount); }
    public boolean hasMana(int required) { return this.customMana >= required; }

    public int getCustomMaxMana() { return customMaxMana; }
    public void setCustomMaxMana(int customMaxMana) { this.customMaxMana = Math.max(1, customMaxMana); }

    public int getMagicLevel() { return magicLevel; }
    public void setMagicLevel(int magicLevel) { this.magicLevel = Math.max(1, magicLevel); }

    public int getActiveSpell() { return activeSpell; }
    public void setActiveSpell(int activeSpell) { this.activeSpell = activeSpell; }
    public boolean isCastingSpell() { return this.activeSpell != 0; }
}

