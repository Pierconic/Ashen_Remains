
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.ashenremains.client.particle.AshParticlesParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AshenremainsModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(AshenremainsModParticleTypes.ASH_PARTICLES.get(), AshParticlesParticle::provider);
	}
}
