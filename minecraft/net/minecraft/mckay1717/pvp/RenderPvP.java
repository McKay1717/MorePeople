package net.minecraft.mckay1717.pvp;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.*;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPvP extends RenderBiped
{
    private ModelBiped modelBipedMain;
    private ModelBiped modelArmorChestplate;
    private ModelBiped modelArmor;
    public static String[] armorFilenamePrefix = new String[] {"cloth", "chain", "iron", "diamond", "gold"};

    public RenderPvP()
    {
        super(new ModelBiped(0.0F), 0.5F);
        this.modelBipedMain = (ModelBiped)this.mainModel;
        this.modelArmorChestplate = new ModelBiped(1.0F);
        this.modelArmor = new ModelBiped(0.5F);
    }


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

    protected void func_82440_a(EntityPvP par1EntityPvP, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        if (!par1EntityPvP.func_82150_aj())
        {
            super.renderModel(par1EntityPvP, par2, par3, par4, par5, par6, par7);
        }
    }

    /**
     * Used to render a player's name above their head
     */
    protected void renderName(EntityPvP par1EntityPvP, double par2, double par4, double par6)
    {
        if (Minecraft.isGuiEnabled() && par1EntityPvP != this.renderManager.livingPlayer && !par1EntityPvP.func_82150_aj())
        {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = par1EntityPvP.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = par1EntityPvP.isSneaking() ? 32.0F : 64.0F;

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

    /**
     * Method for adding special render rules
     */
    protected void renderSpecials(EntityPvP par1EntityPvP, float par2)
    {
        float var3 = 1.0F;
        GL11.glColor3f(var3, var3, var3);
        super.renderEquippedItems(par1EntityPvP, par2);
        

        float var7;

        if (par1EntityPvP.username.equals("deadmau5") && this.loadDownloadableImageTexture(par1EntityPvP.skinUrl, (String)null))
        {
            for (int var20 = 0; var20 < 2; ++var20)
            {
                float var25 = par1EntityPvP.prevRotationYaw + (par1EntityPvP.rotationYaw - par1EntityPvP.prevRotationYaw) * par2 - (par1EntityPvP.prevRenderYawOffset + (par1EntityPvP.renderYawOffset - par1EntityPvP.prevRenderYawOffset) * par2);
                var7 = par1EntityPvP.prevRotationPitch + (par1EntityPvP.rotationPitch - par1EntityPvP.prevRotationPitch) * par2;
                GL11.glPushMatrix();
                GL11.glRotatef(var25, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(var7, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(var20 * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-var7, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-var25, 0.0F, 1.0F, 0.0F);
                float var8 = 1.3333334F;
                GL11.glScalef(var8, var8, var8);
                this.modelBipedMain.renderEars(0.0625F);
                GL11.glPopMatrix();
            }
        }

        float var11;

        if (this.loadDownloadableImageTexture(par1EntityPvP.cloakUrl, (String)null) && !par1EntityPvP.func_82150_aj())
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
          
            var11 = par1EntityPvP.prevRenderYawOffset + (par1EntityPvP.renderYawOffset - par1EntityPvP.prevRenderYawOffset) * par2;
            double var12 = (double)MathHelper.sin(var11 * (float)Math.PI / 180.0F);
            double var14 = (double)(-MathHelper.cos(var11 * (float)Math.PI / 180.0F));
           

          

            
            this.modelBipedMain.renderCloak(0.0625F);
            GL11.glPopMatrix();
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
     */
    protected void passSpecialRender(EntityLiving par1EntityLiving, double par2, double par4, double par6)
    {
        this.renderName((EntityPvP)par1EntityLiving, par2, par4, par6);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.renderPlayerScale((EntityPvP)par1EntityLiving, par2);
    }

  

    /**
     * Queries whether should render the specified pass or not.
     */
   

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        this.renderSpecials((EntityPvP)par1EntityLiving, par2);
    }

   

    /**
     * Sets a simple glTranslate on a LivingEntity.
     */
   

    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(EntityLiving par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.func_82440_a((EntityPvP)par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

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
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderPlayer((EntityPvP)par1Entity, par2, par4, par6, par8, par9);
    }
}
