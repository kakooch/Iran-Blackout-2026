package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.On1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6680On1 {
    private final String a;

    public C6680On1(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C6680On1) && AbstractC13042fc3.d(this.a, ((C6680On1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "CopyText(text=" + this.a + Separators.RPAREN;
    }
}
