package herobrine.chaos.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.amymialee.mialeemisc.util.MialeeText;

import java.util.List;

public class Maledictum extends Item {

    public Maledictum(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("These Pages were made by Drakan, to kill Permanently Kill Herobrine.").formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.literal("Press [Sneak] to show Story.").formatted(Formatting.DARK_GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);

    }
                //I know im going to regret making Drakan kill me. But I don't fucking care

    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0x4A4651);
    }
}
