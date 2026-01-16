package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Mj3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6147Mj3 implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;
    private final InterfaceC4557Fq2 b;

    public C6147Mj3(C5776Ku0 c5776Ku0, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(c5776Ku0, "callBarPeer");
        AbstractC13042fc3.i(interfaceC4557Fq2, "timerFlow");
        this.a = c5776Ku0;
        this.b = interfaceC4557Fq2;
    }

    public C5776Ku0 a() {
        return this.a;
    }

    public final InterfaceC4557Fq2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6147Mj3)) {
            return false;
        }
        C6147Mj3 c6147Mj3 = (C6147Mj3) obj;
        return AbstractC13042fc3.d(this.a, c6147Mj3.a) && AbstractC13042fc3.d(this.b, c6147Mj3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "JoinedCall(callBarPeer=" + this.a + ", timerFlow=" + this.b + Separators.RPAREN;
    }
}
