package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.ashenremains.init.AshenremainsModParticleTypes;
import net.mcreator.ashenremains.init.AshenremainsModEntities;
import net.mcreator.ashenremains.init.AshenremainsModBlocks;
import net.mcreator.ashenremains.AshenremainsMod;

public class RegularAshDamageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip3) : -1) == 1) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.1), (entity.getDeltaMovement().y() * 0.9), (entity.getDeltaMovement().z() * 0.1)));
			entity.fallDistance = 0;
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip10 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip10) : -1) == 2
				|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12)
						: -1) == 3) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.3), (entity.getDeltaMovement().y() * 0.95), (entity.getDeltaMovement().z() * 0.3)));
			entity.fallDistance = 0;
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip19) : -1) == 4
				|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip21)
						: -1) == 5) {
			entity.fallDistance = 0;
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.5), (entity.getDeltaMovement().y() * 0.98), (entity.getDeltaMovement().z() * 0.5)));
		} else {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.7), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 0.7)));
		}
		if (entity instanceof ItemEntity) {
			if ((entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("forge:ashdestroyable")))) {
				AshenremainsMod.queueServerWork(60, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		} else {
			if (Math.random() < 0.005 && !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) && !entity.isInWaterRainOrBubble()) {
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 6 && !(entity instanceof ItemEntity) && !(entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(MobEffects.FIRE_RESISTANCE))
						&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:ash_immune")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y + 0.9), (z + 0.5), 10, 0.2, 0.2, 0.2, 0.2);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.HOT_FLOOR)), 1);
				}
				if (entity instanceof Creeper && Math.random() < 0.2) {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), x, y, z, 15, 0.2, 0.2, 0.2, 0.4);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.death")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.death")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = AshenremainsModEntities.GRIEFER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(entity.getYRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							entityToSpawn.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
						}
					}
				}
			}
			if (Math.random() < 0.005 && !(entity instanceof ItemEntity) && !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) && !entity.isInWaterRainOrBubble()) {
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 6 && !(entity instanceof LivingEntity _livEnt69 && _livEnt69.hasEffect(MobEffects.FIRE_RESISTANCE))
						&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:ash_immune")))
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (AshenremainsModParticleTypes.ASH_PARTICLES.get()), (x + 0.5), (y + 0.9), (z + 0.5), 10, 0.2, 0.2, 0.2, 0.2);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.HOT_FLOOR)), 1);
				}
			}
			if (Math.random() < 0.04 && (entity.getDeltaMovement().z() > 0 || entity.getDeltaMovement().x() > 0)) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss.step")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.ASH.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == AshenremainsModBlocks.FLAMING_ASH.get()
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:ashblocks")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, false, false));
				if (Math.random() < 0.005 && !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) && !entity.isInWaterRainOrBubble()) {
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 6 && !(entity instanceof LivingEntity _livEnt92 && _livEnt92.hasEffect(MobEffects.FIRE_RESISTANCE))
							&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:ash_immune")))
							&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.HOT_FLOOR)), 1);
					}
				}
			}
		}
	}
}
