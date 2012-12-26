package mckay1717.pvp;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Entitypirimaru extends EntityPvP {

	public Entitypirimaru(World par1World) {
		super(par1World);
		this.username = "pirimaru";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		// TODO Auto-generated constructor stub
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
