package icu.senyu.fly_apple.listerner;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import icu.senyu.fly_apple.item.items.FlyInsuranceItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlyAppleMod.MOD_ID)
public class EventListener {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;
        if (player.isCreative()) return;

        MobEffectInstance effectInstance = player.getEffect(EffectRegister.FLY_EFFECT.get());
        if (effectInstance == null) return;

        if (effectInstance.getDuration() <= 1) {
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
            player.onUpdateAbilities();
        } else {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        }
    }


    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource() == DamageSource.FALL) {
                boolean hasInsurance = FlyInsuranceItem.activateFlyInsurance(player);
                if (hasInsurance) {
                    player.setHealth(2f);
                    event.setCanceled(true);
                }
            }
        }
    }

}
