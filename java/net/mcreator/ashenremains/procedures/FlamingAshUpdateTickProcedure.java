package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModGameRules;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class FlamingAshUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sidecheck = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double transfered_age = 0;
		double saved_blockstate = 0;
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 6; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 6; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 6; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:fire"))) || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (!world.getLevelData().isRaining() && found == true) {
			if (world.getLevelData().getGameRules().getBoolean(AshenremainsModGameRules.DOFIRESPREAD) == true) {
				transfered_age = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "age") + 1;
				if (Math.random() < 0.3) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))) {
						FieryTransformationProcedure.execute(world, x, y - 1, z);
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) {
						if (Math.random() < 0.6) {
							FieryTransformationProcedure.execute(world, x, y - 1, z);
						} else {
							IgniteBlockProcedure.execute(world, x, y - 1, z, transfered_age);
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						AshfallProcedure.execute(world, x, y - 1, z);
					}
				}
				if (Math.random() < 0.6) {
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y + 1, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y + 2, z, transfered_age);
					}
				}
				if (Math.random() < 0.4) {
					if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y + 3, z, transfered_age);
					}
				}
				if (Math.random() < 0.2) {
					if ((world.getBlockState(BlockPos.containing(x, y + 4, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 4, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 4, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y + 4, z, transfered_age);
					}
				}
				if (Math.random() < 0.1) {
					if ((world.getBlockState(BlockPos.containing(x, y + 5, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 5, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y + 5, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y + 5, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x + 1, y, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x - 1, y, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y, z - 1, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y, z + 1, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x + 1, y - 1, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x - 1, y - 1, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y - 1, z - 1, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y - 1, z + 1, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x + 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x + 1, y - 2, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x - 1, y - 2, z, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y - 2, z - 1, transfered_age);
					}
				}
				if (Math.random() < 0.5) {
					if ((world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
							|| (world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
						IgniteBlockProcedure.execute(world, x, y - 2, z + 1, transfered_age);
					}
				}
			}
		} else if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.MAGMA_BLOCK)) {
			saved_blockstate = (world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip120
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip120)
					: -1;
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(AshenremainsModBlocks.ASH.get().defaultBlockState(), "blockstate", (int) saved_blockstate));
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.FLOWERING_GRASS.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.PODZOL || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT_PATH) {
			world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.ASHY_GRASS.get().defaultBlockState(), 3);
		}
	}
}
