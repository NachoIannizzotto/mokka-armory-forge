package net.mokkastudios.mokkasarmory.entity.client.models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.mokkastudios.mokkasarmory.entity.animations.ModAnimationDefinitions;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;


public class CoreboundGuardian<T extends Entity> extends HierarchicalModel<T> {

	private final AnimationState idleState = new AnimationState();
	private final AnimationState walkState = new AnimationState();

	private float idleWeight = 1.0f;
	private float walkWeight = 0.0f;

	private final ModelPart Elite;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart torsoUpper;
	private final ModelPart head;
	private final ModelPart leftHand;
	private final ModelPart leftHandDetail;
	private final ModelPart leftHandMiddle;
	private final ModelPart leftHandPunch;
	private final ModelPart rightHand;
	private final ModelPart rightHandDetail;
	private final ModelPart rightHandMiddle;
	private final ModelPart rightHandMiddle2;
	private final ModelPart rightHandPunch;
	private final ModelPart sheetFront;
	private final ModelPart sheetBack;
	private final ModelPart crystal;
	private final ModelPart torsoBottom;
	private final ModelPart leftLegTop;
	private final ModelPart leftLegBottom;
	private final ModelPart rightLegTop;
	private final ModelPart rightLegBottom;

	public CoreboundGuardian(ModelPart root) {
		this.Elite = root.getChild("Elite");
		this.body = Elite.getChild("body");
		this.torso = Elite.getChild("body").getChild("torso");
		this.torsoUpper = Elite.getChild("body").getChild("torso").getChild("torsoUpper");
		this.head = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("head");
		this.leftHand = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("leftHand");
		this.leftHandDetail = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("leftHand").getChild("leftHandDetail");
		this.leftHandMiddle = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("leftHand").getChild("leftHandMiddle");
		this.leftHandPunch = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("leftHand").getChild("leftHandMiddle").getChild("leftHandPunch");
		this.rightHand = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("rightHand");
		this.rightHandDetail = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("rightHand").getChild("rightHandDetail");
		this.rightHandMiddle = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("rightHand").getChild("rightHandMiddle");
		this.rightHandMiddle2 = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("rightHand").getChild("rightHandMiddle").getChild("rightHandMiddle2");
		this.rightHandPunch = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("rightHand").getChild("rightHandMiddle").getChild("rightHandMiddle2").getChild("rightHandPunch");
		this.sheetFront = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("sheetFront");
		this.sheetBack = Elite.getChild("body").getChild("torso").getChild("torsoUpper").getChild("sheetBack");
		this.crystal = Elite.getChild("body").getChild("torso").getChild("crystal");
		this.torsoBottom = Elite.getChild("body").getChild("torso").getChild("torsoBottom");
		this.leftLegTop = Elite.getChild("body").getChild("torso").getChild("torsoBottom").getChild("leftLegTop");
		this.leftLegBottom = Elite.getChild("body").getChild("torso").getChild("torsoBottom").getChild("leftLegTop").getChild("leftLegBottom");
		this.rightLegTop = Elite.getChild("body").getChild("torso").getChild("torsoBottom").getChild("rightLegTop");
		this.rightLegBottom = Elite.getChild("body").getChild("torso").getChild("torsoBottom").getChild("rightLegTop").getChild("rightLegBottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Elite = partdefinition.addOrReplaceChild("Elite", CubeListBuilder.create(), PartPose.offset(0.0F, 2.9F, 0.0F));

		PartDefinition body = Elite.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.7F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition torsoUpper = torso.addOrReplaceChild("torsoUpper", CubeListBuilder.create(), PartPose.offset(0.0F, -3.625F, 0.3313F));

		PartDefinition cube_r1 = torsoUpper.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.375F, 0.2686F, 0.2444F, 0.7703F, 0.1719F));

		PartDefinition head = torsoUpper.addOrReplaceChild("head", CubeListBuilder.create().texOffs(62, 20).addBox(-2.5F, -5.5F, -2.4F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 81).addBox(-1.0F, -6.0F, -1.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(83, 20).addBox(-3.0F, -4.0F, -1.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, -0.6F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(90, 43).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -1.6F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leftHand = torsoUpper.addOrReplaceChild("leftHand", CubeListBuilder.create(), PartPose.offset(8.9F, -5.2F, 0.0F));

		PartDefinition cube_r3 = leftHand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 41).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-3.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition leftHandDetail = leftHand.addOrReplaceChild("leftHandDetail", CubeListBuilder.create(), PartPose.offset(6.2F, 1.9F, 0.0F));

		PartDefinition cube_r4 = leftHandDetail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 77).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition leftHandMiddle = leftHand.addOrReplaceChild("leftHandMiddle", CubeListBuilder.create(), PartPose.offset(3.2F, 10.0F, 0.0F));

		PartDefinition cube_r5 = leftHandMiddle.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(71, 43).addBox(-0.75F, -3.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 0).addBox(-3.75F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition leftHandPunch = leftHandMiddle.addOrReplaceChild("leftHandPunch", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5F, 0.0F));

		PartDefinition cube_r6 = leftHandPunch.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(33, 18).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightHand = torsoUpper.addOrReplaceChild("rightHand", CubeListBuilder.create(), PartPose.offset(-8.9F, -5.2F, 0.0F));

		PartDefinition cube_r7 = rightHand.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(25, 46).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-5.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition rightHandDetail = rightHand.addOrReplaceChild("rightHandDetail", CubeListBuilder.create(), PartPose.offset(-6.2F, 1.9F, 0.0F));

		PartDefinition cube_r8 = rightHandDetail.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(57, 77).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition rightHandMiddle = rightHand.addOrReplaceChild("rightHandMiddle", CubeListBuilder.create(), PartPose.offset(-2.2F, 9.0F, 0.0F));

		PartDefinition cube_r9 = rightHandMiddle.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 70).addBox(-3.0F, -4.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 33).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition rightHandMiddle2 = rightHandMiddle.addOrReplaceChild("rightHandMiddle2", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition cube_r10 = rightHandMiddle2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(19, 71).addBox(-2.85F, -5.9F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(62, 10).addBox(-2.85F, -2.9F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5387F, 0.833F, 0.0F, 0.0F, 0.0F, 2.9234F));

		PartDefinition rightHandPunch = rightHandMiddle2.addOrReplaceChild("rightHandPunch", CubeListBuilder.create().texOffs(33, 0).addBox(-2.5F, 0.5F, -4.5F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(60, 87).addBox(-0.5F, 3.5F, -5.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 90).addBox(-3.5F, 3.0F, 1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 90).addBox(-3.5F, 3.0F, -3.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 59).addBox(-1.5F, 8.5F, -4.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(85, 37).addBox(-0.5F, 9.0F, -4.4F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 87).addBox(-0.5F, 9.0F, 1.4F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(87, 16).addBox(-0.5F, 9.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 4.5F, 0.0F));

		PartDefinition sheetFront = torsoUpper.addOrReplaceChild("sheetFront", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -7.0F));

		PartDefinition cube_r11 = sheetFront.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(85, 0).addBox(-3.0F, -2.7501F, -1.6872F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.875F, 0.4F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r12 = sheetFront.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(87, 8).addBox(-2.0F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6566F, -1.002F, 1.1202F, 0.5885F, 0.7742F, 0.1309F));

		PartDefinition cube_r13 = sheetFront.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(85, 29).addBox(-3.0F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6566F, -1.002F, 1.1202F, 0.5885F, -0.7742F, -0.1309F));

		PartDefinition sheetBack = torsoUpper.addOrReplaceChild("sheetBack", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 7.0F));

		PartDefinition cube_r14 = sheetBack.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(80, 62).addBox(-2.5F, -2.683F, -0.4758F, 5.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8517F, -0.5879F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r15 = sheetBack.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 77).addBox(0.9407F, -3.5626F, 1.4185F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8517F, -0.5879F, 0.4652F, 0.5718F, 0.5681F));

		PartDefinition cube_r16 = sheetBack.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 80).addBox(-5.9407F, -3.5626F, 1.4185F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8517F, -0.5879F, 0.4652F, -0.5718F, -0.5681F));

		PartDefinition crystal = torso.addOrReplaceChild("crystal", CubeListBuilder.create(), PartPose.offset(0.0F, 0.1535F, -0.1464F));

		PartDefinition cube_r17 = crystal.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(47, 87).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1464F, -0.8536F, -0.6155F, 0.5236F, 0.6155F));

		PartDefinition torsoBottom = torso.addOrReplaceChild("torsoBottom", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3816F, 0.1013F));

		PartDefinition cube_r18 = torsoBottom.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(71, 53).addBox(-2.5F, -4.0F, -1.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 33).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8448F, 0.6642F, -0.6109F, 0.0F, 0.0F));

		PartDefinition leftLegTop = torsoBottom.addOrReplaceChild("leftLegTop", CubeListBuilder.create().texOffs(50, 46).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.8F, 0.0F, 0.0F));

		PartDefinition leftLegBottom = leftLegTop.addOrReplaceChild("leftLegBottom", CubeListBuilder.create().texOffs(46, 62).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 7.0F, 1.0F));

		PartDefinition rightLegTop = torsoBottom.addOrReplaceChild("rightLegTop", CubeListBuilder.create().texOffs(0, 54).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.8F, 0.0F, 0.0F));

		PartDefinition rightLegBottom = rightLegTop.addOrReplaceChild("rightLegBottom", CubeListBuilder.create().texOffs(63, 62).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 7.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		Corebound_GuardianEntity corebound = (Corebound_GuardianEntity) entity;

		boolean isMoving = limbSwingAmount > 0.05f;

		if (corebound.heavy_attackAnimationState.isStarted()) {
			if (isMoving) {
				this.animate(corebound.heavy_attackAnimationState, ModAnimationDefinitions.COREBOUND_GUARDIAN_HEAVY_ATTACK_WALK, ageInTicks, 1f);
			} else {
				this.animate(corebound.heavy_attackAnimationState, ModAnimationDefinitions.COREBOUND_GUARDIAN_HEAVY_ATTACK, ageInTicks, 1f);
				return;
			}
		} else if (corebound.attackAnimationState.isStarted()) {
			this.animate(corebound.attackAnimationState, ModAnimationDefinitions.COREBOUND_GUARDIAN_ATTACK, ageInTicks, 1f);
		}

		if (isMoving) {
			this.animateWalk(ModAnimationDefinitions.COREBOUND_GUARDIAN_WALK, limbSwing, limbSwingAmount, 2.8f, 10f);
		} else {
			this.animate(corebound.idleAnimationState, ModAnimationDefinitions.COREBOUND_GUARDIAN_IDLE, ageInTicks, 1f);
		}
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180f);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Elite.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Elite;
	}
}