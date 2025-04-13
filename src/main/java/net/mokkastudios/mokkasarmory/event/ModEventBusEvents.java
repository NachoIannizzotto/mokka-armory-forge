package net.mokkastudios.mokkasarmory.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.entity.ModEntities;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;

@Mod.EventBusSubscriber(modid = MokkaArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.COREBOUND_GUARDIAN.get(), Corebound_GuardianEntity.createAttributes().build());
    }
}
