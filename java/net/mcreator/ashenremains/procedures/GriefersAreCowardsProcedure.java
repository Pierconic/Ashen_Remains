package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModParticleTypes;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;
import net.mcreator.ashenremains.AshenremainsMod;

public class GriefersAreCowardsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double BlindnessDuration = 0;
		if (!entity.isInWaterRainOrBubble()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), x, y, z, 24, 0.2, 0.2, 0.2, 0.3);
			GrieferBlindnessProcedure.execute(world, x, y, z);
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))) {
				world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			AshenremainsMod.queueServerWork(20, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
				}
			});
		}
	}
}
