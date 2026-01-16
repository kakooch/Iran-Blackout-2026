package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oF1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C18195oF1 {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;

    public C18195oF1(SA2 sa2, SA2 sa22, SA2 sa23) {
        AbstractC13042fc3.i(sa2, "chatCallBack");
        AbstractC13042fc3.i(sa22, "jaryanCallBack");
        AbstractC13042fc3.i(sa23, "khadamatCallBack");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
    }

    public final SA2 a() {
        return this.a;
    }

    public final SA2 b() {
        return this.b;
    }

    public final SA2 c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18195oF1)) {
            return false;
        }
        C18195oF1 c18195oF1 = (C18195oF1) obj;
        return AbstractC13042fc3.d(this.a, c18195oF1.a) && AbstractC13042fc3.d(this.b, c18195oF1.b) && AbstractC13042fc3.d(this.c, c18195oF1.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DefaultTabCallBack(chatCallBack=" + this.a + ", jaryanCallBack=" + this.b + ", khadamatCallBack=" + this.c + Separators.RPAREN;
    }
}
