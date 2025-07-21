package harry.cat.holograms.block;

import com.mojang.serialization.MapCodec;
import harry.cat.holograms.block.entity.HoloTableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HoloTableBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE =
            Block.createCuboidShape(2, 0, 2, 14, 13, 14);

    public static final MapCodec<HoloTableBlock> CODEC = HoloTableBlock.createCodec(HoloTableBlock::new);

    public HoloTableBlock(Settings settings) {
        super(settings);
    }

//    @Override
//    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return SHAPE;
//    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HoloTableBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


}


