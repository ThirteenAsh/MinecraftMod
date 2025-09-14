package com.besson.thirteenash.entities.projectile;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class CustomDragonFireball extends DragonFireballEntity {

    private final Vec3d startPos;   // 发射起点

    public CustomDragonFireball(World world, LivingEntity owner) {
        super(world, owner, 0, 0, 0);
        this.startPos = owner.getPos();
    }

    @Override
    public void tick() {
        super.tick();

        // 计算与起点距离
        double distance = this.getPos().distanceTo(startPos);

        // 超过最大距离就移除火球
        // 最大飞行距离
        double maxDistance = 30.0;
        if (distance >= maxDistance) {
            this.remove(RemovalReason.DISCARDED);
        }
    }
}
