package net.lumynity.true_end.mechanics.logic;

import net.lumynity.true_end.config.Config;
import net.lumynity.true_end.network.Variables;
import net.lumynity.true_end.network.packets.ShowCreditsPacket;
import net.lumynity.true_end.registries.Packets;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.lumynity.true_end.registries.Dimensions.BTD;

@Mod.EventBusSubscriber
public class PlayCredits {
    private static boolean hasShownCreditsThisSession = false;
    @SubscribeEvent
    public static void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (Variables.showCredits) { hasShownCreditsThisSession = false; } else { return; }
        if (hasShownCreditsThisSession) return;

        if (event.getFrom() == BTD && event.getTo() == Level.OVERWORLD) {
            hasShownCreditsThisSession = true;
            Config.updateConfig("showCredits", false);

            ServerPlayer player = (ServerPlayer) event.getEntity();
            Packets.sendToPlayer(new ShowCreditsPacket(), player);
        }
    }
}