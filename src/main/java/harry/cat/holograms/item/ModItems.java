package harry.cat.holograms.item;


import harry.cat.holograms.Holograms;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // MOD ITEMS
    //public static final Item HOLO_PROJECTOR = registerItem("holo_projector", new Item(new Item.Settings().maxCount(1)));

    // MOD CRAFTING PARTS
    public static final Item PROJECTION_LENS = registerSimpleItem("projector_lens", new Item.Settings().maxCount(8));
    public static final Item SIGNAL_EMITTER = registerSimpleItem("signal_emitter", new Item.Settings().maxCount(8));
    public static final Item CIRCUIT_BOARD = registerSimpleItem("circuit_board", new Item.Settings().maxCount(8));

    // Solo Items
    public static final Item DEATHSTAR_DATAPAD = registerSimpleItem("deathstar_datapad", new Item.Settings().maxCount(1));



    public static Item registerSimpleItem(String key, Item.Settings settings){
        return registerItem(Holograms.id(key), Item::new, settings);
    }
    public static <TItem extends Item, TSettings extends Item.Settings> TItem registerItem(Identifier registryKey, Function<TSettings, TItem> constructor, TSettings settings)
    {
        var item = constructor.apply((TSettings)settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, registryKey)));
        return Registry.register(Registries.ITEM, registryKey, item);
    }

    public static void registerItems() {
        Holograms.LOGGER.info("Registering Mod Items for " + Holograms.MOD_ID);
    }
}
