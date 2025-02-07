package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GrieferDeathProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double offset = 0;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
			AshfallProcedure.execute(world, x, y, z);
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 4); index1++) {
			offset = Mth.nextInt(RandomSource.create(), 0, 3);
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) {
				IgniteBlockProcedure.execute(world, x, y - 1, z, 0);
			}
		}
	}
}
