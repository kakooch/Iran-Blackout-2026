package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tB1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21144tB1 {
    public static final C21144tB1 a = new C21144tB1();

    /* renamed from: ir.nasim.tB1$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC14254hc6.values().length];
            try {
                iArr[EnumC14254hc6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC14254hc6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private C21144tB1() {
    }

    public static final int a(int i, int i2, int i3, int i4, EnumC14254hc6 enumC14254hc6) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(i / i3);
        int iHighestOneBit2 = Integer.highestOneBit(i2 / i4);
        int i5 = a.a[enumC14254hc6.ordinal()];
        if (i5 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        return AbstractC23053wG5.e(iMin, 1);
    }

    public static final double b(double d, double d2, double d3, double d4, EnumC14254hc6 enumC14254hc6) {
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = a.a[enumC14254hc6.ordinal()];
        if (i == 1) {
            return Math.max(d5, d6);
        }
        if (i == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double c(int i, int i2, int i3, int i4, EnumC14254hc6 enumC14254hc6) {
        double d = i3 / i;
        double d2 = i4 / i2;
        int i5 = a.a[enumC14254hc6.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float d(float f, float f2, float f3, float f4, EnumC14254hc6 enumC14254hc6) {
        float f5 = f3 / f;
        float f6 = f4 / f2;
        int i = a.a[enumC14254hc6.ordinal()];
        if (i == 1) {
            return Math.max(f5, f6);
        }
        if (i == 2) {
            return Math.min(f5, f6);
        }
        throw new NoWhenBranchMatchedException();
    }
}
