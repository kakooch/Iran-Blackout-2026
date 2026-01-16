package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20751sY4 {
    private final String a;

    public C20751sY4(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C20751sY4) && AbstractC13042fc3.d(this.a, ((C20751sY4) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "PassportMainCloseState(url=" + this.a + Separators.RPAREN;
    }
}
