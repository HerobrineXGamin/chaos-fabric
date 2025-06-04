package herobrine.chaos.mixin;

import herobrine.chaos.item.custom.FatesInfluence;
import herobrine.chaos.registry.ChaosSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class HitMixin {

    @Inject(at = @At("HEAD"), method = "attack")
    private void AttackWithFatesInfluence(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        float attackPower = player.getAttackCooldownProgress(.0f);
        ItemStack tool = player.getStackInHand(Hand.MAIN_HAND);

        if (tool.getItem() instanceof FatesInfluence) {
            if (attackPower > .8f) {
                float pitch = .9f + (player.getRandom().nextFloat() * .2f);
                player.world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        ChaosSoundEvents.FATES_INFLUENCE_HIT_EVENT, SoundCategory.PLAYERS, 1.f, pitch);
            }
        }
    }
}