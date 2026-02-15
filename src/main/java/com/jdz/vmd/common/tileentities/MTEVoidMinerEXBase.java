package com.jdz.vmd.common.tileentities;

import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.enums.HatchElement.Energy;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableList;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;

import bwcrossmod.galacticgreg.MTEVoidMinerBase;
import gregtech.api.enums.GTValues;
import gregtech.api.interfaces.IHatchElement;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.tileentities.machines.multi.MTEDrillerBase;

public abstract class MTEVoidMinerEXBase extends MTEVoidMinerBase {

    protected static final String STRUCTURE_PIECE_MAIN = "main";

    protected static final int OFF_X = 3;
    protected static final int OFF_Y = 7;
    protected static final int OFF_Z = 1;

    public MTEVoidMinerEXBase(int aID, String aName, String aNameRegional, int multiplier) {
        super(aID, aName, aNameRegional, multiplier);
    }

    public MTEVoidMinerEXBase(String aName, int tier) {
        super(aName, tier);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType("Miner")
            .addInfo("Consumes " + GTValues.V[this.getMinTier()] + " EU/t")
            .addInfo("Noble gas boosting: DISABLED (no fluid hatches)")
            .addInfo("Outputs scale by tier: 2/4/8 (plus batch mode if enabled)")
            .addInfo("Put an ore in the Input Bus to use White/Blacklist filtering")
            .addInfo("Use a screwdriver to toggle White/Blacklist")
            .toolTipFinisher("CheaperVoidMiners");
        return tt;
    }

    @Override
    protected void setElectricityStats() {
        this.mEUt = -Math.abs(Math.toIntExact(GTValues.V[this.getMinTier()]));
        this.mOutputItems = GTValues.emptyItemStackArray;
        this.mProgresstime = 0;
        this.mMaxProgresstime = 10;
        this.mEfficiency = this.getCurrentEfficiency(null);
        this.mEfficiencyIncrease = 10000;
    }

    @Override
    protected List<IHatchElement<? super MTEDrillerBase>> getAllowedHatches() {
        return ImmutableList.of(InputBus, OutputBus, Maintenance, Energy);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivalBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            OFF_X,
            OFF_Y,
            OFF_Z,
            elementBudget,
            env,
            false,
            true);
    }
}
