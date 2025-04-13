package net.mokkastudios.mokkasarmory.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mokkastudios.mokkasarmory.MokkaArmory;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MokkaArmory.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGREDIENTS_TAB = CREATIVE_MODE_TABS.register("ingredients_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOLD_NETHERITE_TEMPLATE.get()))
                    .title(Component.translatable("creativetab.ingredients_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.GOLD_NETHERITE_TEMPLATE.get());
                        pOutput.accept(ModItems.ECHOES_TEMPLATE.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> WEAPONS_TAB = CREATIVE_MODE_TABS.register("weapons_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHOES_SICKLE.get()))
                    .title(Component.translatable("creativetab.weapons_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.ECHOES_SICKLE.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ARMORS_TAB = CREATIVE_MODE_TABS.register("armors_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_HELMET.get()))
                    .title(Component.translatable("creativetab.armors_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.COPPER_HELMET.get());
                        pOutput.accept(ModItems.COPPER_CHESTPLATE.get());
                        pOutput.accept(ModItems.COPPER_LEGGINGS.get());
                        pOutput.accept(ModItems.COPPER_BOOTS.get());

                        pOutput.accept(ModItems.ECHOES_HELMET.get());
                        pOutput.accept(ModItems.ECHOES_CHESTPLATE.get());
                        pOutput.accept(ModItems.ECHOES_LEGGINGS.get());
                        pOutput.accept(ModItems.ECHOES_BOOTS.get());

                        pOutput.accept(ModItems.GILDED_HELMET.get());
                        pOutput.accept(ModItems.GILDED_CHESTPLATE.get());
                        pOutput.accept(ModItems.GILDED_LEGGINGS.get());
                        pOutput.accept(ModItems.GILDED_BOOTS.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> SPAWN_EGG_TAB = CREATIVE_MODE_TABS.register("spawn_egg_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COREBOUND_GUARDIAN_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.spawn_egg_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.COREBOUND_GUARDIAN_SPAWN_EGG.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
