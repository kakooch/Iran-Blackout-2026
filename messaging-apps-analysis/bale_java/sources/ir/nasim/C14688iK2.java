package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iK2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14688iK2 implements InterfaceC15283jK {
    private int a;
    private String b;

    public C14688iK2(int i, String str) {
        AbstractC13042fc3.i(str, "key");
        this.a = i;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14688iK2)) {
            return false;
        }
        C14688iK2 c14688iK2 = (C14688iK2) obj;
        return this.a == c14688iK2.a && AbstractC13042fc3.d(this.b, c14688iK2.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GrantBotBankiAccess(peer=" + this.a + ", key=" + this.b + Separators.RPAREN;
    }
}
