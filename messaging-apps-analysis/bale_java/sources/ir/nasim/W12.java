package ir.nasim;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class W12 {
    public static final W12 b = new W12("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
    public static final W12 c = new W12("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
    public static final W12 d = new W12("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
    public static final W12 e = new W12("SECONDS", 3, TimeUnit.SECONDS);
    public static final W12 f = new W12("MINUTES", 4, TimeUnit.MINUTES);
    public static final W12 g = new W12("HOURS", 5, TimeUnit.HOURS);
    public static final W12 h = new W12("DAYS", 6, TimeUnit.DAYS);
    private static final /* synthetic */ W12[] i;
    private static final /* synthetic */ F92 j;
    private final TimeUnit a;

    static {
        W12[] w12ArrA = a();
        i = w12ArrA;
        j = G92.a(w12ArrA);
    }

    private W12(String str, int i2, TimeUnit timeUnit) {
        this.a = timeUnit;
    }

    private static final /* synthetic */ W12[] a() {
        return new W12[]{b, c, d, e, f, g, h};
    }

    public static W12 valueOf(String str) {
        return (W12) Enum.valueOf(W12.class, str);
    }

    public static W12[] values() {
        return (W12[]) i.clone();
    }

    public final TimeUnit j() {
        return this.a;
    }
}
