package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class NaturalGenConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			return true;
		}
		return false;
	}
}
