package harry.cat.holograms.block.entity;

import harry.cat.holograms.Holograms;
import harry.cat.holograms.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<HoloTableBlockEntity> HOLO_TABLE =
            register("holo_table_block_entity", HoloTableBlockEntity::new, ModBlocks.HOLO_TABLE);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,

           //BlockEntityType.BlockEntityFactory<? extends T> entityFactory,
            BlockEntityType.BlockEntityFactory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(Holograms.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
    }
    public static void registerBlockEntities() {
        Holograms.LOGGER.info("Registering Mod Block Entities for " + Holograms.MOD_ID);
    }
}
