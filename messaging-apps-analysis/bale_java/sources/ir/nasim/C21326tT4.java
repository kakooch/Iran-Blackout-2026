package ir.nasim;

import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.tT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21326tT4 implements InterfaceC17733nT4, InterfaceC11734dW3 {
    private final List a;
    private final int b;
    private final int c;
    private final int d;
    private final EnumC24286yM4 e;
    private final int f;
    private final int g;
    private final boolean h;
    private final int i;
    private final C14806iW3 j;
    private final C14806iW3 k;
    private final float l;
    private final int m;
    private final boolean n;
    private final FG6 o;
    private final InterfaceC11734dW3 p;
    private final boolean q;
    private final List r;
    private final List s;
    private final InterfaceC20315ro1 t;

    public C21326tT4(List list, int i, int i2, int i3, EnumC24286yM4 enumC24286yM4, int i4, int i5, boolean z, int i6, C14806iW3 c14806iW3, C14806iW3 c14806iW32, float f, int i7, boolean z2, FG6 fg6, InterfaceC11734dW3 interfaceC11734dW3, boolean z3, List list2, List list3, InterfaceC20315ro1 interfaceC20315ro1) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = enumC24286yM4;
        this.f = i4;
        this.g = i5;
        this.h = z;
        this.i = i6;
        this.j = c14806iW3;
        this.k = c14806iW32;
        this.l = f;
        this.m = i7;
        this.n = z2;
        this.o = fg6;
        this.p = interfaceC11734dW3;
        this.q = z3;
        this.r = list2;
        this.s = list3;
        this.t = interfaceC20315ro1;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public EnumC24286yM4 a() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public long b() {
        return C4414Fa3.c((getHeight() & 4294967295L) | (getWidth() << 32));
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int c() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int d() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int e() {
        return -f();
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int f() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public boolean g() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getHeight() {
        return this.p.getHeight();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public int getWidth() {
        return this.p.getWidth();
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int h() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public List i() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public void j() {
        this.p.j();
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public UA2 k() {
        return this.p.k();
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int l() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public int m() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC17733nT4
    public FG6 n() {
        return this.o;
    }

    public final C21326tT4 o(int i) {
        int i2;
        int iH = h() + l();
        C21326tT4 c21326tT4 = null;
        if (!this.q && !i().isEmpty() && this.j != null && (i2 = this.m - i) >= 0 && i2 < iH) {
            float f = iH != 0 ? i / iH : 0.0f;
            float f2 = this.l - f;
            if (this.k != null && f2 < 0.5f && f2 > -0.5f) {
                C14806iW3 c14806iW3 = (C14806iW3) AbstractC15401jX0.q0(i());
                C14806iW3 c14806iW32 = (C14806iW3) AbstractC15401jX0.C0(i());
                if (i >= 0 ? Math.min(f() - c14806iW3.getOffset(), d() - c14806iW32.getOffset()) > i : Math.min((c14806iW3.getOffset() + iH) - f(), (c14806iW32.getOffset() + iH) - d()) > (-i)) {
                    List listI = i();
                    int size = listI.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((C14806iW3) listI.get(i3)).a(i);
                    }
                    List list = this.r;
                    int size2 = list.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((C14806iW3) list.get(i4)).a(i);
                    }
                    List list2 = this.s;
                    int size3 = list2.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ((C14806iW3) list2.get(i5)).a(i);
                    }
                    c21326tT4 = new C21326tT4(i(), h(), l(), c(), a(), f(), d(), g(), m(), this.j, this.k, this.l - f, this.m - i, this.n || i > 0, n(), this.p, this.q, this.r, this.s, this.t);
                }
            }
        }
        return c21326tT4;
    }

    public final boolean p() {
        C14806iW3 c14806iW3 = this.j;
        return ((c14806iW3 != null ? c14806iW3.getIndex() : 0) == 0 && this.m == 0) ? false : true;
    }

    public final boolean q() {
        return this.n;
    }

    public final InterfaceC20315ro1 r() {
        return this.t;
    }

    public final C14806iW3 s() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC11734dW3
    public Map t() {
        return this.p.t();
    }

    public final float u() {
        return this.l;
    }

    public final C14806iW3 v() {
        return this.j;
    }

    public final int w() {
        return this.m;
    }

    public /* synthetic */ C21326tT4(List list, int i, int i2, int i3, EnumC24286yM4 enumC24286yM4, int i4, int i5, boolean z, int i6, C14806iW3 c14806iW3, C14806iW3 c14806iW32, float f, int i7, boolean z2, FG6 fg6, InterfaceC11734dW3 interfaceC11734dW3, boolean z3, List list2, List list3, InterfaceC20315ro1 interfaceC20315ro1, int i8, ED1 ed1) {
        this(list, i, i2, i3, enumC24286yM4, i4, i5, z, i6, c14806iW3, c14806iW32, f, i7, z2, fg6, interfaceC11734dW3, z3, (i8 & 131072) != 0 ? AbstractC10360bX0.m() : list2, (i8 & 262144) != 0 ? AbstractC10360bX0.m() : list3, interfaceC20315ro1);
    }
}
