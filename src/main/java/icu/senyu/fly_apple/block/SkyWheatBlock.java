package icu.senyu.fly_apple.block;

import icu.senyu.fly_apple.item.ItemRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkyWheatBlock extends CropBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    public SkyWheatBlock() {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0));
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ItemRegister.SKY_WHEAT_SEEDS.get();
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull Random random, @NotNull BlockPos pos, @NotNull BlockState state) {
        super.performBonemeal(level, random, pos, state);
    }

    @Override
    public void growCrops(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState state) {
        super.growCrops(world, pos, state);
    }

    @Override
    protected int getBonemealAgeIncrease(@NotNull Level world) {
        return super.getBonemealAgeIncrease(world);
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, @NotNull LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        int age = state.getValue(AGE);
        Random random = builder.getLevel().getRandom();

        if (age >= 7) { // Fully grown
            drops.add(new ItemStack(ItemRegister.SKY_WHEAT.get(), 1));
            int seedCount = 1 + random.nextInt(3);
            drops.add(new ItemStack(ItemRegister.SKY_WHEAT_SEEDS.get(), seedCount));
        } else {
            drops.add(new ItemStack(ItemRegister.SKY_WHEAT_SEEDS.get(), 1));
        }

        return drops;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull net.minecraft.world.level.BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}
