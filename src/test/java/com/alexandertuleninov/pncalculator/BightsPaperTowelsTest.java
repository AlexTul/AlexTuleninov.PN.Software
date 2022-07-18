/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The BightsPaperTowelsTest class tests methods for calculates the required number
 * of coils of each type for all types of moisture resistant towels for the job.
 * @version 04
 *
 * @author Alexander Tuleninov
 */
public class BightsPaperTowelsTest {
    double[] length = new double[]{8.8, 9.0, 10.8, 10.5, 11.0, 10.5, 14.2, 14.2, 20.0, 45.0, 35.0,
                      65.0, 65.0, 71.0, 71.0, 71.0, 84.0, 84.0, 95.0, 100.0, 123.0};

    int[] density = new int[]{18, 17, 17, 20, 20, 20, 17, 18, 17, 18, 18, 18, 18, 18, 17, 18, 17, 17, 20, 17, 20};

    /**
     * The method checks the operation of the calculates the number of coils for each type of moisture-resistant towels.
     * @[]bags                      an array of the number of bags to test the method
     * @[]actualNumberOfBight       an array with actual number
     * @length                      an array of the lengths for each item from the assortment
     * @density                     an array of the density of raw materials for each item from the assortment
     * @[]logs                      the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag
     * []bightsDouble               the number of coils for each type of moisture-resistant towels.
     * @[]validBights               an array of the convert Double to double
     * */
    @Test
    public void validCalculationNumberOfBight() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        // Creating and initializing an array of the actual number of bags to test the method.
        double[] actualNumberOfBight = new double[]{0.003, 0.004, 0.007, 0.012 , 0.015, 0.017, 0.022, 0.028,
                                       0.032, 0.084,0.069,0.075,0.081,0.089,0.091,0.104, 0.124,0.132,0.187,0.177,0.257};

        Integer[] logs = LogsPaperTowels.calculationNumberOfLogs(bags);
        Double[] bightsDouble = BightsPaperTowels.calculationNumberOfBight(length, density, logs);
        // Convert Double to double.
        double[] validBights = new double[bightsDouble.length];
        for (int i = 0; i < bightsDouble.length; i++) {
            validBights[i]  = bightsDouble[i];
        }

        assertArrayEquals(validBights, actualNumberOfBight,0.001);
    }

    /**
     * Auxiliary method for initializing the array of the number of bags to test the method.
     * @param bags                  an array of the number of bags to test the method
     * */
    private void initializeNumberOfBags(int[] bags) {
        for (int i = 1; i <= 21; i++) {
            bags[i-1] += i;
        }
    }

    /**
     * The method checks the operation of the calculates the number of coils of type 17.
     * @[]bags                      an array of the number of bags to test the method
     * @length                      an array of the lengths for each item from the assortment
     * @density                     an array of the density of raw materials for each item from the assortment
     * @[]logs                      the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag
     * @actualNumberBightByType17   the actual number of bights of type 17
     * @validNumberBightByType17    the number with result to test the method
     * */
    @Test
    public void validCalculationNumberBightByType17() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        Integer[] logs = LogsPaperTowels.calculationNumberOfLogs(bags);
        Double[] bightsDouble = BightsPaperTowels.calculationNumberOfBight(length, density, logs);

        double actualNumberBightByType17 = BightsPaperTowels.calculationNumberBightByType17(bightsDouble);

        double validNumberBightByType17 = 0.589;

        assertEquals(actualNumberBightByType17, validNumberBightByType17, 0.001);
    }

    /**
     * The method calculates the number of coils of type 18.
     * @[]bags                      an array of the number of bags to test the method
     * @length                      an array of the lengths for each item from the assortment
     * @density                     an array of the density of raw materials for each item from the assortment
     * @[]logs                      the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag
     * @actualNumberBightByType18   the actual number of bights of type 18
     * @validNumberBightByType18    the number with result to test the method
     * */
    @Test
    public void validCalculationNumberBightByType18() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        Integer[] logs = LogsPaperTowels.calculationNumberOfLogs(bags);
        Double[] bightsDouble = BightsPaperTowels.calculationNumberOfBight(length, density, logs);

        double actualNumberBightByType18 = BightsPaperTowels.calculationNumberBightByType18(bightsDouble);

        double validNumberBightByType18 = 0.533;

        assertEquals(actualNumberBightByType18, validNumberBightByType18, 0.001);
    }

    /**
     * The method calculates the number of coils of type 20.
     * @[]bags                      an array of the number of bags to test the method
     * @length                      an array of the lengths for each item from the assortment
     * @density                     an array of the density of raw materials for each item from the assortment
     * @[]logs                      the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag
     * @actualNumberBightByType20   the actual number of bights of type 20
     * @validNumberBightByType20    the number with result to test the method
     * */
    @Test
    public void validCalculationNumberBightByType20() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        Integer[] logs = LogsPaperTowels.calculationNumberOfLogs(bags);
        Double[] bightsDouble = BightsPaperTowels.calculationNumberOfBight(length, density, logs);

        double actualNumberBightByType20 = BightsPaperTowels.calculationNumberBightByType20(bightsDouble);

        double validNumberBightByType20 = 0.488;

        assertEquals(actualNumberBightByType20, validNumberBightByType20, 0.001);
    }
}