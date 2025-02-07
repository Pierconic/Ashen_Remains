package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class WitherExplosionTweaksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
			if (!world.getEntitiesOfClass(WitherSkull.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				for (int index0 = 0; index0 < 32; index0++) {
					sx = Mth.nextInt(RandomSource.create(), -3, 3);
					sy = Mth.nextInt(RandomSource.create(), 0, 3);
					sz = Mth.nextInt(RandomSource.create(), -3, 3);
					if ((world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:ghast_replaceable")))) {
						if (Math.random() < 0.05) {
							world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), AshenremainsModBlocks.ACTIVATED_SOUL_SAND.get().defaultBlockState(), 3);
						} else if (Math.random() < 0.75) {
							world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), Blocks.SOUL_SAND.defaultBlockState(), 3);
							if (Math.random() < 0.75 && world.isEmptyBlock(BlockPos.containing(x + sx, y - sy + 1, z + sz)) && world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz)).canOcclude()) {
								world.setBlock(BlockPos.containing(x + sx, y - sy + 1, z + sz), Blocks.SOUL_FIRE.defaultBlockState(), 3);
							}
						} else {
							world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), Blocks.SOUL_SOIL.defaultBlockState(), 3);
							if (Math.random() < 0.75 && true) {
								if (Math.random() < 0.75 && world.isEmptyBlock(BlockPos.containing(x + sx, y - sy + 1, z + sz)) && world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz)).canOcclude()) {
									world.setBlock(BlockPos.containing(x + sx, y - sy + 1, z + sz), Blocks.SOUL_FIRE.defaultBlockState(), 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
