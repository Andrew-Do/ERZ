package teamroots.emberroot.entity.creeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teamroots.emberroot.Const;

public class RenderConcussionCreeper extends RenderCreeper {
//  public static final Factory FACTORY = new Factory();
  private static final ResourceLocation creeperTextures = new ResourceLocation(Const.MODID, "textures/entity/creeper_zoo.png");
  public RenderConcussionCreeper(RenderManager p_i46186_1_) {
    super(p_i46186_1_);
  }
  /**
   * Returns the location of an entity's texture. Doesn't seem to be called
   * unless you call Render.bindEntityTexture.
   */
  @Override
  protected ResourceLocation getEntityTexture(EntityCreeper c) {
    return creeperTextures;
  }
  public static class Factory implements IRenderFactory<EntityCreeper> {
    @Override
    public Render<? super EntityCreeper> createRenderFor(RenderManager manager) {
      return new RenderConcussionCreeper(manager);
    }
  }
}
