package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class AshNeighborUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() instanceof LiquidBlock
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() instanceof LiquidBlock) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.ASH.get())
				&& !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get())) {
			AshfallProcedure.execute(world, x, y, z);
		} else {
			NewAshMergingProcedure.execute(world, x, y, z);
		}
	}
}
