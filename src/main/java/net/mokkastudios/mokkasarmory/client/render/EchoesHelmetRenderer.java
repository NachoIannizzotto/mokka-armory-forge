package net.mokkastudios.mokkasarmory.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.client.model.EchoesHelmet;
import net.mokkastudios.mokkasarmory.item.ModItems;

public class EchoesHelmetRenderer<E extends LivingEntity, M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(MokkaArmory.rl("echoes"), "3");
    private static final ResourceLocation TEXTURE = MokkaArmory.rl("textures/models/armor/echoes_layer_3.png");
    private final EntityModelSet model;


    public EchoesHelmetRenderer(RenderLayerParent<E, M> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = modelSet;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, E pLivingEntity, float pLimbSwing, float pLimbSwingAmount,
                       float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if(stack.is(ModItems.ECHOES_HELMET.get())) {
            pPoseStack.pushPose();

            pPoseStack.scale(1, 1, 1);
            this.getParentModel().getHead().translateAndRotate(pPoseStack);
            EchoesHelmet<E> helmetModel = new EchoesHelmet<>(this.model.bakeLayer(MODEL));
            helmetModel.renderToBuffer(pPoseStack, pBuffer.getBuffer(RenderType.armorCutoutNoCull(TEXTURE)), pPackedLight,
                    OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

            pPoseStack.popPose();
        }
    }
}
