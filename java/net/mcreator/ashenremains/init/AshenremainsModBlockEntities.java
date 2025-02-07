
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ashenremains.block.entity.WestFireBlockEntity;
import net.mcreator.ashenremains.block.entity.WeirdFireBlockEntity;
import net.mcreator.ashenremains.block.entity.StrangeFireBlockEntity;
import net.mcreator.ashenremains.block.entity.SouthFireBlockEntity;
import net.mcreator.ashenremains.block.entity.NorthFireBlockEntity;
import net.mcreator.ashenremains.block.entity.FlamingAshBlockEntity;
import net.mcreator.ashenremains.block.entity.EastFireBlockEntity;
import net.mcreator.ashenremains.AshenremainsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AshenremainsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AshenremainsMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WEIRD_FIRE = register("weird_fire", AshenremainsModBlocks.WEIRD_FIRE, WeirdFireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> EAST_FIRE = register("east_fire", AshenremainsModBlocks.EAST_FIRE, EastFireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WEST_FIRE = register("west_fire", AshenremainsModBlocks.WEST_FIRE, WestFireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> NORTH_FIRE = register("north_fire", AshenremainsModBlocks.NORTH_FIRE, NorthFireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SOUTH_FIRE = register("south_fire", AshenremainsModBlocks.SOUTH_FIRE, SouthFireBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLAMING_ASH = register("flaming_ash", AshenremainsModBlocks.FLAMING_ASH, FlamingAshBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> STRANGE_FIRE = register("strange_fire", AshenremainsModBlocks.STRANGE_FIRE, StrangeFireBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WEIRD_FIRE.get(), (blockEntity, side) -> ((WeirdFireBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EAST_FIRE.get(), (blockEntity, side) -> ((EastFireBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WEST_FIRE.get(), (blockEntity, side) -> ((WestFireBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NORTH_FIRE.get(), (blockEntity, side) -> ((NorthFireBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOUTH_FIRE.get(), (blockEntity, side) -> ((SouthFireBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLAMING_ASH.get(), (blockEntity, side) -> ((FlamingAshBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRANGE_FIRE.get(), (blockEntity, side) -> ((StrangeFireBlockEntity) blockEntity).getItemHandler());
	}
}
