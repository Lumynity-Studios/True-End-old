package net.lumynity.true_end.content.command.calls.screentests;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.lumynity.true_end.client.CreditsScreen;
import net.lumynity.true_end.registries.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class TestCredits {
    public static void play() {
        Minecraft mc = Minecraft.getInstance();
        mc.execute(() -> {
            mc.getSoundManager().stop();
            mc.player.playNotifySound(ForgeRegistries.SOUND_EVENTS.getValue(Sounds.MOD_CREDITS_MUSIC.getId()), SoundSource.MASTER, 1f, 1f);
            mc.setScreen(new CreditsScreen());
        });
    }
}
