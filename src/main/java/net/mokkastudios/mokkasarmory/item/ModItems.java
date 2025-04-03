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

    public static final RegistryObject<Item> ECHO_HELMET = ITEMS.register("echo_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> ECHO_CHESTPLATE = ITEMS.register("echo_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> ECHO_LEGGINGS = ITEMS.register("echo_leggings",
            () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> ECHO_BOOTS = ITEMS.register("echo_boots",
            () -> new ArmorItem(ModArmorMaterials.ECHO, ArmorItem.Type.BOOTS, new Item.Properties()));

    ////

    public static final RegistryObject<Item> GILDED_HELMET = ITEMS.register("gilded_helmet",
            () -> new ModArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> GILDED_LEGGINGS = ITEMS.register("gilded_leggings",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> GILDED_BOOTS = ITEMS.register("gilded_boots",
            () -> new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, new Item.Properties()));

    ////

    public static final RegistryObject<Item> GOLD_NETHERITE_TEMPLATE = ITEMS.register("gold_netherite_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.mokkas_armory.gold_netherite_template.applies").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.mokkas_armory.gold_netherite_template.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("upgrade.mokkas_armory.gilded_upgrade").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.mokkas_armory.armory_ingredients"),
                    Component.translatable("item.mokkas_armory.gold_netherite_template"),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_helmet"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_chestplate"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_leggings"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_boots")
                    ),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "gold_ingot")
                    )
            )
    );

    public static final RegistryObject<Item> ECHO_TEMPLATE = ITEMS.register("echo_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.mokkas_armory.echo_template.applies").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.mokkas_armory.echo_template.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("upgrade.mokkas_armory.echo_upgrade").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.mokkas_armory.echo_ingredients"),
                    Component.translatable("item.mokkas_armory.echo_template"),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_helmet"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_chestplate"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_leggings"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_boots")
                    ),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "echo_shard")
                    )
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
