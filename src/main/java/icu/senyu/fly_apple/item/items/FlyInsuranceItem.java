package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FlyInsuranceItem extends Item {

    public FlyInsuranceItem() {
        super(new Properties().tab(FlyAppleMod.TAB).stacksTo(8).durability(64));
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        return new ItemStack(this);
    }

    public static boolean activateFlyInsurance(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof FlyInsuranceItem) {
                stack.shrink(1); // Reduce the stack size by 1
                spawnParticles(player);
                grantAdvancement(player);
                return true;
            }
        }
        return false;
    }


    private static void spawnParticles(Player player) {
        Level level = player.level;
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, player.getX(), player.getY() + 1.0D, player.getZ(), 30, 0.5D, 1.0D, 0.5D, 0.0D);
        }
    }

    private static void grantAdvancement(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, new ItemStack(Items.TOTEM_OF_UNDYING));
        }
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return false;
    }
}
