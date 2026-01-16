package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class A14 {
    private final long a;
    private final String b;
    private final String c;
    private final String d;
    private final ir.nasim.core.modules.banking.l e;

    public A14(long j, String str, String str2, String str3, ir.nasim.core.modules.banking.l lVar) {
        AbstractC13042fc3.i(str, "refundType");
        AbstractC13042fc3.i(str2, "refundNumber");
        AbstractC13042fc3.i(str3, "refundFullName");
        AbstractC13042fc3.i(lVar, "bankCard");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = lVar;
    }

    public final long a() {
        return this.a;
    }

    public final ir.nasim.core.modules.banking.l b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A14)) {
            return false;
        }
        A14 a14 = (A14) obj;
        return this.a == a14.a && AbstractC13042fc3.d(this.b, a14.b) && AbstractC13042fc3.d(this.c, a14.c) && AbstractC13042fc3.d(this.d, a14.d) && AbstractC13042fc3.d(this.e, a14.e);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "MelliLoanResponseEntity(amount=" + this.a + ", refundType=" + this.b + ", refundNumber=" + this.c + ", refundFullName=" + this.d + ", bankCard=" + this.e + Separators.RPAREN;
    }
}
