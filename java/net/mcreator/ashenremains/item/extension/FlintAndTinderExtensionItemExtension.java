
package net.mcreator.ashenremains.item.extension;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.Direction;

import net.mcreator.ashenremains.procedures.FlintAndTinderDispenseSuccessfullyIfProcedure;
import net.mcreator.ashenremains.procedures.FireStarterProcedure;
import net.mcreator.ashenremains.init.AshenremainsModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FlintAndTinderExtensionItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(AshenremainsModItems.FLINT_AND_TINDER.get(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				int x = blockSource.pos().getX();
				int y = blockSource.pos().getY();
				int z = blockSource.pos().getZ();
				this.setSuccess(FlintAndTinderDispenseSuccessfullyIfProcedure.execute(world, x, y, z, direction));
				boolean success = this.isSuccess();
				FireStarterProcedure.execute(world, x, y, z, direction, itemstack);
				if (success)
					itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
