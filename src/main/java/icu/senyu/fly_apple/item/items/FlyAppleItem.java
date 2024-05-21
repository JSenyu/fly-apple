package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FlyAppleItem extends Item {

    public FlyAppleItem() {
        super(new Properties().tab(FlyAppleMod.TAB).food(
                new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).alwaysEat()
                        .effect(() -> new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), 1800, 0), 1.0F)
                        .build()
        ));
    }


}
