package icu.senyu.fly_apple.capability;

import net.minecraft.nbt.CompoundTag;

public class FlyCapability implements IFlyCapability {
    private boolean isFlying = false;

    @Override
    public boolean isFlying() {
        return isFlying;
    }

    @Override
    public void setFlying(boolean flying) {
        this.isFlying = flying;
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("isFlying", isFlying);
        return tag;
    }

    public void deserializeNBT(CompoundTag nbt) {
        this.isFlying = nbt.getBoolean("isFlying");
    }
}
