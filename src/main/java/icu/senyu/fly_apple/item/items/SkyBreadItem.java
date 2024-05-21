package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SkyBreadItem extends Item {

    public SkyBreadItem() {
        super(new Properties()
                .tab(FlyAppleMod.TAB)
                .food(new FoodProperties.Builder()
                        .nutrition(8) // 饥饿值
                        .saturationMod(0.6F) // 饱食度
                        .effect(() -> new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), 300, 0), 1.0F) // 15秒的飞行效果 (300 ticks)
                        .build()));
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return false;
    }
}
