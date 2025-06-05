package herobrine.chaos;

import herobrine.chaos.block.ModBlocks;
import herobrine.chaos.item.ModItems;
import herobrine.chaos.item.custom.DarkworldBanishment;
import herobrine.chaos.registry.ChaosDamageSources;
import herobrine.chaos.registry.ChaosEnchantments;
import herobrine.chaos.registry.ChaosSoundEvents;
import herobrine.chaos.registry.ChaosStatusEffects;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chaos implements ModInitializer {
	public static boolean isEclipseActive = false;
	public static final String MOD_ID = "chaos";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ChaosDamageSources.register();
		ChaosStatusEffects.register();
		ChaosSoundEvents.register();
		ChaosEnchantments.register();
		ModBlocks.registerModBlocks();


		ModItems.registerModItems();
		LOGGER.info("Let Chaos Ensue...");
	}


}