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

public class ForsakenGemstone extends Item {

    public ForsakenGemstone(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("A Forlorn Gem, which it's Malevolent Intent draws close to").formatted(Formatting.DARK_RED).formatted(Formatting.ITALIC));
            tooltip.add(Text.literal("People Wishing for Great Power and Mayhem.").formatted(Formatting.DARK_RED).formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.literal("Press [Sneak] to show Story.").formatted(Formatting.DARK_GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }


    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0xD51212);
    }
}
