package com.hbm.items.weapon;

import java.util.List;

import com.hbm.items.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemClip extends Item {

    public ItemClip()
    {
        this.setMaxDamage(1);
    }
    
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		stack.stackSize--;
		if(stack.stackSize <= 0)
			stack.damageItem(5, player);
		
		if(this == ModItems.clip_revolver_iron)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_iron_ammo, 20)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_iron_ammo, 20), false);
        	}
		}
		
		if(this == ModItems.clip_revolver)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_ammo, 12)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_ammo, 12), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_gold)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_gold_ammo, 4)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_gold_ammo, 4), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_schrabidium)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_schrabidium_ammo, 2)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_schrabidium_ammo, 2), false);
        	}
		}
		
		if(this == ModItems.clip_rpg)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_rocket, 3)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_rpg_ammo, 3), false);
        	}
		}
		
		if(this == ModItems.clip_osipr)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_osipr_ammo, 30)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_osipr_ammo, 30), false);
        	}
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_osipr_ammo2, 1)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_osipr_ammo2, 1), false);
        	}
		}
		
		if(this == ModItems.clip_xvl1456)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_xvl1456_ammo, 60)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_xvl1456_ammo, 60), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_lead)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_lead_ammo, 12)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_lead_ammo, 12), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_cursed)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_cursed_ammo, 17)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_revolver_cursed_ammo, 17), false);
        	}
		}
		
		if(this == ModItems.clip_fatman)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_nuke, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_fatman_ammo, 6), false);
        	}
		}
		
		if(this == ModItems.clip_mp)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_566_gold, 30)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp_ammo, 30), false);
        	}
		}
		
		if(this == ModItems.clip_mp40)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_9mm, 32)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_uzi)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_22lr, 32)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_uzi_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_uboinik)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_12gauge, 24)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_uboinik_ammo, 24), false);
        	}
		}
		
		if(this == ModItems.clip_lever_action)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge, 24)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_lever_action_ammo, 24), false);
        	}
		}
		
		if(this == ModItems.clip_bolt_action)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge_slug, 24)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_bolt_action_ammo, 24), false);
        	}
		}
		
		if(this == ModItems.clip_mirv)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_mirv, 3)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_bf)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_bf_ammo, 2)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_immolator)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_immolator_ammo, 60)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_cryolator)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_cryolator_ammo, 60)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_emp)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_emp_ammo, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_nightmare)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_nightmare_ammo, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_nightmare2)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_nightmare2_ammo, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_pip)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44_pip, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_revolver_nopip)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44, 12)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_stinger)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_stinger_rocket, 3)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_jack)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_jack_ammo, 6)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_spark)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_spark_ammo, 4)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_hp)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_hp_ammo, 8)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_euthanasia)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_euthanasia_ammo, 16)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.clip_defabricator)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_defabricator_ammo, 12)))
        	{
        		//player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.gun_mp40_ammo, 32), false);
        	}
		}
		
		if(this == ModItems.ammo_container)
		{
			if(player.inventory.hasItem(ModItems.gun_revolver_iron))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_iron_ammo, 24));
			if(player.inventory.hasItem(ModItems.gun_revolver))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_ammo, 12));
			if(player.inventory.hasItem(ModItems.gun_revolver_gold))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_gold_ammo, 4));
			if(player.inventory.hasItem(ModItems.gun_revolver_lead))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_lead_ammo, 6));
			if(player.inventory.hasItem(ModItems.gun_revolver_schrabidium))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_schrabidium_ammo, 2));
			if(player.inventory.hasItem(ModItems.gun_revolver_cursed))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_cursed_ammo, 8));
			if(player.inventory.hasItem(ModItems.gun_revolver_nightmare))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_nightmare_ammo, 6));
			if(player.inventory.hasItem(ModItems.gun_revolver_nightmare2))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_nightmare2_ammo, 3));
			if(player.inventory.hasItem(ModItems.gun_revolver_pip))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44_pip, 12));
			if(player.inventory.hasItem(ModItems.gun_revolver_nopip))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44, 12));
			if(player.inventory.hasItem(ModItems.gun_revolver_blackjack))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44_bj, 12));
			if(player.inventory.hasItem(ModItems.gun_revolver_red))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_44, 12));
			if(player.inventory.hasItem(ModItems.gun_calamity))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_50bmg, 16));
			if(player.inventory.hasItem(ModItems.gun_calamity_dual))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_50bmg, 32));
			if(player.inventory.hasItem(ModItems.gun_minigun)) {
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
			}
			if(player.inventory.hasItem(ModItems.gun_avenger)) {
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
			}
			if(player.inventory.hasItem(ModItems.gun_lacunae)) {
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_5mm, 64));
			}
			if(player.inventory.hasItem(ModItems.gun_rpg))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_rocket, 3));
			if(player.inventory.hasItem(ModItems.gun_stinger))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_stinger_rocket, 2));
			if(player.inventory.hasItem(ModItems.gun_skystinger))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_stinger_rocket_he, 2));
			if(player.inventory.hasItem(ModItems.gun_fatman))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_nuke, 2));
			if(player.inventory.hasItem(ModItems.gun_proto))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_nuke, 8));
			if(player.inventory.hasItem(ModItems.gun_mirv))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_mirv_ammo, 1));
			if(player.inventory.hasItem(ModItems.gun_bf))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_bf_ammo, 1));
			if(player.inventory.hasItem(ModItems.gun_mp40))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_9mm, 32));
			if(player.inventory.hasItem(ModItems.gun_uzi))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_22lr, 32));
			if(player.inventory.hasItem(ModItems.gun_uzi_silencer))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_22lr, 32));
			if(player.inventory.hasItem(ModItems.gun_uzi_saturnite))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_22lr, 32));
			if(player.inventory.hasItem(ModItems.gun_uzi_saturnite_silencer))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_22lr, 32));
			if(player.inventory.hasItem(ModItems.gun_uboinik))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_12gauge, 12));
			if(player.inventory.hasItem(ModItems.gun_lever_action))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge, 12));
			if(player.inventory.hasItem(ModItems.gun_lever_action_dark))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge, 12));
			if(player.inventory.hasItem(ModItems.gun_lever_action_sonata))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge, 1));
			if(player.inventory.hasItem(ModItems.gun_bolt_action))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge_flechette, 12));
			if(player.inventory.hasItem(ModItems.gun_bolt_action_green))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_20gauge_flechette, 12));
			if(player.inventory.hasItem(ModItems.gun_xvl1456))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_xvl1456_ammo, 40));
			if(player.inventory.hasItem(ModItems.gun_osipr)) {
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_osipr_ammo, 30));
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_osipr_ammo2, 1));
			}
			if(player.inventory.hasItem(ModItems.gun_immolator))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_immolator_ammo, 40));
			if(player.inventory.hasItem(ModItems.gun_cryolator))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_cryolator_ammo, 40));
			if(player.inventory.hasItem(ModItems.gun_mp))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.ammo_566_gold, 34));
			if(player.inventory.hasItem(ModItems.gun_zomg))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.nugget_euphemium, 1));
			if(player.inventory.hasItem(ModItems.gun_emp))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_emp_ammo, 8));
			if(player.inventory.hasItem(ModItems.gun_revolver_inverted))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_ammo, 1));
			if(player.inventory.hasItem(ModItems.gun_revolver_inverted))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_revolver_ammo, 1));
			if(player.inventory.hasItem(ModItems.gun_jack))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_jack_ammo, 3));
			if(player.inventory.hasItem(ModItems.gun_spark))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_spark_ammo, 2));
			if(player.inventory.hasItem(ModItems.gun_hp))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_hp_ammo, 6));
			if(player.inventory.hasItem(ModItems.gun_euthanasia))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_euthanasia_ammo, 8));
			if(player.inventory.hasItem(ModItems.gun_defabricator))
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.gun_defabricator_ammo, 6));
		}
		
		return stack;
		
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
	{
		if(this == ModItems.ammo_container)
		{
			list.add("Gives ammo for all held weapons.");
		}
	}
}
