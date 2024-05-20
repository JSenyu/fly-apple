package icu.senyu.fly_apple;

import icu.senyu.fly_apple.effects.EffectRegister;
import icu.senyu.fly_apple.item.ItemRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlyAppleMod.MOD_ID)
public class FlyAppleMod {

    public static final String MOD_ID = "fly_apple";

    public FlyAppleMod() {

        EffectRegister.EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
