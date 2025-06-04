package herobrine.chaos.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import xyz.amymialee.mialeemisc.util.MialeeText;

public class DarksignEffigy extends Item {

    public DarksignEffigy(Settings settings) {
        super(settings);
    }
    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0xC5C5C5);
    }
}
