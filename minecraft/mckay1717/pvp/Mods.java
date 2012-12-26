package mckay1717.pvp;


import java.io.File;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import mckay1717.pvp.client.RenderPvP;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraftforge.common.Configuration;
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
import cpw.mods.fml.common.registry.EntityRegistry;
@Mod(modid="Pvp", name="PvP", version="0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class Mods    {
	@Instance("PvP")
	public static Mods instance;
	static Configuration configuration;
	static int niveau = 3;
	static int maxplayer = 20;
	static boolean EpicMode = false;
	public static int id = ModLoader.getUniqueEntityId();
	@SidedProxy(clientSide = "mckay1717.pvp.CommonProxy", serverSide = "mckay1717.pvp.client.ClientProxy")
	public static CommonProxy proxy;

	public static Logger logger;
 public void registerrecipe()
 {
	 
 }
 public void registerentity()
 {

	  EntityRegistry.registerGlobalEntityID(EntityTheFumelgo.class, "assasineman", id+1, 001, 000);
	  EntityRegistry.registerGlobalEntityID(EntityFurtys.class, "Furtys", id+2, 999, 000);
	  EntityRegistry.registerGlobalEntityID(Entitycypobos.class, "cypobos", id+3, 899, 000);
	  EntityRegistry.registerGlobalEntityID(EntitySticor.class, "Sticor", id+4, 799, 000);
	  EntityRegistry.registerGlobalEntityID(EntityKnux14.class, "Knux14", id+5, 899, 800);
	  EntityRegistry.registerGlobalEntityID(Entityvoolvif.class, "Voolvif_3", id+6, 899, 261165416);
	  EntityRegistry.registerGlobalEntityID(EntityNotch.class, "Notch", id+8, 511651, 151321);
	  EntityRegistry.registerGlobalEntityID(EntityChrisFly81.class, "ChrisFly81", id+7, 1615546, 54941265);
	  EntityRegistry.registerGlobalEntityID(EntityTheDudu36.class, "TheDudu36", id+9, 64654, 359974);
	  EntityRegistry.registerGlobalEntityID(EntityAgeo.class, "Ageo", id+10, 644554, 35995754);
	  EntityRegistry.registerGlobalEntityID(EntityBynouz.class, "Bynouz", id+11, 644554, 35995754);
	  EntityRegistry.registerGlobalEntityID(EntityLeSilouatien.class, "LeSilouatien", id+11, 4554, 35995754);
	  EntityRegistry.registerGlobalEntityID(Entitypirimaru.class, "pirimaru", id+12, 644554, 359754);
	  EntityRegistry.registerGlobalEntityID(EntitySoxyn.class, "Soxyn", id+13, 6554, 359957);
	  EntityRegistry.registerGlobalEntityID(EntityTurBo67.class, "TurBo67", id+14, 644554, 355754);
//	  EntityRegistry.registerGlobalEntityID(EntityMedlinya.class, "Medlinya", id+15, 6444, 359754);
//	  EntityRegistry.registerGlobalEntityID(EntityMedlinya.class, "Medlinya", id+16, 644554, 355754);
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


	public static boolean configurationProperties()
    {
        configuration = new Configuration(new File(ModLoader.getMinecraftInstance().getMinecraftDir(), "/config/MorePLayer.cfg"));
        configuration.load();
       
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

	
   
}



