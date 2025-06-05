package herobrine.chaos.item.custom;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.amymialee.mialeemisc.util.MialeeText;

import static herobrine.chaos.Chaos.isEclipseActive;
import static herobrine.chaos.item.ModItems.DARKSIGN_EFFIGY;

public class DarksignEffigy extends Item {

    public DarksignEffigy(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0xC5C5C5);
    }
}
