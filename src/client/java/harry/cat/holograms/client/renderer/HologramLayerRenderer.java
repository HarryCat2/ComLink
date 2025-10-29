package harry.cat.holograms.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.util.Util;

@Environment(EnvType.CLIENT)
public abstract class HologramLayerRenderer extends RenderPhase {
    public HologramLayerRenderer(String name, Runnable beginAction, Runnable endAction) {
        super(name, beginAction, endAction);
    }
    /*public static RenderLayer HOLOGRAM_TRANSLUCENT_LAYER = RenderLayer.of(
            "hologram_translucent_layer",
            4194304,
            true,
            true,
            RenderPipelines.ENTITY_TRANSLUCENT_EMISSIVE,
            RenderLayer.MultiPhaseParameters.builder().lightmap(ENABLE_LIGHTMAP).texture(MIPMAP_BLOCK_ATLAS_TEXTURE).target(TRANSLUCENT_TARGET).build(false)
    );*/
    public static final BiFunction<Identifier, Boolean, RenderLayer> HOLOGRAM_TRANSLUCENT_LAYER = Util.memoize(
            (texture, affectsOutline) -> {
                RenderLayer.MultiPhaseParameters multiPhaseParameters = RenderLayer.MultiPhaseParameters.builder()
                        .texture(new RenderPhase.Texture(texture, TriState.FALSE, false))
                        .lightmap(ENABLE_LIGHTMAP)
                        .overlay(ENABLE_OVERLAY_COLOR)
                        .build(affectsOutline);

                return RenderLayer.of("hologram_render_layer", 1536, true, true, RenderPipelines.ENTITY_TRANSLUCENT, multiPhaseParameters);
            }
    );
}
