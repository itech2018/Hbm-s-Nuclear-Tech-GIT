package com.hbm.explosion.vanillant;

import java.util.HashMap;
import java.util.List;

import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityProcessorStandard implements IEntityProcessor {

	@Override
	public HashMap<EntityPlayer, Vec3> process(ExplosionVNT explosion, World world, double x, double y, double z, float size) {

		HashMap<EntityPlayer, Vec3> affectedPlayers = new HashMap();

		size *= 2.0F;
		
		double minX = x - (double) size - 1.0D;
		double maxX = x + (double) size + 1.0D;
		double minY = y - (double) size - 1.0D;
		double maxY = y + (double) size + 1.0D;
		double minZ = z - (double) size - 1.0D;
		double maxZ = z + (double) size + 1.0D;
		
		List list = world.getEntitiesWithinAABBExcludingEntity(explosion.exploder, AxisAlignedBB.getBoundingBox(minX, minY, minZ, maxX, maxY, maxZ));
		
		ForgeEventFactory.onExplosionDetonate(world, explosion.compat, list, size);
		Vec3 vec3 = Vec3.createVectorHelper(x, y, z);

		for(int index = 0; index < list.size(); ++index) {
			
			Entity entity = (Entity) list.get(index);
			double distanceScaled = entity.getDistance(x, y, z) / size;

			if(distanceScaled <= 1.0D) {
				
				double deltaX = entity.posX - x;
				double deltaY = entity.posY + entity.getEyeHeight() - y;
				double deltaZ = entity.posZ - z;
				double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

				if(distance != 0.0D) {
					
					deltaX /= distance;
					deltaY /= distance;
					deltaZ /= distance;
					
					double density = world.getBlockDensity(vec3, entity.boundingBox);
					double knockback = (1.0D - distanceScaled) * density;
					
					entity.attackEntityFrom(DamageSource.setExplosionSource(explosion.compat), (float) ((int) ((knockback * knockback + knockback) / 2.0D * 8.0D * size + 1.0D)));
					double enchKnockback = EnchantmentProtection.func_92092_a(entity, knockback);
					
					entity.motionX += deltaX * enchKnockback;
					entity.motionY += deltaY * enchKnockback;
					entity.motionZ += deltaZ * enchKnockback;

					if(entity instanceof EntityPlayer) {
						affectedPlayers.put((EntityPlayer) entity, Vec3.createVectorHelper(deltaX * knockback, deltaY * knockback, deltaZ * knockback));
					}
				}
			}
		}

		return affectedPlayers;
	}
}
