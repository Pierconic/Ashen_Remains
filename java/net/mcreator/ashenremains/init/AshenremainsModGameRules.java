
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ashenremains.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AshenremainsModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> DOPLANTGROWTH;
	public static GameRules.Key<GameRules.BooleanValue> DOFIRESPREAD;
	public static GameRules.Key<GameRules.BooleanValue> MOB_FIRES;
	public static GameRules.Key<GameRules.IntegerValue> MAXIMUM_FIRE_DISTANCE;
	public static GameRules.Key<GameRules.IntegerValue> PLANT_GROWTH_SPEED;
	public static GameRules.Key<GameRules.BooleanValue> EASY_PORTALS;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		DOPLANTGROWTH = GameRules.register("doPlantGrowth", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));
		DOFIRESPREAD = GameRules.register("doFireSpread", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		MOB_FIRES = GameRules.register("mobFires", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		MAXIMUM_FIRE_DISTANCE = GameRules.register("maximumFireDistance", GameRules.Category.MISC, GameRules.IntegerValue.create(50));
		PLANT_GROWTH_SPEED = GameRules.register("plantGrowthSpeed", GameRules.Category.MISC, GameRules.IntegerValue.create(10));
		EASY_PORTALS = GameRules.register("easyPortals", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	}
}
