package harry.cat.holograms.block.entity;


import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HoloTableBlockEntity extends BlockEntity {
    public HoloTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HOLO_TABLE, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, HoloTableBlockEntity blockEntity) {

    }
}