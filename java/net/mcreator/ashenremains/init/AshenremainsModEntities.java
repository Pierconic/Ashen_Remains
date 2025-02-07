
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.ashenremains.entity.GrieferEntity;
import net.mcreator.ashenremains.entity.AshBallProjectileEntity;
import net.mcreator.ashenremains.AshenremainsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AshenremainsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, AshenremainsMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<GrieferEntity>> GRIEFER = register("griefer",
			EntityType.Builder.<GrieferEntity>of(GrieferEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<AshBallProjectileEntity>> ASH_BALL_PROJECTILE = register("ash_ball_projectile",
			EntityType.Builder.<AshBallProjectileEntity>of(AshBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		GrieferEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GRIEFER.get(), GrieferEntity.createAttributes().build());
	}
}
