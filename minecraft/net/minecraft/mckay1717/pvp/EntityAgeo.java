package net.minecraft.mckay1717.pvp;

import net.minecraft.src.*;

public class EntityAgeo extends EntityPvP {

	protected boolean spawn = false;
	private static final ItemStack defaultHeldItem = new ItemStack(Item.swordDiamond, 1);
	public EntityAgeo(World par1World) {
		super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
 
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.username = "Ageo";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + "ageo" + ".png";
		// TODO Auto-generated constructor stub
	}
	protected boolean isAIEnabled()
    {
        return true;
    }
	  public ItemStack getHeldItem()
	    {
	        return defaultHeldItem;
	    }

	  public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeEntityToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setString("Username", this.username);
	        par1NBTTagCompound.setBoolean("Spawn", this.spawn);
	    }
		public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readEntityFromNBT(par1NBTTagCompound);
	        this.username = par1NBTTagCompound.getString("Username");
	        this.spawn = par1NBTTagCompound.getBoolean("Spawn");
	    }
	}


