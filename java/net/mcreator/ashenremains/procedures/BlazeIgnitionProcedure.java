package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BlazeIgnitionProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
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
		if (entity instanceof Blaze) {
			if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && world.isEmptyBlock(BlockPos.containing(x, y, z))) {
				world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))) && world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		}
	}
}
