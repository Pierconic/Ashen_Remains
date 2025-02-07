package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CreeperMossProcedure {
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
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true && !world.getEntitiesOfClass(Creeper.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:base_stone_overworld")))) {
				if (((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
						|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:base_stone_overworld"))))
						&& ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
								|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:base_stone_overworld"))))
						&& ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
								|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:base_stone_overworld"))))
						&& ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
								|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:base_stone_overworld"))))) {
					world.setBlock(BlockPos.containing(x - 1, y - 1, z - 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y - 1, z + 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 1, y - 1, z + 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 1, y - 1, z - 1), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x - 1, y - 1, z - 1);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x + 1, y - 1, z + 1);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x - 1, y - 1, z + 1);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x + 1, y - 1, z - 1);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
				}
			}
			TheMossIsRealProcedure.execute(world, x, y, z);
		}
	}
}
