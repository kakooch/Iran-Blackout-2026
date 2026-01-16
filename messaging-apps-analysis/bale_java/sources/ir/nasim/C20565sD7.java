package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20565sD7 extends AbstractC20556sC7 {
    private final SC3 a;

    public C20565sD7(SC3 sc3) {
        super(null);
        this.a = sc3;
    }

    public final SC3 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C20565sD7) && AbstractC13042fc3.d(this.a, ((C20565sD7) obj).a);
    }

    public int hashCode() {
        SC3 sc3 = this.a;
        if (sc3 == null) {
            return 0;
        }
        return sc3.hashCode();
    }

    public String toString() {
        return "UpdateEndLive(info=" + this.a + Separators.RPAREN;
    }
}
