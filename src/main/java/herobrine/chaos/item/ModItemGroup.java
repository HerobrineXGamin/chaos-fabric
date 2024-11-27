package herobrine.chaos.item;

import herobrine.chaos.Chaos;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CHAOS = FabricItemGroupBuilder.build(
            new Identifier(Chaos.MOD_ID, "blood"), () -> new ItemStack(ModItems.MALEDICTUM));

}
