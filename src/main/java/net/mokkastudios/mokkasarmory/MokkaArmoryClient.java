package net.mokkastudios.mokkasarmory;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mokkastudios.mokkasarmory.client.model.EchoesHelmet;
import net.mokkastudios.mokkasarmory.client.render.EchoesHelmetRenderer;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MokkaArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MokkaArmoryClient {

    @SubscribeEvent
    public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EchoesHelmetRenderer.MODEL, EchoesHelmet::createBodyModel);
    }

    @SubscribeEvent
    public static void addLayers(final EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(name -> {
            if(event.getSkin(name) instanceof PlayerRenderer renderer) {
                renderer.addLayer(new EchoesHelmetRenderer<>(renderer, event.getEntityModels()));
            }
        });
        if(event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
            renderer.addLayer(new EchoesHelmetRenderer<>(renderer, event.getEntityModels()));
        }
        if(event.getRenderer(EntityType.ZOMBIE) instanceof ZombieRenderer renderer) {
            renderer.addLayer(new EchoesHelmetRenderer<>(renderer, event.getEntityModels()));
        }
    }
}
