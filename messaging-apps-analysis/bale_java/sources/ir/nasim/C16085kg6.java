package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kg6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16085kg6 {
    private final long a;
    private final String b;

    public C16085kg6(long j, String str) {
        AbstractC13042fc3.i(str, "formatedString");
        this.a = j;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16085kg6)) {
            return false;
        }
        C16085kg6 c16085kg6 = (C16085kg6) obj;
        return this.a == c16085kg6.a && AbstractC13042fc3.d(this.b, c16085kg6.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SearchFilterDateItem(date=" + this.a + ", formatedString=" + this.b + Separators.RPAREN;
    }
}
