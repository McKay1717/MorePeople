package mckay1717.pvp.client;
import mckay1717.pvp.CommonProxy;
import mckay1717.pvp.*;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRendering() {
		// MinecraftForgeClient.preloadTexture(texture);
		// RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
		// registerBlockHandler
		 RenderingRegistry.registerEntityRenderingHandler(EntityTheFumelgo.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityFurtys.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(Entitycypobos.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntitySticor.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityKnux14.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(Entityvoolvif.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityNotch.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityChrisFly81.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityTheDudu36.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityAgeo.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityBynouz.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityLeSilouatien.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(Entitypirimaru.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntitySoxyn.class, new RenderPvP());
		 RenderingRegistry.registerEntityRenderingHandler(EntityTurBo67.class, new RenderPvP());
	}

	// example method for adding armor
	@Override
	public int addArmour(String path) {
		return RenderingRegistry.addNewArmourRendererPrefix(path);
	}
}