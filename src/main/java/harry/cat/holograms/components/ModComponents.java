package harry.cat.holograms.components;

import com.mojang.serialization.Codec;
import harry.cat.holograms.Holograms;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ModComponents {


    // !! FABRIC DOCS SAY TO USE PROTECTED NOT PUBLIC, GIVES ISSUES WHEN INITIALIZING !! //
    public static void initialize() {
        Holograms.LOGGER.info("Registering {} componenents", Holograms.MOD_ID);

    }
    // Owner UUID, for specific UUID of the player
    public static final ComponentType<String> OWNER_UUID_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Holograms.MOD_ID, "owner_uuid"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
    // Player name, for generic player name
    public static final ComponentType<String> OWNER_NAME_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Holograms.MOD_ID, "owner_name"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
    // Device ID for specific Device, refer to docs for how device ID works
    public static final ComponentType<String> DEVICE_ID = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Holograms.MOD_ID, "device_id"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
    // Channel Number, works like Television Channels
    public static final ComponentType<String> CHANNEL_NUMBER = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Holograms.MOD_ID, "channel_number"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

}
