package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class GrieferExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xoffset = 0;
		double yoffset = 0;
		double zoffset = 0;
		if (!entity.level().isClientSide())
			entity.discard();
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 12, 24); index0++) {
				xoffset = Mth.nextInt(RandomSource.create(), -5, -5);
				yoffset = Mth.nextInt(RandomSource.create(), -2, 4);
				xoffset = Mth.nextInt(RandomSource.create(), -5, -5);
				if (Math.random() < 0.7 && world.isEmptyBlock(BlockPos.containing(xoffset, yoffset, zoffset)) && world.getBlockState(BlockPos.containing(xoffset, yoffset - 1, zoffset)).canOcclude()) {
					world.setBlock(BlockPos.containing(xoffset, yoffset, zoffset), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
				} else {
					FieryTransformationProcedure.execute(world, xoffset, yoffset, zoffset);
				}
			}
		}
	}
}
