package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.block.BlockRegister;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SkyWheatSeedsItem extends ItemNameBlockItem {

    public SkyWheatSeedsItem() {
        super(BlockRegister.SKY_WHEAT.get(), new Properties().tab(FlyAppleMod.TAB));
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return false;
    }
}
