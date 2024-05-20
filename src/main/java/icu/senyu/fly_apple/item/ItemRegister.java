package icu.senyu.fly_apple.item;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegister {


    public static final DeferredRegister<Item>
            ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlyAppleMod.MOD_ID);

    public static final RegistryObject<Item> CAN_FLY_APPLE = ITEMS.register("can_fly_apple", FlyAppleItem::new);

    public static final RegistryObject<Item> CAN_FLY_GOLDEN_APPLE = ITEMS.register("can_fly_golden_apple", FlyGoldenAppleItem::new);
}
