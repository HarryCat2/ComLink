package harry.cat.holograms.item;

import harry.cat.holograms.Holograms;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup HOLO_PROJECTOR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Holograms.MOD_ID, "holo_projector_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PROJECTION_LENS))
                    .displayName(Text.translatable("itemgroup.Holograms.holo_projector_items"))
                    .entries((displayContext, entries) -> {
                        //entries.add(ModItems.HOLO_PROJECTOR);
                        entries.add(ModItems.CIRCUIT_BOARD);
                        entries.add(ModItems.PROJECTION_LENS);
                        entries.add(ModItems.SIGNAL_EMITTER);
                    }).build());

    public static void registerItemGroups() {
        Holograms.LOGGER.info("Registering Item Groups for " + Holograms.MOD_ID);
    }

}
