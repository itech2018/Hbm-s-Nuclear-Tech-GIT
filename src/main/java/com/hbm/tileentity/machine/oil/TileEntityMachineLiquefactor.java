package com.hbm.tileentity.machine.oil;

import java.util.ArrayList;
import java.util.List;

import com.hbm.interfaces.IFluidAcceptor;
import com.hbm.interfaces.IFluidSource;
import com.hbm.inventory.FluidStack;
import com.hbm.inventory.FluidTank;
import com.hbm.inventory.UpgradeManager;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.recipes.LiquefactionRecipes;
import com.hbm.items.machine.ItemMachineUpgrade.UpgradeType;
import com.hbm.lib.Library;
import com.hbm.tileentity.TileEntityMachineBase;

import api.hbm.energy.IEnergyUser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityMachineLiquefactor extends TileEntityMachineBase implements IEnergyUser, IFluidSource {

	public long power;
	public static final long maxPower = 100000;
	public static final int usageBase = 500;
	public int usage;
	public int progress;
	public static final int processTimeBase = 200;
	public int processTime;
	
	public FluidTank tank;
	
	public TileEntityMachineLiquefactor() {
		super(4);
		tank = new FluidTank(Fluids.NONE, 24000, 0);
	}

	@Override
	public String getName() {
		return "container.machineLiquefactor";
	}

	@Override
	public void updateEntity() {
		
		if(!worldObj.isRemote) {
			this.power = Library.chargeTEFromItems(slots, 1, power, maxPower);
			tank.updateTank(this);

			this.trySubscribe(worldObj, xCoord, yCoord + 4, zCoord, Library.POS_Y);
			this.trySubscribe(worldObj, xCoord, yCoord - 1, zCoord, Library.NEG_Y);
			this.trySubscribe(worldObj, xCoord + 2, yCoord + 1, zCoord, Library.POS_X);
			this.trySubscribe(worldObj, xCoord - 2, yCoord + 1, zCoord, Library.NEG_X);
			this.trySubscribe(worldObj, xCoord, yCoord + 1, zCoord + 2, Library.POS_Z);
			this.trySubscribe(worldObj, xCoord, yCoord + 1, zCoord - 2, Library.NEG_Z);

			UpgradeManager.eval(slots, 2, 3);
			int speed = Math.min(UpgradeManager.getLevel(UpgradeType.SPEED), 3);
			int power = Math.min(UpgradeManager.getLevel(UpgradeType.POWER), 3);

			this.processTime = processTimeBase - (processTimeBase / 4) * speed;
			this.usage = usageBase - (usageBase / 4) * speed;
			
			if(this.canProcess())
				this.process();
			else
				this.progress = 0;
			
			if(worldObj.getTotalWorldTime() % 10 == 0) {
				this.fillFluidInit(tank.getTankType());
			}
			
			NBTTagCompound data = new NBTTagCompound();
			data.setLong("power", this.power);
			data.setInteger("progress", this.progress);
			data.setInteger("usage", this.usage);
			data.setInteger("processTime", this.processTime);
			this.networkPack(data, 50);
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return i == 0 && LiquefactionRecipes.getOutput(itemStack) != null;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[] { 0 };
	}
	
	public boolean canProcess() {
		
		if(this.power < usage)
			return false;
		
		if(slots[0] == null)
			return false;
		
		FluidStack out = LiquefactionRecipes.getOutput(slots[0]);
		
		if(out == null)
			return false;
		
		if(out.type != tank.getTankType() && tank.getFill() > 0)
			return false;
		
		if(out.fill + tank.getFill() > tank.getMaxFill())
			return false;
		
		return true;
	}
	
	public void process() {
		
		this.power -= usage;
		
		progress++;
		
		if(progress >= processTime) {
			
			FluidStack out = LiquefactionRecipes.getOutput(slots[0]);
			tank.setTankType(out.type);
			tank.setFill(tank.getFill() + out.fill);
			this.decrStackSize(0, 1);
			
			progress = 0;
			
			this.markDirty();
		}
	}

	@Override
	public void networkUnpack(NBTTagCompound nbt) {
		this.power = nbt.getLong("power");
		this.progress = nbt.getInteger("progress");
		this.usage = nbt.getInteger("usage");
		this.processTime = nbt.getInteger("processTime");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		tank.readFromNBT(nbt, "tank");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		tank.writeToNBT(nbt, "tank");
	}

	@Override
	public void setPower(long power) {
		this.power = power;
	}

	@Override
	public long getPower() {
		return power;
	}

	@Override
	public long getMaxPower() {
		return maxPower;
	}

	@Override
	public void setFillForSync(int fill, int index) {
		tank.setFill(fill);
	}

	@Override
	public void setFluidFill(int fill, FluidType type) {
		if(type == tank.getTankType())
			tank.setFill(fill);
	}

	@Override
	public void setTypeForSync(FluidType type, int index) {
		tank.setTankType(type);
	}

	@Override
	public int getFluidFill(FluidType type) {
		return type == tank.getTankType() ? tank.getFill() : 0;
	}

	@Override
	public void fillFluidInit(FluidType type) {
		fillFluid(xCoord, yCoord - 1, zCoord, getTact(), type);
		fillFluid(xCoord, yCoord + 4, zCoord, getTact(), type);
		fillFluid(xCoord + 2, yCoord + 1, zCoord, getTact(), type);
		fillFluid(xCoord - 2, yCoord + 1, zCoord, getTact(), type);
		fillFluid(xCoord, yCoord + 1, zCoord + 2, getTact(), type);
		fillFluid(xCoord, yCoord + 1, zCoord - 2, getTact(), type);
	}

	@Override
	public void fillFluid(int x, int y, int z, boolean newTact, FluidType type) {
		Library.transmitFluid(x, y, z, newTact, this, worldObj, type);
	}

	@Override
	public boolean getTact() {
		return worldObj.getTotalWorldTime() % 20 < 10;
	}

	private List<IFluidAcceptor> consumers = new ArrayList();
	
	@Override
	public List<IFluidAcceptor> getFluidList(FluidType type) {
		return consumers;
	}

	@Override
	public void clearFluidList(FluidType type) {
		consumers.clear();
	}
	
	AxisAlignedBB bb = null;
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		
		if(bb == null) {
			bb = AxisAlignedBB.getBoundingBox(
					xCoord - 1,
					yCoord,
					zCoord - 1,
					xCoord + 2,
					yCoord + 4,
					zCoord + 2
					);
		}
		
		return bb;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return 65536.0D;
	}
}
