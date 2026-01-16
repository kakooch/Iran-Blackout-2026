package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yU, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24353yU implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;

    public C24353yU(C5776Ku0 c5776Ku0) {
        AbstractC13042fc3.i(c5776Ku0, "callBarPeer");
        this.a = c5776Ku0;
    }

    public C5776Ku0 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24353yU) && AbstractC13042fc3.d(this.a, ((C24353yU) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AvailableCall(callBarPeer=" + this.a + Separators.RPAREN;
    }
}
