package com.jdz.vmd.common.loaders;

import gregtech.api.enums.ItemList;
import gregtech.api.util.GTModHandler;

public class RecipeLoader {

    public static void run() {
        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX1,
            new Object[] { "SES", "MHM", "RAR", 'M', ItemList.Machine_LV_Miner.get(1), 'H', ItemList.Hull_LV.get(1),
                'S', ItemList.Sensor_LV.get(1), 'E', ItemList.Emitter_LV.get(1), 'R', ItemList.Robot_Arm_LV.get(1), 'A',
                ItemList.Circuit_Advanced.get(1) });

        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX2,
            new Object[] { "SCS", "MHM", "RFR", 'M', ItemList.Machine_HV_Miner.get(1), 'H', ItemList.Hull_HV.get(1),
                'S', ItemList.Sensor_HV.get(1), 'R', ItemList.Robot_Arm_HV.get(1), 'F',
                ItemList.Field_Generator_HV.get(1), 'C', ItemList.Circuit_Data.get(1) });

        GTModHandler.addCraftingRecipe(
            ItemRegistry.VoidMinerEX3,
            new Object[] { "SCS", "MHM", "RFR", 'M', ItemList.OreDrill1.get(1), 'H', ItemList.Hull_IV.get(1), 'S',
                ItemList.Sensor_IV.get(1), 'R', ItemList.Robot_Arm_IV.get(1), 'F', ItemList.Field_Generator_IV.get(1),
                'C', ItemList.Circuit_Elite.get(1) });
    }
}
