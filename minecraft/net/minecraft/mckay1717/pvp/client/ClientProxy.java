package net.minecraft.mckay1717.pvp.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraft.mckay1717.pvp.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
		
	}
	
}