package icu.senyu.fly_apple.capability;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = FlyAppleMod.MOD_ID)
public class CapabilityFly {

    public static final Capability<IFlyCapability> FLY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IFlyCapability.class);
    }

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(FlyAppleMod.MOD_ID, "fly"), new CapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        event.getPlayer().getCapability(FLY_CAPABILITY).ifPresent(cap -> {
            if (event.getPlayer().hasEffect(EffectRegister.FLY_EFFECT.get())) {
                event.getPlayer().getAbilities().mayfly = true;
                event.getPlayer().getAbilities().flying = cap.isFlying();
                event.getPlayer().onUpdateAbilities();
            }
        });
    }

    @SubscribeEvent
    public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        event.getPlayer().getCapability(FLY_CAPABILITY).ifPresent(cap -> {
            if (event.getPlayer().hasEffect(EffectRegister.FLY_EFFECT.get())) {
                cap.setFlying(event.getPlayer().getAbilities().flying);
            }
        });
    }

    private static class CapabilityProvider implements ICapabilitySerializable<CompoundTag> {
        private final LazyOptional<IFlyCapability> instance = LazyOptional.of(FlyCapability::new);

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            return cap == FLY_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public CompoundTag serializeNBT() {
            return instance.orElseThrow(IllegalArgumentException::new).serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            instance.orElseThrow(IllegalArgumentException::new).deserializeNBT(nbt);
        }
    }
}
