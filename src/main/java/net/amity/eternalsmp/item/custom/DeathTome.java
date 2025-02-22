package net.amity.eternalsmp.item.custom;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class DeathTome extends Item implements ProjectileItem {
    private static final int COOLDOWN = 40;

    public DeathTome(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            Vec3d direction = user.getRotationVec(1.0F);
            // Create the Wither Skull entity with correct parameters
            WitherSkullEntity witherSkullEntity = new WitherSkullEntity(EntityType.WITHER_SKULL, world);
            witherSkullEntity.setOwner(user);
            witherSkullEntity.setPosition(user.getX(), user.getEyeY(), user.getZ());
            witherSkullEntity.setVelocity(direction.multiply(1.5));
            world.spawnEntity(witherSkullEntity);
        }

        // Play the appropriate sound when the item is used
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.PLAYERS, 0.5F, 1.0F);
        user.getItemCooldownManager().set(this, COOLDOWN);
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        Vec3d velocity = new Vec3d(direction.getOffsetX(), direction.getOffsetY(), direction.getOffsetZ());
        WitherSkullEntity witherSkullEntity = new WitherSkullEntity(EntityType.WITHER_SKULL, world);
        witherSkullEntity.setPosition(pos.getX(), pos.getY(), pos.getZ());
        witherSkullEntity.setVelocity(velocity);
        return witherSkullEntity;
    }

    @Override
    public void initializeProjectile(ProjectileEntity entity, double x, double y, double z, float power, float uncertainty) {
    }

    @Override
    public ProjectileItem.Settings getProjectileSettings() {
        return ProjectileItem.Settings.builder()
                .positionFunction((pointer, facing) -> DispenserBlock.getOutputLocation(pointer, 1.0, Vec3d.ZERO))
                .uncertainty(6.6666665F)
                .power(1.0F)
                .overrideDispenseEvent(1009) // Plays Wither shoot sound instead of Blaze
                .build();
    }
}
