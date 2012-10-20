package net.minecraft.mckay1717.pvp;

import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public class EntityFurtys extends  EntityPvP {


	public EntityFurtys(World par1World) {
		super(par1World);

		this.username = "Furtys";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTheFumelgo.class, this.moveSpeed, false));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityTheFumelgo.class, 8.0F));
		 this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTheFumelgo.class, 16.0F, 0, true));
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 20;
	}
	protected boolean isAIEnabled()
    {
        return true;
    }

}
