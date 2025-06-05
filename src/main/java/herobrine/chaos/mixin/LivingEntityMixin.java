package herobrine.chaos.mixin;

import herobrine.chaos.item.custom.DarkworldBanishment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource source, CallbackInfo ci) {
        // Cast this mixin instance to LivingEntity to get entity info
        LivingEntity entity = (LivingEntity) (Object) this;

        // Only run on server side to avoid client desyncs
        if (entity.world.isClient()) {
            return;
        }

        // Call your item kill handler
        DarkworldBanishment.onEntityKilled(entity, source);
    }
}
