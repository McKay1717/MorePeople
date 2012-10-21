package net.minecraft.mckay1717.pvp;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPig;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityTheFumelgo extends  EntityPvP {
	
	
	public EntityTheFumelgo(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.username = "assasineman";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX+1, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX+2, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX+3, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX+4, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ-1, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ-2, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ-3, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ-4, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ+1, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ+2, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ+3, 38);
		this.worldObj.setBlockWithNotify((int)this.posX, (int)this.posY, (int)this.posZ+4, 38);
		this.worldObj.setBlockWithNotify((int)this.posX-1, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX-2, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX-3, (int)this.posY, (int)this.posZ, 38);
		this.worldObj.setBlockWithNotify((int)this.posX-4, (int)this.posY, (int)this.posZ, 38);
		
		
	}
	protected boolean isAIEnabled()
    {
        return false;
    }
	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 20;
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
