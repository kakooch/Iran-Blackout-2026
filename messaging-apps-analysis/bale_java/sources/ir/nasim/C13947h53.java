package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.h53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13947h53 implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;
    private final InterfaceC4557Fq2 b;

    public C13947h53(C5776Ku0 c5776Ku0, InterfaceC4557Fq2 interfaceC4557Fq2) {
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
        if (!(obj instanceof C13947h53)) {
            return false;
        }
        C13947h53 c13947h53 = (C13947h53) obj;
        return AbstractC13042fc3.d(this.a, c13947h53.a) && AbstractC13042fc3.d(this.b, c13947h53.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "InCall(callBarPeer=" + this.a + ", timerFlow=" + this.b + Separators.RPAREN;
    }
}
