package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.dA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11536dA3 implements InterfaceC10156bA3 {
    private final ExPeer a;

    public C11536dA3(ExPeer exPeer) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        this.a = exPeer;
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public Object a(Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        C18987pb3.x1(C18987pb3.a, new C11458d25(c()), null, null, false, null, null, false, null, null, z, null, 1520, null);
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
        return (obj instanceof C11536dA3) && AbstractC13042fc3.d(this.a, ((C11536dA3) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "OpenConversation(exPeer=" + this.a + Separators.RPAREN;
    }
}
