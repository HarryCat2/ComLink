package harry.cat.holograms.items;


import harry.cat.holograms.Holograms;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // MOD ITEMS
    //public static final Item HOLO_PROJECTOR = registerItem("holo_projector", new Item(new Item.Settings().maxCount(1)));

    // MOD CRAFTING PARTS
    public static final Item PROJECTION_LENS = registerItem("projector_lens", new Item(new Item.Settings().maxCount(8)));
    public static final Item SIGNAL_EMITTER = registerItem("signal_emitter", new Item(new Item.Settings().maxCount(8)));
    public static final Item CIRCUIT_BOARD = registerItem("circuit_board", new Item(new Item.Settings().maxCount(8)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Holograms.MOD_ID, name), item);

    }

    public static void registerModItems() {
        Holograms.LOGGER.info("Registering Mod Items for " + Holograms.MOD_ID);
    }
}
