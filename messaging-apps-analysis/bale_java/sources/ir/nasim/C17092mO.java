package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mO, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17092mO {
    private final VL a;
    private final C22505vM b;

    public C17092mO(VL vl, C22505vM c22505vM) {
        this.a = vl;
        this.b = c22505vM;
    }

    public final C22505vM a() {
        return this.b;
    }

    public final VL b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17092mO)) {
            return false;
        }
        C17092mO c17092mO = (C17092mO) obj;
        return AbstractC13042fc3.d(this.a, c17092mO.a) && AbstractC13042fc3.d(this.b, c17092mO.b);
    }

    public int hashCode() {
        VL vl = this.a;
        int iHashCode = (vl == null ? 0 : vl.hashCode()) * 31;
        C22505vM c22505vM = this.b;
        return iHashCode + (c22505vM != null ? c22505vM.hashCode() : 0);
    }

    public String toString() {
        return "AudioPlayerBarState(currentAudio=" + this.a + ", audioBarState=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C17092mO(VL vl, C22505vM c22505vM, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : vl, (i & 2) != 0 ? null : c22505vM);
    }
}
