package harry.cat.holograms;

import harry.cat.holograms.block.ModBlocks;
import harry.cat.holograms.block.entity.ModBlockEntities;
import harry.cat.holograms.item.ModItemGroups;
import harry.cat.holograms.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Holograms implements ModInitializer {
    public static final String MOD_ID = "holograms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
    }
}


