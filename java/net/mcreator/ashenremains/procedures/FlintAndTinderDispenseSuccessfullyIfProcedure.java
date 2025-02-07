package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FlintAndTinderDispenseSuccessfullyIfProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return false;
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && ((world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.DOWN) {
			return true;
		} else if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) && ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.UP) {
			return true;
		} else if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.NORTH) {
			return true;
		} else if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.SOUTH) {
			return true;
		} else if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) && ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.EAST) {
			return true;
		} else if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) && direction == Direction.WEST) {
			return true;
		}
		return false;
	}
}
