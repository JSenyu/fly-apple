package icu.senyu.fly_apple.effects;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegister {


    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FlyAppleMod.MOD_ID);


    public static final RegistryObject<MobEffect> FLY_EFFECT = EFFECTS.register("fly_effect", FlyEffect::new);


}
