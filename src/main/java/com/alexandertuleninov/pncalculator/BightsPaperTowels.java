/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

/**
 * The BightsPaperTowels class calculates the required number of coils of each type
 * for all types of moisture resistant towels for the job.
 * @version 04
 *
 * @author Alexander Tuleninov
 * */
public class BightsPaperTowels {
    /**
     * The method calculates the number of coils for each type of moisture-resistant towels.
     * @param length                an array of material length for each item from the assortment
     * @param density               an array of material density for each item from the assortment
     * @param logs                  array of the number of logs for moisture resistant towels
     * @return []bights             array of number of bights for moisture resistant towels
     * */
    protected static Double[] calculationNumberOfBight(double[] length, int[] density, Integer[] logs) {
        Double[] bights = new Double[21];
        for (int i = 0; i <= 20; i++) {
            bights[i] = logs[i] * length[i] * 1.55 * (density[i] * 2) / 1000 / 535;
            bights[i] = Math.round(bights[i] * 1000) / 1000.0d;
        }
        return bights;
    }

    /**
     * The method calculates the number of coils of type 17.
     * @param bights            array of number of bights for moisture resistant towels
     * @return                  total number of coils type 17 for moisture resistant towels
     * */
    protected static double calculationNumberBightByType17(Double[] bights) {
        return Math.round((bights[1] + bights[2] + bights[6] + bights[8]
                         + bights[14] + bights[16] + bights[17] + bights[19]) * 1000) / 1000.0d;
    }

    /**
     * The method calculates the number of coils of type 18.
     * @param bights            array of number of bights for moisture resistant towels
     * @return                  total number of coils type 18 for moisture resistant towels
     * */
    protected static double calculationNumberBightByType18(Double[] bights) {
        return Math.round((bights[0] + bights[7] + bights[9] + bights[10]
                         + bights[11] + bights[12] + bights[13] + bights[15]) * 1000) / 1000.0d;
    }

    /**
     * The method calculates the number of coils of type 20.
     * @param bights            array of number of bights for moisture resistant towels
     * @return                  total number of coils type 20 for moisture resistant towels
     * */
    protected static double calculationNumberBightByType20(Double[] bights) {
        return Math.round((bights[3] + bights[4] + bights[5] + bights[18] + bights[20]) * 1000) / 1000.0d;
    }
}
