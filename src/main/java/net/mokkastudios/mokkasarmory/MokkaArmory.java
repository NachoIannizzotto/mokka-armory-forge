package net.mokkastudios.mokkasarmory;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mokkastudios.mokkasarmory.effect.ModEffects;
import net.mokkastudios.mokkasarmory.entity.ModEntities;
import net.mokkastudios.mokkasarmory.entity.client.Corebound_GuardianRenderer;
import net.mokkastudios.mokkasarmory.item.ModCreativeTabs;
import net.mokkastudios.mokkasarmory.item.ModItems;
import org.slf4j.Logger;

@Mod(MokkaArmory.MOD_ID)
public class MokkaArmory
{
    public static final String MOD_ID = "mokkas_armory";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MokkaArmory(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModEffects.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.parse(MOD_ID + ":" + path);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.COREBOUND_GUARDIAN.get(), Corebound_GuardianRenderer::new);
        }
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
}
