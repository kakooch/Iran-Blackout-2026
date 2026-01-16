package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.vd1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC22663vd1 {
    public static final a Companion;
    public static final EnumC22663vd1 a = new EnumC22663vd1("EXCELLENT", 0);
    public static final EnumC22663vd1 b = new EnumC22663vd1("GOOD", 1);
    public static final EnumC22663vd1 c = new EnumC22663vd1("POOR", 2);
    public static final EnumC22663vd1 d = new EnumC22663vd1("UNKNOWN", 3);
    public static final EnumC22663vd1 e = new EnumC22663vd1("LOST", 4);
    private static final /* synthetic */ EnumC22663vd1[] f;
    private static final /* synthetic */ F92 g;

    /* renamed from: ir.nasim.vd1$a */
    public static final class a {

        /* renamed from: ir.nasim.vd1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1670a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[QE3.values().length];
                try {
                    iArr[QE3.EXCELLENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[QE3.GOOD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[QE3.POOR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[QE3.UNRECOGNIZED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[QE3.LOST.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC22663vd1 a(QE3 qe3) {
            AbstractC13042fc3.i(qe3, "proto");
            int i = C1670a.a[qe3.ordinal()];
            if (i == 1) {
                return EnumC22663vd1.a;
            }
            if (i == 2) {
                return EnumC22663vd1.b;
            }
            if (i == 3) {
                return EnumC22663vd1.c;
            }
            if (i == 4) {
                return EnumC22663vd1.d;
            }
            if (i == 5) {
                return EnumC22663vd1.e;
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC22663vd1[] enumC22663vd1ArrA = a();
        f = enumC22663vd1ArrA;
        g = G92.a(enumC22663vd1ArrA);
        Companion = new a(null);
    }

    private EnumC22663vd1(String str, int i) {
    }

    private static final /* synthetic */ EnumC22663vd1[] a() {
        return new EnumC22663vd1[]{a, b, c, d, e};
    }

    public static EnumC22663vd1 valueOf(String str) {
        return (EnumC22663vd1) Enum.valueOf(EnumC22663vd1.class, str);
    }

    public static EnumC22663vd1[] values() {
        return (EnumC22663vd1[]) f.clone();
    }
}
