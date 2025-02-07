package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GhastExplosionProcedure {
	@SubscribeEvent
	public static void onExplode(ExplosionEvent.Detonate event) {
		execute(event, event.getLevel(), event.getExplosion().center().x(), event.getExplosion().center().y(), event.getExplosion().center().z());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.getEntitiesOfClass(LargeFireball.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			for (int index0 = 0; index0 < 24; index0++) {
				sx = Mth.nextInt(RandomSource.create(), -3, 3);
				sy = Mth.nextInt(RandomSource.create(), 1, 3);
				sz = Mth.nextInt(RandomSource.create(), -3, 3);
				if ((world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:ghast_replaceable")))) {
					if (Math.random() < 0.6) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), Blocks.SOUL_SAND.defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), Blocks.SOUL_SOIL.defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
