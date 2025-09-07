package harry.cat.holograms.client.renderer.renderlayer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.render.MapRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.equipment.EquipmentModelLoader;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.TextureManager;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class HologramRenderLayer extends EntityRenderDispatcher {
    public HologramRenderLayer(MinecraftClient client, TextureManager textureManager, ItemModelManager itemModelManager, ItemRenderer itemRenderer, MapRenderer mapRenderer, BlockRenderManager blockRenderManager, TextRenderer textRenderer, GameOptions gameOptions, Supplier<LoadedEntityModels> entityModelsGetter, EquipmentModelLoader equipmentModelLoader) {
        super(client, textureManager, itemModelManager, itemRenderer, mapRenderer, blockRenderManager, textRenderer, gameOptions, entityModelsGetter, equipmentModelLoader);
    }



}
