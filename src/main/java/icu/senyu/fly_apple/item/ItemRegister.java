package icu.senyu.fly_apple.item;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.item.items.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ItemRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlyAppleMod.MOD_ID);


    // 注册所有法杖物品
    public static void registerStaffItems() {
        for (StaffType type : StaffType.values()) {
            registerStaff(type);
        }
    }

    /**
     * 注册法杖物品
     *
     * @param type 要注册的法杖类型
     */
    private static void registerStaff(StaffType type) {
        ITEMS.register(type.getName(), () -> new StaffItem(type));
    }


    // Apples with flying abilities
    public static final RegistryObject<Item> CAN_FLY_APPLE = ITEMS.register("can_fly_apple", FlyAppleItem::new);
    public static final RegistryObject<Item> CAN_FLY_GOLDEN_APPLE = ITEMS.register("can_fly_golden_apple", FlyGoldenAppleItem::new);
    public static final RegistryObject<Item> ENCHANTED_FLY_GOLDEN_APPLE = ITEMS.register("enchanted_fly_golden_apple", EnchantedFlyGoldenAppleItem::new);

    // Floating essences
    public static final RegistryObject<Item> FLOAT_ESSENCE = ITEMS.register("float_essence", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> MYTHICAL_FLOAT_ESSENCE = ITEMS.register("mythical_float_essence", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> BOTTLED_FLOAT_ESSENCE = ITEMS.register("bottled_float_essence", BottledFloatEssenceItem::new);

    // Core items
    public static final RegistryObject<Item> FLY_CORE = ITEMS.register("fly_core", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> FLY_CORE_PRACTICAL = ITEMS.register("fly_core_practical", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB)));
    public static final RegistryObject<Item> FLY_CORE_EXQUISITE = ITEMS.register("fly_core_exquisite", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> FLY_CORE_COLLECTIBLE = ITEMS.register("fly_core_collectible", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> FLY_CORE_TREASURE = ITEMS.register("fly_core_treasure", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLY_CORE_MYTHICAL = ITEMS.register("fly_core_mythical", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SKY_CORE = ITEMS.register("sky_core", () -> new Item(new Item.Properties().tab(FlyAppleMod.TAB).rarity(Rarity.UNCOMMON)){
        @Override
        public boolean isFoil(@NotNull ItemStack item) {
            return true;
        }
    });

    // Repair core for staff items
    public static final RegistryObject<Item> FLY_CORE_REPAIR = ITEMS.register("fly_core_repair", FlyCoreRepairItem::new);

    // Sky wheat and related items
    public static final RegistryObject<Item> SKY_WHEAT = ITEMS.register("sky_wheat", SkyWheatItem::new);
    public static final RegistryObject<Item> SKY_WHEAT_SEEDS = ITEMS.register("sky_wheat_seeds", SkyWheatSeedsItem::new);
    public static final RegistryObject<Item> SKY_BREAD = ITEMS.register("sky_bread", SkyBreadItem::new);

    // Fly insurance item
    public static final RegistryObject<Item> FLY_INSURANCE = ITEMS.register("fly_insurance", FlyInsuranceItem::new);
}
