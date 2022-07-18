/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The PaperTowelsTest class tests methods for counting the required the number of dens, coils of raw
 * materials for winding and cutting areas by types of products required to fulfill the factory order.
 * @version 04
 *
 * @author Alexander Tuleninov
 */
public class LogsPaperTowelsTest {
    /**
     * The method checks the operation of the calculationNumberOfLogs() method of the checked LogsPaperTowels class.
     * @[]bags                  an array of the number of bags to test the method
     * @validArray              an array with reference results to test the method
     * */
    @Test
    public void validCalculationNumberOfLogs() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        // Creating and initializing an array with reference results to test the method.
        Integer[] validArray = new Integer[]{3,5,7,10,12,14,16,19,16,18,19,11,12,12,13,14,15,16,17,18,18};

        assertArrayEquals(LogsPaperTowels.calculationNumberOfLogs(bags), validArray);
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
     * The method checks the operation of the calculationTotalOfLogs() method of the checked LogsPaperTowels class
     * @[]bags                  an array of the number of bags to test the method
     * @[]logs                  the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag
     * @validTotalLog           the calculated number
     * @actualNumber            the actual number
     * */
    @Test
    public void validCalculationTotalOfLogs() {
        // Creating and initializing an array of the number of bags to test the method.
        int[] bags = new int[21];
        initializeNumberOfBags(bags);

        Integer[] logs = LogsPaperTowels.calculationNumberOfLogs(bags);
        int validTotalLog = 285;
        int actualNumber = LogsPaperTowels.calculationTotalOfLogs(logs);

        assertEquals(validTotalLog, actualNumber);
    }
}