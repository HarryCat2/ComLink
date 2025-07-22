package harry.cat.holograms.client;

import harry.cat.holograms.client.renderer.blockentity.HoloTableEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import static harry.cat.holograms.block.entity.ModBlockEntities.HOLO_TABLE;

public class HologramsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(HOLO_TABLE, HoloTableEntityRenderer::new);
    }
}
