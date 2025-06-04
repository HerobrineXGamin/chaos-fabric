package herobrine.chaos.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BleedingEdgeEnchantment extends Enchantment {
    public BleedingEdgeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
