package net.mokkastudios.mokkasarmory.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class EchoesHelmet<E extends LivingEntity> extends EntityModel<E> implements HeadedModel {
    private final ModelPart head;

    public EchoesHelmet(ModelPart head) {
        this.head = head;
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightHorn = root.addOrReplaceChild("right_horn",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-3.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-6.2F, -1.5F, 0.0F, 0.0F, 0.8F, -0.2F));

        PartDefinition leftHorn = root.addOrReplaceChild("left_horn",
                CubeListBuilder.create()
                        .texOffs(0, 0).mirror()
                        .addBox(-3.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.2F, -1.5F, 0.0F, 0.0F, -0.8F, 0.2F));

        return LayerDefinition.create(mesh, 16, 16);
    }

    @Override
    public void setupAnim(E pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30, 30);
        pHeadPitch = Mth.clamp(pHeadPitch, -25, 45);
        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180f);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180f);
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        head.getChild("root").getChild("right_horn").render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        head.getChild("root").getChild("left_horn").render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
