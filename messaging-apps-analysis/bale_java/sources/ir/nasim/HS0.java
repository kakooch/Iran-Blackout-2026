package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes6.dex */
public final class HS0 {
    private final String a;
    private final boolean b;

    public HS0(String str, boolean z) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        this.a = str;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HS0)) {
            return false;
        }
        HS0 hs0 = (HS0) obj;
        return AbstractC13042fc3.d(this.a, hs0.a) && this.b == hs0.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "ChipItem(text=" + this.a + ", isSelected=" + this.b + Separators.RPAREN;
    }
}
