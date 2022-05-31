package icu.bitchigo.utils.lang;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class RMBUtil {
    /**
     * 单位转换
     *
     * @param amount     金额
     * @param originUnit 来源单位
     * @param targetUnit 目标单位
     * @return {@link BigDecimal}
     */
    private static BigDecimal coverter(@NotNull BigDecimal amount, @NotNull EnumRMBUnit originUnit, @NotNull EnumRMBUnit targetUnit){
        if (NullUtil.isAllNotNull(amount, originUnit,targetUnit)){
            return null;
        }
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
        private final String name;
        /**
         * 状态码
         */
        private final int code;

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
