package herobrine.chaos.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChaosSoundEvents {
    public static final Identifier FATES_INFLUENCE_HIT = new Identifier("chaos:fates_influence_hit");
    public static SoundEvent FATES_INFLUENCE_HIT_EVENT = new SoundEvent(FATES_INFLUENCE_HIT);

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, ChaosSoundEvents.FATES_INFLUENCE_HIT, FATES_INFLUENCE_HIT_EVENT);
    }
}
