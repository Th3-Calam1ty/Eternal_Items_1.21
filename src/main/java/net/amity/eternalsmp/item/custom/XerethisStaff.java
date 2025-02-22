package net.amity.eternalsmp.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.ShapeType;

public class XerethisStaff extends Item {
    private static final int COOLDOWN = 5;

    public XerethisStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient()) { // Ensure this runs only on the server
            // Get player's position and aim direction
            Vec3d eyePos = player.getEyePos();
            Vec3d lookDirection = player.getRotationVec(1.0F).normalize();

            // Perform a raycast from the player's eye to the point they are looking at
            RaycastContext raycastContext = new RaycastContext(eyePos, eyePos.add(lookDirection.multiply(250)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player);
            BlockHitResult hitResult = world.raycast(raycastContext);

            if (hitResult.getType() == BlockHitResult.Type.BLOCK) {
                // If it hits a block, get the exact hit position
                BlockPos hitPos = hitResult.getBlockPos();
                spawnLightning(world, hitPos);
            }

            // Apply cooldown
            player.getItemCooldownManager().set(this, COOLDOWN);
        }

        return TypedActionResult.success(player.getStackInHand(hand), world.isClient());
    }

    private void spawnLightning(World world, BlockPos hitPos) {
        // Create a lightning entity at the target position
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.refreshPositionAfterTeleport(hitPos.getX(), hitPos.getY(), hitPos.getZ());

        // Spawn the lightning in the world
        world.spawnEntity(lightning);
    }
}
