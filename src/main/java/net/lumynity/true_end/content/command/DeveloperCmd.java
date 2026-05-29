package net.lumynity.true_end.content.command;

import net.lumynity.true_end.content.command.calls.BTDTest;
import net.lumynity.true_end.content.command.calls.InvFileConvert;
import net.lumynity.true_end.content.command.calls.PrintVars;
import net.lumynity.true_end.content.command.calls.screentests.TestBlackOverlay;
import net.lumynity.true_end.content.command.calls.screentests.TestFunny;
import net.lumynity.true_end.mechanics.logic.PlayerInvManager;
import net.lumynity.true_end.network.packets.ShowCreditsPacket;
import net.lumynity.true_end.registries.Packets;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.lumynity.true_end.registries.Dimensions.BTD;
import static net.lumynity.true_end.registries.Dimensions.NWAD;

@Mod.EventBusSubscriber
public class DeveloperCmd {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("trueend")
			.then(Commands.literal("testScreen")
				.then(Commands.literal("credits")
					.requires(s -> s.hasPermission(4))
					.executes(arguments -> {
                        ServerPlayer player = arguments.getSource().getPlayer();
                        Packets.sendToPlayer(new ShowCreditsPacket(), player);
						return 0;
					})).then(Commands.literal("funny")
					.executes(arguments -> {
						Level world = arguments.getSource().getUnsidedLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();

						TestFunny.execute(world, x, y, z, entity);
						return 0;
					})).then(Commands.literal("black")
					.requires(s -> s.hasPermission(4))
					.executes(arguments -> {
						Level world = arguments.getSource().getUnsidedLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();

						TestBlackOverlay.execute(world, x, y, z, entity);
						return 0;
					})))
			.then(Commands.literal("printVars")
				.requires(s -> s.hasPermission(4))
				.executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					Entity entity = arguments.getSource().getEntity();

					PrintVars.execute(world, (ServerPlayer) entity, arguments.getSource());
					return 0;
				})).then(Commands.literal("testBTD")
				.requires(s -> s.hasPermission(4))
				.executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					Entity entity = arguments.getSource().getEntity();

					BTDTest.execute(entity);
					return 0;
				}))			.then(Commands.literal("clearAccessories")
				.requires(s -> s.hasPermission(4))
				.executes(arguments -> {
					ServerPlayer player = arguments.getSource().getPlayer();

					PlayerInvManager.clearAccessories(player);
					return 0;
				})).then(Commands.literal("convertInvBackup")
				.requires(s -> s.hasPermission(4))
				.then(Commands.literal(BTD.location().toString())
					.executes(arguments -> {
						ServerPlayer player = arguments.getSource().getPlayer();
						InvFileConvert.execute(player, "BTD");
						return 0;
					}))
				.then(Commands.literal(NWAD.location().toString())
					.executes(arguments -> {
						ServerPlayer player = arguments.getSource().getPlayer();
						InvFileConvert.execute(player, "NWAD");
						return 0;
					}))
			)
		);
	}
}