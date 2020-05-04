package com.lunaticcat.yourbuddycal.client.model;
// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

import com.lunaticcat.yourbuddycal.entity.cals.ClassicCalEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class ClassicCalModel<T extends ClassicCalEntity> extends EntityModel<T> {
	private final RendererModel head;
	private final RendererModel body;
	private final RendererModel leftarm1;
	private final RendererModel leftarm2;
	private final RendererModel rightarm1;
	private final RendererModel rightarm2;
	private final RendererModel rightleg1;
	private final RendererModel rightleg2;
	private final RendererModel leftleg1;
	private final RendererModel leftleg2;

	public ClassicCalModel() {
		textureWidth = 87;
		textureHeight = 71;

		head = new RendererModel(this, 0, 0);
		head.setRotationPoint(2.0F, 10.0F, 4.0F);
		setRotation(head, 0.0F, 0.0F, 0.0F);
		head.setTextureOffset(37, 25).addBox(-5.0F, -14.0F, -4.0F, 9, 2, 7, 0.0F, false);
		head.setTextureOffset(44, 34).addBox(-5.0F, -13.0F, -7.0F, 9, 1, 3, 0.0F, false);
		head.setTextureOffset(0, 45).addBox(-5.0F, -12.0F, -4.0F, 9, 5, 7, 0.0F, false);
		head.setTextureOffset(0, 32).addBox(-8.0F, -7.0F, -4.0F, 15, 6, 7, 0.0F, false);
		head.setTextureOffset(25, 46).addBox(-3.0F, -1.0F, -3.0F, 5, 1, 5, 0.0F, false);

		body = new RendererModel(this, 0, 0);
		body.setRotationPoint(2.0F, 24.0F, 6.0F);
		setRotation(body, 0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-6.0F, -14.0F, -6.0F, 11, 25, 7, 0.0F, false);
		body.setTextureOffset(62, 25).addBox(-5.0F, 11.0F, -4.0F, 9, 3, 3, 0.0F, false);

		rightarm1 = new RendererModel(this);
		rightarm1.setRotationPoint(7.0F, 12.0F, 3.0F);
		setRotation(rightarm1, 0.0F, 0.0F, 0.0F);
		rightarm1.setTextureOffset(0, 21).addBox(0.0F, -2.0F, -3.0F, 4, 4, 7, 0.0F, false);
		rightarm1.setTextureOffset(0, 20).addBox(1.0F, 2.0F, -3.0F, 4, 5, 7, 0.0F, false);
		rightarm1.setTextureOffset(46, 0).addBox(2.0F, 7.0F, -1.0F, 2, 11, 3, 0.0F, false);

		rightarm2 = new RendererModel(this);
		rightarm2.setRotationPoint(10.0F, 30.0F, 4.0F);
		setRotation(rightarm2, 0.0F, 0.0F, 0.0F);
		rightarm2.setTextureOffset(76, 48).addBox(-1.0F, 16.0F, -1.0F, 1, 3, 5, 0.0F, false);
		rightarm2.setTextureOffset(68, 43).addBox(-2.0F, 17.0F, -1.0F, 1, 3, 5, 0.0F, false);
		rightarm2.setTextureOffset(59, 46).addBox(0.0F, 16.0F, -1.0F, 2, 6, 5, 0.0F, false);
		rightarm2.setTextureOffset(66, 14).addBox(-1.0F, 8.0F, 0.0F, 2, 8, 3, 0.0F, false);
		rightarm2.setTextureOffset(56, 14).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 3, 0.0F, false);

		leftarm1 = new RendererModel(this);
		leftarm1.setRotationPoint(-4.0F, 12.0F, 4.0F);
		setRotation(leftarm1, 0.0F, 0.0F, 0.0F);
		leftarm1.setTextureOffset(0, 21).addBox(-4.0F, -2.0F, -4.0F, 4, 4, 7, 0.0F, false);
		leftarm1.setTextureOffset(0, 20).addBox(-5.0F, 2.0F, -4.0F, 4, 5, 7, 0.0F, false);
		leftarm1.setTextureOffset(36, 0).addBox(-4.0F, 7.0F, -2.0F, 2, 11, 3, 0.0F, false);

		leftarm2 = new RendererModel(this);
		leftarm2.setRotationPoint(-7.0F, 30.0F, 4.0F);
		setRotation(leftarm2, 0.0F, 0.0F, 0.0F);
		leftarm2.setTextureOffset(36, 14).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 3, 0.0F, false);
		leftarm2.setTextureOffset(46, 14).addBox(-1.0F, 8.0F, 0.0F, 2, 8, 3, 0.0F, false);
		leftarm2.setTextureOffset(45, 46).addBox(-2.0F, 16.0F, -1.0F, 2, 6, 5, 0.0F, false);
		leftarm2.setTextureOffset(44, 38).addBox(1.0F, 17.0F, -1.0F, 1, 3, 5, 0.0F, false);
		leftarm2.setTextureOffset(56, 38).addBox(0.0F, 16.0F, -1.0F, 1, 3, 5, 0.0F, false);

		leftleg1 = new RendererModel(this);
		leftleg1.setRotationPoint(-2.0F, 38.0F, 4.0F);
		setRotation(leftleg1, 0.0F, 0.0F, 0.0F);
		leftleg1.setTextureOffset(66, 0).addBox(-1.0F, 0.0F, -2.0F, 2, 11, 3, 0.0F, false);

		leftleg2 = new RendererModel(this);
		leftleg2.setRotationPoint(-2.0F, 49.0F, 4.0F);
		setRotation(leftleg2, 0.0F, 0.0F, 0.0F);
		leftleg2.setTextureOffset(76, 14).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 3, 0.0F, false);
		leftleg2.setTextureOffset(76, 3).addBox(-1.0F, 8.0F, 0.0F, 2, 8, 3, 0.0F, false);
		leftleg2.setTextureOffset(16, 63).addBox(-2.0F, 16.0F, -1.0F, 4, 1, 5, 0.0F, false);
		leftleg2.setTextureOffset(28, 62).addBox(-2.0F, 17.0F, -1.0F, 4, 1, 8, 0.0F, false);
		leftleg2.setTextureOffset(45, 61).addBox(-2.0F, 18.0F, -1.0F, 4, 1, 3, 0.0F, false);
		leftleg2.setTextureOffset(29, 57).addBox(-2.0F, 18.0F, 3.0F, 4, 1, 4, 0.0F, false);

		rightleg1 = new RendererModel(this);
		rightleg1.setRotationPoint(5.0F, 38.0F, 4.0F);
		setRotation(rightleg1, 0.0F, 0.0F, 0.0F);
		rightleg1.setTextureOffset(56, 0).addBox(-1.0F, 0.0F, -2.0F, 2, 11, 3, 0.0F, false);

		rightleg2 = new RendererModel(this);
		rightleg2.setRotationPoint(5.0F, 49.0F, 4.0F);
		setRotation(rightleg2, 0.0F, 0.0F, 0.0F);
		rightleg2.setTextureOffset(0, 57).addBox(-2.0F, 18.0F, 3.0F, 4, 1, 4, 0.0F, false);
		rightleg2.setTextureOffset(69, 31).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 3, 0.0F, false);
		rightleg2.setTextureOffset(79, 31).addBox(-1.0F, 8.0F, 0.0F, 2, 8, 3, 0.0F, false);
		rightleg2.setTextureOffset(16, 57).addBox(-2.0F, 16.0F, -1.0F, 4, 1, 5, 0.0F, false);
		rightleg2.setTextureOffset(0, 62).addBox(-2.0F, 17.0F, -1.0F, 4, 1, 8, 0.0F, false);
		rightleg2.setTextureOffset(45, 57).addBox(-2.0F, 18.0F, -1.0F, 4, 1, 3, 0.0F, false);
	}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		scale*=0.65F;
		GL11.glTranslatef(0.05F, -1.30F, 0.25F);
		GL11.glRotatef(180,0,90,0);

		setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		body.render(scale);
		rightarm1.render(scale);
		rightarm2.render(scale);
		leftarm1.render(scale);
		leftarm2.render(scale);
		leftleg1.render(scale);
		leftleg2.render(scale);
		rightleg1.render(scale);
		rightleg2.render(scale);
	}

	private void setRotation(RendererModel model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.leftleg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightleg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}
}