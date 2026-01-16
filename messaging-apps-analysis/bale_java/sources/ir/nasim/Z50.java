package ir.nasim;

/* loaded from: classes5.dex */
public enum Z50 {
    MELLI_LOAN("melli_loan");

    private final String a;

    Z50(String str) {
        this.a = str;
    }

    public static boolean j(Y50 y50, Z50 z50) {
        return z50 != MELLI_LOAN || y50 == Y50.e;
    }

    public String getValue() {
        return this.a;
    }
}
