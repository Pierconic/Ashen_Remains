package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModGameRules;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class ExpansionProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double Xvalue = 0;
		double ZValue = 0;
		double Yvalue = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Plants = 0;
		double Regrowth = 0;
		if (Math.random() < (world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.PLANT_GROWTH_SPEED)) * 0.01) {
			Plants = 0;
			found = false;
			for (int index0 = 0; index0 < 8; index0++) {
				sy = -4;
				for (int index1 = 0; index1 < 8; index1++) {
					sz = -4;
					for (int index2 = 0; index2 < 8; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.CRYING_OBSIDIAN) {
							found = true;
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))) {
							Plants = Plants + 0.07;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (Math.random() < 1 - Plants && found == false) {
				sx = -4;
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR) {
					if (world.getLevelData().getGameRules().getBoolean(AshenremainsModGameRules.DOPLANTGROWTH) == true) {
						GrowthProcedureProcedure.execute(world, x, y + 1, z);
					}
				} else {
					if (Math.random() < 0.5) {
						Xvalue = x + Mth.nextInt(RandomSource.create(), 2, 6);
					} else {
						Xvalue = x - Mth.nextInt(RandomSource.create(), 2, 6);
					}
					if (Math.random() < 0.5) {
						ZValue = z + Mth.nextInt(RandomSource.create(), 2, 6);
					} else {
						ZValue = z - Mth.nextInt(RandomSource.create(), 2, 6);
					}
					Yvalue = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Xvalue, (int) ZValue) - 1;
					if ((world.getBlockState(BlockPos.containing(Xvalue, Yvalue, ZValue))).getBlock() == Blocks.GRASS_BLOCK && (world.getBlockState(BlockPos.containing(Xvalue, Yvalue + 1, ZValue))).getBlock() == Blocks.AIR
							&& !(world.getBlockState(BlockPos.containing(Xvalue + 1, Yvalue + 1, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue - 1, Yvalue + 1, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue + 1, ZValue - 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue + 1, ZValue + 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue + 1, Yvalue + 0, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue - 1, Yvalue + 0, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue + 0, ZValue - 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue + 0, ZValue + 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue + 1, Yvalue - 1, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue - 1, Yvalue - 1, ZValue))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue - 1, ZValue - 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))
							&& !(world.getBlockState(BlockPos.containing(Xvalue, Yvalue - 1, ZValue + 1))).is(BlockTags.create(ResourceLocation.parse("forge:growth_preventing")))) {
						world.setBlock(BlockPos.containing(Xvalue, Yvalue, ZValue), AshenremainsModBlocks.FLOWERING_GRASS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x, y, z), Blocks.GRASS_BLOCK.defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
