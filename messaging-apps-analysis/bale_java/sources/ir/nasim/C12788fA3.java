package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.fA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12788fA3 implements InterfaceC10156bA3 {
    private final ExPeer a;
    private final long b;
    private final long c;

    public C12788fA3(ExPeer exPeer, long j, long j2) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        this.a = exPeer;
        this.b = j;
        this.c = j2;
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public Object a(Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        C18987pb3.x1(C18987pb3.a, new C11458d25(c()), AbstractC6392Nk0.e(this.b), AbstractC6392Nk0.e(this.c), true, null, null, false, null, null, z, null, 1520, null);
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public ExPeer c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12788fA3)) {
            return false;
        }
        C12788fA3 c12788fA3 = (C12788fA3) obj;
        return AbstractC13042fc3.d(this.a, c12788fA3.a) && this.b == c12788fA3.b && this.c == c12788fA3.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "OpenPost(exPeer=" + this.a + ", rId=" + this.b + ", date=" + this.c + Separators.RPAREN;
    }
}
