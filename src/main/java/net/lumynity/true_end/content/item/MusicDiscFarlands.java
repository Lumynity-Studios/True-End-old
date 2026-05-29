
package net.lumynity.true_end.content.item;

import net.lumynity.true_end.registries.Sounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class MusicDiscFarlands extends RecordItem {
    public MusicDiscFarlands() {
        super(8, () -> ForgeRegistries.SOUND_EVENTS.getValue(Sounds.MUSIC_FARLANDS.getId()), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2540);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
    }
}
