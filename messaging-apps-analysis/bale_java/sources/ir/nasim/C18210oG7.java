package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18210oG7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18210oG7(int i, String str) {
        super(null);
        AbstractC13042fc3.i(str, "name");
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
        if (!(obj instanceof C18210oG7)) {
            return false;
        }
        C18210oG7 c18210oG7 = (C18210oG7) obj;
        return this.a == c18210oG7.a && AbstractC13042fc3.d(this.b, c18210oG7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateUserNameChanged(uid=" + this.a + ", name=" + this.b + Separators.RPAREN;
    }
}
