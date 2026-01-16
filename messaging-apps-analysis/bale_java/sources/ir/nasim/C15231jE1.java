package ir.nasim;

/* renamed from: ir.nasim.jE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15231jE1 implements ZV3 {
    private final InterfaceC9236Zb3 a;
    private final EnumC11026cc3 b;
    private final EnumC12433ec3 c;

    public C15231jE1(InterfaceC9236Zb3 interfaceC9236Zb3, EnumC11026cc3 enumC11026cc3, EnumC12433ec3 enumC12433ec3) {
        this.a = interfaceC9236Zb3;
        this.b = enumC11026cc3;
        this.c = enumC12433ec3;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int Z(int i) {
        return this.a.Z(i);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public Object h() {
        return this.a.h();
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int i0(int i) {
        return this.a.i0(i);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int k0(int i) {
        return this.a.k0(i);
    }

    @Override // ir.nasim.ZV3
    public AbstractC21430te5 l0(long j) {
        if (this.c == EnumC12433ec3.a) {
            return new C19717qp2(this.b == EnumC11026cc3.b ? this.a.k0(C17833ne1.k(j)) : this.a.i0(C17833ne1.k(j)), C17833ne1.g(j) ? C17833ne1.k(j) : 32767);
        }
        return new C19717qp2(C17833ne1.h(j) ? C17833ne1.l(j) : 32767, this.b == EnumC11026cc3.b ? this.a.z(C17833ne1.l(j)) : this.a.Z(C17833ne1.l(j)));
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int z(int i) {
        return this.a.z(i);
    }
}
