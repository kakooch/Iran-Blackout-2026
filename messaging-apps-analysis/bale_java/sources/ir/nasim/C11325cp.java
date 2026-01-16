package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.cp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11325cp implements InterfaceC18438of5 {
    private final int b;

    public C11325cp(int i) {
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC18438of5
    public C4593Fu2 d(C4593Fu2 c4593Fu2) {
        int i = this.b;
        return (i == 0 || i == Integer.MAX_VALUE) ? c4593Fu2 : new C4593Fu2(AbstractC23053wG5.m(c4593Fu2.t() + this.b, 1, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C11325cp) && this.b == ((C11325cp) obj).b;
    }

    public int hashCode() {
        return Integer.hashCode(this.b);
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.b + ')';
    }
}
