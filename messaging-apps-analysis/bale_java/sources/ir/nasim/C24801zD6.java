package ir.nasim;

/* renamed from: ir.nasim.zD6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24801zD6 implements InterfaceC4066Dn6 {
    public static final a f = new a(null);
    private final boolean a;
    private final int b;
    private final int c;
    private final C19701qn6 d;
    private final C8329Vm6 e;

    /* renamed from: ir.nasim.zD6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24801zD6(boolean z, int i, int i2, C19701qn6 c19701qn6, C8329Vm6 c8329Vm6) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = c19701qn6;
        this.e = c8329Vm6;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public boolean a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public C8329Vm6 b() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public C8329Vm6 c() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public int d() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public EnumC5309Iu1 e() {
        return l() < d() ? EnumC5309Iu1.b : l() > d() ? EnumC5309Iu1.a : this.e.d();
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public int f() {
        return 1;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public boolean g(InterfaceC4066Dn6 interfaceC4066Dn6) {
        return (i() != null && interfaceC4066Dn6 != null && (interfaceC4066Dn6 instanceof C24801zD6) && l() == interfaceC4066Dn6.l() && d() == interfaceC4066Dn6.d() && a() == interfaceC4066Dn6.a() && !this.e.m(((C24801zD6) interfaceC4066Dn6).e)) ? false : true;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public C19701qn6 i() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public C8329Vm6 j() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public C8329Vm6 k() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public int l() {
        return this.b;
    }

    public String toString() {
        return "SingleSelectionLayout(isStartHandle=" + a() + ", crossed=" + e() + ", info=\n\t" + this.e + ')';
    }

    @Override // ir.nasim.InterfaceC4066Dn6
    public void h(UA2 ua2) {
    }
}
