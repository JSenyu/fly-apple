package icu.senyu.fly_apple.item;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.item.items.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlyAppleMod.MOD_ID);

    // Apples with flying abilities
    public static final RegistryObject<Item> CAN_FLY_APPLE = ITEMS.register("can_fly_apple", FlyAppleItem::new);
    public static final RegistryObject<Item> CAN_FLY_GOLDEN_APPLE = ITEMS.register("can_fly_golden_apple", FlyGoldenAppleItem::new);
    public static final RegistryObject<Item> ENCHANTED_FLY_GOLDEN_APPLE = ITEMS.register("enchanted_fly_golden_apple", EnchantedFlyGoldenAppleItem::new);

    // Floating essences
    public static final RegistryObject<Item> FLOAT_ESSENCE = ITEMS.register("float_essence", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> MYTHICAL_FLOAT_ESSENCE = ITEMS.register("mythical_float_essence", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> BOTTLED_FLOAT_ESSENCE = ITEMS.register("bottled_float_essence", BottledFloatEssenceItem::new);

    // Staff items with flying abilities
    public static final RegistryObject<Item> FLY_STAFF = ITEMS.register("fly_staff", () -> new StaffItem(4, 200)); // 10 seconds
    public static final RegistryObject<Item> FLY_STAFF_PRACTICAL = ITEMS.register("fly_staff_practical", () -> new StaffItem(8, 200)); // 10 seconds
    public static final RegistryObject<Item> FLY_STAFF_EXQUISITE = ITEMS.register("fly_staff_exquisite", () -> new StaffItem(8, 400)); // 20 seconds
    public static final RegistryObject<Item> FLY_STAFF_COLLECTIBLE = ITEMS.register("fly_staff_collectible", () -> new StaffItem(16, 400)); // 20 seconds
    public static final RegistryObject<Item> FLY_STAFF_TREASURE = ITEMS.register("fly_staff_treasure", () -> new StaffItem(16, 600)); // 30 seconds
    public static final RegistryObject<Item> FLY_STAFF_MYTHICAL = ITEMS.register("fly_staff_mythical", () -> new StaffItem(32, 600)); // 30 seconds
    public static final RegistryObject<Item> SKY_STAFF = ITEMS.register("sky_staff", () -> new StaffItem(64, 1200)); // 60 seconds

    // Core items
    public static final RegistryObject<Item> FLY_CORE = ITEMS.register("fly_core", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> FLY_CORE_PRACTICAL = ITEMS.register("fly_core_practical", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> FLY_CORE_EXQUISITE = ITEMS.register("fly_core_exquisite", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> FLY_CORE_COLLECTIBLE = ITEMS.register("fly_core_collectible", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> FLY_CORE_TREASURE = ITEMS.register("fly_core_treasure", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> FLY_CORE_MYTHICAL = ITEMS.register("fly_core_mythical", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));
    public static final RegistryObject<Item> SKY_CORE = ITEMS.register("sky_core", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).durability(64)));

    // Repair core for staff items
    public static final RegistryObject<Item> FLY_CORE_REPAIR = ITEMS.register("fly_core_repair", FlyCoreRepairItem::new);

    // Sky wheat and related items
    public static final RegistryObject<Item> SKY_WHEAT = ITEMS.register("sky_wheat", SkyWheatItem::new);
    public static final RegistryObject<Item> SKY_WHEAT_SEEDS = ITEMS.register("sky_wheat_seeds", SkyWheatSeedsItem::new);
    public static final RegistryObject<Item> SKY_BREAD = ITEMS.register("sky_bread", SkyBreadItem::new);

    // Fly insurance item
    public static final RegistryObject<Item> FLY_INSURANCE = ITEMS.register("fly_insurance", FlyInsuranceItem::new);
}
