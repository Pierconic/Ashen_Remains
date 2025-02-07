package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class BurninatingTheCountrysideProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double cx = 0;
		double cz = 0;
		double cy = 0;
		double frequency = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Fire = 0;
		FireRainExtinguishProcedure.execute(world, x, y, z);
		Fire = 0;
		sx = -5;
		found = false;
		for (int index0 = 0; index0 < 10; index0++) {
			sy = -5;
			for (int index1 = 0; index1 < 10; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 10; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.SPORE_BLOSSOM) {
						found = true;
					} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:fire")))) {
						Fire = Fire + 1;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 6, 12); index3++) {
				world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, x, y, z, 0, 0.1, 0);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) && !world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				IgniteBlockProcedure.execute(world, x, y + 1, z, new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "age") + 1);
			}
			if (Fire <= 14) {
				SpreadFireProcedure.execute(world, x, y, z);
			} else {
				SpreadLessFireProcedure.execute(world, x, y, z);
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.WEIRD_FIRE.get()) {
				cx = x;
				cy = y - 1;
				cz = z;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.EAST_FIRE.get()) {
				cx = x - 1;
				cy = y;
				cz = z;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.WEST_FIRE.get()) {
				cx = x + 1;
				cy = y;
				cz = z;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.NORTH_FIRE.get()) {
				cx = x;
				cy = y;
				cz = z + 1;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.SOUTH_FIRE.get()) {
				cx = x;
				cy = y;
				cz = z - 1;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.STRANGE_FIRE.get()) {
				cx = x;
				cy = y + 1;
				cz = z;
			}
			if (((world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))
					|| (world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) && !world.isEmptyBlock(BlockPos.containing(cx, cy + 1, cz))) {
				IgniteBlockProcedure.execute(world, cx, cy + 1, cz, new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "age") + 1);
			}
			if ((world.getBlockState(BlockPos.containing(cx, cy, cz))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) {
				FieryTransformationProcedure.execute(world, cx, cy, cz);
			} else if ((world.getBlockState(BlockPos.containing(cx, cy, cz))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(cx, cy, cz))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))) {
				if (Math.random() < 0.3 + frequency || ((world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
						|| (world.getBlockState(BlockPos.containing(cx, cy + 1, cz))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))) && Math.random() < 0.9 + frequency) {
					FieryTransformationProcedure.execute(world, cx, cy, cz);
				} else {
					if (Math.random() < 0.5) {
						if (Fire <= 14) {
							SpreadFireProcedure.execute(world, x, y, z);
						} else {
							SpreadLessFireProcedure.execute(world, x, y, z);
						}
						AshfallProcedure.execute(world, cx, cy, cz);
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(cx, cy, cz))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				SpreadFireProcedure.execute(world, x, y, z);
				AshfallProcedure.execute(world, cx, cy, cz);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.6, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.6, 1, false);
					}
				}
			}
		}
	}
}
