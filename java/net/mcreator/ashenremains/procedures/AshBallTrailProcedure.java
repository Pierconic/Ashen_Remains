package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ashenremains.init.AshenremainsModParticleTypes;

public class AshBallTrailProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.3), y, (z + 0.3), Mth.nextInt(RandomSource.create(), 0, 1), 0.2, 0.2, 0.2, 1);
	}
}
