package net.minecraft.mckay1717.pvp;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityPig;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySticor extends EntityPvP {



	public EntitySticor(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.username = "Sticor";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		
		
		// TODO Auto-generated constructor stub
	}

	 public void onUpdate()
	 {
		


		 if(this.worldObj.isRaining() == true || this.isInWater())
		 {
			 this.setDead();
		 }
		
		 if(!this.isRiding())
		 {
			 EntityPig var3 = new EntityPig(this.worldObj);
			 
	            var3.setPosition(this.posX + 0.2D, this.posY + 4.0D, this.posZ + 0.2D);
	            this.worldObj.spawnEntityInWorld(var3);
	            var3.setSaddled(true);
	            var3.isInLove();
	            var3.height= 1.5f;
	            this.mountEntity(var3);
			 
			 
		 }
		
		 
		 super.onUpdate();
	 }
	 @Override
	 public boolean attackEntityFrom(DamageSource var1, int var2)
	 {
		var2 = 0;
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
