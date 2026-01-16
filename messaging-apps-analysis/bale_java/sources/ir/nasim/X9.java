package ir.nasim;

import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class X9 {
    public static final a b;
    public static final X9 c = new X9("NOT_ADDED_AT_ALL", 0, 0);
    public static final X9 d = new X9("FIRST_STORY_ADDED", 1, 1);
    public static final X9 e = new X9("REGULAR", 2, 2);
    private static final /* synthetic */ X9[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    public static final class a {
        private a() {
        }

        public final X9 a(int i) {
            for (X9 x9 : X9.values()) {
                if (x9.j() == i) {
                    return x9;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        X9[] x9ArrA = a();
        f = x9ArrA;
        g = G92.a(x9ArrA);
        b = new a(null);
    }

    private X9(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ X9[] a() {
        return new X9[]{c, d, e};
    }

    public static X9 valueOf(String str) {
        return (X9) Enum.valueOf(X9.class, str);
    }

    public static X9[] values() {
        return (X9[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
