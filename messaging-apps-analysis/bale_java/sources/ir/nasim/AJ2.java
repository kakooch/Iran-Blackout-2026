package ir.nasim;

/* loaded from: classes3.dex */
public final class AJ2 {
    private final String a;
    private final String b;

    public AJ2(String str) {
        this(str, null);
    }

    public AJ2(String str, String str2) {
        AbstractC3795Cj5.k(str, "log tag cannot be null");
        AbstractC3795Cj5.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        this.b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
