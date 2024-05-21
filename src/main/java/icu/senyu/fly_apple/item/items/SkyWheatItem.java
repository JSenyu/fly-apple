package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SkyWheatItem extends Item {

    public SkyWheatItem() {
        super(new Properties()
                .tab(FlyAppleMod.TAB)
                .food(new FoodProperties.Builder()
                        .nutrition(1) // ����ֵ
                        .saturationMod(0.1F) // ��ʳ��
                        .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 40, 0), 1.0F) // 2���Ư��Ч�� (40 ticks)
                        .build()));
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return false;
    }
}
