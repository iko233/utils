package icu.bitchigo.utils.lang;

import java.math.BigDecimal;

public class YuanUtil {
    private static final int YUAN = 0;
    private static final int JIAO = 1;
    private static final int FEN = 3;
    private static final int Li = 4;
    private static final int DECIMAL=10;

    private static BigDecimal coverter(BigDecimal amount,int originTypeCode,int targetTypeCode){
        return amount.movePointLeft(targetTypeCode-originTypeCode);
    }

    public static void main(String[] args) {
        System.out.println(coverter(new BigDecimal("2.33"), 4, 1));
    }
}
