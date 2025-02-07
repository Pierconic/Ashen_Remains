package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModGameRules;

public class SpreadFireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double cx = 0;
		double sy = 0;
		double cy = 0;
		double sz = 0;
		double cz = 0;
		double frequency = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fire"))) && !world.getLevelData().isRaining()
				&& world.getLevelData().getGameRules().getBoolean(AshenremainsModGameRules.DOFIRESPREAD)) {
			frequency = 0.05;
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("wooded_badlands"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("eroded_badlands")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("badlands"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_savanna"))) {
				frequency = frequency + 0.1;
			} else if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER) {
				frequency = frequency + 0.2;
			} else if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)) && world.getLevelData().isRaining()) {
				frequency = frequency - 0.025;
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("mangrove_swamp")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("jungle"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("lush_caves"))) {
				frequency = frequency - 0.025;
			} else if (world.getDifficulty() == Difficulty.HARD) {
				frequency = frequency + 0.1;
			}
			sx = -2;
			for (int index0 = 0; index0 < 5; index0++) {
				sy = -2;
				for (int index1 = 0; index1 < 3; index1++) {
					sz = -2;
					for (int index2 = 0; index2 < 5; index2++) {
						if (((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))
								|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && Math.random() < frequency) {
							IgniteBlockProcedure.execute(world, x + sx, y + sy, z + sz, new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "age"));
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_fire_ignore"))) && Math.random() < frequency) {
							FieryTransformationProcedure.execute(world, x + sx, y + sy, z + sz);
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
							IgniteBlockProcedure.execute(world, x + sx, y + sy, z + sz, new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "age"));
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			sx = -1;
			for (int index3 = 0; index3 < 3; index3++) {
				sy = -1;
				for (int index4 = 0; index4 < 6; index4++) {
					sz = -1;
					for (int index5 = 0; index5 < 3; index5++) {
						if (((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))
								|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:flammable"))))
								&& (Math.random() < frequency || world.isEmptyBlock(BlockPos.containing(x + sx, (y + sy) - 1, z + sz)))) {
							IgniteBlockProcedure.execute(world, x + sx, y + sy, z + sz, new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "age"));
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_fire_ignore"))) && Math.random() < frequency) {
							FieryTransformationProcedure.execute(world, x + sx, y + sy, z + sz);
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
							IgniteBlockProcedure.execute(world, x + sx, y + sy, z + sz, new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "age"));
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
