package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Pd3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6826Pd3 implements InterfaceC9449Zz0 {
    private final long a;

    public C6826Pd3(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C6826Pd3) && this.a == ((C6826Pd3) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "InviteCallEnded(callId=" + this.a + Separators.RPAREN;
    }
}
