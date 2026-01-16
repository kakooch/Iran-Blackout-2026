package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.pv2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19186pv2 {
    private final InterfaceC14603iB2 a;
    private final InterfaceC14603iB2 b;

    public C19186pv2(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
        AbstractC13042fc3.i(interfaceC14603iB2, "datePickerRequested");
        AbstractC13042fc3.i(interfaceC14603iB22, "onfieldChanged");
        this.a = interfaceC14603iB2;
        this.b = interfaceC14603iB22;
    }

    public final InterfaceC14603iB2 a() {
        return this.a;
    }

    public final InterfaceC14603iB2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19186pv2)) {
            return false;
        }
        C19186pv2 c19186pv2 = (C19186pv2) obj;
        return AbstractC13042fc3.d(this.a, c19186pv2.a) && AbstractC13042fc3.d(this.b, c19186pv2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FormCallBack(datePickerRequested=" + this.a + ", onfieldChanged=" + this.b + Separators.RPAREN;
    }
}
