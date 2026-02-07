package net.mysticcreations.true_end.command.calls;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mysticcreations.true_end.TrueEnd;

public class BTDTest {
    public static void execute(Entity entity) {
        if (entity == null) return;
        if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "setblock ~ ~ ~ minecraft:end_portal");
        }
        TrueEnd.wait(30, () -> {
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                        entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @e[type=ender_dragon]");
                }
            }
        });
        TrueEnd.wait(5, () -> {
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                        entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s 0 96 -1");
                }
            }
        });
    }
}
