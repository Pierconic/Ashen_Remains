
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.ashenremains.AshenremainsMod;

public class AshenremainsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, AshenremainsMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ASH_PARTICLES = REGISTRY.register("ash_particles", () -> new SimpleParticleType(false));
}
