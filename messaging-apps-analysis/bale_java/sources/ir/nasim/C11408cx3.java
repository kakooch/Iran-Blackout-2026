package ir.nasim;

import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.cx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11408cx3 implements InterfaceC9425Zw3, InterfaceC11734dW3 {
    private final C12051dx3 a;
    private final int b;
    private final boolean c;
    private final float d;
    private final InterfaceC11734dW3 e;
    private final float f;
    private final boolean g;
    private final InterfaceC20315ro1 h;
    private final WH1 i;
    private final long j;
    private final List k;
    private final int l;
    private final int m;
    private final int n;
    private final boolean o;
    private final EnumC24286yM4 p;
    private final int q;
    private final int r;

    public /* synthetic */ C11408cx3(C12051dx3 c12051dx3, int i, boolean z, float f, InterfaceC11734dW3 interfaceC11734dW3, float f2, boolean z2, InterfaceC20315ro1 interfaceC20315ro1, WH1 wh1, long j, List list, int i2, int i3, int i4, boolean z3, EnumC24286yM4 enumC24286yM4, int i5, int i6, ED1 ed1) {
        this(c12051dx3, i, z, f, interfaceC11734dW3, f2, z2, interfaceC20315ro1, wh1, j, list, i2, i3, i4, z3, enumC24286yM4, i5, i6);
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public EnumC24286yM4 a() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public long b() {
        return C4414Fa3.c((getHeight() & 4294967295L) | (getWidth() << 32));
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int c() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int d() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int e() {
        return -f();
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int f() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int g() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getHeight() {
        return this.e.getHeight();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getWidth() {
        return this.e.getWidth();
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public int h() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC9425Zw3
    public List i() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public void j() {
        this.e.j();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public UA2 k() {
        return this.e.k();
    }

    public final C11408cx3 l(int i, boolean z) {
        C12051dx3 c12051dx3;
        C11408cx3 c11408cx3 = null;
        if (!this.g && !i().isEmpty() && (c12051dx3 = this.a) != null) {
            int iK = c12051dx3.k();
            int i2 = this.b - i;
            if (i2 >= 0 && i2 < iK) {
                C12051dx3 c12051dx32 = (C12051dx3) AbstractC15401jX0.q0(i());
                C12051dx3 c12051dx33 = (C12051dx3) AbstractC15401jX0.C0(i());
                if (!c12051dx32.h() && !c12051dx33.h() && (i >= 0 ? Math.min(f() - c12051dx32.getOffset(), d() - c12051dx33.getOffset()) > i : Math.min((c12051dx32.getOffset() + c12051dx32.k()) - f(), (c12051dx33.getOffset() + c12051dx33.k()) - d()) > (-i))) {
                    List listI = i();
                    int size = listI.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((C12051dx3) listI.get(i3)).a(i, z);
                    }
                    c11408cx3 = new C11408cx3(this.a, this.b - i, this.c || i > 0, i, this.e, this.f, this.g, this.h, this.i, this.j, i(), f(), d(), g(), v(), a(), c(), h(), null);
                }
            }
        }
        return c11408cx3;
    }

    public final boolean m() {
        C12051dx3 c12051dx3 = this.a;
        return ((c12051dx3 != null ? c12051dx3.getIndex() : 0) == 0 && this.b == 0) ? false : true;
    }

    public final boolean n() {
        return this.c;
    }

    public final long o() {
        return this.j;
    }

    public final float p() {
        return this.d;
    }

    public final InterfaceC20315ro1 q() {
        return this.h;
    }

    public final WH1 r() {
        return this.i;
    }

    public final C12051dx3 s() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public Map t() {
        return this.e.t();
    }

    public final int u() {
        return this.b;
    }

    public boolean v() {
        return this.o;
    }

    public final float w() {
        return this.f;
    }

    private C11408cx3(C12051dx3 c12051dx3, int i, boolean z, float f, InterfaceC11734dW3 interfaceC11734dW3, float f2, boolean z2, InterfaceC20315ro1 interfaceC20315ro1, WH1 wh1, long j, List list, int i2, int i3, int i4, boolean z3, EnumC24286yM4 enumC24286yM4, int i5, int i6) {
        this.a = c12051dx3;
        this.b = i;
        this.c = z;
        this.d = f;
        this.e = interfaceC11734dW3;
        this.f = f2;
        this.g = z2;
        this.h = interfaceC20315ro1;
        this.i = wh1;
        this.j = j;
        this.k = list;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = z3;
        this.p = enumC24286yM4;
        this.q = i5;
        this.r = i6;
    }
}
