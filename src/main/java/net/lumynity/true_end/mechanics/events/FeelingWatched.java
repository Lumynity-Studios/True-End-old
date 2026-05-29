package net.lumynity.true_end.mechanics.events;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.lumynity.true_end.registries.Dimensions.BTD;

@Mod.EventBusSubscriber
public class FeelingWatched {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player && !player.level().isClientSide() && (entity.level().dimension()) == BTD)
			player.displayClientMessage(Component.translatable("events.true_end.feelingwatched"), true);
	}
}
