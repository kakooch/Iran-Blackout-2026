package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.n43, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17501n43 implements InterfaceC15283jK {
    private final String a;
    private final long b;

    public C17501n43(String str, long j) {
        AbstractC13042fc3.i(str, "name");
        this.a = str;
        this.b = j;
    }

    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17501n43)) {
            return false;
        }
        C17501n43 c17501n43 = (C17501n43) obj;
        return AbstractC13042fc3.d(this.a, c17501n43.a) && this.b == c17501n43.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "ImportSingleContact(name=" + this.a + ", phoneNumber=" + this.b + Separators.RPAREN;
    }
}
