package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SaplingRootsProcedure {
	@SubscribeEvent
	public static void onSaplingGrow(BlockGrowFeatureEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT) {
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
			if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.DIRT && Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				if ((world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == Blocks.DIRT && Math.random() < 0.2) {
					world.setBlock(BlockPos.containing(x, y - 3, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				}
			}
			if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.DIRT) && Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK) && Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y - 1, z + 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				}
				if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK) && Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + 1, y - 1, z - 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				}
			}
			if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.DIRT) && Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK) && Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x - 1, y - 1, z + 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				}
				if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK) && Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x - 1, y - 1, z - 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
				}
			}
			if (((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.DIRT) && Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
			}
			if (((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.GRASS_BLOCK) && Math.random() < 0.3) {
				world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
			}
		}
	}
}
