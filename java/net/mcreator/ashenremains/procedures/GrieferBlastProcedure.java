package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class GrieferBlastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offset = 0;
		if (entity.isInWater()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 3);
		}
		if (world.getLevelData().isRaining() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 1);
		}
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true && Math.random() <= 0.002) {
			AshfallProcedure.execute(world, x, y, z);
		}
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true && Math.random() <= 0.0003) {
			offset = Mth.nextInt(RandomSource.create(), 0, 3);
			if (offset == 0 && world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			} else if (offset == 1 && world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			} else if (offset == 2 && world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			} else if (offset == 3 && world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		}
	}
}
