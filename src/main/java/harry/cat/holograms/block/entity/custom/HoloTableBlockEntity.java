package harry.cat.holograms.block.entity.custom;


import harry.cat.holograms.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class HoloTableBlockEntity extends BlockEntity {
    public HoloTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HOLO_TABLE, pos, state);
    }
}