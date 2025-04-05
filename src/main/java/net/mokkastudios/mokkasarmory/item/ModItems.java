package net.mokkastudios.mokkasarmory.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.item.custom.ModArmorItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MokkaArmory.MOD_ID);

    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));

    ////

    public static final RegistryObject<Item> ECHOES_HELMET = ITEMS.register("echoes_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ECHOES, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> ECHOES_CHESTPLATE = ITEMS.register("echoes_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ECHOES, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> ECHOES_LEGGINGS = ITEMS.register("echoes_leggings",
            () -> new ArmorItem(ModArmorMaterials.ECHOES, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> ECHOES_BOOTS = ITEMS.register("echoes_boots",
            () -> new ArmorItem(ModArmorMaterials.ECHOES, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ECHOES_SICKLE = ITEMS.register("echoes_sickle",
            () -> new SwordItem(ModToolTiers.ECHOES, 4, -1.4F, new Item.Properties()));

    ////

    public static final RegistryObject<Item> GILDED_HELMET = ITEMS.register("gilded_helmet",
            () -> new ModArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> GILDED_LEGGINGS = ITEMS.register("gilded_leggings",
            () -> new ModArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> GILDED_BOOTS = ITEMS.register("gilded_boots",
            () -> new ModArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    ////

    public static final RegistryObject<Item> GOLD_NETHERITE_TEMPLATE = ITEMS.register("gold_netherite_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.mokkas_armory.gold_netherite_template.applies").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.mokkas_armory.gold_netherite_template.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("upgrade.mokkas_armory.gilded_upgrade").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.mokkas_armory.armory_ingredients"),
                    Component.translatable("item.mokkas_armory.gold_netherite_template"),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_helmet"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_chestplate"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_leggings"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_boots")
                    ),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_slot_ingot")
                    )
            )
    );

    public static final RegistryObject<Item> ECHOES_TEMPLATE = ITEMS.register("echoes_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.mokkas_armory.echoes_template.applies").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.mokkas_armory.echoes_template.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("upgrade.mokkas_armory.echoes_upgrade").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.mokkas_armory.echoes_ingredients"),
                    Component.translatable("item.mokkas_armory.echoes_template"),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_helmet"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_chestplate"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_leggings"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_armor_slot_boots")
                    ),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "item/empty_slot_ingot")
                    )
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
