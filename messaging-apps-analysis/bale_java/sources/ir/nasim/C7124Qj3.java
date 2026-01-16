package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Qj3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7124Qj3 implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;
    private final InterfaceC4557Fq2 b;

    public C7124Qj3(C5776Ku0 c5776Ku0, InterfaceC4557Fq2 interfaceC4557Fq2) {
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
        if (!(obj instanceof C7124Qj3)) {
            return false;
        }
        C7124Qj3 c7124Qj3 = (C7124Qj3) obj;
        return AbstractC13042fc3.d(this.a, c7124Qj3.a) && AbstractC13042fc3.d(this.b, c7124Qj3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "JoinedInviteCall(callBarPeer=" + this.a + ", timerFlow=" + this.b + Separators.RPAREN;
    }
}
