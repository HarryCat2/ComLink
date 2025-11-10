package harry.cat.holograms.client.renderer.blockentity;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import harry.cat.holograms.block.entity.HoloTableBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import static harry.cat.holograms.Holograms.MOD_ID;
import static net.minecraft.client.gl.RenderPipelines.ENTITY_SNIPPET;


@Environment(EnvType.CLIENT)

public class HoloTableEntityRenderer implements BlockEntityRenderer<HoloTableBlockEntity> {
    public HoloTableEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    //HOLOGRAM RENDER LAYER
    public static final RenderPipeline HOLOGRAM_ENTITY_TRANSLUCENT =
            RenderPipeline.builder(ENTITY_SNIPPET)
                    .withLocation(Identifier.of(MOD_ID, "pipeline/hologram_entity_translucent"))
                    .withVertexShader(Identifier.of(MOD_ID, "core/custom"))
                    .withFragmentShader(Identifier.of(MOD_ID, "core/custom"))
                    .withBlend(BlendFunction.TRANSLUCENT)
                    .withCull(false)
                    .withShaderDefine("ALPHA_CUTOUT", 0.1F)
                    .withSampler("Sampler1")
                    .build();

    @Override
    public void render(HoloTableBlockEntity entity, float tickProgress, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        MinecraftClient client = MinecraftClient.getInstance();

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

    }

}





        /*matrices.push();

        //RenderSystem.setShaderTexture(0, "textures/entity/hologram_base.png");

        float time = (client.world.getTime() % 60) / 60f;
        float flicker = 0.8f + (float)Math.sin(time * 40.0) * 0.2f;


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
