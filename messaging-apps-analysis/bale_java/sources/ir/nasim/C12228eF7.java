package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.eF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12228eF7 extends AbstractC20556sC7 {
    private final String a;
    private final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12228eF7(String str, String str2) {
        super(null);
        AbstractC13042fc3.i(str, "key");
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
        if (!(obj instanceof C12228eF7)) {
            return false;
        }
        C12228eF7 c12228eF7 = (C12228eF7) obj;
        return AbstractC13042fc3.d(this.a, c12228eF7.a) && AbstractC13042fc3.d(this.b, c12228eF7.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateParameterChanged(key=" + this.a + ", value=" + this.b + Separators.RPAREN;
    }
}
