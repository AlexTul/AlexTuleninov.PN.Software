/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

import lombok.extern.log4j.Log4j;
import java.util.Scanner;

/**
 * The DataPaperTowels class receives from the user the required quantity of products for the factory order.<p>
 * There are 21 types of products in the range of moisture-resistant towels.
 * @version 04
 *
 * @author Alexander Tuleninov
 * */
@Log4j
public class DataPaperTowels {
    /**
     * The method receives from the user the required quantity of products for the factory order.<p>
     * There are 21 types of products in the range of moisture-resistant towels.
     * @param productRange              an array of product names
     * @return []bags                   an array of products in bags
     * @bags                            an array with 21 elements to record the entered bags by type
     * @in                              the object of class Scanner
     * */
     protected static int[] getNumberOfBags(String[] productRange) {
        int[] bags = new int[21];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= 20; i++) {
            log.info("Введите необходимое целое количество мешков " + productRange[i] + ": ");
            i = getAnInt(bags, in, i);
        }
        in.close();
        return bags;
    }

    /**
     * A helper method for getting an integer from the user.
     * @param bags                      an array of products in bags
     * @param in                        the object of class Scanner
     * @param i                         the number of iterations
     * @temp                            a local variable
     * @return                          ghdf
     * */
    private static int getAnInt(int[] bags, Scanner in, int i) {
        int temp;
        if (in.hasNextInt() && ((temp = in.nextInt()) >= 0)) {
            bags[i] = temp;
        } else {
            log.info("Вы ошиблись. Попробуйте снова!");
            i = 20;
        }
        return i;
    }
}