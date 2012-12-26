package mckay1717.pvp;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.src.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
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
