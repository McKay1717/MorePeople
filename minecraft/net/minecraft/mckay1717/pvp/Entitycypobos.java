package net.minecraft.mckay1717.pvp;

import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityMob;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class Entitycypobos extends EntityPvP {

	public Entitycypobos(World par1World) {
		super(par1World);
		this.username  = "cypobos";
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		 this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMob.class, this.moveSpeed, false));
			this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityMob.class, 8.0F));
			 this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMob.class, 16.0F, 0, true));
		// TODO Auto-generated constructor stub
	}
	protected boolean isAIEnabled()
    {
        return true;
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
