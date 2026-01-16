package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aG6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9619aG6 {
    private final CI3 a;

    public C9619aG6(CI3 ci3) {
        AbstractC13042fc3.i(ci3, "messageState");
        this.a = ci3;
    }

    public final CI3 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9619aG6) && this.a == ((C9619aG6) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SnackBarState(messageState=" + this.a + Separators.RPAREN;
    }
}
