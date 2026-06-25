package com.example.secretid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretIdMod implements ModInitializer {
	public static final String MOD_ID = "secretid";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Secret ID Mod is initializing...");

		// Register Player Join Event
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			PlayerDataState state = PlayerDataState.getServerState(server);
			String secretId = state.getOrCreateSecretId(player.getUuid());
		});

		// Register Commands
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			Commands.register(dispatcher);
		});
	}
}
