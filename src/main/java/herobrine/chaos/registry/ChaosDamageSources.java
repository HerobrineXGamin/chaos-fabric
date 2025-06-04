package herobrine.chaos.registry;

import net.minecraft.entity.damage.DamageSource;

public class ChaosDamageSources extends DamageSource {
    public static final DamageSource BLEEDING = new ChaosDamageSources("bleeding").setBypassesArmor().setUnblockable();
    protected ChaosDamageSources(String name) {
        super(name);
    }

    public static void register() {
    }
}