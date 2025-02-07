package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.AshenremainsMod;

public class CandleIgnitionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!((blockstate.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true)) {
			AshenremainsMod.queueServerWork(1, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			});
		}
	}
}
