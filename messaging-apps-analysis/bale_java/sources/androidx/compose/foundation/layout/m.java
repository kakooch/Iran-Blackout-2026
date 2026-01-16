package androidx.compose.foundation.layout;

import ir.nasim.C17833ne1;
import ir.nasim.EnumC11821dc3;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class m extends l {
    private EnumC11821dc3 o;
    private boolean p;

    public m(EnumC11821dc3 enumC11821dc3, boolean z) {
        this.o = enumC11821dc3;
        this.p = z;
    }

    @Override // androidx.compose.foundation.layout.l, ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.o == EnumC11821dc3.a ? interfaceC9236Zb3.i0(i) : interfaceC9236Zb3.k0(i);
    }

    @Override // androidx.compose.foundation.layout.l
    public long v2(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iI0 = this.o == EnumC11821dc3.a ? zv3.i0(C17833ne1.k(j)) : zv3.k0(C17833ne1.k(j));
        if (iI0 < 0) {
            iI0 = 0;
        }
        return C17833ne1.b.e(iI0);
    }

    @Override // androidx.compose.foundation.layout.l
    public boolean w2() {
        return this.p;
    }

    public void x2(boolean z) {
        this.p = z;
    }

    public final void y2(EnumC11821dc3 enumC11821dc3) {
        this.o = enumC11821dc3;
    }

    @Override // androidx.compose.foundation.layout.l, ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.o == EnumC11821dc3.a ? interfaceC9236Zb3.i0(i) : interfaceC9236Zb3.k0(i);
    }
}
