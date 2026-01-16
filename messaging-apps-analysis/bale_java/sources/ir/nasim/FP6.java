package ir.nasim;

import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class FP6 {
    public static final a b;
    public static final FP6 c = new FP6("NOT_OPENED_AT_ALL", 0, 0);
    public static final FP6 d = new FP6("FIRST_TIME_OPENING", 1, 1);
    public static final FP6 e = new FP6("SECOND_TIME_OPENING", 2, 3);
    public static final FP6 f = new FP6("REGULAR", 3, 4);
    private static final /* synthetic */ FP6[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    public static final class a {
        private a() {
        }

        public final FP6 a(int i) {
            for (FP6 fp6 : FP6.values()) {
                if (fp6.j() == i) {
                    return fp6;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        FP6[] fp6ArrA = a();
        g = fp6ArrA;
        h = G92.a(fp6ArrA);
        b = new a(null);
    }

    private FP6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ FP6[] a() {
        return new FP6[]{c, d, e, f};
    }

    public static FP6 valueOf(String str) {
        return (FP6) Enum.valueOf(FP6.class, str);
    }

    public static FP6[] values() {
        return (FP6[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
