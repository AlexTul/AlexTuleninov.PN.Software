/*
 * Copyright (c) 2022
 * For PN
 */
package com.alexandertuleninov.pncalculator;

import lombok.extern.log4j.Log4j;

/**
 * The PaperTowels class calculates the required number of logs, coils of raw materials for overlay and cutting areas
 * by type of product, food products to fulfill the factory order. There are 21 types of products in total.
 * @version 04
 *
 * @author Alexander Tuleninov
 */
@Log4j
public class CalculationPaperTowels {
    /*
     * The range of product names, 21 items:
     * "ВП КВ", "ВП Классик", "ВП Актив", "ВП ПроСервис", "ВП Safe Med", "ВП HORECA", "ВП енот XL", "ВП Дабл",
     * "ВП 20", "ВП 50", "ВП БигРолл", "ВП happy", "ВП 69_термоусадка", "ВП Проф", "ВП 75", "ВП МегаРолл",
     * "ВП 90*19", "ВП 90*22", "ВП 100 без перфорации", "ВП 100 Щебпак", "ВП 130 без перфорации"
     * */
    private static final String[] PRODUCT_RANGE = new String[]{"ВП КВ", "ВП Классик", "ВП Актив", "ВП ПроСервис",
                                                  "ВП Safe Med", "ВП HORECA", "ВП енот XL", "ВП Дабл", "ВП 20", "ВП 50",
                                                  "ВП БигРолл", "ВП happy", "ВП 69_термоусадка", "ВП Проф", "ВП 75",
                                                  "ВП МегаРолл", "ВП 90*19", "ВП 90*22", "ВП 100 без перфорации",
                                                  "ВП 100 Щебпак", "ВП 130 без перфорации"};

    /*
     * The lengths for each item from the assortment, 21 items:
     * {8.8, 9.0, 10.8, 10.5, 11.0, 10.5, 14.2, 14.2, 20.0, 45.0, 35.0,
     * 65.0, 65.0, 71.0, 71.0, 71.0, 84.0, 84.0, 95.0, 100.0, 123.0}
     * */
    private static final double[] LENGTH = new double[]{8.8, 9.0, 10.8, 10.5, 11.0, 10.5, 14.2, 14.2, 20.0, 45.0,
                                           35.0, 65.0, 65.0, 71.0, 71.0, 71.0, 84.0, 84.0, 95.0, 100.0, 123.0};

    /*
     * The density of raw materials for each item from the assortment, 21 items:
     * {18, 17, 17, 20, 20, 20, 17, 18, 17, 18, 18, 18, 18, 18, 17, 18, 17, 17, 20, 17, 20}
     * */
    private static final int[] DENSITY = new int[]{18, 17, 17, 20, 20, 20, 17, 18, 17, 18, 18, 18, 18, 18, 17, 18, 17,
                                         17, 20, 17, 20};

    public static void main(String[] args) {
        // Receiving from the user the required quantity of products for the factory order.
        int[] numberOfBags = DataPaperTowels.getNumberOfBags(PRODUCT_RANGE);

        // Calculation of the number of logs for moisture-resistant towels with 6, 12, 16 rolls/bag.
        Integer[] numberOfLogs = LogsPaperTowels.calculationNumberOfLogs(numberOfBags);
        CalculationPaperTowels.print("логов" , numberOfLogs);
        // Calculation of the total number of logs required for all types of moisture-resistant towels.
        log.info("Итого: необходимое количество логов для выполнения задания, шт. - "
                + LogsPaperTowels.calculationTotalOfLogs(numberOfLogs) + "\n");

        // Calculation of the number of bays for each type of moisture-resistant towels.
        Double[] numberOfBights = BightsPaperTowels.calculationNumberOfBight(LENGTH, DENSITY, numberOfLogs);
        CalculationPaperTowels.print("бухт" , numberOfBights);
        log.info("Итого: необходимое количество бухт 17 грамажа для выполнения задания, шт. - "
                + BightsPaperTowels.calculationNumberBightByType17(numberOfBights) + "\n");
        log.info("Итого: необходимое количество бухт 18 грамажа для выполнения задания, шт. - "
                + BightsPaperTowels.calculationNumberBightByType18(numberOfBights) + "\n");
        log.info("Итого: необходимое количество бухт 20 грамажа для выполнения задания, шт. - "
                + BightsPaperTowels.calculationNumberBightByType20(numberOfBights) + "\n");
    }

    /**
     * The method outputs of results.
     * @param title                     the name of output type
     * @param numberOf                  output array
     * */
    private static <T> void print(String title, T[] numberOf) {
        for (int i = 0; i < numberOf.length; i++) {
            log.info("- необходимое количество " + title + " для "  + CalculationPaperTowels.PRODUCT_RANGE[i] + " - "
                    + numberOf[i] + "\n");
        }
    }
}