package net.amity.eternalsmp.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CustomArrowEntity extends ArrowEntity {
    public CustomArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick(); // Continue normal projectile movement

        // Log the arrow's current position
        System.out.println("Arrow position: " + this.getX() + ", " + this.getY() + ", " + this.getZ());

        // Check if the arrow is colliding with any block (simpler than checking for lava)
        BlockPos currentPos = new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ());
        if (this.getWorld().getBlockState(currentPos).isSolid()) {
            System.out.println("Arrow hit a solid block! Spawning lightning...");
            spawnLightning(currentPos);  // Spawn lightning at the collision point
            this.remove(Entity.RemovalReason.DISCARDED); // Remove the arrow after impact
        }

        // You can also add collision checks with entities if needed (optional)
        // if (this.world.getEntities(this, this.getBoundingBox().expand(0.1, 0.1, 0.1)).size() > 0) {
        //     System.out.println("Arrow collided with an entity!");
        // }
    }

    private void spawnLightning(BlockPos currentPos) {
    }

}
