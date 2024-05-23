package icu.senyu.fly_apple.capability;

import net.minecraft.nbt.CompoundTag;

public interface IFlyCapability {
    boolean isFlying();
    void setFlying(boolean flying);

    CompoundTag serializeNBT();
    void deserializeNBT(CompoundTag nbt);
}
