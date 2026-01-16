package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.lB3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16388lB3 {
    private final int a;
    private final String b;
    private final String c;

    public C16388lB3(int i, String str, String str2) {
        AbstractC13042fc3.i(str, "phone");
        AbstractC13042fc3.i(str2, "displayName");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16388lB3)) {
            return false;
        }
        C16388lB3 c16388lB3 = (C16388lB3) obj;
        return this.a == c16388lB3.a && AbstractC13042fc3.d(this.b, c16388lB3.b) && AbstractC13042fc3.d(this.c, c16388lB3.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "LinkedContactDetails(uid=" + this.a + ", phone=" + this.b + ", displayName=" + this.c + Separators.RPAREN;
    }
}
