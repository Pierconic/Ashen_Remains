
package net.mcreator.ashenremains.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.procedures.AshyGrassUpdateTickProcedure;
import net.mcreator.ashenremains.procedures.AshyGrassRemovalProcedure;

public class AshyGrassBlock extends Block {
	public AshyGrassBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grass.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grass.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grass.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.fall"))))
				.strength(0.6f, 10f).requiresCorrectToolForDrops().randomTicks());
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		AshyGrassRemovalProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		AshyGrassUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
