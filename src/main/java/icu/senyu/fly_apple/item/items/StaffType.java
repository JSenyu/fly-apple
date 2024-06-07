package icu.senyu.fly_apple.item.items;

import net.minecraft.world.item.Rarity;

public enum StaffType {
    FLY_STAFF("fly_staff", 4, 200, 60, false),
    FLY_STAFF_PRACTICAL("fly_staff_practical", 8, 200, 60, false),
    FLY_STAFF_EXQUISITE("fly_staff_exquisite", 8, 400, 60, false, Rarity.RARE),
    FLY_STAFF_COLLECTIBLE("fly_staff_collectible", 16, 400, 60, false, Rarity.RARE),
    FLY_STAFF_TREASURE("fly_staff_treasure", 16, 600, 60, true, Rarity.EPIC),
    FLY_STAFF_MYTHICAL("fly_staff_mythical", 32, 600, 60, true, Rarity.EPIC),
    SKY_STAFF("sky_staff", 64, 1200, 60, true, Rarity.UNCOMMON);

    private final String name;
    private final int maxDamage;
    private final int flyEffectDuration;
    private final int cooldownDuration;
    private final boolean isFoil;
    private final Rarity rarity;

    StaffType(String name, int maxDamage, int flyEffectDuration, int cooldownDuration, boolean isFoil, Rarity rarity) {
        this.name = name;
        this.maxDamage = maxDamage;
        this.flyEffectDuration = flyEffectDuration;
        this.cooldownDuration = cooldownDuration;
        this.isFoil = isFoil;
        this.rarity = rarity;
    }


    StaffType(String name, int maxDamage, int flyEffectDuration, int cooldownDuration, boolean isFoil) {
        this.name = name;
        this.maxDamage = maxDamage;
        this.flyEffectDuration = flyEffectDuration;
        this.cooldownDuration = cooldownDuration;
        this.isFoil = isFoil;
        this.rarity = Rarity.COMMON;
    }

    public String getName() {
        return name;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getFlyEffectDuration() {
        return flyEffectDuration;
    }

    public int getCooldownDuration() {
        return cooldownDuration;
    }

    public boolean isFoil() {
        return isFoil;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
