package harry.cat.holograms.client.renderer.blockentity;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import harry.cat.holograms.block.entity.HoloTableBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

import java.util.OptionalDouble;




@Environment(EnvType.CLIENT)

public class HoloTableEntityRenderer implements BlockEntityRenderer<HoloTableBlockEntity> {
    private static final ItemStack stack = new ItemStack(Items.JUKEBOX);




    public HoloTableEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    public static final RenderPipeline DEBUG_LINES = RenderPipelines.register(
            RenderPipeline.builder(RenderPipelines.POSITION_COLOR_SNIPPET)
                    .withLocation("pipeline/debug_lines")
                    .withVertexFormat(VertexFormats.POSITION_COLOR, VertexFormat.DrawMode.DEBUG_LINES)
                    .withCull(true)
                    .withoutBlend()
                    .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
                    .build()
    );
    Tessellator tess = Tessellator.getInstance();
    BufferBuilder buff = tess.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);



    public static final RenderLayer renderLayer = RenderLayer.of(
            "debug_lines",
            1526,
            DEBUG_LINES,
            RenderLayer.MultiPhaseParameters.builder().lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(1))).build(false)
    );





    @Override
    public void render(HoloTableBlockEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        //renderLayer.draw(buff.end());
        MinecraftClient client = MinecraftClient.getInstance();


        matrices.push();

        // Move the item
        matrices.translate(0.5, 1.35, 0.5);
        matrices.scale(2f, 2f, 2f);
        double offset = Math.sin((entity.getWorld().getTime() + tickProgress) / 2.0);


        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((entity.getWorld().getTime() + tickProgress) * 0.5f));

        client.getItemRenderer().renderItem(
            stack,
            ItemDisplayContext.GROUND,
            light,
            overlay,
            matrices,
            vertexConsumers,
            entity.getWorld(),
            entity.getWorld().random.nextInt()
        );
        /*MinecraftClient.getInstance().getItemRenderer().renderItem(
                stack,
                ModelTransformationMode.GROUND,
                light,
                overlay,
                matrices,
                vertexConsumers,
                blockEntity.getWorld(),
                0
        );*/
        // Mandatory call after GL calls
        matrices.pop();
    }
}
