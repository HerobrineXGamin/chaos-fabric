package herobrine.chaos.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import xyz.amymialee.mialeemisc.util.MialeeText;

public class RuneOfDeath extends Item {
    public RuneOfDeath(Settings settings) {
        super(settings);
    }

    // "Why covet Destined Death, To kill what?" Fucking everyone dipshit, what it look like?

    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0x680D0D);
    }
}
