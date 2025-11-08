package harry.cat.holograms.client.screens;

import harry.cat.holograms.components.ModComponents;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;


public class DataPadScreen extends Screen {
    private TextFieldWidget inputField;
    private final ItemStack stack;

    public DataPadScreen(Text title, ItemStack stack) {
        super(title);
        this.stack = stack;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        //Text Box
        inputField = new TextFieldWidget(
                this.textRenderer,
                centerX - 100, centerY - 10,
                200, 20,
                Text.of("Enter Block ID")
        );
        inputField.setMaxLength(64);
        inputField.setPlaceholder(Text.of("minecraft:grass_block"));
        this.addDrawableChild(inputField);



        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Submit"), (btn) -> {
            String input = inputField.getText().trim();
            if (!input.isEmpty()) {
                stack.set(ModComponents.IDLE_HOLOGRAM, inputField.getText());
                this.close();
            }
            this.client.getToastManager().add(
              SystemToast.create(
                      this.client,
                      SystemToast.Type.NARRATOR_TOGGLE,
                      Text.of("Selection Stored"),
                      Text.of( inputField.getText() + " has been saved!")
              )
            );
        }).dimensions(
                centerX - 30, centerY + 60,
                50, 20).build();

        this.addDrawableChild(buttonWidget);


    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);


        context.drawText(
                this.textRenderer,
                "Special Button",
                40,
                40 - this.textRenderer.fontHeight - 10,
                0xFFFFFFFF,
                true);
    }


}
