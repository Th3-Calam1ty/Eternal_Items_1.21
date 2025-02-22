package net.amity.eternalsmp.entity.custom;

import net.amity.eternalsmp.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.joml.Vector2f;

public class StaffCrystal extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;

    public StaffCrystal(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }


    public StaffCrystal(World world, PlayerEntity player) {
        super(EntityType.ARROW, player, world, new ItemStack(ModItems.XERETHIS_STAFF), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.XERETHIS_STAFF);
    }


}
