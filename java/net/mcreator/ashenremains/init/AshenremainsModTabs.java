
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.ashenremains.AshenremainsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AshenremainsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AshenremainsMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_WOOD.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_LOG.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_PLANKS.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_STAIRS.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_SLAB.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_FENCE.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_STRIPPED_WOOD.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_STRIPPED_LOG.get().asItem());
			tabData.accept(AshenremainsModBlocks.FLAMING_ASH.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {

			tabData.accept(AshenremainsModBlocks.CHARRED_WOOD_FENCE_GATE.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_TRAP_DOOR.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_DOOR.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(AshenremainsModItems.GRIEFER_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(AshenremainsModItems.OAK_ACORN.get());
			tabData.accept(AshenremainsModItems.BIRCH_FROND.get());
			tabData.accept(AshenremainsModItems.ACACIA_FROND.get());
			tabData.accept(AshenremainsModItems.JUNGLE_POD.get());
			tabData.accept(AshenremainsModItems.DARK_ACORN.get());
			tabData.accept(AshenremainsModItems.PINE_CONE.get());
			tabData.accept(AshenremainsModItems.BUCKET_OF_ASH.get());
			tabData.accept(AshenremainsModItems.CHERRY_SEED.get());
			tabData.accept(AshenremainsModItems.ASH_BALL.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

			tabData.accept(AshenremainsModBlocks.FLOWERING_GRASS.get().asItem());
			tabData.accept(AshenremainsModBlocks.OAK_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.DARK_OAK_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.BIRCH_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.ACACIA_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.JUNGLE_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.SPRUCE_SPROUT.get().asItem());
			tabData.accept(AshenremainsModBlocks.ASH.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHARRED_ROOTS.get().asItem());
			tabData.accept(AshenremainsModBlocks.CHERRY_SPROUT.get().asItem());

		}
	}
}
