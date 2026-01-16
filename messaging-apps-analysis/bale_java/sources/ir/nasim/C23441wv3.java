package ir.nasim;

import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.wv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23441wv3 implements InterfaceC21665tv3, InterfaceC11734dW3 {
    private final C25215zv3 a;
    private final int b;
    private final boolean c;
    private final float d;
    private final InterfaceC11734dW3 e;
    private final float f;
    private final boolean g;
    private final InterfaceC20315ro1 h;
    private final WH1 i;
    private final int j;
    private final UA2 k;
    private final List l;
    private final int m;
    private final int n;
    private final int o;
    private final boolean p;
    private final EnumC24286yM4 q;
    private final int r;
    private final int s;

    public C23441wv3(C25215zv3 c25215zv3, int i, boolean z, float f, InterfaceC11734dW3 interfaceC11734dW3, float f2, boolean z2, InterfaceC20315ro1 interfaceC20315ro1, WH1 wh1, int i2, UA2 ua2, List list, int i3, int i4, int i5, boolean z3, EnumC24286yM4 enumC24286yM4, int i6, int i7) {
        this.a = c25215zv3;
        this.b = i;
        this.c = z;
        this.d = f;
        this.e = interfaceC11734dW3;
        this.f = f2;
        this.g = z2;
        this.h = interfaceC20315ro1;
        this.i = wh1;
        this.j = i2;
        this.k = ua2;
        this.l = list;
        this.m = i3;
        this.n = i4;
        this.o = i5;
        this.p = z3;
        this.q = enumC24286yM4;
        this.r = i6;
        this.s = i7;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public EnumC24286yM4 a() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public long b() {
        return C4414Fa3.c((getHeight() & 4294967295L) | (getWidth() << 32));
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int c() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int d() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int e() {
        return -f();
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int f() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int g() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getHeight() {
        return this.e.getHeight();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getWidth() {
        return this.e.getWidth();
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public int h() {
        return this.s;
    }

    @Override // ir.nasim.InterfaceC21665tv3
    public List i() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public void j() {
        this.e.j();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public UA2 k() {
        return this.e.k();
    }

    public final C23441wv3 l(int i, boolean z) {
        C25215zv3 c25215zv3;
        if (this.g || i().isEmpty() || (c25215zv3 = this.a) == null) {
            return null;
        }
        int iD = c25215zv3.d();
        int i2 = this.b - i;
        if (i2 < 0 || i2 >= iD) {
            return null;
        }
        C24031xv3 c24031xv3 = (C24031xv3) AbstractC15401jX0.q0(i());
        C24031xv3 c24031xv32 = (C24031xv3) AbstractC15401jX0.C0(i());
        if (c24031xv3.h() || c24031xv32.h()) {
            return null;
        }
        if (i < 0) {
            if (Math.min((AbstractC5320Iv3.b(c24031xv3, a()) + c24031xv3.k()) - f(), (AbstractC5320Iv3.b(c24031xv32, a()) + c24031xv32.k()) - d()) <= (-i)) {
                return null;
            }
        } else if (Math.min(f() - AbstractC5320Iv3.b(c24031xv3, a()), d() - AbstractC5320Iv3.b(c24031xv32, a())) <= i) {
            return null;
        }
        List listI = i();
        int size = listI.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C24031xv3) listI.get(i3)).p(i, z);
        }
        return new C23441wv3(this.a, this.b - i, this.c || i > 0, i, this.e, this.f, this.g, this.h, this.i, this.j, this.k, i(), f(), d(), g(), v(), a(), c(), h());
    }

    public final boolean m() {
        C25215zv3 c25215zv3 = this.a;
        return ((c25215zv3 != null ? c25215zv3.a() : 0) == 0 && this.b == 0) ? false : true;
    }

    public final boolean n() {
        return this.c;
    }

    public final float o() {
        return this.d;
    }

    public final InterfaceC20315ro1 p() {
        return this.h;
    }

    public final WH1 q() {
        return this.i;
    }

    public final C25215zv3 r() {
        return this.a;
    }

    public final int s() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public Map t() {
        return this.e.t();
    }

    public final UA2 u() {
        return this.k;
    }

    public boolean v() {
        return this.p;
    }

    public final float w() {
        return this.f;
    }
}
