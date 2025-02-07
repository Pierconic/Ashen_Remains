package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshWaterWorkaroundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.ASH.get())
				&& !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get())
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:ashblocks")))) {
			AshfallProcedure.execute(world, x, y, z);
		}
	}
}
