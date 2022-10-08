package com.nxtdelivery.loneliness.mixin;

import com.nxtdelivery.loneliness.Lonliness;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderManager.class)
public class RenderManagerMixin {
    @Inject(method = "shouldRender", at = @At(value = "HEAD"), cancellable = true)
    private void shouldRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        if (Lonliness.INSTANCE.config.enabled) cir.setReturnValue(!Lonliness.shouldHideEntity(entityIn));
    }
}
