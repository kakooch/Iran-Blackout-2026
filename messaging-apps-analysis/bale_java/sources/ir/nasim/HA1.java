package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class HA1 {
    private final InterfaceC13346g43 a;
    private final InterfaceC13346g43 b;
    private final InterfaceC13346g43 c;
    private final int d;
    private final int e;
    private final int f;

    public HA1(InterfaceC13346g43 interfaceC13346g43, InterfaceC13346g43 interfaceC13346g432, InterfaceC13346g43 interfaceC13346g433, int i, int i2, int i3) {
        AbstractC13042fc3.i(interfaceC13346g43, "yearItems");
        AbstractC13042fc3.i(interfaceC13346g432, "monthNames");
        AbstractC13042fc3.i(interfaceC13346g433, "days");
        this.a = interfaceC13346g43;
        this.b = interfaceC13346g432;
        this.c = interfaceC13346g433;
        this.d = i;
        this.e = i2;
        this.f = i3;
    }

    public final InterfaceC13346g43 a() {
        return this.c;
    }

    public final InterfaceC13346g43 b() {
        return this.b;
    }

    public final int c() {
        return this.f;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HA1)) {
            return false;
        }
        HA1 ha1 = (HA1) obj;
        return AbstractC13042fc3.d(this.a, ha1.a) && AbstractC13042fc3.d(this.b, ha1.b) && AbstractC13042fc3.d(this.c, ha1.c) && this.d == ha1.d && this.e == ha1.e && this.f == ha1.f;
    }

    public final InterfaceC13346g43 f() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "DatePickerState(yearItems=" + this.a + ", monthNames=" + this.b + ", days=" + this.c + ", startSelectedYear=" + this.d + ", startSelectedMonth=" + this.e + ", startSelectedDay=" + this.f + Separators.RPAREN;
    }
}
