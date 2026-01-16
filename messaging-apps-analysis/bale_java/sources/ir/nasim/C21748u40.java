package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.u40, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21748u40 {
    private final String a;

    public C21748u40(String str) {
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C21748u40) && AbstractC13042fc3.d(this.a, ((C21748u40) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "BankCardCopied(card=" + this.a + Separators.RPAREN;
    }
}
