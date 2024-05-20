package icu.senyu.fly_apple.listerner;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlyAppleMod.MOD_ID)
public class TickListener {


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;
        if(player.isCreative()) return;

        MobEffectInstance effectInstance = player.getEffect(EffectRegister.FLY_EFFECT.get());
        if(effectInstance == null) return;

        if(effectInstance.getDuration() <= 1){
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
            player.onUpdateAbilities();
        }else {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        }
    }

}
