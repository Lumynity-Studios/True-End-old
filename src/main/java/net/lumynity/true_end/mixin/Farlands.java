package net.lumynity.true_end.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = PerlinNoise.class, priority = 2048)
public class Farlands {
    @ModifyReturnValue(method = "wrap", at = @At("RETURN"))
    private static double replaceWrapReturn(double originalReturn, double input) {
        return input;
    }
}
