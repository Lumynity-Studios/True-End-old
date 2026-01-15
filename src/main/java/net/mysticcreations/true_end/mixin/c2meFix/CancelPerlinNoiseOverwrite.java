package net.mysticcreations.true_end.mixin.c2meFix;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class CancelPerlinNoiseOverwrite implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> list, String mixinClassName) {
        //Kinda shitty fix 'cause can break chunk loading randomly
        //Probably need to expand the fix to cover the chunks sometimes not loading in random areas
        return mixinClassName.equals("com.ishland.c2me.opts.math.mixin.MixinOctavePerlinNoiseSampler") ||
            mixinClassName.equals("com.ishland.c2me.opts.math.mixin.MixinPerlinNoiseSampler");
    }
}
