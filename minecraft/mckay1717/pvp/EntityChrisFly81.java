package mckay1717.pvp;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
public class EntityChrisFly81 extends  EntityPvP {
	
	
	public EntityChrisFly81(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.username = "ChrisFly81";
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
