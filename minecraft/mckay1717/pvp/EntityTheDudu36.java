package mckay1717.pvp;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.*;
import net.minecraft.world.World;

public class EntityTheDudu36 extends  EntityPvP {

	public EntityTheDudu36(World par1World) {
		super(par1World);
		this.username ="TheDudu36";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		// TODO Auto-generated constructor stub
	}
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }
	

}
