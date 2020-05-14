package com.lunaticcat.yourbuddycal.client.model;
// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

import com.lunaticcat.yourbuddycal.entity.cals.ClassicCalEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class ClassicCalModel<T extends ClassicCalEntity> extends EntityModel<T> {
	public boolean isIdle;
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

	private final RendererModel headIdle;
	private final RendererModel bodyIdle;
	private final RendererModel leftarm1Idle;
	private final RendererModel leftarm2Idle;
	private final RendererModel rightarm1Idle;
	private final RendererModel rightarm2Idle;
	private final RendererModel rightleg1Idle;
	private final RendererModel rightleg2Idle;
	private final RendererModel leftleg1Idle;
	private final RendererModel leftleg2Idle;

	public ClassicCalModel() {
		textureWidth = 89;
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

			//now the iddle model

		headIdle = new RendererModel(this, 0, 0);
		headIdle.setRotationPoint(2.0F, 10.0F, 4.0F);
		setRotation(headIdle, 0.0873F, 0.0F, -0.0873F);
		headIdle.setTextureOffset(37, 25).addBox(-3.605F, -29.8784F, -2.6103F, 9, 2, 7, 0.0F, false);
		headIdle.setTextureOffset(44, 34).addBox(-3.605F, -28.8784F, -5.6103F, 9, 1, 3, 0.0F, false);
		headIdle.setTextureOffset(0, 45).addBox(-3.605F, -27.8784F, -2.6103F, 9, 5, 7, 0.0F, false);
		headIdle.setTextureOffset(0, 32).addBox(-6.605F, -22.8784F, -2.6103F, 15, 6, 7, 0.0F, false);
		headIdle.setTextureOffset(25, 46).addBox(-1.605F, -16.8784F, -1.6103F, 5, 2, 5, 0.0F, false);

		bodyIdle = new RendererModel(this);
		bodyIdle.setRotationPoint(2.0F, 24.0F, 6.0F);
		bodyIdle.setTextureOffset(0, 0).addBox(-6.0F, -30.0F, -6.0F, 11, 25, 7, 0.0F, false);
		bodyIdle.setTextureOffset(62, 25).addBox(-5.0F, -5.0F, -4.0F, 9, 3, 3, 0.0F, false);

		rightarm1Idle = new RendererModel(this);
		rightarm1Idle.setRotationPoint(7.0F, 12.0F, 3.0F);
		setRotation(rightarm1Idle, 0.2618F, 0.0F, -0.4363F);
		rightarm1Idle.setTextureOffset(0, 21).addBox(6.7614F, -16.007F, 0.7532F, 4, 4, 7, 0.0F, false);
		rightarm1Idle.setTextureOffset(0, 20).addBox(7.7614F, -12.007F, 0.7532F, 4, 5, 7, 0.0F, false);
		rightarm1Idle.setTextureOffset(46, 0).addBox(8.7614F, -7.007F, 2.7532F, 2, 11, 3, 0.0F, false);

		rightarm2Idle = new RendererModel(this);
		rightarm2Idle.setRotationPoint(18.0F, 34.0F, 10.0F);
		setRotation(rightarm2Idle, 0.9599F, -0.2618F, -0.7854F);
		rightarm2Idle.setTextureOffset(76, 48).addBox(13.87F, 1.6817F, 9.0577F, 1, 3, 5, 0.0F, false);
		rightarm2Idle.setTextureOffset(68, 43).addBox(12.87F, 2.6817F, 9.0577F, 1, 3, 5, 0.0F, false);
		rightarm2Idle.setTextureOffset(59, 46).addBox(14.87F, 1.6817F, 9.0577F, 2, 6, 5, 0.0F, false);
		rightarm2Idle.setTextureOffset(66, 14).addBox(13.87F, -6.3183F, 10.0577F, 2, 8, 3, 0.0F, false);
		rightarm2Idle.setTextureOffset(56, 14).addBox(13.87F, -14.3183F, 9.0577F, 2, 8, 3, 0.0F, false);

		leftarm1Idle = new RendererModel(this);
		leftarm1Idle.setRotationPoint(-4.0F, 12.0F, 4.0F);
		setRotation(leftarm1Idle, 0.6109F, -0.6981F, 0.1745F);
		leftarm1Idle.setTextureOffset(0, 21).addBox(-6.128F, -13.8829F, 6.5009F, 4, 4, 7, 0.0F, false);
		leftarm1Idle.setTextureOffset(0, 20).addBox(-7.128F, -9.8829F, 6.5009F, 4, 5, 7, 0.0F, false);
		leftarm1Idle.setTextureOffset(36, 0).addBox(-6.128F, -4.8829F, 8.5009F, 2, 11, 3, 0.0F, false);

		leftarm2Idle = new RendererModel(this);
		leftarm2Idle.setRotationPoint(-15.0F, 26.0F, 9.0F);
		setRotation(leftarm2Idle, 1.0472F, -0.4363F, -0.1745F);
		leftarm2Idle.setTextureOffset(36, 14).addBox(1.5176F, -8.8951F, 12.0591F, 2, 8, 3, 0.0F, false);
		leftarm2Idle.setTextureOffset(46, 14).addBox(1.5176F, -0.8951F, 13.0591F, 2, 8, 3, 0.0F, false);
		leftarm2Idle.setTextureOffset(45, 46).addBox(0.5176F, 7.1049F, 12.0591F, 2, 6, 5, 0.0F, false);
		leftarm2Idle.setTextureOffset(44, 38).addBox(3.5176F, 8.1049F, 12.0591F, 1, 3, 5, 0.0F, false);
		leftarm2Idle.setTextureOffset(56, 38).addBox(2.5176F, 7.1049F, 12.0591F, 1, 3, 5, 0.0F, false);

		leftleg1Idle = new RendererModel(this);
		leftleg1Idle.setRotationPoint(-2.0F, 38.0F, 4.0F);
		setRotation(leftleg1Idle, 1.5708F, -0.2618F, 0.0F);
		leftleg1Idle.setTextureOffset(66, 0).addBox(-1.0F, 0.0001F, 14.0F, 2, 11, 3, 0.0F, false);

		leftleg2Idle = new RendererModel(this);
		leftleg2Idle.setRotationPoint(2.0F, 49.0F, 6.0F);
		setRotation(leftleg2Idle, 1.5708F, -0.7854F, 0.0F);
		leftleg2Idle.setTextureOffset(76, 14).addBox(0.8949F, 10.6593F, 25.0F, 2, 8, 3, 0.0F, false);
		leftleg2Idle.setTextureOffset(76, 3).addBox(0.8949F, 18.6593F, 26.0F, 2, 8, 3, 0.0F, false);
		leftleg2Idle.setTextureOffset(16, 63).addBox(-0.1051F, 26.6593F, 25.0F, 4, 1, 5, 0.0F, false);
		leftleg2Idle.setTextureOffset(28, 62).addBox(-0.1051F, 27.6593F, 25.0F, 4, 1, 8, 0.0F, false);
		leftleg2Idle.setTextureOffset(45, 61).addBox(-0.1051F, 28.6593F, 25.0F, 4, 1, 3, 0.0F, false);
		leftleg2Idle.setTextureOffset(29, 57).addBox(-0.1051F, 28.6593F, 29.0F, 4, 1, 4, 0.0F, false);

		rightleg1Idle = new RendererModel(this);
		rightleg1Idle.setRotationPoint(5.0F, 38.0F, 4.0F);
		setRotation(rightleg1Idle, 1.5708F, 0.3491F, 0.0F);
		rightleg1Idle.setTextureOffset(56, 0).addBox(-1.0F, 0.0001F, 14.0F, 2, 11, 3, 0.0F, false);

		rightleg2Idle = new RendererModel(this);
		rightleg2Idle.setRotationPoint(9.0F, 49.0F, 3.0F);
		setRotation(rightleg2Idle, 1.5708F, -0.2618F, 0.0F);
		rightleg2Idle.setTextureOffset(0, 57).addBox(0.0F, 29.0001F, 29.0F, 4, 1, 4, 0.0F, false);
		rightleg2Idle.setTextureOffset(69, 31).addBox(1.0F, 11.0001F, 25.0F, 2, 8, 3, 0.0F, false);
		rightleg2Idle.setTextureOffset(79, 31).addBox(1.0F, 19.0001F, 26.0F, 2, 8, 3, 0.0F, false);
		rightleg2Idle.setTextureOffset(16, 57).addBox(0.0F, 27.0001F, 25.0F, 4, 1, 5, 0.0F, false);
		rightleg2Idle.setTextureOffset(0, 62).addBox(0.0F, 28.0001F, 25.0F, 4, 1, 8, 0.0F, false);
		rightleg2Idle.setTextureOffset(45, 57).addBox(0.0F, 29.0001F, 25.0F, 4, 1, 3, 0.0F, false);
		}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		scale*=0.65F;
		GL11.glRotatef(180,0,90,0);

		if(this.isIdle){
			GL11.glTranslatef(-0.05F, 0.50F, -0.25F);
		}else{
			GL11.glTranslatef(-0.05F, -1.30F, -0.25F);
		}

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
		headIdle.render(scale);
		bodyIdle.render(scale);
		rightarm1Idle.render(scale);
		rightarm2Idle.render(scale);
		leftarm1Idle.render(scale);
		leftarm2Idle.render(scale);
		leftleg1Idle.render(scale);
		leftleg2Idle.render(scale);
		rightleg1Idle.render(scale);
		rightleg2Idle.render(scale);

		if (this.isIdle) {
			head.isHidden = true;
			body.isHidden = true;
			leftarm1.isHidden = true;
			leftarm2.isHidden = true;
			rightarm1.isHidden = true;
			rightarm2.isHidden = true;
			rightleg1.isHidden = true;
			rightleg2.isHidden = true;
			leftleg1.isHidden = true;
			leftleg2.isHidden = true;
			headIdle.isHidden = false;
			bodyIdle.isHidden = false;
			leftarm1Idle.isHidden = false;
			leftarm2Idle.isHidden = false;
			rightarm1Idle.isHidden = false;
			rightarm2Idle.isHidden = false;
			rightleg1Idle.isHidden = false;
			rightleg2Idle.isHidden = false;
			leftleg1Idle.isHidden = false;
			leftleg2Idle.isHidden = false;
		}
		else{
			head.isHidden = false;
			body.isHidden = false;
			leftarm1.isHidden = false;
			leftarm2.isHidden = false;
			rightarm1.isHidden = false;
			rightarm2.isHidden = false;
			rightleg1.isHidden = false;
			rightleg2.isHidden = false;
			leftleg1.isHidden = false;
			leftleg2.isHidden = false;
			headIdle.isHidden = true;
			bodyIdle.isHidden = true;
			leftarm1Idle.isHidden = true;
			leftarm2Idle.isHidden = true;
			rightarm1Idle.isHidden = true;
			rightarm2Idle.isHidden = true;
			rightleg1Idle.isHidden = true;
			rightleg2Idle.isHidden = true;
			leftleg1Idle.isHidden = true;
			leftleg2Idle.isHidden = true;
		}
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