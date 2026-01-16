package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.My7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6286My7 {

    /* renamed from: ir.nasim.My7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KQ7.valuesCustom().length];
            iArr[KQ7.INVARIANT.ordinal()] = 1;
            iArr[KQ7.IN_VARIANCE.ordinal()] = 2;
            iArr[KQ7.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final EnumC8204Uy7 a(KQ7 kq7) {
        AbstractC13042fc3.i(kq7, "<this>");
        int i = a.a[kq7.ordinal()];
        if (i == 1) {
            return EnumC8204Uy7.INV;
        }
        if (i == 2) {
            return EnumC8204Uy7.IN;
        }
        if (i == 3) {
            return EnumC8204Uy7.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
