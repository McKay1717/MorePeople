package mckay1717.pvp.client;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import mckay1717.pvp.EntityPvP;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPvP extends RenderLiving
{
    private ModelBiped modelBipedMain;
    private ModelBiped modelArmorChestplate;
    private ModelBiped modelArmor;
    public static String[] armorFilenamePrefix = new String[] {"cloth", "chain", "iron", "diamond", "gold"};
    public static float NAME_TAG_RANGE = 64.0f;
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;

    public RenderPvP()
    {
        super(new ModelBiped(0.0F), 0.5F);
        this.modelBipedMain = (ModelBiped)this.mainModel;
        this.modelArmorChestplate = new ModelBiped(1.0F);
        this.modelArmor = new ModelBiped(0.5F);
    }

    /**
     * Set the specified armor model as the player model. Args: player, armorSlot, partialTick
     */


   

    public void renderPlayer(EntityPvP par1EntityPvP, double par2, double par4, double par6, float par8, float par9)
    {
        float var10 = 1.0F;
        GL11.glColor3f(var10, var10, var10);
        
      



        this.modelArmorChestplate.isSneak = this.modelArmor.isSneak = this.modelBipedMain.isSneak = par1EntityPvP.isSneaking();
        double var14 = par4 - (double)par1EntityPvP.yOffset;

        

        super.doRenderLiving(par1EntityPvP, par2, var14, par6, par8, par9);
        this.modelArmorChestplate.aimedBow = this.modelArmor.aimedBow = this.modelBipedMain.aimedBow = false;
        this.modelArmorChestplate.isSneak = this.modelArmor.isSneak = this.modelBipedMain.isSneak = false;
        this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight = 0;
    }

    /**
     * Used to render a player's name above their head
     */
    protected void renderName(EntityPvP par1EntityPvP, double par2, double par4, double par6)
    {
        if (Minecraft.isGuiEnabled() && par1EntityPvP != this.renderManager.livingPlayer && !par1EntityPvP.getHasActivePotion())
        {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = par1EntityPvP.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = par1EntityPvP.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

            if (var10 < (double)(var12 * var12))
            {
                String var13 = par1EntityPvP.username;

                if (par1EntityPvP.isSneaking())
                {
                    FontRenderer var14 = this.getFontRendererFromRenderManager();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 2.3F, (float)par6);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-var9, -var9, var9);
                    GL11.glDisable(GL11.GL_LIGHTING);
                    GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                    Tessellator var15 = Tessellator.instance;
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    var15.startDrawingQuads();
                    int var16 = var14.getStringWidth(var13) / 2;
                    var15.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                    var15.addVertex((double)(-var16 - 1), -1.0D, 0.0D);
                    var15.addVertex((double)(-var16 - 1), 8.0D, 0.0D);
                    var15.addVertex((double)(var16 + 1), 8.0D, 0.0D);
                    var15.addVertex((double)(var16 + 1), -1.0D, 0.0D);
                    var15.draw();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                    GL11.glDepthMask(true);
                    var14.drawString(var13, -var14.getStringWidth(var13) / 2, 0, 553648127);
                    GL11.glEnable(GL11.GL_LIGHTING);
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                }
                else if (par1EntityPvP.isPlayerSleeping())
                {
                    this.renderLivingLabel(par1EntityPvP, var13, par2, par4 - 1.5D, par6, 64);
                }
                else
                {
                    this.renderLivingLabel(par1EntityPvP, var13, par2, par4, par6, 64);
                }
            }
        }
    }

    protected void renderPlayerScale(EntityPvP par1EntityPvP, float par2)
    {
        float var3 = 0.9375F;
        GL11.glScalef(var3, var3, var3);
    }

    public void func_82441_a(EntityPvP par1EntityPvP)
    {
        float var2 = 1.0F;
        GL11.glColor3f(var2, var2, var2);
        this.modelBipedMain.onGround = 0.0F;
        this.modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, par1EntityPvP);
        this.modelBipedMain.bipedRightArm.render(0.0625F);
    }

    /**
     * Passes the specialRender and renders it
     * 
     * 
     */
    @Override 
    protected void passSpecialRender(EntityLiving par1EntityLiving, double par2, double par4, double par6)
    {
        this.renderName((EntityPvP)par1EntityLiving, par2, par4, par6);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    @Override 
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.renderPlayerScale((EntityPvP)par1EntityLiving, par2);
    }



    /**
     * Queries whether should render the specified pass or not.
     */




 

    /**
     * Sets a simple glTranslate on a LivingEntity.
     */

    @Override 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderPlayer((EntityPvP)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override 
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderPlayer((EntityPvP)par1Entity, par2, par4, par6, par8, par9);
    }
}
