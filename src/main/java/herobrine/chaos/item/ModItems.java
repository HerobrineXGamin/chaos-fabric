package herobrine.chaos.item;

import herobrine.chaos.Chaos;
import herobrine.chaos.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item FATES_INFLUENCE = registerItem("fates_influence",
            new FatesInfluence(ToolMaterials.NETHERITE, 5, -2.4f, new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof()));
    public static final Item EMPTY_FATES_INFLUENCE = registerItem("empty_fates_influence",
            new EmptyFatesInfluence(ToolMaterials.NETHERITE, 5, -2.4f, new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof()));
    public static final Item DARKWORLD_BANISHMENT = registerItem("darkworld_banishment",
            new DarkworldBanishment());
    public static final Item FORSAKEN_GEMSTONE = registerItem("forsaken_gemstone",
            new ForsakenGemstone(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof().maxCount(1)));
    public static final Item UMBRALIUM_INGOT = registerItem("umbralium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof()));
    public static final Item FADED_CINDER = registerItem("faded_cinder",
            new FadedCinder(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof()));
    public static final Item DARKSIGN_EFFIGY = registerItem("darksign_effigy",
            new DarksignEffigy(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof().maxCount(1)));
    public static final Item RUNE_OF_DEATH = registerItem("rune_of_death",
            new RuneOfDeath(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof().maxCount(1)));
    public static final Item MALEDICTUM = registerItem("maledictum",
            new Maledictum(new FabricItemSettings().group(ModItemGroup.CHAOS).fireproof().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Chaos.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Chaos.LOGGER.debug("Registering Mod Items for " + Chaos.MOD_ID);
    }
}