package harry.cat.holograms.client.renderer.blockentity;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import harry.cat.holograms.block.entity.HoloTableBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL11;

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



    public static final RenderLayer renderlayer = RenderLayer.of(
            "debug_lines",
            1526,
            DEBUG_LINES,
            RenderLayer.MultiPhaseParameters.builder().lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(1))).build(false)
    );

    renderLayer.draw(builtBuff);


    @Override
    public void render(HoloTableBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider
            vertexConsumers, int light, int overlay) {
        MinecraftClient client = MinecraftClient.getInstance();

        matrices.push();

        // Move the item
        matrices.translate(0.5, 1.35, 0.5);
        matrices.scale(2f, 2f, 2f);
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 2.0);


        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((blockEntity.getWorld().getTime() + tickDelta) * 0.5f));

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

    @Override
    public void render(HoloTableBlockEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {

    }
}
