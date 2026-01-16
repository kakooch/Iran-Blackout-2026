package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Jy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5578Jy0 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final boolean b;

    public C5578Jy0(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = z;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5578Jy0)) {
            return false;
        }
        C5578Jy0 c5578Jy0 = (C5578Jy0) obj;
        return AbstractC13042fc3.d(this.a, c5578Jy0.a) && this.b == c5578Jy0.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "CallRunning(peer=" + this.a + ", isRunning=" + this.b + Separators.RPAREN;
    }
}
