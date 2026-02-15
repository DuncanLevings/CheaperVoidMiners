package com.jdz.vmd.common.tileentities;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofFrame;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GTUtility;

public class MTEVoidMiners {

    // spotless:off
    private static final String[][] SHAPE = transpose(
            new String[][] {
                { "       ", "       ", "       ", "   B   ", "       ", "       ", "       " },
                { "       ", "       ", "       ", "   B   ", "       ", "       ", "       " },
                { "       ", "       ", "       ", "   B   ", "       ", "       ", "       " },
                { "       ", "       ", "   B   ", "  BCB  ", "   B   ", "       ", "       " },
                { "       ", "       ", "   B   ", "  BCB  ", "   B   ", "       ", "       " },
                { "       ", "       ", "   B   ", "  BCB  ", "   B   ", "       ", "       " },
                { "       ", " B   B ", "  DAD  ", "  ACA  ", "  DAD  ", " B   B ", "       " },
                { "  D D  ", " BA~AB ", " A   A ", " B C B ", " A   A ", " BABAB ", "       " },
                { "  E E  ", " BBBBB ", "EB   BE", " B C B ", "EB   BE", " BBBBB ", "  E E  " } });
    // spotless:on

    public static class VMLV extends MTEVoidMinerEXBase {

        private static final ItemList CASING = ItemList.Casing_SolidSteel;

        private static final Block CASING_BLOCK = Block.getBlockFromItem(
            CASING.get(1)
                .getItem());
        private static final int CASING_META = CASING.get(1)
            .getItemDamage();

        private static final IStructureDefinition<VMLV> STRUCTURE_DEFINITION = StructureDefinition.<VMLV>builder()
            .addShape(STRUCTURE_PIECE_MAIN, SHAPE)
            .addElement('A', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('C', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('D', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('B', ofFrame(Materials.Steel))
            .addElement(
                'E',
                buildHatchAdder(VMLV.class).atLeast(OutputBus, InputBus, Maintenance, Energy)
                    .casingIndex(16)
                    .dot(1)
                    .hint(() -> "casing")
                    .buildAndChain(ofBlock(CASING_BLOCK, CASING_META)))
            .build();

        public VMLV(int aID, String aName, String aNameRegional) {
            super(aID, aName, aNameRegional, 2);
        }

        public VMLV(String aName, int tier) {
            super(aName, tier);
        }

        @Override
        public IStructureDefinition<VMLV> getStructureDefinition() {
            return STRUCTURE_DEFINITION;
        }

        @Override
        public void construct(ItemStack stackSize, boolean hintsOnly) {
            buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, OFF_X, OFF_Y, OFF_Z);
        }

        @Override
        public boolean checkMachine(IGregTechTileEntity te, ItemStack stack) {
            return checkPiece(STRUCTURE_PIECE_MAIN, OFF_X, OFF_Y, OFF_Z) && checkHatches()
                && GTUtility.getTier(getMaxInputVoltage()) >= getMinTier()
                && mMaintenanceHatches.size() == 1;
        }

        @Override
        protected int getControllerTextureIndex() {
            return 16;
        }

        @Override
        protected int getMinTier() {
            return 1;
        }

        @Override
        public IMetaTileEntity newMetaEntity(IGregTechTileEntity te) {
            return new VMLV(this.mName, this.TIER_MULTIPLIER);
        }
    }

    public static class VMHV extends MTEVoidMinerEXBase {

        private static final ItemList CASING = ItemList.Casing_CleanStainlessSteel;

        private static final Block CASING_BLOCK = Block.getBlockFromItem(
            CASING.get(1)
                .getItem());
        private static final int CASING_META = CASING.get(1)
            .getItemDamage();

        private static final int TEX = GTUtility.getCasingTextureIndex(GregTechAPI.sBlockCasings4, 1);

        private static final IStructureDefinition<VMHV> STRUCTURE_DEFINITION = StructureDefinition.<VMHV>builder()
            .addShape(STRUCTURE_PIECE_MAIN, SHAPE)
            .addElement('A', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('C', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('D', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('B', ofFrame(Materials.StainlessSteel))
            .addElement(
                'E',
                buildHatchAdder(VMHV.class).atLeast(OutputBus, InputBus, Maintenance, Energy)
                    .casingIndex(TEX)
                    .dot(1)
                    .hint(() -> "casing")
                    .buildAndChain(ofBlock(CASING_BLOCK, CASING_META)))
            .build();

        public VMHV(int aID, String aName, String aNameRegional) {
            super(aID, aName, aNameRegional, 4);
        }

        public VMHV(String aName, int tier) {
            super(aName, tier);
        }

        @Override
        public IStructureDefinition<VMHV> getStructureDefinition() {
            return STRUCTURE_DEFINITION;
        }

        @Override
        public void construct(ItemStack stackSize, boolean hintsOnly) {
            buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, OFF_X, OFF_Y, OFF_Z);
        }

        @Override
        public boolean checkMachine(IGregTechTileEntity te, ItemStack stack) {
            return checkPiece(STRUCTURE_PIECE_MAIN, OFF_X, OFF_Y, OFF_Z) && checkHatches()
                && GTUtility.getTier(getMaxInputVoltage()) >= getMinTier()
                && mMaintenanceHatches.size() == 1;
        }

        @Override
        protected int getControllerTextureIndex() {
            return TEX;
        }

        @Override
        protected int getMinTier() {
            return 3;
        }

        @Override
        public IMetaTileEntity newMetaEntity(IGregTechTileEntity te) {
            return new VMHV(this.mName, this.TIER_MULTIPLIER);
        }
    }

    public static class VMIV extends MTEVoidMinerEXBase {

        private static final ItemList CASING = ItemList.Casing_RobustTungstenSteel;

        private static final Block CASING_BLOCK = Block.getBlockFromItem(
            CASING.get(1)
                .getItem());
        private static final int CASING_META = CASING.get(1)
            .getItemDamage();

        private static final int TEX = GTUtility.getCasingTextureIndex(GregTechAPI.sBlockCasings4, 0);

        private static final IStructureDefinition<VMIV> STRUCTURE_DEFINITION = StructureDefinition.<VMIV>builder()
            .addShape(STRUCTURE_PIECE_MAIN, SHAPE)
            .addElement('A', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('C', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('D', ofBlock(CASING_BLOCK, CASING_META))
            .addElement('B', ofFrame(Materials.TungstenSteel))
            .addElement(
                'E',
                buildHatchAdder(VMIV.class).atLeast(OutputBus, InputBus, Maintenance, Energy)
                    .casingIndex(TEX)
                    .dot(1)
                    .hint(() -> "casing")
                    .buildAndChain(ofBlock(CASING_BLOCK, CASING_META)))
            .build();

        public VMIV(int aID, String aName, String aNameRegional) {
            super(aID, aName, aNameRegional, 8);
        }

        public VMIV(String aName, int tier) {
            super(aName, tier);
        }

        @Override
        public IStructureDefinition<VMIV> getStructureDefinition() {
            return STRUCTURE_DEFINITION;
        }

        @Override
        public void construct(ItemStack stackSize, boolean hintsOnly) {
            buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, OFF_X, OFF_Y, OFF_Z);
        }

        @Override
        public boolean checkMachine(IGregTechTileEntity te, ItemStack stack) {
            return checkPiece(STRUCTURE_PIECE_MAIN, OFF_X, OFF_Y, OFF_Z) && checkHatches()
                && GTUtility.getTier(getMaxInputVoltage()) >= getMinTier()
                && mMaintenanceHatches.size() == 1;
        }

        @Override
        protected int getControllerTextureIndex() {
            return TEX;
        }

        @Override
        protected int getMinTier() {
            return 5;
        }

        @Override
        public IMetaTileEntity newMetaEntity(IGregTechTileEntity te) {
            return new VMIV(this.mName, this.TIER_MULTIPLIER);
        }
    }
}
