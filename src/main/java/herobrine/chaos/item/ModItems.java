package herobrine.chaos.item;

import herobrine.chaos.Chaos;
import herobrine.chaos.item.custom.FatesInfluence;
import herobrine.chaos.item.custom.ForsakenGemstone;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item FATES_INFLUENCE = registerItem("fates_influence",
            new FatesInfluence(ToolMaterials.NETHERITE, 5, -2.6f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item FORSAKEN_GEMSTONE = registerItem("forsaken_gemstone",
            new ForsakenGemstone(new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Chaos.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Chaos.LOGGER.debug("Registering Mod Items for " + Chaos.MOD_ID);
    }
}