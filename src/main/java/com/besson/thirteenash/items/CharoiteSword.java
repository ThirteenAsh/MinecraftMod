package com.besson.thirteenash.items;

import com.besson.thirteenash.entities.projectile.CustomDragonFireball;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CharoiteSword extends SwordItem {

    public CharoiteSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            CustomDragonFireball fireball = new CustomDragonFireball(world, user);

            // 设置火球位置在玩家眼睛
            fireball.updatePosition(user.getX(), user.getEyeY(), user.getZ());

            // 设置火球速度
            Vec3d direction = user.getRotationVec(1.0F);
            fireball.setVelocity(direction.x, direction.y, direction.z, 2.5F, 0.0F);

            // 生成实体
            world.spawnEntity(fireball);

            // 播放声音
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, user.getSoundCategory(), 1.0F, 1.0F);
            // 消耗耐久
            stack.damage(20, user, (p) -> p.sendToolBreakStatus(hand));
        }

        // 设置冷却（可选）
        user.getItemCooldownManager().set(this, 20); // 1秒冷却

        return TypedActionResult.success(stack, world.isClient());
    }
}
