package net.mokkastudios.mokkasarmory.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.entity.client.ModModelLayers;
import net.mokkastudios.mokkasarmory.entity.client.models.CoreboundGuardian;

@Mod.EventBusSubscriber(modid = MokkaArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.COREBOUND_GUARDIAN_LAYER, CoreboundGuardian::createBodyLayer);
    }

}
