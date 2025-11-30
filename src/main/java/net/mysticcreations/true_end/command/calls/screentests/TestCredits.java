package net.mysticcreations.true_end.command.calls.screentests;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.mysticcreations.true_end.client.CreditsScreen;
import net.mysticcreations.true_end.init.Sounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

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
