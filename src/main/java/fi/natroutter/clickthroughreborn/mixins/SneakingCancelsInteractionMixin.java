package fi.natroutter.clickthroughreborn.mixins;

import fi.natroutter.clickthroughreborn.ClickThroughReborn;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)

public class SneakingCancelsInteractionMixin {
    @Inject(method="shouldCancelInteraction", at=@At("HEAD"), cancellable = true)
    private void noCancelWhenDyeing(CallbackInfoReturnable cir) {
        if (((Object) this) instanceof ClientPlayerEntity) {
            if (ClickThroughReborn.isDyeOnSign) {
                cir.setReturnValue(false);
                cir.cancel();
                ClickThroughReborn.isDyeOnSign = false;
            }
        }
    }
}
