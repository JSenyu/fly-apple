package icu.senyu.fly_apple.item;

import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class FlyAppleItem extends Item {

    public FlyAppleItem() {
        super(new Properties().tab(CreativeModeTab.TAB_FOOD).food(
                new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).alwaysEat()
                        .effect(() -> new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), 600, 0), 1.0F)
                        .build()
        ));
    }


}
