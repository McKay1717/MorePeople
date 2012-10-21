package net.minecraft.mckay1717.pvp;

import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityNotch extends EntityPvP {
	private static final ItemStack defaultHeldItem = new ItemStack(net.minecraft.src.Item.appleRed, 1);
	public EntityNotch(World par1World) {
		super(par1World);
		this.username = "Notch";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		// TODO Auto-generated constructor stub
	}
	 public ItemStack getHeldItem()
	    {
	        return defaultHeldItem;
	    }
	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeEntityToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setString("Username", this.username);
	    }
		public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readEntityFromNBT(par1NBTTagCompound);
	        this.username = par1NBTTagCompound.getString("Username");
	    }

}
