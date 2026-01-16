package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DO4 implements BI5 {
    private static X06[] b(C6338Ne0 c6338Ne0, Map map, boolean z) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        CO4 co4B = CJ1.b(c6338Ne0, map, z);
        for (C12092e16[] c12092e16Arr : co4B.b()) {
            LB1 lb1I = FO4.i(co4B.a(), c12092e16Arr[4], c12092e16Arr[5], c12092e16Arr[6], c12092e16Arr[7], e(c12092e16Arr), c(c12092e16Arr));
            X06 x06 = new X06(lb1I.h(), lb1I.e(), c12092e16Arr, EnumC9549a90.PDF_417);
            x06.h(EnumC11449d16.ERROR_CORRECTION_LEVEL, lb1I.b());
            EO4 eo4 = (EO4) lb1I.d();
            if (eo4 != null) {
                x06.h(EnumC11449d16.PDF417_EXTRA_METADATA, eo4);
            }
            arrayList.add(x06);
        }
        return (X06[]) arrayList.toArray(new X06[arrayList.size()]);
    }

    private static int c(C12092e16[] c12092e16Arr) {
        return Math.max(Math.max(d(c12092e16Arr[0], c12092e16Arr[4]), (d(c12092e16Arr[6], c12092e16Arr[2]) * 17) / 18), Math.max(d(c12092e16Arr[1], c12092e16Arr[5]), (d(c12092e16Arr[7], c12092e16Arr[3]) * 17) / 18));
    }

    private static int d(C12092e16 c12092e16, C12092e16 c12092e162) {
        if (c12092e16 == null || c12092e162 == null) {
            return 0;
        }
        return (int) Math.abs(c12092e16.c() - c12092e162.c());
    }

    private static int e(C12092e16[] c12092e16Arr) {
        return Math.min(Math.min(f(c12092e16Arr[0], c12092e16Arr[4]), (f(c12092e16Arr[6], c12092e16Arr[2]) * 17) / 18), Math.min(f(c12092e16Arr[1], c12092e16Arr[5]), (f(c12092e16Arr[7], c12092e16Arr[3]) * 17) / 18));
    }

    private static int f(C12092e16 c12092e16, C12092e16 c12092e162) {
        if (c12092e16 == null || c12092e162 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(c12092e16.c() - c12092e162.c());
    }

    @Override // ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) throws NotFoundException {
        X06 x06;
        X06[] x06ArrB = b(c6338Ne0, map, false);
        if (x06ArrB == null || x06ArrB.length == 0 || (x06 = x06ArrB[0]) == null) {
            throw NotFoundException.a();
        }
        return x06;
    }

    @Override // ir.nasim.BI5
    public void reset() {
    }
}
