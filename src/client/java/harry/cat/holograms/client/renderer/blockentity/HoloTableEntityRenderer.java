package harry.cat.holograms.client.renderer.blockentity;

import com.mojang.authlib.GameProfile;
import harry.cat.holograms.block.entity.HoloTableBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
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

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class HoloTableEntityRenderer implements BlockEntityRenderer<HoloTableBlockEntity> {
    private static final ItemStack stack = new ItemStack(Items.JUKEBOX);
    private static final GameProfile DEMO_PROFILE = new GameProfile(UUID.nameUUIDFromBytes("Steve".getBytes()), "Steve");

    public HoloTableEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(HoloTableBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider
            vertexConsumers, int light, int overlay) {
        MinecraftClient client = MinecraftClient.getInstance();

        matrices.push();

        matrices.translate(0.5, 2.3, 0.5);

        // Scale down to make it mini
        float scale = 0.9f;
        matrices.scale(-scale, -scale, scale); // Flip Y

        // Get the player model
        PlayerEntityModel<AbstractClientPlayerEntity> model = new PlayerEntityModel<>(
                client.getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER),
                true
        );

        // Get player skin texture
        Identifier skin = MinecraftClient.getInstance().getSkinProvider().getSkinTextures(DEMO_PROFILE).texture();

        // Get buffer
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(skin));

        // Render
        model.render(matrices, consumer, light, overlay);








        /*// Calculate the current offset in the y value
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);

        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((blockEntity.getWorld().getTime() + tickDelta) * 4));

        MinecraftClient.getInstance().getItemRenderer().renderItem(
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
