package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ashenremains.init.AshenremainsModGameRules;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class WeDidntStartTheFireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction) {
		if (direction == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:candles")))) {
			CandleIgnitionProcedure.execute(world, x, y, z, blockstate);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAMPFIRE) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ campfire");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_CAMPFIRE) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ soul_campfire");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TNT) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.tnt.primed")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))
				&& (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OBSIDIAN) || world.getLevelData().getGameRules().getBoolean(AshenremainsModGameRules.EASY_PORTALS))) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks"))) && direction == Direction.UP) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else if (direction == Direction.UP) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.FIRE.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:other_flammable")))) && !(world.getLevelData().isRaining() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)))
				&& Math.random() < 1) {
			if (direction == Direction.UP && ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x, y + 1, z)))
					&& !(world.getBlockState(BlockPos.containing(x, y + 1, z))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x, y + 1, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			} else if (direction == Direction.DOWN && ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x, y - 1, z)))
					&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.STRANGE_FIRE.get().defaultBlockState(), 3);
			} else if (direction == Direction.NORTH && ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x, y, z - 1)))
					&& !(world.getBlockState(BlockPos.containing(x, y, z - 1))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x, y, z - 1), AshenremainsModBlocks.NORTH_FIRE.get().defaultBlockState(), 3);
			} else if (direction == Direction.SOUTH && ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x, y, z + 1)))
					&& !(world.getBlockState(BlockPos.containing(x, y, z + 1))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x, y, z + 1), AshenremainsModBlocks.SOUTH_FIRE.get().defaultBlockState(), 3);
			} else if (direction == Direction.WEST && ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x - 1, y, z)))
					&& !(world.getBlockState(BlockPos.containing(x - 1, y, z))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x - 1, y, z), AshenremainsModBlocks.WEST_FIRE.get().defaultBlockState(), 3);
			} else if (direction == Direction.EAST && ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:fire_ignore"))) || world.isEmptyBlock(BlockPos.containing(x + 1, y, z)))
					&& !(world.getBlockState(BlockPos.containing(x + 1, y, z))).getFluidState().isSource() && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() instanceof LiquidBlock)) {
				world.setBlock(BlockPos.containing(x + 1, y, z), AshenremainsModBlocks.EAST_FIRE.get().defaultBlockState(), 3);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
