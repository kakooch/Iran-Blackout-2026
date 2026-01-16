package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.q35, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19266q35 implements InterfaceC6009Lu0 {
    private final C5776Ku0 a;
    private final int b;

    public C19266q35(C5776Ku0 c5776Ku0, int i) {
        AbstractC13042fc3.i(c5776Ku0, "callBarPeer");
        this.a = c5776Ku0;
        this.b = i;
    }

    public C5776Ku0 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19266q35)) {
            return false;
        }
        C19266q35 c19266q35 = (C19266q35) obj;
        return AbstractC13042fc3.d(this.a, c19266q35.a) && this.b == c19266q35.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "PendingCall(callBarPeer=" + this.a + ", stateTextResourceId=" + this.b + Separators.RPAREN;
    }
}
