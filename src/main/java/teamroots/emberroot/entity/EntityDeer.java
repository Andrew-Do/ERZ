package teamroots.emberroot.entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import teamroots.emberroot.Const;

public class EntityDeer extends EntityAnimal {
  public static final DataParameter<Boolean> hasHorns = EntityDataManager.<Boolean> createKey(EntityDeer.class, DataSerializers.BOOLEAN);
  public static final DataParameter<Boolean> hasRednose = EntityDataManager.<Boolean> createKey(EntityDeer.class, DataSerializers.BOOLEAN);
  public EntityDeer(World world) {
    super(world);
    setSize(1.0f, 1.0f);
    this.experienceValue = 3;
  }
  @Override
  protected void entityInit() {
    super.entityInit();
    this.getDataManager().register(hasHorns, rand.nextBoolean());
    this.getDataManager().register(hasRednose, rand.nextInt(200) == 0 && getDataManager().get(hasHorns));
  }
  protected void initEntityAI() {
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(1, new EntityAIPanic(this, 1.5D));
    this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
    this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
    this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
    this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(7, new EntityAILookIdle(this));
  }
  @Override
  public void onUpdate() {
    super.onUpdate();
    this.rotationYaw = this.rotationYawHead;
  }
  @Override
  public void setScaleForAge(boolean child) {
    this.setScale(child ? 0.5f : 1.0f);
  }
  @Override
  public boolean isAIDisabled() {
    return false;
  }
  @Override
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
  }
  @Override
  public EntityAgeable createChild(EntityAgeable ageable) {
    return new EntityDeer(ageable.world);
  }
  @Override
  public ResourceLocation getLootTable() {
    return new ResourceLocation(Const.MODID, "entity/deer");
  }
  public float getEyeHeight() {
    return this.isChild() ? this.height : 1.3F;
  }
  @Override
  public void readEntityFromNBT(NBTTagCompound compound) {
    super.readEntityFromNBT(compound);
    getDataManager().set(hasHorns, compound.getBoolean("hasHorns"));
    getDataManager().setDirty(hasHorns);
    getDataManager().set(hasRednose, compound.getBoolean("hasRednose"));
    getDataManager().setDirty(hasRednose);
  }
  @Override
  public void writeEntityToNBT(NBTTagCompound compound) {
    super.writeEntityToNBT(compound);
    compound.setBoolean("hasHorns", getDataManager().get(hasHorns));
    compound.setBoolean("hasRednose", getDataManager().get(hasRednose));
  }
}