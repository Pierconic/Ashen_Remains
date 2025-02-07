
package net.mcreator.ashenremains.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;

import net.mcreator.ashenremains.procedures.QuestionableChoiceProcedure;
import net.mcreator.ashenremains.procedures.LegacyFlintSteelCheckProcedure;

public class FlintAndTinderItem extends Item {
	public FlintAndTinderItem() {
		super(new Item.Properties().durability(52).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		LegacyFlintSteelCheckProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		QuestionableChoiceProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
