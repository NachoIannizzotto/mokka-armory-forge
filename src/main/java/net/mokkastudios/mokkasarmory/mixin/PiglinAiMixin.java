package net.mokkastudios.mokkasarmory.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.mokkastudios.mokkasarmory.item.ModArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public abstract class PiglinAiMixin {
    @Inject(method = "isWearingGold", at = @At("HEAD"), cancellable = true)
    private static void isWearingGold(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player) {
            for (ItemStack stack : player.getArmorSlots()) {
                Item item = stack.getItem();
                if (item instanceof ArmorItem armor && armor.getMaterial() == ModArmorMaterials.GILDED) {
                    cir.setReturnValue(true);
                    return;
                }
            }
        }
    }
}