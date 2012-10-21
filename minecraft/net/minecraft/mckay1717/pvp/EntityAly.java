
    package net.minecraft.mckay1717.pvp;

import net.minecraft.src.*;

    public class EntityAly extends EntityTameable{
    	public  String username = "";
            public EntityAly(World par1World) {
                    super(par1World);
                    this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
            moveSpeed = 0.3F;
            this.getNavigator().setAvoidsWater(true);
            this.tasks.addTask(1, new EntityAISwimming(this));
            this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
            this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
            this.tasks.addTask(4, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
            this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
            this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
            this.tasks.addTask(7, new EntityAILookIdle(this));
            this.targetTasks.addTask(8, new EntityAIHurtByTarget(this, true));
            this.setOwner(ModLoader.getMinecraftInstance().session.username);
            this.setTamed(true);
            }
           
            public int getMaxHealth() {
                    return 20;
            }
           
            public boolean isAIEnabled(){
            return true;
            }

            public void onLivingUpdate(){
                    super.onLivingUpdate();
            }


    
            public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
            {
                Entity var3 = par1DamageSource.getEntity();
                this.aiSit.setSitting(false);

                if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
                {
                    par2 = (par2 + 1) / 2;
                }

                return super.attackEntityFrom(par1DamageSource, par2);
            }

            public boolean attackEntityAsMob(Entity par1Entity)
            {
                int var2 = this.isTamed() ? 4 : 2;
                return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
            }
  
     


            
           
            public EntityAnimal spawnBabyAnimal(EntityAnimal var1) {
                    return null;
            }
    }
 