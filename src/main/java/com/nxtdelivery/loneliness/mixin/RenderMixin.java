package com.nxtdelivery.loneliness.mixin;

import com.nxtdelivery.loneliness.Loneliness;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Render.class, priority = 999)
public class RenderMixin {
    @Inject(method = "shouldRender", at = @At(value = "HEAD"), cancellable = true)
    private void shouldRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        if (Loneliness.INSTANCE.config.enabled) cir.setReturnValue(!Loneliness.shouldHideEntity(entityIn));
    }
}
