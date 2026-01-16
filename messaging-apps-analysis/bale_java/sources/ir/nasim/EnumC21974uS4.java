package ir.nasim;

/* renamed from: ir.nasim.uS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC21974uS4 {
    PHONE_NUMBER("PHONE_NUMBER"),
    OPERATOR("OPERATOR"),
    BILL_TYPE("BILL_TYPE"),
    CHARGE_TYPE("CHARGE_TYPE"),
    MONEY_AMOUNT("MONEY_AMOUNT"),
    BILL_ID("BILL_ID"),
    PAYMENT_ID("PAYMENT_ID"),
    CC_PAN("CC_PAN"),
    CC_PIN("CC_PIN"),
    CC_CVV2("CC_CVV2"),
    CC_EXPIRE_DATE("CC_EXPIRE_DATE"),
    BILL_OPERATOR("BILL_OPERATOR"),
    NATIONAL_CODE("NATIONAL_CODE"),
    SERVICE_PROVIDER("SERVICE_PROVIDER"),
    SERVICE_TYPE("SERVICE_TYPE"),
    SERVICE_TYPE_NEW("SERVICE_TYPE_NEW"),
    TERMINAL_ID("TERMINAL_ID"),
    MERCHANT_ID("MERCHANT_ID"),
    UNSUPPORTED_VALUE("UNSUPPORTED_VALUE");

    private String a;

    EnumC21974uS4(String str) {
        this.a = str;
    }

    public static EnumC21974uS4 j(String str) {
        str.hashCode();
        switch (str) {
            case "NATIONAL_CODE":
                return NATIONAL_CODE;
            case "SERVICE_TYPE":
                return SERVICE_TYPE;
            case "MERCHANT_ID":
                return MERCHANT_ID;
            case "CHARGE_TYPE":
                return CHARGE_TYPE;
            case "SERVICE_PROVIDER":
                return SERVICE_PROVIDER;
            case "MONEY_AMOUNT":
                return MONEY_AMOUNT;
            case "CC_EXPIRE_DATE":
                return CC_EXPIRE_DATE;
            case "SERVICE_TYPE_NEW":
                return SERVICE_TYPE_NEW;
            case "PHONE_NUMBER":
                return PHONE_NUMBER;
            case "TERMINAL_ID":
                return TERMINAL_ID;
            case "OPERATOR":
                return OPERATOR;
            case "BILL_TYPE":
                return BILL_TYPE;
            case "BILL_ID":
                return BILL_ID;
            case "CC_CVV2":
                return CC_CVV2;
            case "CC_PAN":
                return CC_PAN;
            case "CC_PIN":
                return CC_PIN;
            case "PAYMENT_ID":
                return PAYMENT_ID;
            case "BILL_OPERATOR":
                return BILL_OPERATOR;
            default:
                return UNSUPPORTED_VALUE;
        }
    }
}
