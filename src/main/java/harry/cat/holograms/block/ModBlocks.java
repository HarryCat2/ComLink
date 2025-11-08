package harry.cat.holograms.block;

import harry.cat.holograms.Holograms;
import harry.cat.holograms.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {


    private static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Holograms.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Holograms.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static <TBlock extends Block, TSettings extends Block.Settings> TBlock block(Identifier registryKey, Function<TSettings, TBlock> constructor, TSettings settings)
    {
        var block = constructor.apply((TSettings)settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, registryKey)));
        ModItems.registerItem(registryKey, itemSettings -> new BlockItem(block, itemSettings) , new Item.Settings());
        return Registry.register(Registries.BLOCK, registryKey, block);
    }

    public static void registerBlocks() {
        Holograms.LOGGER.info("Registering Blocks for " + Holograms.MOD_ID);
    }

    public static final HoloTableBlock HOLO_TABLE =
            block(Holograms.id("holo_table"),
                    HoloTableBlock::new,
                    AbstractBlock.Settings.create()
                            .nonOpaque()
            );
}

