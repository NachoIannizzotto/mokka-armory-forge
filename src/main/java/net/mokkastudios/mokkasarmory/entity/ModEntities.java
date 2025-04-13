package net.mokkastudios.mokkasarmory.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mokkastudios.mokkasarmory.MokkaArmory;
import net.mokkastudios.mokkasarmory.entity.custom.Corebound_GuardianEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MokkaArmory.MOD_ID);

    public static final RegistryObject<EntityType<Corebound_GuardianEntity>> COREBOUND_GUARDIAN =
            ENTITY_TYPES.register("corebound_guardian", () -> EntityType.Builder.of(Corebound_GuardianEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 4.0f).fireImmune().build("corebound_guardian"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
