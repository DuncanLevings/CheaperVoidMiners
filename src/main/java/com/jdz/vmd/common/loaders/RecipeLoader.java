package com.jdz.vmd.common.loaders;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class RecipeLoader {

    // spotless:off
    public static void run() {
        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX1,
            new Object[] { "SES", "MHM", "RAR", 'M',
                ItemList.Machine_LV_Miner.get(1), 'H',
                ItemList.Hull_LV.get(1), 'S',
                ItemList.Sensor_LV.get(1), 'E',
                ItemList.Emitter_LV.get(1), 'R',
                ItemList.Robot_Arm_LV.get(1), 'A',
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L)});

        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX2,
            new Object[] { "SCS", "MHM", "RFR", 'M',
                ItemList.Machine_HV_Miner.get(1), 'H',
                ItemList.Hull_HV.get(1), 'S',
                ItemList.Sensor_HV.get(1), 'R',
                ItemList.Robot_Arm_HV.get(1), 'F',
                ItemList.Field_Generator_LV.get(1), 'C',
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L)});

        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX3,
            new Object[] { "SCS", "MHM", "RFR", 'M',
                ItemList.OreDrill1.get(1), 'H',
                ItemList.Hull_IV.get(1), 'S',
                ItemList.Sensor_IV.get(1), 'R',
                ItemList.Robot_Arm_IV.get(1), 'F',
                ItemList.Field_Generator_IV.get(1), 'C',
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1L)});
    }
    // spotless:on
}
