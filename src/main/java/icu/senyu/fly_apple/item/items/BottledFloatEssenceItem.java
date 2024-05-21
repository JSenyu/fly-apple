package icu.senyu.fly_apple.item.items;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class BottledFloatEssenceItem extends Item {

    public BottledFloatEssenceItem() {
        super(new Properties().tab(FlyAppleMod.TAB).stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 32;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, Level world, @NotNull LivingEntity entity) {
        if (!world.isClientSide) {
            entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0)); // 10 seconds of floating
            if (entity instanceof Player && !((Player) entity).getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return stack.isEmpty() ? ItemStack.EMPTY : stack;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        if (!world.isClientSide && player != null) {
            Vec3 clickLocation = context.getClickLocation();
            AABB area = new AABB(clickLocation, clickLocation).inflate(1.0D); // Area around the clicked location
            for (LivingEntity entity : world.getEntitiesOfClass(LivingEntity.class, area)) {
                if (entity != player) { // Ensure it's not the player using the item
                    entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0)); // 10 seconds of floating
                    context.getItemInHand().shrink(1); // Decrease item stack
                    world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BOTTLE_EMPTY, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}
