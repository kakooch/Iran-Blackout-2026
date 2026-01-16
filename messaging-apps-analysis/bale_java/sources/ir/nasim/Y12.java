package ir.nasim;

import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public abstract class Y12 {
    public static final double a(double d, W12 w12, W12 w122) {
        AbstractC13042fc3.i(w12, "sourceUnit");
        AbstractC13042fc3.i(w122, "targetUnit");
        long jConvert = w122.j().convert(1L, w12.j());
        return jConvert > 0 ? d * jConvert : d / w12.j().convert(1L, w122.j());
    }

    public static final long b(long j, W12 w12, W12 w122) {
        AbstractC13042fc3.i(w12, "sourceUnit");
        AbstractC13042fc3.i(w122, "targetUnit");
        return w122.j().convert(j, w12.j());
    }

    public static final long c(long j, W12 w12, W12 w122) {
        AbstractC13042fc3.i(w12, "sourceUnit");
        AbstractC13042fc3.i(w122, "targetUnit");
        return w122.j().convert(j, w12.j());
    }

    public static TimeUnit d(W12 w12) {
        AbstractC13042fc3.i(w12, "<this>");
        return w12.j();
    }
}
