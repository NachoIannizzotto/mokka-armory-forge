package net.mokkastudios.mokkasarmory.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.entity.client.models.CoreboundGuardian;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;

public class Corebound_GuardianRenderer extends MobRenderer<Corebound_GuardianEntity, CoreboundGuardian<Corebound_GuardianEntity>> {

    private static final ResourceLocation TEXTURE = MokkaArmory.rl("textures/entity/elite_stoneling_layer_1.png");
    public Corebound_GuardianRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CoreboundGuardian<>(pContext.bakeLayer(ModModelLayers.COREBOUND_GUARDIAN_LAYER)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(Corebound_GuardianEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(Corebound_GuardianEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1.8f, 1.8f, 1.8f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
