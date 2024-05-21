package icu.senyu.fly_apple;

import icu.senyu.fly_apple.block.BlockRegister;
import icu.senyu.fly_apple.effects.EffectRegister;
import icu.senyu.fly_apple.item.FlyAppleTab;
import icu.senyu.fly_apple.item.ItemRegister;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FlyAppleMod.MOD_ID)
public class FlyAppleMod {

    public static final String MOD_ID = "fly_apple";
    public static final FlyAppleTab TAB = new FlyAppleTab();
    private static final Logger LOGGER = LogManager.getLogger();

    public FlyAppleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegister.ITEMS.register(modEventBus);
        BlockRegister.BLOCKS.register(modEventBus);
        EffectRegister.EFFECTS.register(modEventBus);
    }

}
