package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.ls5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC16795ls5 {
    CHARGE("CHARGE"),
    UTILITY_BILL("UTILITY_BILL"),
    PHONE_BILL("PHONE_BILL"),
    PAYMENT("PAYMENT"),
    LEAVING_COUNTRY_CHARGES("LEAVING_COUNTRY_CHARGES"),
    INQUERY_MOBILE_BILL("INQUERY_MOBILE_BILL"),
    UNSUPPORTED_VALUE("UNSUPPORTED_VALUE");

    private String a;

    EnumC16795ls5(String str) {
        this.a = str;
    }

    public static EnumC16795ls5 j(String str) throws IOException {
        str.hashCode();
        switch (str) {
            case "INQUERY_MOBILE_BILL":
                return INQUERY_MOBILE_BILL;
            case "UTILITY_BILL":
                return UTILITY_BILL;
            case "PHONE_BILL":
                return PHONE_BILL;
            case "PAYMENT":
                return PAYMENT;
            case "LEAVING_COUNTRY_CHARGES":
                return LEAVING_COUNTRY_CHARGES;
            case "CHARGE":
                return CHARGE;
            default:
                throw new IOException(UNSUPPORTED_VALUE.getValue());
        }
    }

    public String getValue() {
        return this.a;
    }
}
