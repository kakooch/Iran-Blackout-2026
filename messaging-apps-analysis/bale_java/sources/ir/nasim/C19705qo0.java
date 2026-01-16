package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qo0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19705qo0 {
    private final int a;
    private final InterfaceC19114po0 b;

    public C19705qo0(int i, InterfaceC19114po0 interfaceC19114po0) {
        AbstractC13042fc3.i(interfaceC19114po0, "buttonState");
        this.a = i;
        this.b = interfaceC19114po0;
    }

    public final InterfaceC19114po0 a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19705qo0)) {
            return false;
        }
        C19705qo0 c19705qo0 = (C19705qo0) obj;
        return this.a == c19705qo0.a && AbstractC13042fc3.d(this.b, c19705qo0.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ButtonUiDetail(textResId=" + this.a + ", buttonState=" + this.b + Separators.RPAREN;
    }
}
