package herobrine.chaos.item.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class DarkworldBanishment extends SwordItem {
    public static final String TAG = "divine_charge";
    private static final Map<UUID, BanishmentEffect> pendingBanishments = new HashMap<>();

    public DarkworldBanishment() {
        super(ToolMaterials.NETHERITE, 5, -2.4f, new FabricItemSettings().maxCount(1));
        ServerTickEvents.END_SERVER_TICK.register(this::tick);
    }

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("chaos", "darkworld_banishment"), new DarkworldBanishment());
    }

    public static void onEntityKilled(LivingEntity target, DamageSource source) {
        if (!(source.getAttacker() instanceof PlayerEntity player)) return;
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);

        if (!(stack.getItem() instanceof DarkworldBanishment)) return;

        int charge = stack.getOrCreateNbt().getInt(TAG);
        if (charge >= 2) {
            World world = target.getWorld();
            if (!world.isClient) {
                world.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 2.0F, 1.0F);
                pendingBanishments.put(target.getUuid(), new BanishmentEffect(target, world.getTime() + 60));
                stack.decrement(1); // Destroy item
            }
        } else {
            stack.getOrCreateNbt().putInt(TAG, charge + 1);
        }
    }

    private void tick(MinecraftServer server) {
        Iterator<Map.Entry<UUID, BanishmentEffect>> iterator = pendingBanishments.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<UUID, BanishmentEffect> entry = iterator.next();
            BanishmentEffect effect = entry.getValue();

            ServerWorld world = (ServerWorld) effect.world;
            Entity entity = world.getEntity(entry.getKey());

            if (entity != null && world.getTime() >= effect.triggerTime) {
                world.createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), 6.5f, Explosion.DestructionType.DESTROY);


                for (int i = 0; i < 8; i++) {
                    double angle = (2 * Math.PI / 8) * i;
                    double dx = entity.getX() + Math.cos(angle) * 10;
                    double dz = entity.getZ() + Math.sin(angle) * 10;
                    LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
                    if (lightning != null) {
                        lightning.refreshPositionAfterTeleport(dx, entity.getY(), dz);
                        world.spawnEntity(lightning);
                    }
                }

                world.spawnParticles(ParticleTypes.LARGE_SMOKE, entity.getX(), entity.getY(), entity.getZ(), 100, 3.0, 3.0, 3.0, 0.1);
                for (int i = 0; i < 5; i++) {
                    world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_WITHER_HURT, SoundCategory.HOSTILE, 1.5f, 0.9f + (i * 0.02f));
                }

                world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_WITHER_DEATH, SoundCategory.HOSTILE, 3.0f, 1.0f);
                iterator.remove();
            }
        }
    }

    private static class BanishmentEffect {
        public final World world;
        public final long triggerTime;

        public BanishmentEffect(LivingEntity entity, long triggerTime) {
            this.world = entity.getWorld();
            this.triggerTime = triggerTime;
        }
    }
}
