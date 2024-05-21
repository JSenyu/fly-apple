package icu.senyu.fly_apple;

import icu.senyu.fly_apple.block.BlockRegister;
import icu.senyu.fly_apple.effects.EffectRegister;
import icu.senyu.fly_apple.item.FlyAppleTab;
import icu.senyu.fly_apple.item.ItemRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlyAppleMod.MOD_ID)
public class FlyAppleMod {

    public static final String MOD_ID = "fly_apple";
    public static final CreativeModeTab TAB = new FlyAppleTab();
    private static final Logger LOGGER = LogManager.getLogger();

    public FlyAppleMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegister.ITEMS.register(bus);
        BlockRegister.BLOCKS.register(bus);
        EffectRegister.EFFECTS.register(bus);
    }

}
