package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C21753u45;

/* loaded from: classes8.dex */
public final class D88 {
    private final C21753u45.g a;
    private final SA2 b;
    private final SA2 c;

    public D88(C21753u45.g gVar, SA2 sa2, SA2 sa22) {
        AbstractC13042fc3.i(gVar, "type");
        AbstractC13042fc3.i(sa2, "onAccepted");
        AbstractC13042fc3.i(sa22, "onRejected");
        this.a = gVar;
        this.b = sa2;
        this.c = sa22;
    }

    public final SA2 a() {
        return this.b;
    }

    public final SA2 b() {
        return this.c;
    }

    public final C21753u45.g c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D88)) {
            return false;
        }
        D88 d88 = (D88) obj;
        return this.a == d88.a && AbstractC13042fc3.d(this.b, d88.b) && AbstractC13042fc3.d(this.c, d88.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "WebViewPermissionRequestState(type=" + this.a + ", onAccepted=" + this.b + ", onRejected=" + this.c + Separators.RPAREN;
    }
}
