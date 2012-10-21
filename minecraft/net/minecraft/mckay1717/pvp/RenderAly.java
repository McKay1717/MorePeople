package net.minecraft.mckay1717.pvp;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.client.Minecraft;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.*;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAly extends RenderBiped
{
    private ModelBiped modelBipedMain;
    public static String[] armorFilenamePrefix = new String[] {"cloth", "chain", "iron", "diamond", "gold"};

    public RenderAly()
    {
    	
        super(new ModelBiped(0.0F), 0.5F);
        this.modelBipedMain = (ModelBiped)this.mainModel;
        

    }

    /**
     * Used to render a player's name above their head
     */
    protected void renderName(EntityAly par1EntityAly, double par2, double par4, double par6)
    {
        if (Minecraft.isGuiEnabled() && par1EntityAly != this.renderManager.livingPlayer)
        {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = par1EntityAly.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = par1EntityAly.isSneaking() ? 32.0F : 64.0F;

            if (var10 < (double)(var12 * var12))
            {
                String var13 = par1EntityAly.username;

                if (par1EntityAly.isSneaking())
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
                else if (par1EntityAly.isPlayerSleeping())
                {
                    this.renderLivingLabel(par1EntityAly, var13, par2, par4 - 1.5D, par6, 64);
                }
                else
                {
                    this.renderLivingLabel(par1EntityAly, var13, par2, par4, par6, 64);
                }
            }
        }
    }

    protected void renderPlayerScale(EntityAly par1EntityAly, float par2)
    {
        float var3 = 0.9375F;
        GL11.glScalef(var3, var3, var3);
    }

    public void drawFirstPersonHand()
    {
        this.modelBipedMain.onGround = 0.0F;
        this.modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        this.modelBipedMain.bipedRightArm.render(0.0625F);
    }

    /**
     * Passes the specialRender and renders it
     */
    protected void passSpecialRender(EntityLiving par1EntityLiving, double par2, double par4, double par6)
    {
        this.renderName((EntityAly)par1EntityLiving, par2, par4, par6);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.renderPlayerScale((EntityAly)par1EntityLiving, par2);
    }
}
