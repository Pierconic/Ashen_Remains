package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class AdditionalCharredSoundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 5; index0++) {
			world.addParticle(ParticleTypes.LARGE_SMOKE, (x + 0.5 + Mth.nextInt(RandomSource.create(), (int) (-0.3), (int) 0.3)), (y + 0.5), (z + 0.5 + Mth.nextInt(RandomSource.create(), (int) (-0.3), (int) 0.3)), 0, 0.1, 0);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.NEUTRAL, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.NEUTRAL, 2, 1, false);
			}
		}
		CharredDisintegrateProcedure.execute(world, x, y, z);
	}
}
