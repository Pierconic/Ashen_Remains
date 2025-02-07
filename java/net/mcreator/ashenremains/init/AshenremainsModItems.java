
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.ashenremains.item.PineConeItem;
import net.mcreator.ashenremains.item.OakAcornItem;
import net.mcreator.ashenremains.item.JunglePodItem;
import net.mcreator.ashenremains.item.FlintAndTinderItem;
import net.mcreator.ashenremains.item.DarkAcornItem;
import net.mcreator.ashenremains.item.CherrySeedItem;
import net.mcreator.ashenremains.item.BucketOfAshItem;
import net.mcreator.ashenremains.item.BirchFrondItem;
import net.mcreator.ashenremains.item.AshBallItem;
import net.mcreator.ashenremains.item.AcaciaFrondItem;
import net.mcreator.ashenremains.AshenremainsMod;

public class AshenremainsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(AshenremainsMod.MODID);
	public static final DeferredItem<Item> FLOWERING_GRASS = block(AshenremainsModBlocks.FLOWERING_GRASS);
	public static final DeferredItem<Item> OAK_ACORN = REGISTRY.register("oak_acorn", OakAcornItem::new);
	public static final DeferredItem<Item> BIRCH_FROND = REGISTRY.register("birch_frond", BirchFrondItem::new);
	public static final DeferredItem<Item> ACACIA_FROND = REGISTRY.register("acacia_frond", AcaciaFrondItem::new);
	public static final DeferredItem<Item> JUNGLE_POD = REGISTRY.register("jungle_pod", JunglePodItem::new);
	public static final DeferredItem<Item> DARK_ACORN = REGISTRY.register("dark_acorn", DarkAcornItem::new);
	public static final DeferredItem<Item> PINE_CONE = REGISTRY.register("pine_cone", PineConeItem::new);
	public static final DeferredItem<Item> OAK_SPROUT = block(AshenremainsModBlocks.OAK_SPROUT);
	public static final DeferredItem<Item> DARK_OAK_SPROUT = block(AshenremainsModBlocks.DARK_OAK_SPROUT);
	public static final DeferredItem<Item> BIRCH_SPROUT = block(AshenremainsModBlocks.BIRCH_SPROUT);
	public static final DeferredItem<Item> ACACIA_SPROUT = block(AshenremainsModBlocks.ACACIA_SPROUT);
	public static final DeferredItem<Item> JUNGLE_SPROUT = block(AshenremainsModBlocks.JUNGLE_SPROUT);
	public static final DeferredItem<Item> SPRUCE_SPROUT = block(AshenremainsModBlocks.SPRUCE_SPROUT);
	public static final DeferredItem<Item> ASH = block(AshenremainsModBlocks.ASH);
	public static final DeferredItem<Item> ASH_LAYER_14 = block(AshenremainsModBlocks.ASH_LAYER_14);
	public static final DeferredItem<Item> ASH_LAYER_12 = block(AshenremainsModBlocks.ASH_LAYER_12);
	public static final DeferredItem<Item> ASH_LAYER_10 = block(AshenremainsModBlocks.ASH_LAYER_10);
	public static final DeferredItem<Item> ASH_LAYER_8 = block(AshenremainsModBlocks.ASH_LAYER_8);
	public static final DeferredItem<Item> ASH_LAYER_6 = block(AshenremainsModBlocks.ASH_LAYER_6);
	public static final DeferredItem<Item> ASH_LAYER_4 = block(AshenremainsModBlocks.ASH_LAYER_4);
	public static final DeferredItem<Item> ASH_LAYER_2 = block(AshenremainsModBlocks.ASH_LAYER_2);
	public static final DeferredItem<Item> BUCKET_OF_ASH = REGISTRY.register("bucket_of_ash", BucketOfAshItem::new);
	public static final DeferredItem<Item> WEIRD_FIRE = block(AshenremainsModBlocks.WEIRD_FIRE);
	public static final DeferredItem<Item> EAST_FIRE = block(AshenremainsModBlocks.EAST_FIRE);
	public static final DeferredItem<Item> WEST_FIRE = block(AshenremainsModBlocks.WEST_FIRE);
	public static final DeferredItem<Item> NORTH_FIRE = block(AshenremainsModBlocks.NORTH_FIRE);
	public static final DeferredItem<Item> SOUTH_FIRE = block(AshenremainsModBlocks.SOUTH_FIRE);
	public static final DeferredItem<Item> FLINT_AND_TINDER = REGISTRY.register("flint_and_tinder", FlintAndTinderItem::new);
	public static final DeferredItem<Item> CHARRED_WOOD_WOOD = block(AshenremainsModBlocks.CHARRED_WOOD_WOOD);
	public static final DeferredItem<Item> CHARRED_WOOD_LOG = block(AshenremainsModBlocks.CHARRED_WOOD_LOG);
	public static final DeferredItem<Item> CHARRED_WOOD_PLANKS = block(AshenremainsModBlocks.CHARRED_WOOD_PLANKS);
	public static final DeferredItem<Item> CHARRED_WOOD_STAIRS = block(AshenremainsModBlocks.CHARRED_WOOD_STAIRS);
	public static final DeferredItem<Item> CHARRED_WOOD_SLAB = block(AshenremainsModBlocks.CHARRED_WOOD_SLAB);
	public static final DeferredItem<Item> CHARRED_WOOD_FENCE = block(AshenremainsModBlocks.CHARRED_WOOD_FENCE);
	public static final DeferredItem<Item> CHARRED_WOOD_FENCE_GATE = block(AshenremainsModBlocks.CHARRED_WOOD_FENCE_GATE);
	public static final DeferredItem<Item> CHARRED_TRAP_DOOR = block(AshenremainsModBlocks.CHARRED_TRAP_DOOR);
	public static final DeferredItem<Item> CHARRED_DOOR = doubleBlock(AshenremainsModBlocks.CHARRED_DOOR);
	public static final DeferredItem<Item> CHARRED_STRIPPED_WOOD = block(AshenremainsModBlocks.CHARRED_STRIPPED_WOOD);
	public static final DeferredItem<Item> CHARRED_STRIPPED_LOG = block(AshenremainsModBlocks.CHARRED_STRIPPED_LOG);
	public static final DeferredItem<Item> FLAMING_ASH = block(AshenremainsModBlocks.FLAMING_ASH);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_14 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_14);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_12 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_12);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_10 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_10);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_8 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_8);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_6 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_6);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_4 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_4);
	public static final DeferredItem<Item> FLAMING_ASH_LAYER_2 = block(AshenremainsModBlocks.FLAMING_ASH_LAYER_2);
	public static final DeferredItem<Item> STRANGE_FIRE = block(AshenremainsModBlocks.STRANGE_FIRE);
	public static final DeferredItem<Item> GRIEFER_SPAWN_EGG = REGISTRY.register("griefer_spawn_egg", () -> new DeferredSpawnEggItem(AshenremainsModEntities.GRIEFER, -10066330, -26368, new Item.Properties()));
	public static final DeferredItem<Item> ACTIVATED_SOUL_SAND = block(AshenremainsModBlocks.ACTIVATED_SOUL_SAND);
	public static final DeferredItem<Item> ACTIVATED_SOUL_SOIL = block(AshenremainsModBlocks.ACTIVATED_SOUL_SOIL);
	public static final DeferredItem<Item> ASHY_GRASS = block(AshenremainsModBlocks.ASHY_GRASS);
	public static final DeferredItem<Item> CHARRED_ROOTS = block(AshenremainsModBlocks.CHARRED_ROOTS);
	public static final DeferredItem<Item> FAKE_STONE_BRICKS = block(AshenremainsModBlocks.FAKE_STONE_BRICKS);
	public static final DeferredItem<Item> FAKE_COBBLESTONE = block(AshenremainsModBlocks.FAKE_COBBLESTONE);
	public static final DeferredItem<Item> BLOSSOMING_STONE_BRICKS = block(AshenremainsModBlocks.BLOSSOMING_STONE_BRICKS);
	public static final DeferredItem<Item> BLOSSOMING_COBBLESTONE = block(AshenremainsModBlocks.BLOSSOMING_COBBLESTONE);
	public static final DeferredItem<Item> CHERRY_SPROUT = block(AshenremainsModBlocks.CHERRY_SPROUT);
	public static final DeferredItem<Item> CHERRY_SEED = REGISTRY.register("cherry_seed", CherrySeedItem::new);
	public static final DeferredItem<Item> ASH_BALL = REGISTRY.register("ash_ball", AshBallItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
