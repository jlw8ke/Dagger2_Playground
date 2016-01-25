package com.mobiquityinc.nwprototype.util;

import java.math.BigDecimal;

public class MathUtils {

    public static double round(double unrounded, int precision)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
}
