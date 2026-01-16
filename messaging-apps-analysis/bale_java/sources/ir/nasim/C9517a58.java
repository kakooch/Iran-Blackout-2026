package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.a58, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9517a58 {
    private final String a;

    public C9517a58(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9517a58) && AbstractC13042fc3.d(this.a, ((C9517a58) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "WebAppErrorState(errorMessage=" + this.a + Separators.RPAREN;
    }
}
