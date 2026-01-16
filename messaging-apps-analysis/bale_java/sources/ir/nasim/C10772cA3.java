package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.cA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10772cA3 implements InterfaceC10156bA3 {
    private final ExPeer a;
    private final String b;

    /* renamed from: ir.nasim.cA3$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C10772cA3.this.a(null, false, this);
        }
    }

    public C10772cA3(ExPeer exPeer, String str) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "token");
        this.a = exPeer;
        this.b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC10156bA3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(android.content.Context r19, boolean r20, ir.nasim.InterfaceC20295rm1 r21) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10772cA3.a(android.content.Context, boolean, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public ExPeer c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10772cA3)) {
            return false;
        }
        C10772cA3 c10772cA3 = (C10772cA3) obj;
        return AbstractC13042fc3.d(this.a, c10772cA3.a) && AbstractC13042fc3.d(this.b, c10772cA3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Join(exPeer=" + this.a + ", token=" + this.b + Separators.RPAREN;
    }
}
