
package net.mcreator.ashenremains.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.ashenremains.procedures.GrieferSubmergedProcedure;
import net.mcreator.ashenremains.entity.GrieferEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GrieferRenderer extends MobRenderer<GrieferEntity, CreeperModel<GrieferEntity>> {
	public GrieferRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
		this.addLayer(new RenderLayer<GrieferEntity, CreeperModel<GrieferEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ashenremains:textures/entities/darkestglow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GrieferEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GrieferEntity entity) {
		return ResourceLocation.parse("ashenremains:textures/entities/griefed.png");
	}

	@Override
	protected boolean isShaking(GrieferEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return GrieferSubmergedProcedure.execute(world, x, y, z);
	}
}
