package com.lunaticcat.yourbuddycal.entity.cals;

import com.lunaticcat.yourbuddycal.entity.EntityListFilter;
import com.lunaticcat.yourbuddycal.entity.YourBuddyCalEntity;
import com.lunaticcat.yourbuddycal.player.IdentifierHandler;
import com.lunaticcat.yourbuddycal.player.PlayerIdentifier;
import com.lunaticcat.yourbuddycal.util.YBCTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public abstract class CalsEntity extends YourBuddyCalEntity implements IMob {
	protected EntityListFilter attackEntitySelector;    //TODO this filter isn't being saved. F1X PLZ
	protected boolean fromSpawner;
	public boolean dropCandy;
	private int targetChangeTime;
	private static final float maxSharedProgress = 2;    //The multiplier for the maximum amount progress that can be gathered from each enemy with the group fight bonus

	protected Map<PlayerIdentifier, Double> damageMap = new HashMap<>();    //Map that stores how much damage each player did to this to this underling. Null is used for environmental or other non-player damage

	public CalsEntity(EntityType<? extends CalsEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void registerGoals() {
		attackEntitySelector = new EntityListFilter(new ArrayList<>());
		attackEntitySelector.entityList.add(EntityType.PLAYER);

		goalSelector.addGoal(1, new SwimGoal(this));
		goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, getWanderSpeed()));
		goalSelector.addGoal(5, new RandomWalkingGoal(this, getWanderSpeed()));
		goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);

		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(this.getKnockbackResistance());
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.getWanderSpeed());
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	@Override
	protected void registerData() {
		super.registerData();
	}

	//used when getting how much grist should be dropped on death

	protected abstract float getKnockbackResistance();

	protected abstract double getWanderSpeed();

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
	}

	@Override
	protected ResourceLocation createTexture() {
		ResourceLocation calsName = Objects.requireNonNull(getType().getRegistryName(), () -> "Getting texture for entity without a registry name! " + this);

		return new ResourceLocation(calsName.getNamespace(), String.format("textures/entity/%s.png", calsName.getPath()));
	}

	private double randX() {
		return this.posX + this.rand.nextDouble() * this.getWidth() - this.getWidth() / 2;
	}

	private double randZ() {
		return this.posZ + this.rand.nextDouble() * this.getWidth() - this.getWidth() / 2;
	}

	@Override
	public void setAttackTarget(LivingEntity entity) {
		super.setAttackTarget(entity);
		if (entity != null) {
			this.addEnemy(entity.getType());
		}
	}

	public void addEnemy(EntityType<?> enemyType) {
		if (!attackEntitySelector.entityList.contains(enemyType) && !YBCTags.EntityTypes.CALS.contains(enemyType)) {
			attackEntitySelector.entityList.add(enemyType);
		}
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Spawned", fromSpawner);
		if (detachHome()) {
			CompoundNBT nbt = new CompoundNBT();
			BlockPos home = getHomePosition();
			nbt.putInt("HomeX", home.getX());
			nbt.putInt("HomeY", home.getY());
			nbt.putInt("HomeZ", home.getZ());
			nbt.putInt("MaxHomeDistance", (int) getMaximumHomeDistance());
			compound.put("HomePos", nbt);
		}
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);

		fromSpawner = compound.getBoolean("Spawned");

		if (compound.contains("HomePos", Constants.NBT.TAG_COMPOUND)) {
			CompoundNBT nbt = compound.getCompound("HomePos");
			BlockPos pos = new BlockPos(nbt.getInt("HomeX"), nbt.getInt("HomeY"), nbt.getInt("homeZ"));
			setHomePosAndDistance(pos, nbt.getInt("MaxHomeDistance"));
		}
	}

	@Nullable

	public void onEntityDamaged(DamageSource source, float amount) {
		PlayerIdentifier player = null;
		if (source.getTrueSource() instanceof ServerPlayerEntity)
			player = IdentifierHandler.encode((ServerPlayerEntity) source.getTrueSource());
		if (damageMap.containsKey(player))
			damageMap.put(player, damageMap.get(player) + amount);
		else damageMap.put(player, (double) amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		if (this.getHealth() > 0.0F)
			dropCandy = false;
	}

	protected void computePlayerProgress(int progress) {
		double totalDamage = 0;
		for (Double i : damageMap.values())
			totalDamage += i;
		if (totalDamage < this.getMaxHealth())
			totalDamage = this.getMaxHealth();

		int maxProgress = (int) (progress * maxSharedProgress);
		damageMap.remove(null);
		PlayerIdentifier[] playerList = damageMap.keySet().toArray(new PlayerIdentifier[0]);
		double[] modifiers = new double[playerList.length];
		double totalModifier = 0;

		for (int i = 0; i < playerList.length; i++) {
			double f = damageMap.get(playerList[i]) / totalDamage;
			modifiers[i] = 2 * f - f * f;
			totalModifier += modifiers[i];
		}
	}
//enderman code
boolean shouldAttackPlayer(PlayerEntity player) {
		Vec3d vec3d = player.getLook(1.0F).normalize();
		Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getBoundingBox().minY + (double)this.getEyeHeight() - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
		double d0 = vec3d1.length();
		vec3d1 = vec3d1.normalize();
		double d1 = vec3d.dotProduct(vec3d1);
		return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
	}
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}
	protected void updateAITasks() {
		if (this.isInWaterRainOrBubbleColumn()) {
			this.attackEntityFrom(DamageSource.DROWN, 1.0F);
		}

		if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
			float f = this.getBrightness();
			if (f > 0.5F && this.world.isSkyLightMax(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setAttackTarget((LivingEntity)null);
				this.teleportRandomly();
			}
		}

		super.updateAITasks();
	}

	boolean teleportToEntity(Entity p_70816_1_) {
		Vec3d vec3d = new Vec3d(this.posX - p_70816_1_.posX, this.getBoundingBox().minY + (double)(this.getHeight() / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
		vec3d = vec3d.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3d.y * 16.0D;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
		return this.teleportTo(d1, d2, d3);
	}

	private boolean teleportTo(double x, double y, double z) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

		while(blockpos$mutableblockpos.getY() > 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
			blockpos$mutableblockpos.move(Direction.DOWN);
		}

		if (!this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
			return false;
		} else {
			boolean flag = this.attemptTeleport(x, y, z, true);
			if (flag) {
				this.world.playSound((PlayerEntity)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
				this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
			}

			return flag;
		}
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (!(source instanceof IndirectEntityDamageSource) && source != DamageSource.FIREWORKS) {
			boolean flag = super.attackEntityFrom(source, amount);
			if (source.isUnblockable() && this.rand.nextInt(10) != 0) {
				this.teleportRandomly();
			}

			return flag;
		} else {
			for(int i = 0; i < 64; ++i) {
				if (this.teleportRandomly()) {
					return true;
				}
			}

			return false;
		}
	}
}
