package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;
import net.mcreator.ashenremains.AshenremainsMod;

public class RainDisintegrateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().isRaining() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			if (Math.random() < 0.3) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:ashblocks"))) || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.ASH.get()
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get()) {
					AshenremainsMod.queueServerWork(1, () -> {
						AshfallProcedure.execute(world, x, y + 1, z);
					});
				}
			}
		}
	}
}
