package net.mcreator.ashenremains.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class FireStarterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, ItemStack itemstack) {
		if (direction == null)
			return;
		boolean damaged = false;
		ItemStack itemstate = ItemStack.EMPTY;
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		if (direction == Direction.DOWN) {
			if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		} else if (direction == Direction.UP) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x, y + 2, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		} else if (direction == Direction.NORTH) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		} else if (direction == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		} else if (direction == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		} else if (direction == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:soul_fire_base_blocks")))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:infiniburn")))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.FIRE.defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:flammable")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:semi_flammable")))
					|| (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:extremely_flammable")))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.flintandsteel.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
