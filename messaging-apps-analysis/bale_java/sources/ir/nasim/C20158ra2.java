package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ra2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20158ra2 {
    private final InterfaceC14603iB2 a;
    private final InterfaceC14603iB2 b;
    private final InterfaceC14603iB2 c;

    public C20158ra2(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23) {
        AbstractC13042fc3.i(interfaceC14603iB2, "provideBackgroundOverlayColor");
        AbstractC13042fc3.i(interfaceC14603iB22, "provideSketchColor");
        AbstractC13042fc3.i(interfaceC14603iB23, "provideButtonColor");
        this.a = interfaceC14603iB2;
        this.b = interfaceC14603iB22;
        this.c = interfaceC14603iB23;
    }

    public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-2034939296);
        long jR = G10.a.a(interfaceC22053ub1, G10.b).r();
        interfaceC22053ub1.Q();
        return jR;
    }

    public final long b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1889468034);
        long jY = ((C24381yX0) this.a.invoke(interfaceC22053ub1, 0)).y();
        interfaceC22053ub1.Q();
        return jY;
    }

    public final long c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1085701080);
        long jY = ((C24381yX0) this.c.invoke(interfaceC22053ub1, 0)).y();
        interfaceC22053ub1.Q();
        return jY;
    }

    public final long d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1333430114);
        long jF = G10.a.a(interfaceC22053ub1, G10.b).F();
        interfaceC22053ub1.Q();
        return jF;
    }

    public final long e(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(266904164);
        long jY = ((C24381yX0) this.b.invoke(interfaceC22053ub1, 0)).y();
        interfaceC22053ub1.Q();
        return jY;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20158ra2)) {
            return false;
        }
        C20158ra2 c20158ra2 = (C20158ra2) obj;
        return AbstractC13042fc3.d(this.a, c20158ra2.a) && AbstractC13042fc3.d(this.b, c20158ra2.b) && AbstractC13042fc3.d(this.c, c20158ra2.c);
    }

    public final long f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(463369122);
        long jF = G10.a.a(interfaceC22053ub1, G10.b).F();
        interfaceC22053ub1.Q();
        return jF;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "EventBarColors(provideBackgroundOverlayColor=" + this.a + ", provideSketchColor=" + this.b + ", provideButtonColor=" + this.c + Separators.RPAREN;
    }
}
