package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class NewAshMergingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.ASH.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get())
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
						? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip5)
						: -1) != 0) {
			while (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.ASH.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get())
					&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11
							? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip11)
							: -1) != 0) {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip13)
						: -1) == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip16)
								: -1) + 1);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19
							? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip19)
							: -1) - 1);
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
	}
}
