package icu.bitchigo.utils.lang;

import java.math.BigDecimal;

public class RMBUtil {
    private static final int YUAN = 0;
    private static final int JIAO = 1;
    private static final int FEN = 3;
    private static final int Li = 4;

    private static BigDecimal coverter(BigDecimal amount,EnumRMBUnit originUnit,EnumRMBUnit targetUnit){
        return amount.movePointLeft(targetUnit.getCode()- originUnit.getCode());
    }

    public enum EnumRMBUnit{
        YUAN("元",0),
        JIAO("角",1),
        FEN("分",2),
        LI("厘",3),
        ;
        /**
         * 名称
         */
        private String name;
        /**
         * 状态码
         */
        private int code;

        EnumRMBUnit(String name,int code){
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }

}
