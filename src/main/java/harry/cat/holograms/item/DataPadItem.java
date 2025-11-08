package harry.cat.holograms.item;

import harry.cat.holograms.components.ModComponents;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class DataPadItem extends Item {

    public DataPadItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient && FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            String idle_hologram = stack.get(ModComponents.IDLE_HOLOGRAM);
            try {
                Class.forName("harry.cat.holograms.client.ClientHooks").getMethod("openDataPadScreen", ItemStack.class).invoke(null, stack);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return ActionResult.SUCCESS;
    }
}
