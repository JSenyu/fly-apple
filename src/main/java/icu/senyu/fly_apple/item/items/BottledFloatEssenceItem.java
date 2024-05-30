package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BottledFloatEssenceItem extends Item {

    public BottledFloatEssenceItem() {
        super(new Properties().tab(FlyAppleMod.TAB).stacksTo(8).craftRemainder(Items.GLASS_BOTTLE));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 32; // 设置使用时间为32 ticks
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity entity) {
        if (!world.isClientSide && entity instanceof Player player) {
            entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0)); // 10秒漂浮效果
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                player.addItem(Items.GLASS_BOTTLE.getDefaultInstance());
            }
        }
        return stack.isEmpty() ? ItemStack.EMPTY : stack;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0)); // 应用10秒漂浮效果
        if (attacker instanceof Player player) {
            if (!player.isCreative()) stack.shrink(1);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
