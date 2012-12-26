package mckay1717.pvp;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTurBo67 extends EntityPvP {

	private static final ItemStack defaultHeldItem = new ItemStack(Item.cookie, 1);
	public EntityTurBo67(World par1World) {
		super(par1World);
		this.username = "TurBo67";
		this.skinUrl = "http://skins.minecraft.net/MinecraftSkins/" + username + ".png";
		// TODO Auto-generated constructor stub
	}
	  public ItemStack getHeldItem()
	    {
	        return defaultHeldItem;
	    }
}
