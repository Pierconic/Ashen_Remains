package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshRainDissipateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		boolean path = false;
		boolean pathfound = false;
		double Layerdecrease = 0;
		double Flowerchance = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double uy = 0;
		double saved_age = 0;
		double saved_blockstate = 0;
		if (world.getLevelData().isRaining() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			Flowerchance = Mth.nextInt(RandomSource.create(), 1, 16);
			if (Math.random() < 0.5 && ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip4
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4)
					: -1) <= 5) {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip6)
						: -1) == 7) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (Flowerchance == 1 && ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.COARSE_DIRT)) {
						world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.FLOWERING_GRASS.get().defaultBlockState(), 3);
					}
				} else {
					{
						int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip14
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip14)
								: -1) + 2);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			} else {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip17)
						: -1) == 7) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (Flowerchance == 1 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT) {
						world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.FLOWERING_GRASS.get().defaultBlockState(), 3);
					}
				} else {
					{
						int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip23)
								: -1) + 1);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			}
		} else {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.FLOWERING_GRASS.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.PODZOL || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT_PATH) {
				world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.ASHY_GRASS.get().defaultBlockState(), 3);
			}
			found = false;
			sx = -3;
			for (int index0 = 0; index0 < 6; index0++) {
				sy = -3;
				for (int index1 = 0; index1 < 6; index1++) {
					sz = -3;
					for (int index2 = 0; index2 < 6; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:fire")))) {
							found = true;
							if (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x + sx, y + sy, z + sz), "age") > saved_age) {
								saved_age = new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x + sx, y + sy, z + sz), "age");
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			saved_blockstate = (world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip39
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip39)
					: -1;
			if (found == true || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.MAGMA_BLOCK) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(AshenremainsModBlocks.FLAMING_ASH.get().defaultBlockState(), "blockstate", (int) saved_blockstate));
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(_bnbt, world.registryAccess());
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("age", saved_age);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
