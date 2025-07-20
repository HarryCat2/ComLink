package harry.cat.holograms.block.entity;

import harry.cat.holograms.Holograms;
import harry.cat.holograms.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import harry.cat.holograms.block.ModBlocks;
import harry.cat.holograms.block.entity.custom.HoloTableBlockEntity;


import static org.spongepowered.asm.mixin.injection.struct.InjectionInfo.register;

public class ModBlockEntities {
    public static final BlockEntityType<HoloTableBlockEntity> HOLO_TABLE =
            register("counter", HoloTableBlockEntity::new, ModBlocks.HOLO_TABLE);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(Holograms.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}
