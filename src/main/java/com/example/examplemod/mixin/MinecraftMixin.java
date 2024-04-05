package com.example.examplemod.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	//fix multiplayer not working in dev
	@Inject(at = @At("HEAD"), method = "allowsMultiplayer", cancellable = true)
	private void init(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}
}
