package icu.senyu.fly_apple.listerner;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import icu.senyu.fly_apple.item.ItemRegister;
import icu.senyu.fly_apple.item.items.FlyInsuranceItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
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
    public static void onLivingDrops(LivingDropsEvent event) {
        if(!(event.getEntity() instanceof LivingEntity entity))return;
        Level world = entity.level;
        int lootingLevel = event.getLootingLevel();
        boolean isBoss = entity instanceof WitherBoss || entity instanceof EnderDragon;
        ItemStack floatEssence = new ItemStack(ItemRegister.FLOAT_ESSENCE.get());

        if (isFlyingMob(entity)) {
            float chance = 0.6f + (0.1f * lootingLevel);
            if (world.random.nextFloat() < chance) {
                floatEssence.setCount(world.random.nextInt(1, 2 + lootingLevel));
                entity.spawnAtLocation(floatEssence.copy());
            }
        }

        if (isBoss) {
            entity.spawnAtLocation(new ItemStack(ItemRegister.MYTHICAL_FLOAT_ESSENCE.get()));
            floatEssence.setCount(world.random.nextInt(6 + (lootingLevel * 3), 16 + (lootingLevel * 6)));
            entity.spawnAtLocation(floatEssence.copy());
        }
    }

    public static boolean isFlyingMob(LivingEntity entity) {
        return entity instanceof FlyingAnimal || //·ÉÐÐ¶¯Îï
                entity instanceof FlyingMob ||
                entity instanceof Bat ||
                entity instanceof Blaze;
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getSource() == DamageSource.FALL)) return;
        if (!(event.getEntity() instanceof Player player)) return;

        boolean hasInsurance = FlyInsuranceItem.activateFlyInsurance(player);
        if (hasInsurance) {
            player.setHealth(2f);
            event.setCanceled(true);
        }


    }

}
