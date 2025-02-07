package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshyGrassUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean path = false;
		boolean pathfound = false;
		boolean found = false;
		double uy = 0;
		double sx = 0;
		double Flowerchance = 0;
		double sy = 0;
		double sz = 0;
		double Layerdecrease = 0;
		if (world.getLevelData().isRaining()) {
			path = false;
			pathfound = false;
			if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
				uy = y + 1;
				while (pathfound == false) {
					if (world.isEmptyBlock(BlockPos.containing(x, uy, z)) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, uy, z))) {
						pathfound = true;
						path = true;
					} else if (world.isEmptyBlock(BlockPos.containing(x, uy, z)) && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, uy, z))
							|| !world.getBlockState(BlockPos.containing(x, uy, z)).isFaceSturdy(world, BlockPos.containing(x, uy, z), Direction.UP)) {
						uy = uy + 1;
					} else {
						pathfound = true;
					}
				}
			}
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)) || path == true) {
				if (Math.random() < 0.8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
				} else {
					if (Math.random() < 0.8) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.GRASS_BLOCK.defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.FLOWERING_GRASS.get().defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
