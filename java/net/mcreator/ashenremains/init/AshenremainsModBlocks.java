
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.ashenremains.block.WestFireBlock;
import net.mcreator.ashenremains.block.WeirdFireBlock;
import net.mcreator.ashenremains.block.StrangeFireBlock;
import net.mcreator.ashenremains.block.SpruceSproutBlock;
import net.mcreator.ashenremains.block.SouthFireBlock;
import net.mcreator.ashenremains.block.OakSproutBlock;
import net.mcreator.ashenremains.block.NorthFireBlock;
import net.mcreator.ashenremains.block.JungleSproutBlock;
import net.mcreator.ashenremains.block.FloweringGrassBlock;
import net.mcreator.ashenremains.block.FlamingAshLayer8Block;
import net.mcreator.ashenremains.block.FlamingAshLayer6Block;
import net.mcreator.ashenremains.block.FlamingAshLayer4Block;
import net.mcreator.ashenremains.block.FlamingAshLayer2Block;
import net.mcreator.ashenremains.block.FlamingAshLayer14Block;
import net.mcreator.ashenremains.block.FlamingAshLayer12Block;
import net.mcreator.ashenremains.block.FlamingAshLayer10Block;
import net.mcreator.ashenremains.block.FlamingAshBlock;
import net.mcreator.ashenremains.block.FakeStoneBricksBlock;
import net.mcreator.ashenremains.block.FakeCobblestoneBlock;
import net.mcreator.ashenremains.block.EastFireBlock;
import net.mcreator.ashenremains.block.DarkOakSproutBlock;
import net.mcreator.ashenremains.block.CherrySproutBlock;
import net.mcreator.ashenremains.block.CharredWoodWoodBlock;
import net.mcreator.ashenremains.block.CharredWoodStairsBlock;
import net.mcreator.ashenremains.block.CharredWoodSlabBlock;
import net.mcreator.ashenremains.block.CharredWoodPlanksBlock;
import net.mcreator.ashenremains.block.CharredWoodLogBlock;
import net.mcreator.ashenremains.block.CharredWoodFenceGateBlock;
import net.mcreator.ashenremains.block.CharredWoodFenceBlock;
import net.mcreator.ashenremains.block.CharredTrapDoorBlock;
import net.mcreator.ashenremains.block.CharredStrippedWoodBlock;
import net.mcreator.ashenremains.block.CharredStrippedLogBlock;
import net.mcreator.ashenremains.block.CharredRootsBlock;
import net.mcreator.ashenremains.block.CharredDoorBlock;
import net.mcreator.ashenremains.block.BlossomingStoneBricksBlock;
import net.mcreator.ashenremains.block.BlossomingCobblestoneBlock;
import net.mcreator.ashenremains.block.BirchSproutBlock;
import net.mcreator.ashenremains.block.AshyGrassBlock;
import net.mcreator.ashenremains.block.AshLayer8Block;
import net.mcreator.ashenremains.block.AshLayer6Block;
import net.mcreator.ashenremains.block.AshLayer4Block;
import net.mcreator.ashenremains.block.AshLayer2Block;
import net.mcreator.ashenremains.block.AshLayer14Block;
import net.mcreator.ashenremains.block.AshLayer12Block;
import net.mcreator.ashenremains.block.AshLayer10Block;
import net.mcreator.ashenremains.block.AshBlock;
import net.mcreator.ashenremains.block.ActivatedSoulSoilBlock;
import net.mcreator.ashenremains.block.ActivatedSoulSandBlock;
import net.mcreator.ashenremains.block.AcaciaSproutBlock;
import net.mcreator.ashenremains.AshenremainsMod;

public class AshenremainsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(AshenremainsMod.MODID);
	public static final DeferredBlock<Block> FLOWERING_GRASS = REGISTRY.register("flowering_grass", FloweringGrassBlock::new);
	public static final DeferredBlock<Block> OAK_SPROUT = REGISTRY.register("oak_sprout", OakSproutBlock::new);
	public static final DeferredBlock<Block> DARK_OAK_SPROUT = REGISTRY.register("dark_oak_sprout", DarkOakSproutBlock::new);
	public static final DeferredBlock<Block> BIRCH_SPROUT = REGISTRY.register("birch_sprout", BirchSproutBlock::new);
	public static final DeferredBlock<Block> ACACIA_SPROUT = REGISTRY.register("acacia_sprout", AcaciaSproutBlock::new);
	public static final DeferredBlock<Block> JUNGLE_SPROUT = REGISTRY.register("jungle_sprout", JungleSproutBlock::new);
	public static final DeferredBlock<Block> SPRUCE_SPROUT = REGISTRY.register("spruce_sprout", SpruceSproutBlock::new);
	public static final DeferredBlock<Block> ASH = REGISTRY.register("ash", AshBlock::new);
	public static final DeferredBlock<Block> ASH_LAYER_14 = REGISTRY.register("ash_layer_14", AshLayer14Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_12 = REGISTRY.register("ash_layer_12", AshLayer12Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_10 = REGISTRY.register("ash_layer_10", AshLayer10Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_8 = REGISTRY.register("ash_layer_8", AshLayer8Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_6 = REGISTRY.register("ash_layer_6", AshLayer6Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_4 = REGISTRY.register("ash_layer_4", AshLayer4Block::new);
	public static final DeferredBlock<Block> ASH_LAYER_2 = REGISTRY.register("ash_layer_2", AshLayer2Block::new);
	public static final DeferredBlock<Block> WEIRD_FIRE = REGISTRY.register("weird_fire", WeirdFireBlock::new);
	public static final DeferredBlock<Block> EAST_FIRE = REGISTRY.register("east_fire", EastFireBlock::new);
	public static final DeferredBlock<Block> WEST_FIRE = REGISTRY.register("west_fire", WestFireBlock::new);
	public static final DeferredBlock<Block> NORTH_FIRE = REGISTRY.register("north_fire", NorthFireBlock::new);
	public static final DeferredBlock<Block> SOUTH_FIRE = REGISTRY.register("south_fire", SouthFireBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_WOOD = REGISTRY.register("charred_wood_wood", CharredWoodWoodBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_LOG = REGISTRY.register("charred_wood_log", CharredWoodLogBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_PLANKS = REGISTRY.register("charred_wood_planks", CharredWoodPlanksBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_STAIRS = REGISTRY.register("charred_wood_stairs", CharredWoodStairsBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_SLAB = REGISTRY.register("charred_wood_slab", CharredWoodSlabBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_FENCE = REGISTRY.register("charred_wood_fence", CharredWoodFenceBlock::new);
	public static final DeferredBlock<Block> CHARRED_WOOD_FENCE_GATE = REGISTRY.register("charred_wood_fence_gate", CharredWoodFenceGateBlock::new);
	public static final DeferredBlock<Block> CHARRED_TRAP_DOOR = REGISTRY.register("charred_trap_door", CharredTrapDoorBlock::new);
	public static final DeferredBlock<Block> CHARRED_DOOR = REGISTRY.register("charred_door", CharredDoorBlock::new);
	public static final DeferredBlock<Block> CHARRED_STRIPPED_WOOD = REGISTRY.register("charred_stripped_wood", CharredStrippedWoodBlock::new);
	public static final DeferredBlock<Block> CHARRED_STRIPPED_LOG = REGISTRY.register("charred_stripped_log", CharredStrippedLogBlock::new);
	public static final DeferredBlock<Block> FLAMING_ASH = REGISTRY.register("flaming_ash", FlamingAshBlock::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_14 = REGISTRY.register("flaming_ash_layer_14", FlamingAshLayer14Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_12 = REGISTRY.register("flaming_ash_layer_12", FlamingAshLayer12Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_10 = REGISTRY.register("flaming_ash_layer_10", FlamingAshLayer10Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_8 = REGISTRY.register("flaming_ash_layer_8", FlamingAshLayer8Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_6 = REGISTRY.register("flaming_ash_layer_6", FlamingAshLayer6Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_4 = REGISTRY.register("flaming_ash_layer_4", FlamingAshLayer4Block::new);
	public static final DeferredBlock<Block> FLAMING_ASH_LAYER_2 = REGISTRY.register("flaming_ash_layer_2", FlamingAshLayer2Block::new);
	public static final DeferredBlock<Block> STRANGE_FIRE = REGISTRY.register("strange_fire", StrangeFireBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_SOUL_SAND = REGISTRY.register("activated_soul_sand", ActivatedSoulSandBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_SOUL_SOIL = REGISTRY.register("activated_soul_soil", ActivatedSoulSoilBlock::new);
	public static final DeferredBlock<Block> ASHY_GRASS = REGISTRY.register("ashy_grass", AshyGrassBlock::new);
	public static final DeferredBlock<Block> CHARRED_ROOTS = REGISTRY.register("charred_roots", CharredRootsBlock::new);
	public static final DeferredBlock<Block> FAKE_STONE_BRICKS = REGISTRY.register("fake_stone_bricks", FakeStoneBricksBlock::new);
	public static final DeferredBlock<Block> FAKE_COBBLESTONE = REGISTRY.register("fake_cobblestone", FakeCobblestoneBlock::new);
	public static final DeferredBlock<Block> BLOSSOMING_STONE_BRICKS = REGISTRY.register("blossoming_stone_bricks", BlossomingStoneBricksBlock::new);
	public static final DeferredBlock<Block> BLOSSOMING_COBBLESTONE = REGISTRY.register("blossoming_cobblestone", BlossomingCobblestoneBlock::new);
	public static final DeferredBlock<Block> CHERRY_SPROUT = REGISTRY.register("cherry_sprout", CherrySproutBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			FloweringGrassBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			FloweringGrassBlock.itemColorLoad(event);
		}
	}
}
