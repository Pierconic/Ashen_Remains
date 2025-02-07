package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshyGrassRemovalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.ASH.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:ashblocks"))))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
			if (world.getLevelData().isRaining() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
				if (Math.random() < 0.05) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.GRASS_BLOCK.defaultBlockState(), 3);
				} else if (Math.random() < 0.02) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.FLOWERING_GRASS.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
