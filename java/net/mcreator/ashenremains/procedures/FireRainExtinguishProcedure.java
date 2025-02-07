package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FireRainExtinguishProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean path = false;
		boolean pathfound = false;
		boolean found = false;
		double uy = 0;
		if (world.getLevelData().isRaining()) {
			path = false;
			pathfound = false;
			if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
				uy = y + 1;
				while (pathfound == false) {
					if (world.isEmptyBlock(BlockPos.containing(x, uy, z)) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, uy, z))) {
						pathfound = true;
						path = true;
					} else if (world.isEmptyBlock(BlockPos.containing(x, uy, z)) && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, uy, z))
							|| !world.getBlockState(BlockPos.containing(x, uy, z)).isFaceSturdy(world, BlockPos.containing(x, uy, z), Direction.UP)) {
						uy = uy + 1;
					} else {
						pathfound = true;
					}
				}
			}
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)) || path == true) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (Math.random() < 0.5) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
