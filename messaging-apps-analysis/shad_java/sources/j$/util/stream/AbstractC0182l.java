package j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;

/* renamed from: j$.util.stream.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0182l {
    static {
        EnumC0158h enumC0158h = EnumC0158h.CONCURRENT;
        EnumC0158h enumC0158h2 = EnumC0158h.UNORDERED;
        EnumC0158h enumC0158h3 = EnumC0158h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(enumC0158h, enumC0158h2, enumC0158h3));
        Collections.unmodifiableSet(EnumSet.of(enumC0158h, enumC0158h2));
        Collections.unmodifiableSet(EnumSet.of(enumC0158h3));
        Collections.unmodifiableSet(EnumSet.of(enumC0158h2, enumC0158h3));
        Collections.emptySet();
    }

    static double a(double[] dArr) {
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    static double[] b(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }
}
