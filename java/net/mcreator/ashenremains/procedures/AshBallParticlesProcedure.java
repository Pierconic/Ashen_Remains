package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ashenremains.init.AshenremainsModParticleTypes;

public class AshBallParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y + 1), (z + 0.5), 20, 0.1, 0.1, 0.1, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y + 1), (z + 0.5), 20, 0.1, 0.1, 0.1, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y + 1), (z + 0.5), 20, 0.1, 0.1, 0.1, 1);
	}
}
