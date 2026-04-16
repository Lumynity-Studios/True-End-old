package net.lumynity.true_end.network.packets;

import net.lumynity.true_end.command.calls.screentests.TestCredits;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShowCreditsPacket {
    public ShowCreditsPacket() {}
    public void toBytes(FriendlyByteBuf buf) {}
    public ShowCreditsPacket(FriendlyByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> context) {
        if (context.get().getDirection().getReceptionSide().isClient()) {
            context.get().enqueueWork(() -> {
                TestCredits.play();
            });
        }

        context.get().setPacketHandled(true);
    }
}
