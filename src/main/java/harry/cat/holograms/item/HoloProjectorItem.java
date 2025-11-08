package harry.cat.holograms.item;
import harry.cat.holograms.components.ModComponents;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;



public class HoloProjectorItem extends Item {
    public HoloProjectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand ) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient) {
            String owner = stack.get(ModComponents.OWNER_UUID_COMPONENT);

            if (owner == null || owner.isEmpty()) {
                stack.set(ModComponents.OWNER_UUID_COMPONENT, user.getUuid().toString());
                stack.set(ModComponents.OWNER_NAME_COMPONENT, user.getName().getString());

                user.sendMessage(Text.literal("Linked to: " + user.getName().getString()), true);


            } // insert else statement here for full function of device

            return ActionResult.SUCCESS;


        }
        return ActionResult.SUCCESS;
    }
}