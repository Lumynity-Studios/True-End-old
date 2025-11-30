package net.mysticcreations.true_end.procedures.randomEvents;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mysticcreations.true_end.network.Variables;

@Mod.EventBusSubscriber
public class NoVoidDamage {
    public static boolean eventActive;

    @SubscribeEvent
    public static void onPlayerJoin(LevelEvent.Load event) {
        if (!Variables.doRandomEvents) return;
        if (Math.random() < 0.5) {
            eventActive = true;
        } else {
            eventActive = false;
        }
    }
    @SubscribeEvent
    public static void onEntityDamaged(LivingHurtEvent event) {
        if (!eventActive) return;
        Entity entity = event.getEntity();
        if (!(entity instanceof ServerPlayer player)) return;

        if (player.level().dimension().equals(Level.END)) return;

        DamageSource source = event.getSource();
        if (source == null) return;
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD) && player.getY() >= -2010) event.setCanceled(true);
        //It's set to -2010 cuz year 2010 is when Alpha 1.1.2_01 released
    }
}
