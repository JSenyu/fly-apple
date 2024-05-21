package icu.senyu.fly_apple.block;

import icu.senyu.fly_apple.FlyAppleMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegister {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FlyAppleMod.MOD_ID);

    // Register blocks
    public static final RegistryObject<Block> SKY_WHEAT = BLOCKS.register("sky_wheat", () -> new SkyWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    // Other blocks...
}
