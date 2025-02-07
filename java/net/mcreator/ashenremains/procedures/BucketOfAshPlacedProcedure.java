package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ashenremains.init.AshenremainsModItems;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class BucketOfAshPlacedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_y = 0;
		double raytrace_x = 0;
		double raytrace_z = 0;
		if (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getType() == HitResult.Type.BLOCK
				&& !(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
			raytrace_x = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			raytrace_y = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			raytrace_z = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if (world.getBlockState(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z)).canOcclude() && world.isEmptyBlock(BlockPos.containing(raytrace_x, raytrace_y + 1, raytrace_z))) {
				world.setBlock(BlockPos.containing(raytrace_x, raytrace_y + 1, raytrace_z), AshenremainsModBlocks.ASH.get().defaultBlockState(), 3);
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AshenremainsModItems.BUCKET_OF_ASH.get()) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AshenremainsModItems.BUCKET_OF_ASH.get()) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z))).getBlock() == Blocks.DIRT_PATH
						|| (world.getBlockState(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z))).getBlock() == Blocks.PODZOL
						|| (world.getBlockState(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z))).getBlock() == AshenremainsModBlocks.FLOWERING_GRASS.get()) {
					world.setBlock(BlockPos.containing(raytrace_x, raytrace_y, raytrace_z), AshenremainsModBlocks.ASHY_GRASS.get().defaultBlockState(), 3);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}
