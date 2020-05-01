package com.lunaticcat.yourbuddycal.client.renderer.entity;

import com.lunaticcat.yourbuddycal.entity.YourBuddyCalEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class YourBuddyCalEntityRenderer<T extends YourBuddyCalEntity, M extends EntityModel<T>> extends MobRenderer<T, M>
{

    public YourBuddyCalEntityRenderer(EntityRendererManager manager, M par1ModelBase, float par2)
    {
        super(manager, par1ModelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity)
    {
        return entity.getTextureResource();
    }
}