package net.mokkastudios.mokkasarmory.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModToolTiers {
    public static final Tier ECHO = new ForgeTier(
            3,
            670,
            5.0F,
            4.0F,
            22,
            Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.ECHO_TEMPLATE.get())
    );
}
