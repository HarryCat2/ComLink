package harry.cat.holograms.block.entity;

import harry.cat.holograms.Holograms;
import harry.cat.holograms.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import harry.cat.holograms.block.ModBlocks;
import harry.cat.holograms.block.entity.custom.HoloTableBlockEntity;

import static org.spongepowered.asm.mixin.injection.struct.InjectionInfo.register;

public class ModBlockEntities {
    public static final BlockEntityType<HoloTableBlockEntity> HOLO_TABLE = register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("holograms", "holo_table"),
            FabricBlockEntityType.Builder.create(HoloTableBlockEntity::new, ModBlocks.HOLO_TABLE).build()
    );
    public static void initialize() {
        Holograms.LOGGER.info("Registering block entities for " + Holograms.MOD_ID);
    }
}

