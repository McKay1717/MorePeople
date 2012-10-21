package net.minecraft.mckay1717.pvp;

import net.minecraft.src.*;

public class EntityKnux14 extends EntityPvP {

	public EntityKnux14(World par1World) {
		super(par1World);
		this.username = "Knux14";
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLiving.class, this.moveSpeed, false));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		 this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 16.0F, 0, true));
		// TODO Auto-generated constructor stub
		 this.getNavigator().setBreakDoors(true);
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(1, new EntityAIBreakDoor(this));
	        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
	        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
	        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));

	        this.tasks.addTask(7, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	        
		 this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
	}
	@Override
	 protected boolean isAIEnabled()
	    {
	        return true;
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
