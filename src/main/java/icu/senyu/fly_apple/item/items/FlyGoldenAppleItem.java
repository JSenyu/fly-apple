package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FlyGoldenAppleItem extends Item {

    public FlyGoldenAppleItem() {
        super(new Properties().tab(FlyAppleMod.TAB).food(
                new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).alwaysEat().fast()
                        .effect(() -> new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), 3600, 0), 1.0F)
                        .build()
        ));
    }

}
