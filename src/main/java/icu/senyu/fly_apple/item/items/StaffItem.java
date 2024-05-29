package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StaffItem extends Item {
    private final int flyEffectDuration;
    private final int cooldownDuration;
    private final boolean isFoil;

    public StaffItem(StaffType staffType) {
        super(new Properties().tab(FlyAppleMod.TAB).durability(staffType.getMaxDamage() + 1));
        this.flyEffectDuration = staffType.getFlyEffectDuration();
        this.cooldownDuration = staffType.getCooldownDuration();
        this.isFoil = staffType.isFoil();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        // 检查物品是否耗尽耐久度
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            // 播放破损声音
            player.playSound(SoundEvents.ITEM_BREAK, 1.0F, 1.0F);
            return InteractionResultHolder.fail(itemstack);
        }

        if (!world.isClientSide) {
            // 给予飞行效果
            player.addEffect(new MobEffectInstance(EffectRegister.FLY_EFFECT.get(), flyEffectDuration, 0));
            itemstack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            player.getCooldowns().addCooldown(this, cooldownDuration); // 应用冷却时间
        }
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        // 检查物品是否耗尽耐久度
        if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
            // 如果攻击者是玩家，播放破损声音
            if (attacker instanceof Player player) {
                player.playSound(SoundEvents.ITEM_BREAK, 1.0F, 1.0F);
            }
            return false;
        }

        // 给予目标悬浮效果，持续 2 秒（40 ticks）
        target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 0));
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false; // 禁用附魔
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false; // 禁用铁砧附魔
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, @NotNull ItemStack repair) {
        // 检查修复材料是否为 FlyCoreRepairItem 实例
        return repair.getItem() instanceof FlyCoreRepairItem;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return this.isFoil; // 根据传入的参数决定是否闪光
    }
}
