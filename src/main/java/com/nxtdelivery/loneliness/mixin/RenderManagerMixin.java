package com.nxtdelivery.loneliness.mixin;


import com.nxtdelivery.loneliness.config.LonelyConfig;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class RenderManagerMixin {
    @Inject(method = "renderHand", at = @At("HEAD"), cancellable = true)
    public void yes(float partialTicks, int xOffset, CallbackInfo ci) {
        if (LonelyConfig.hideSelf) ci.cancel();
    }
}
