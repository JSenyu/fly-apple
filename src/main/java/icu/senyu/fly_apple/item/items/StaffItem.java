package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StaffItem extends Item {
    private final int flyEffectDuration;

    public StaffItem(int maxDamage, int flyEffectDuration) {
        super(new Properties().tab(FlyAppleMod.TAB).durability(maxDamage));
        this.flyEffectDuration = flyEffectDuration;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!world.isClientSide) {
            player.addEffect(new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), flyEffectDuration, 0)); // Apply flying effect
            itemstack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            player.getCooldowns().addCooldown(this, 60); // 3 seconds cooldown (60 ticks)
        }
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean canBeDepleted() {
        return true;
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, @NotNull ItemStack repair) {
        return repair.getItem() instanceof FlyCoreRepairItem;
    }
}
