package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModGameRules;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;
import net.mcreator.ashenremains.AshenremainsMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FlamingArrowProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double baseRate = 0;
		double rateWithAmplifier = 0;
		if (entity instanceof Arrow && entity.isOnFire()) {
			AshenremainsMod.queueServerWork(Mth.nextInt(RandomSource.create(), 180, 300), () -> {
				if (entity.isAlive()
						&& ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable"))))
						&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("age", Math.ceil((world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.MAXIMUM_FIRE_DISTANCE)) * 0.6));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if ((entity.getDirection()) == Direction.NORTH && entity.isAlive()
						&& ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable"))))
						&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AshenremainsModBlocks.SOUTH_FIRE.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("age", Math.ceil((world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.MAXIMUM_FIRE_DISTANCE)) * 0.6));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if ((entity.getDirection()) == Direction.SOUTH && entity.isAlive()
						&& ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable"))))
						&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AshenremainsModBlocks.NORTH_FIRE.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("age", Math.ceil((world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.MAXIMUM_FIRE_DISTANCE)) * 0.6));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if ((entity.getDirection()) == Direction.WEST && entity.isAlive()
						&& ((world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable"))))
						&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AshenremainsModBlocks.WEST_FIRE.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("age", Math.ceil((world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.MAXIMUM_FIRE_DISTANCE)) * 0.6));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if ((entity.getDirection()) == Direction.EAST && entity.isAlive()
						&& ((world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
								|| (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable"))))
						&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AshenremainsModBlocks.EAST_FIRE.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("age", Math.ceil((world.getLevelData().getGameRules().getInt(AshenremainsModGameRules.MAXIMUM_FIRE_DISTANCE)) * 0.6));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
