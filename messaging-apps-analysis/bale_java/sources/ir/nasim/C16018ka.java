package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ka, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16018ka {
    private final String a;

    public C16018ka(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C16018ka) && AbstractC13042fc3.d(this.a, ((C16018ka) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "AdditionalMetaData(baleRamzToken=" + this.a + Separators.RPAREN;
    }
}
