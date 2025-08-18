package harry.cat.holograms.block.entity;

import harry.cat.holograms.Holograms;
import harry.cat.holograms.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<HoloTableBlockEntity> HOLO_TABLE =
            registerBlockEntity(Holograms.id("holo_table_block_entity"), HoloTableBlockEntity::new, ModBlocks.HOLO_TABLE);

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(Identifier registryKey, FabricBlockEntityTypeBuilder.Factory<? extends T> factory, Block... blocks)
    {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, registryKey, FabricBlockEntityTypeBuilder.<T>create(factory, blocks).build());
    }
    public static void registerBlockEntities() {
        Holograms.LOGGER.info("Registering Mod Block Entities for " + Holograms.MOD_ID);
    }
}
