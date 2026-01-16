package androidx.compose.foundation.layout;

import ir.nasim.C17833ne1;
import ir.nasim.EnumC11821dc3;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class j extends l {
    private EnumC11821dc3 o;
    private boolean p;

    public j(EnumC11821dc3 enumC11821dc3, boolean z) {
        this.o = enumC11821dc3;
        this.p = z;
    }

    @Override // androidx.compose.foundation.layout.l, ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.o == EnumC11821dc3.a ? interfaceC9236Zb3.Z(i) : interfaceC9236Zb3.z(i);
    }

    @Override // androidx.compose.foundation.layout.l, ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return this.o == EnumC11821dc3.a ? interfaceC9236Zb3.Z(i) : interfaceC9236Zb3.z(i);
    }

    @Override // androidx.compose.foundation.layout.l
    public long v2(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iZ = this.o == EnumC11821dc3.a ? zv3.Z(C17833ne1.l(j)) : zv3.z(C17833ne1.l(j));
        if (iZ < 0) {
            iZ = 0;
        }
        return C17833ne1.b.d(iZ);
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
}
