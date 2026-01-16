package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12847fH {
    private final String a;
    private final String b;

    public C12847fH(String str, String str2) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, "title");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12847fH)) {
            return false;
        }
        C12847fH c12847fH = (C12847fH) obj;
        return AbstractC13042fc3.d(this.a, c12847fH.a) && AbstractC13042fc3.d(this.b, c12847fH.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ArbaeenMobileItem(id=" + this.a + ", title=" + this.b + Separators.RPAREN;
    }
}
