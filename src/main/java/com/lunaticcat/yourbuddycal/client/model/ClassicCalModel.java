package com.lunaticcat.yourbuddycal.client.model;
// Made with Blockbench 3.5.0
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;

class ClassicCalModel extends EntityModel {
	private final RendererModel head;
	private final RendererModel body;
	private final RendererModel rightarm;
	private final RendererModel leftarm;
	private final RendererModel leftleg;
	private final RendererModel rightleg;

	public ClassicCalModel() {
		textureWidth = 87;
		textureHeight = 71;

		head = new RendererModel(this);
		head.setRotationPoint(3.0F, 10.0F, 4.0F);
		head.cubeList.add(new ModelBox(head, 37, 25, -5.0F, -14.0F, -4.0F, 9, 2, 7, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 34, -5.0F, -13.0F, -7.0F, 9, 1, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 45, -5.0F, -12.0F, -4.0F, 9, 5, 7, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 32, -8.0F, -7.0F, -4.0F, 15, 6, 7, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 25, 46, -3.0F, -1.0F, -3.0F, 5, 1, 5, 0.0F, false));

		body = new RendererModel(this);
		body.setRotationPoint(2.0F, 24.0F, 6.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -5.0F, -14.0F, -6.0F, 11, 25, 7, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 62, 25, -4.0F, 11.0F, -4.0F, 9, 3, 3, 0.0F, false));

		rightarm = new RendererModel(this);
		rightarm.setRotationPoint(-5.0F, 12.0F, 4.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 21, -2.0F, -2.0F, -4.0F, 4, 4, 7, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 20, -3.0F, 2.0F, -4.0F, 4, 5, 7, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 36, 0, -2.0F, 7.0F, -2.0F, 2, 11, 3, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 36, 14, -2.0F, 18.0F, -1.0F, 2, 8, 3, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 46, 14, -2.0F, 26.0F, 0.0F, 2, 8, 3, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 45, 46, -3.0F, 34.0F, -1.0F, 2, 6, 5, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 44, 38, 0.0F, 35.0F, -1.0F, 1, 3, 5, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 56, 38, -1.0F, 34.0F, -1.0F, 1, 3, 5, 0.0F, false));

		leftarm = new RendererModel(this);
		leftarm.setRotationPoint(10.0F, 12.0F, 3.0F);
		setRotationAngle(leftarm, 0.0F, 180.0F, 0.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 21, -2.0F, -2.0F, -4.0F, 4, 4, 7, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 20, -3.0F, 2.0F, -4.0F, 4, 5, 7, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 46, 0, -2.0F, 7.0F, -2.0F, 2, 11, 3, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 56, 14, -2.0F, 18.0F, -3.0F, 2, 8, 3, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 66, 14, -2.0F, 26.0F, -4.0F, 2, 8, 3, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 59, 46, -3.0F, 34.0F, -5.0F, 2, 6, 5, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 68, 43, 0.0F, 35.0F, -5.0F, 1, 3, 5, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 76, 48, -1.0F, 34.0F, -5.0F, 1, 3, 5, 0.0F, false));

		leftleg = new RendererModel(this);
		leftleg.setRotationPoint(5.0F, 27.0F, 3.0F);
		setRotationAngle(leftleg, 0.0F, 180.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 56, 0, -2.0F, 11.0F, -2.0F, 2, 11, 3, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 69, 31, -2.0F, 22.0F, -3.0F, 2, 8, 3, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 79, 31, -2.0F, 30.0F, -4.0F, 2, 8, 3, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 16, 57, -3.0F, 38.0F, -5.0F, 4, 1, 5, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 62, -3.0F, 39.0F, -8.0F, 4, 1, 8, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 45, 57, -3.0F, 40.0F, -3.0F, 4, 1, 3, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 57, -3.0F, 40.0F, -8.0F, 4, 1, 4, 0.0F, false));

		rightleg = new RendererModel(this);
		rightleg.setRotationPoint(-2.0F, 27.0F, 3.0F);
		setRotationAngle(rightleg, 0.0F, 180.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 66, 0, -2.0F, 11.0F, -2.0F, 2, 11, 3, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 76, 14, -2.0F, 22.0F, -3.0F, 2, 8, 3, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 76, 3, -2.0F, 30.0F, -4.0F, 2, 8, 3, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 16, 63, -3.0F, 38.0F, -5.0F, 4, 1, 5, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 28, 62, -3.0F, 39.0F, -8.0F, 4, 1, 8, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 45, 61, -3.0F, 40.0F, -3.0F, 4, 1, 3, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 29, 57, -3.0F, 40.0F, -8.0F, 4, 1, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		leftleg.render(f5);
		rightleg.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}