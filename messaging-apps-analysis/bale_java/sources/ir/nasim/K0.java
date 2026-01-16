package ir.nasim;

/* loaded from: classes8.dex */
public abstract class K0 extends C22725vj3 implements InterfaceC13730gj3, InterfaceC20295rm1, InterfaceC20315ro1 {
    private final InterfaceC11938do1 c;

    public K0(InterfaceC11938do1 interfaceC11938do1, boolean z, boolean z2) {
        super(z2);
        if (z) {
            A0((InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0));
        }
        this.c = interfaceC11938do1.X(this);
    }

    @Override // ir.nasim.C22725vj3
    public String I0() {
        String strB = AbstractC12551eo1.b(this.c);
        if (strB == null) {
            return super.I0();
        }
        return '\"' + strB + "\":" + super.I0();
    }

    @Override // ir.nasim.C22725vj3
    protected final void N0(Object obj) {
        if (!(obj instanceof B01)) {
            f1(obj);
        } else {
            B01 b01 = (B01) obj;
            e1(b01.a, b01.a());
        }
    }

    @Override // ir.nasim.C22725vj3, ir.nasim.InterfaceC13730gj3
    public boolean b() {
        return super.b();
    }

    protected void d1(Object obj) {
        Q(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C22725vj3
    public String g0() {
        return YA1.a(this) + " was cancelled";
    }

    public final void g1(EnumC23959xo1 enumC23959xo1, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        enumC23959xo1.j(interfaceC14603iB2, obj, this);
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public final InterfaceC11938do1 getContext() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public final void resumeWith(Object obj) {
        Object objG0 = G0(E01.d(obj, null, 1, null));
        if (objG0 == AbstractC23321wj3.b) {
            return;
        }
        d1(objG0);
    }

    @Override // ir.nasim.C22725vj3
    public final void z0(Throwable th) {
        AbstractC16160ko1.a(this.c, th);
    }

    protected void f1(Object obj) {
    }

    protected void e1(Throwable th, boolean z) {
    }
}
