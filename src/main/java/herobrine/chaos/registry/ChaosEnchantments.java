package herobrine.chaos.registry;

import herobrine.chaos.enchantment.BleedingEdgeEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChaosEnchantments {
    public static Enchantment BLEEDING_EDGE = Registry.register(Registry.ENCHANTMENT, new Identifier("chaos", "bleeding_edge"), new BleedingEdgeEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static void register() {
    }
}
