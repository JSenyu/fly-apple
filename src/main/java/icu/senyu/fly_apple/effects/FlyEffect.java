package icu.senyu.fly_apple.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class FlyEffect extends MobEffect {
    protected FlyEffect() {
        super(MobEffectCategory.BENEFICIAL, 745784);
    }


    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap map, int i) {
        if(entity instanceof Player player){
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        }
        super.removeAttributeModifiers(entity, map, i);
    }

}
