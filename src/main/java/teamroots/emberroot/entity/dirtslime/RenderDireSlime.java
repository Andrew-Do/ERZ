package teamroots.emberroot.entity.dirtslime;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.emberroot.Const;

@SideOnly(Side.CLIENT)
public class RenderDireSlime extends RenderLiving<EntityDireSlime> {
  private static final ResourceLocation magmaCubeTextures = new ResourceLocation(Const.MODID, "textures/entity/slime_dirt.png");
  public RenderDireSlime(RenderManager rm) {
    super(rm, new ModelDireSlime(), 0.25F);
  }
  @Override
  protected void preRenderCallback(EntityDireSlime direSlime, float partialTick) {
    int i = direSlime.getSlimeSize();
    float f1 = (direSlime.prevSquishFactor + (direSlime.squishFactor - direSlime.prevSquishFactor) * partialTick) / (i * 0.5F + 1.0F);
    float f2 = 1.0F / (f1 + 1.0F);
    float f3 = i;
    GL11.glScalef(f2 * f3, 1.0F / f2 * f3, f2 * f3);
  }
  @Override
  protected ResourceLocation getEntityTexture(EntityDireSlime p_110775_1_) {
    return magmaCubeTextures;
  }
  @Override
  protected void applyRotations(EntityDireSlime entity, float f, float rotationYaw, float partialTicks) {
    //    this.rotateCorpse(entityLiving, p_77043_2_, p_77043_3_, partialTicks);
    if (entity.deathTime > 0) {
      float f3 = (entity.deathTime + partialTicks - 1.0F) / 20.0F * 1.6F;
      f3 = Math.max(MathHelper.sqrt(f3), 1.0F);
      GL11.glRotatef(f3 * this.getDeathMaxRotation(entity), 0.0F, 0.0F, 1.0F);
    }
  }
  public static class Factory implements IRenderFactory<EntityDireSlime> {
    @Override
    public Render<? super EntityDireSlime> createRenderFor(RenderManager manager) {
      return new RenderDireSlime(manager);
    }
  }
}
