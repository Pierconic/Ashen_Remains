package net.mcreator.ashenremains.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LightningStrikeProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LightningBolt && (world.getDifficulty() == Difficulty.HARD || world.getDifficulty() == Difficulty.NORMAL)) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (Math.random() < 0.5 && world.getBlockState(BlockPos.containing(x - 1, y - 1, z)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (Math.random() < 0.5 && world.getBlockState(BlockPos.containing(x + 1, y - 1, z)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (Math.random() < 0.5 && world.getBlockState(BlockPos.containing(x, y - 1, z + 1)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
			if (Math.random() < 0.5 && world.getBlockState(BlockPos.containing(x, y - 1, z - 1)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), AshenremainsModBlocks.WEIRD_FIRE.get().defaultBlockState(), 3);
			}
		}
	}
}
