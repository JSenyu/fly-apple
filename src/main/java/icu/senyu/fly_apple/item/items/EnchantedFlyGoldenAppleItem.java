package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.EnchantedGoldenAppleItem;
import net.minecraft.world.item.Item;

public class EnchantedFlyGoldenAppleItem extends Item {

    public EnchantedFlyGoldenAppleItem() {
        super(new Properties().tab(FlyAppleMod.TAB).food(
                new FoodProperties.Builder().nutrition(8).saturationMod(1.2f).alwaysEat().fast()
                        .effect(() -> new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), 7200, 1), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F) // Regeneration for 20 seconds
                        .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F) // Absorption for 2 minutes
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F) // Resistance for 5 minutes
                        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F) // Fire Resistance for 5 minutes
                        .build()
        ));
    }

}
