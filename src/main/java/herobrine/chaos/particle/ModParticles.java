package herobrine.chaos.particle;

import herobrine.chaos.Chaos;
import herobrine.chaos.particle.custom.FatesInfluenceSweep;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType FatesInfluenceSweep = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Chaos.MOD_ID, "fates_influence_sweep"),
                FatesInfluenceSweep);
    }
}
