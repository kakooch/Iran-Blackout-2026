package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mL6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17072mL6 {
    private final XK6 a;
    private final QV b;

    public C17072mL6(XK6 xk6, QV qv) {
        AbstractC13042fc3.i(xk6, "newState");
        AbstractC13042fc3.i(qv, "newBBR2OptimizerProfile");
        this.a = xk6;
        this.b = qv;
    }

    public final XK6 a() {
        return this.a;
    }

    public final QV b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17072mL6)) {
            return false;
        }
        C17072mL6 c17072mL6 = (C17072mL6) obj;
        return AbstractC13042fc3.d(this.a, c17072mL6.a) && AbstractC13042fc3.d(this.b, c17072mL6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StateResult(newState=" + this.a + ", newBBR2OptimizerProfile=" + this.b + Separators.RPAREN;
    }
}
