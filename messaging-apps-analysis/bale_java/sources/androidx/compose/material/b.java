package androidx.compose.material;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.C17784nZ1;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.JG1;
import ir.nasim.VX0;

/* loaded from: classes.dex */
final class b implements InterfaceC17521n63 {
    private final boolean a;
    private final float b;
    private final VX0 c;
    private final long d;

    static final class a implements VX0 {
        a() {
        }

        @Override // ir.nasim.VX0
        public final long a() {
            return b.this.d;
        }
    }

    public /* synthetic */ b(boolean z, float f, long j, ED1 ed1) {
        this(z, f, j);
    }

    @Override // ir.nasim.InterfaceC17521n63
    public JG1 b(InterfaceC23241wb3 interfaceC23241wb3) {
        VX0 aVar = this.c;
        if (aVar == null) {
            aVar = new a();
        }
        return new DelegatingThemeAwareRippleNode(interfaceC23241wb3, this.a, this.b, aVar, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a == bVar.a && C17784nZ1.s(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c)) {
            return C24381yX0.q(this.d, bVar.d);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC17521n63
    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.a) * 31) + C17784nZ1.t(this.b)) * 31;
        VX0 vx0 = this.c;
        return ((iHashCode + (vx0 != null ? vx0.hashCode() : 0)) * 31) + C24381yX0.w(this.d);
    }

    private b(boolean z, float f, VX0 vx0, long j) {
        this.a = z;
        this.b = f;
        this.c = vx0;
        this.d = j;
    }

    private b(boolean z, float f, long j) {
        this(z, f, (VX0) null, j);
    }
}
