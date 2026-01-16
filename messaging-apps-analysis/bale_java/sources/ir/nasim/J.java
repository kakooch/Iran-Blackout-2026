package ir.nasim;

import java.io.IOException;

/* loaded from: classes5.dex */
public enum J {
    VOUCHER("VOUCHER"),
    TOPUP("TOPUP"),
    WOW("WOW"),
    UNSUPPORTED_VALUE("UNSUPPORTED_VALUE");

    final String a;

    J(String str) {
        this.a = str;
    }

    public static J j(String str) throws IOException {
        str.hashCode();
        switch (str) {
            case "WOW":
                return WOW;
            case "TOPUP":
                return TOPUP;
            case "VOUCHER":
                return VOUCHER;
            default:
                throw new IOException(UNSUPPORTED_VALUE.getValue());
        }
    }

    public String getValue() {
        return this.a;
    }
}
