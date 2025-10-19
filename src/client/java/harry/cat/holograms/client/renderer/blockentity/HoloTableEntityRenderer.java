package harry.cat.holograms.client.renderer.blockentity;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderSystem;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

import java.util.OptionalDouble;




@Environment(EnvType.CLIENT)

public class HoloTableEntityRenderer implements BlockEntityRenderer<HoloTableBlockEntity> {
    private static final ItemStack stack = new ItemStack(Items.JUKEBOX);

    public HoloTableEntityRenderer(BlockEntityRendererFactory.Context ctx) {}




    @Override
    public void render(HoloTableBlockEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        MinecraftClient client = MinecraftClient.getInstance();
        matrices.push();
        float time = (client.world.getTime() % 60) / 60f;
        float flicker = 0.8f + (float)Math.sin(time * 40.0) * 0.2f;
        client.getEntityRenderDispatcher().render(
                client.player,
                0.5,
                1.25,
                0.5,
                0,
                matrices,
                vertexConsumers,
                light
        );

        client.getEntityRenderDispatcher().setRenderShadows(false);
        RenderSystem.setShaderColor(0.2f, 0.8f, 1.0f, 0.5f);

        matrices.pop();
/*        matrices.push();

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

        matrices.pop();*/
    }
}
