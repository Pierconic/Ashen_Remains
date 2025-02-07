package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class GrieferSubmergedProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:ashblocks"))) || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.ASH.get() || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fire")))) {
			return false;
		}
		return true;
	}
}
