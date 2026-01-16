package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24072y extends C {
    C24072y(C3988Df0 c3988Df0) {
        super(c3988Df0);
    }

    @Override // ir.nasim.F
    protected void h(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // ir.nasim.F
    protected int i(int i) {
        return i < 10000 ? i : i - AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
    }
}
