package icu.senyu.fly_apple.item;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FlyAppleTab extends CreativeModeTab {
    public FlyAppleTab() {
        super(FlyAppleMod.MOD_ID);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ItemRegister.CAN_FLY_APPLE.get());
    }
}
