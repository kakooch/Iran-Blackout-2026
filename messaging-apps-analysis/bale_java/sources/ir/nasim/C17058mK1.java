package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mK1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17058mK1 {
    private final ZJ1 a;
    private final UA2 b;

    public C17058mK1(ZJ1 zj1, UA2 ua2) {
        AbstractC13042fc3.i(zj1, "item");
        AbstractC13042fc3.i(ua2, "exitCallback");
        this.a = zj1;
        this.b = ua2;
    }

    public final UA2 a() {
        return this.b;
    }

    public final ZJ1 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17058mK1)) {
            return false;
        }
        C17058mK1 c17058mK1 = (C17058mK1) obj;
        return AbstractC13042fc3.d(this.a, c17058mK1.a) && AbstractC13042fc3.d(this.b, c17058mK1.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DeviceInfoBottomSheetState(item=" + this.a + ", exitCallback=" + this.b + Separators.RPAREN;
    }
}
