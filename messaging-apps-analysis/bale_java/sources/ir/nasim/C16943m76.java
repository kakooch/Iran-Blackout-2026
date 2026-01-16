package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.m76, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16943m76 implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;
    private final int b;

    public C16943m76(C5776Ku0 c5776Ku0, int i) {
        AbstractC13042fc3.i(c5776Ku0, "callBarPeer");
        this.a = c5776Ku0;
        this.b = i;
    }

    public C5776Ku0 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16943m76)) {
            return false;
        }
        C16943m76 c16943m76 = (C16943m76) obj;
        return AbstractC13042fc3.d(this.a, c16943m76.a) && this.b == c16943m76.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "RunningCall(callBarPeer=" + this.a + ", stateTextResourceId=" + this.b + Separators.RPAREN;
    }
}
