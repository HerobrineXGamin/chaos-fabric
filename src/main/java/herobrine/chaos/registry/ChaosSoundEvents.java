package herobrine.chaos.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChaosSoundEvents {
    public static final SoundEvent FATES_INFLUENCE_HIT_EVENT = registerSound("fates_influence_hit");

    private static SoundEvent registerSound(String name) {
        Identifier id = new Identifier("chaos", name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    // Call this method once during your mod init to ensure registration
    public static void register() {
        // This method can be empty if you register statically,
        // or call it from your main class to force class loading
    }
}