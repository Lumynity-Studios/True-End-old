package net.lumynity.true_end.mechanics.alphaFeatures;

import net.lumynity.true_end.TrueEnd;
import net.lumynity.true_end.registries.Dimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber
public class NoCooldown {
    private static final UUID MODIFIER_UUID = UUID.fromString("9b91a426-cc5c-4a08-a0e5-7d00627cb3ef");
    private static final AttributeModifier baseModifier = new AttributeModifier(MODIFIER_UUID, "true_end.noCooldown",200.0, AttributeModifier.Operation.ADDITION);
    private static final AttributeModifier bcModifier = new AttributeModifier(MODIFIER_UUID, "true_end.noCooldown",2.0, AttributeModifier.Operation.ADDITION);

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        ResourceKey<Level> toDim = serverPlayer.level().dimension();
        applyCooldown(serverPlayer, toDim);
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        ResourceKey<Level> toDim = event.getTo();
        applyCooldown(serverPlayer, toDim);
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.Clone event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        ResourceKey<Level> toDim = serverPlayer.level().dimension();
        applyCooldown(serverPlayer, toDim);
    }

    private static void applyCooldown(ServerPlayer player, ResourceKey<Level> toDim) {
        AttributeInstance attackSpeedAttr = player.getAttribute(Attributes.ATTACK_SPEED);
        if (attackSpeedAttr == null) return;

        // remove old bugged attributes
        Set<AttributeModifier> buggedAttributes = new HashSet<>();
        for (AttributeModifier modifier : attackSpeedAttr.getModifiers()) {
            if (modifier.getName().equals(MODIFIER_UUID.toString())) {
                buggedAttributes.add(modifier);
            }
        }
        for (AttributeModifier buggedAttribute : buggedAttributes) {
            attackSpeedAttr.removeModifier(buggedAttribute);
        }

        // then add the modifier to the player
        AttributeModifier modifier = TrueEnd.inModList("bettercombat") ? bcModifier : baseModifier;
        if (toDim.equals(Dimensions.BTD)) {
            attackSpeedAttr.addTransientModifier(modifier);
        } else {
            attackSpeedAttr.removeModifier(modifier);
        }
    }
}