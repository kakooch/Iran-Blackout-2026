package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xf0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23868xf0 {
    private final int a;
    private final int b;
    private final UA2 c;
    private final InterfaceC19114po0 d;

    public C23868xf0(int i, int i2, UA2 ua2, InterfaceC19114po0 interfaceC19114po0) {
        AbstractC13042fc3.i(ua2, "onButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po0, "buttonStates");
        this.a = i;
        this.b = i2;
        this.c = ua2;
        this.d = interfaceC19114po0;
    }

    public final InterfaceC19114po0 a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final UA2 c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23868xf0)) {
            return false;
        }
        C23868xf0 c23868xf0 = (C23868xf0) obj;
        return this.a == c23868xf0.a && this.b == c23868xf0.b && AbstractC13042fc3.d(this.c, c23868xf0.c) && AbstractC13042fc3.d(this.d, c23868xf0.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "BiometricButtonState(titleRes=" + this.a + ", iconRes=" + this.b + ", onButtonClicked=" + this.c + ", buttonStates=" + this.d + Separators.RPAREN;
    }
}
