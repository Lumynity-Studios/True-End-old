package net.lumynity.true_end.registries;

import net.lumynity.true_end.TrueEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TrueEnd.MODID);
    private static RegistryObject<SoundEvent> sound(String name) {
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.parse(TrueEnd.MODID+":"+name)));
    }
    public static final RegistryObject<SoundEvent> VINE_BOOM = sound("vine_boom");
    public static final RegistryObject<SoundEvent> MOD_CREDITS_MUSIC = sound("back_in_the_game");
    public static final RegistryObject<SoundEvent> MUSIC_FARLANDS = sound("farlands");
    public static final RegistryObject<SoundEvent> MUSIC_NEVER_ALONE = sound("never_alone");
    public static final RegistryObject<SoundEvent> DAISY_BELL = sound("daisy_bell");
}