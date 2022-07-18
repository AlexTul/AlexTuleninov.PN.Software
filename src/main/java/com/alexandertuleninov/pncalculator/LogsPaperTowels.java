/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

/** The LogsPaperTowels class calculates the number of logs for
 * moisture resistant towels packing 6, 12, 16 rolls/bag.
 * @version 04
 *
 * @author Alexander Tuleninov
 * */
public class LogsPaperTowels {
    /** The method calculates the number of logs for moisture resistant towels packing 6, 12, 16 rolls/bag.
     * @param bags                  array of products in bags
     * @return []log                array of the number of logs for moisture resistant towels
     * */
    protected static Integer[] calculationNumberOfLogs(int[] bags) {
        Integer[] logs = new Integer[21];
        // calculation of logs for towels packing 16 rolls/bag
        for (int i = 0; i <= 7; i++) {
            logs[i] = (int) Math.ceil((double) bags[i] * 16 / 7);
        }

        // calculation of logs for towels packing 12 rolls/bag
        for (int i = 8; i <= 10; i++) {
            logs[i] = (int) Math.ceil((double) bags[i] * 12 / 7);
        }

        // calculation of logs for towels packing 6 rolls/bag
        for (int i = 11; i <= 20; i++) {
            logs[i] = (int) Math.ceil((double) bags[i] * 6 / 7);
        }
        return logs;
    }

    /** The method calculates the required number of logs for all types of moisture-resistant towels
     * to complete the task.
     * @param logs                    array of products in bags
     * @return totalLog               array of the number of logs for all types of moisture-resistant towels
     * */
    protected static int calculationTotalOfLogs(Integer[] logs) {
        int totalLog = 0;
        for (int i = 0; i <= 20; i++) {
            totalLog += logs[i];
        }
        return totalLog;
    }
}
