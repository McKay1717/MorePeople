package net.minecraft.src;


import java.io.File;
import java.util.Map;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.mckay1717.pvp.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
@Mod(modid="Pvp", name="PvP", version="0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_PvP extends BaseMod   {
	@Instance("PvP")
	public static mod_PvP instance;
	static Configuration configuration;
	static int niveau = 3;
	static int maxplayer = 20;
	static boolean EpicMode = false;
	public int id = 124;
	
 public void registerrecipe()
 {
	 
 }
 public void registerentity()
 {

	 ModLoader.registerEntityID(EntityTheFumelgo.class, "TheFumelgo", id+1, 001, 000);
	 ModLoader.registerEntityID(EntityFurtys.class, "Furtys", id+2, 999, 000);
	 ModLoader.registerEntityID(Entitycypobos.class, "cypobos", id+3, 899, 000);
 }
 public void PvPspawn()
 {
	 
 }
 public void registerBlocks()
 {
	 
 }
 public void registerName()
 {
	 
 }
	@Override
 public void addRenderer(Map map )
 {
	 map.put(EntityTheFumelgo.class, new RenderPvP());
	 map.put(EntityFurtys.class, new RenderPvP());
	 map.put(Entitycypobos.class, new RenderPvP());
 
 }

	public static boolean configurationProperties()
    {
        configuration = new Configuration(new File(ModLoader.getMinecraftInstance().getMinecraftDir(), "/config/MorePLayer.cfg"));
        configuration.load();
        niveau = Integer.parseInt(configuration.getOrCreateIntProperty("Difficulter", "general", 1).value);
        maxplayer = Integer.parseInt(configuration.getOrCreateIntProperty("Nombre de joueur differant", "general", 20).value);
        EpicMode = Boolean.parseBoolean(configuration.getOrCreateBooleanProperty("Epic Mode", "general", false).value);
        configuration.save();
        return true;
    }

 @PreInit
 public void preInit(FMLPreInitializationEvent event) {
	 registerentity();
 }

 @Init
 public void init(FMLInitializationEvent event) {

 }

 @PostInit
 public static void postInit(FMLPostInitializationEvent event) {

 }
@Override
public String getVersion() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void load() {
	// TODO Auto-generated method stub
	 registerentity();
	 configurationProperties();
	 MinecraftForgeClient.preloadTexture("http://darkube.net/skin/Patate.png");
 }
}

