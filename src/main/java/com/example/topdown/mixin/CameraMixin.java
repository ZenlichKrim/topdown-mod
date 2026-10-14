package com.example.topdown.mixin;

import com.example.topdown.TopDownState;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Inject(method = "update", at = @At("TAIL"))
    private void topdown$applyTopDownView(BlockView area,
                                          Entity focusedEntity,
                                          boolean thirdPerson,
                                          boolean inverseView,
                                          float tickDelta,
                                          CallbackInfo ci) {
        if (!TopDownState.isEnabled()) return;
        if (!(focusedEntity instanceof PlayerEntity player)) return;

        CameraAccessor acc = (CameraAccessor) (Object) this;

        acc.invokeSetPos(
                player.getX(),
                player.getY() + TopDownState.getHeight(),
                player.getZ()
        );

        acc.invokeSetRotation(player.getYaw(), 90.0f);
    }
}
