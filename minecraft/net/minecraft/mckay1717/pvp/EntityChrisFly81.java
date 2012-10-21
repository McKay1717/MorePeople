package net.minecraft.mckay1717.pvp;

import net.minecraft.src.*;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPig;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

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
