package herobrine.chaos.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.amymialee.mialeemisc.util.MialeeText;

import java.util.List;

public class FatesInfluence extends SwordItem {
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private final float attackDamage;

    public FatesInfluence(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(ToolMaterials.NETHERITE, attackDamage, attackSpeed, settings);
        this.attackDamage = ToolMaterials.NETHERITE.getAttackDamage() + attackDamage;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier("Attack range", 1.3D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", 1.3D, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }


    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0x680D0D);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.isOnGround()) {
            applyReversedKnockback(target, attacker);
            target.velocityModified = true;
        }
        return super.postHit(stack, target, attacker);
    }
    private void applyReversedKnockback(LivingEntity target, LivingEntity attacker) {
        Vec3d attackerPos = attacker.getPos();
        Vec3d targetPos = target.getPos();
        double xDiff = targetPos.x - attackerPos.x;
        double zDiff = targetPos.z - attackerPos.z;

        double distance = Math.sqrt(xDiff * xDiff + zDiff * zDiff);

        EntityAttributeInstance reachAttribute = attacker.getAttributeInstance(ReachEntityAttributes.REACH);
        double maxReach = reachAttribute == null ? 5.0 : reachAttribute.getValue();
        double maxStrength = 0.8;
        double strength = Math.min(0.8, Math.max(0.2, maxStrength * (distance / maxReach)));

        target.setVelocity(0, 0, 0);

        double xKnockback = xDiff * strength;
        double zKnockback = zDiff * strength;

        target.takeKnockback(strength, xKnockback, zKnockback);
    }
}
