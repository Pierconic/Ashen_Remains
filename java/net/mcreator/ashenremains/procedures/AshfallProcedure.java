package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModParticleTypes;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshfallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean Surfacefound = false;
		boolean Blocked = false;
		double FallSurface = 0;
		double Quantity = 0;
		double location = 0;
		Quantity = 8 - ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1);
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		} else {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
		Blocked = false;
		while (Blocked == false && Surfacefound == false && FallSurface <= 32) {
			if ((world.getBlockState(BlockPos.containing(x, y - FallSurface, z))).is(BlockTags.create(ResourceLocation.parse("forge:ash_permeable")))) {
				FallSurface = FallSurface + 1;
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y - FallSurface), (z + 0.5), 2, 0.2, 0.2, 0.2, 0.1);
			} else if ((world.getBlockState(BlockPos.containing(x, y - FallSurface, z)).isFaceSturdy(world, BlockPos.containing(x, y - FallSurface, z), Direction.UP)
					|| (world.getBlockState(BlockPos.containing(x, y - FallSurface, z))).getBlock() == AshenremainsModBlocks.ASH.get()
					|| (world.getBlockState(BlockPos.containing(x, y - FallSurface, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get())
					&& (world.isEmptyBlock(BlockPos.containing(x, y - FallSurface + 1, z)) || (world.getBlockState(BlockPos.containing(x, y - FallSurface + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))))) {
				Surfacefound = true;
			} else {
				Blocked = true;
			}
		}
		FallSurface = FallSurface - 1;
		if (Surfacefound == true) {
			for (int index1 = 0; index1 < 8; index1++) {
				if (Quantity > 0) {
					if ((world.getBlockState(BlockPos.containing(x, y - FallSurface, z))).getBlock() == AshenremainsModBlocks.ASH.get()
							|| (world.getBlockState(BlockPos.containing(x, y - FallSurface, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get()) {
						location = Mth.nextInt(RandomSource.create(), 1, 5);
						if (location == 1) {
							AshAccumulateProcedure.execute(world, x + 1, y - FallSurface, z);
							Quantity = Quantity - 1;
						} else if (location == 2) {
							AshAccumulateProcedure.execute(world, x - 1, y - FallSurface, z);
							Quantity = Quantity - 1;
						} else if (location == 3) {
							AshAccumulateProcedure.execute(world, x, y - FallSurface, z - 1);
							Quantity = Quantity - 1;
						} else if (location == 4) {
							AshAccumulateProcedure.execute(world, x, y - FallSurface, z + 1);
							Quantity = Quantity - 1;
						} else {
							AshAccumulateProcedure.execute(world, x, y - FallSurface, z);
							Quantity = Quantity - 1;
						}
					} else {
						AshAccumulateProcedure.execute(world, x, y - FallSurface, z);
						Quantity = Quantity - 1;
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore")))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
