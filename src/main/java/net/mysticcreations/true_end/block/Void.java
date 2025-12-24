package net.mysticcreations.true_end.block;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class Void extends Block {
    public Void() {
        super(BlockBehaviour.Properties.of().sound(SoundType.EMPTY)
            .strength(-1.0f, -1.0f)
            .hasPostProcess((bs, br, bp) -> true)
            .lightLevel(s -> 1)
            .emissiveRendering((bs, br, bp) -> true)
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder lootContext) {
        return Collections.emptyList();
    }
}
