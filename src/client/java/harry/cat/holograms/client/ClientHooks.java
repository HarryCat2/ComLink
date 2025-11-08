package harry.cat.holograms.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.item.ItemStack;
import harry.cat.holograms.client.screens.DataPadScreen;

@Environment(EnvType.CLIENT)
public class ClientHooks {
    public static void openDataPadScreen(ItemStack stack) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            client.setScreen(new DataPadScreen(Text.of("DataPad"), stack));
        }
    }
}