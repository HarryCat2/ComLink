package harry.cat.holograms;

import harry.cat.holograms.block.ModBlocks;
import harry.cat.holograms.block.entity.ModBlockEntities;
import harry.cat.holograms.components.ModComponents;
import harry.cat.holograms.item.ModItemGroups;
import harry.cat.holograms.item.ModItems;
import harry.cat.holograms.mob_effects.CarboniteBlindness;
import harry.cat.holograms.mob_effects.CarboniteFrozen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Holograms implements ModInitializer {
    public static final String MOD_ID = "holograms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryEntry<StatusEffect> CARBONITE_FROZEN =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Holograms.MOD_ID, "carbonite_frozen"), new CarboniteFrozen());
    public static final RegistryEntry<StatusEffect> CARBONITE_BLINDNESS =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Holograms.MOD_ID, "carbonite_blindness"), new CarboniteBlindness());


    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        ModComponents.initialize();

    }
    public static Identifier id(String string){
        return Identifier.of(MOD_ID, string);
    }
}


