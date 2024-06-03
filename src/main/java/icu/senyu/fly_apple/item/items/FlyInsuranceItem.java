package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.item.ItemRegister;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.core.particles.ParticleTypes.TOTEM_OF_UNDYING;

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
            serverLevel.sendParticles(TOTEM_OF_UNDYING, player.getX(), player.getY() + 1.0D, player.getZ(), 30, 0.5D, 1.0D, 0.5D, 0.0D);

            // 播放不死图腾的音效
            serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        displayAnimation();
    }

    @OnlyIn(Dist.CLIENT)
    private static void displayAnimation() {
        Minecraft mc = Minecraft.getInstance();
        mc.gameRenderer.displayItemActivation(ItemRegister.FLY_INSURANCE.get().getDefaultInstance());
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
