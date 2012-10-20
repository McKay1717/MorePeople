package net.minecraft.mckay1717.pvp;

import net.minecraft.src.*;

public abstract class EntityPvP extends EntityMob
{
	public  String username = "";
	public EntityPvP(World par1World) {
		super(par1World);
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		this.attackStrength = 4;
        this.moveSpeed = 0.28555F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
      
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
      
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

       
		// TODO Auto-generated constructor stub
	}

	
    
	public int getMaxHealth()
    {
        return 20;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return 2;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }
}
