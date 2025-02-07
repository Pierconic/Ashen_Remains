package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EntityTypeTags;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AshenDemiseProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getRemainingFireTicks() > 0 && !entity.getType().is(EntityTypeTags.UNDEAD)) {
			if (Math.random() < 0.4) {
				AshAccumulateProcedure.execute(world, x + 1, y, z);
			}
			if (Math.random() < 0.4) {
				AshAccumulateProcedure.execute(world, x - 1, y, z);
			}
			if (Math.random() < 0.4) {
				AshAccumulateProcedure.execute(world, x, y, z + 1);
			}
			if (Math.random() < 0.4) {
				AshAccumulateProcedure.execute(world, x, y, z - 1);
			}
			for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 2, 3); index0++) {
				AshAccumulateProcedure.execute(world, x, y, z);
			}
		}
	}
}
