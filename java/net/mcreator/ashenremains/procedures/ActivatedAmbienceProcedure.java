package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;
import net.mcreator.ashenremains.AshenremainsMod;

public class ActivatedAmbienceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.ambient")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.ambient")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if ((!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty() || !world.getEntitiesOfClass(WitherBoss.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty())
				&& world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			if (Math.random() < 0.008) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				for (int index0 = 0; index0 < 6; index0++) {
					world.addParticle(ParticleTypes.SOUL, x, (y + 1), z, 0, 1, 0);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else {
			AshenremainsMod.queueServerWork(800, () -> {
				if (!((!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty() || !world.getEntitiesOfClass(WitherBoss.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty())
						&& world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WITHER_SKELETON_SKULL)) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.ACTIVATED_SOUL_SAND.get()) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SOUL_SAND.defaultBlockState(), 3);
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AshenremainsModBlocks.ACTIVATED_SOUL_SOIL.get()) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SOUL_SOIL.defaultBlockState(), 3);
					}
				}
			});
		}
	}
}
