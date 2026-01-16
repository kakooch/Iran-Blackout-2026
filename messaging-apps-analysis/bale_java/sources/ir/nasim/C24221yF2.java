package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yF2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24221yF2 implements InterfaceC15283jK {
    private String a;
    private String b;

    public C24221yF2(String str, String str2) {
        AbstractC13042fc3.i(str, "transactionID");
        AbstractC13042fc3.i(str2, "cardId");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24221yF2)) {
            return false;
        }
        C24221yF2 c24221yF2 = (C24221yF2) obj;
        return AbstractC13042fc3.d(this.a, c24221yF2.a) && AbstractC13042fc3.d(this.b, c24221yF2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GetCardInfo(transactionID=" + this.a + ", cardId=" + this.b + Separators.RPAREN;
    }
}
