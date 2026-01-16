package ir.nasim;

/* loaded from: classes2.dex */
public final class MK3 implements LK3 {
    private final InterfaceC22299v01 a = AbstractC23485x01.c(null, 1, null);
    private final InterfaceC9102Ym4 b = AbstractC13472gH6.d(null, null, 2, null);
    private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(null, null, 2, null);
    private final InterfaceC9664aL6 d = AbstractC10222bH6.d(new c());
    private final InterfaceC9664aL6 e = AbstractC10222bH6.d(new a());
    private final InterfaceC9664aL6 f = AbstractC10222bH6.d(new b());
    private final InterfaceC9664aL6 g = AbstractC10222bH6.d(new d());

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf((MK3.this.getValue() == null && MK3.this.j() == null) ? false : true);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(MK3.this.j() != null);
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(MK3.this.getValue() == null && MK3.this.j() == null);
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(MK3.this.getValue() != null);
        }
    }

    private void C(Throwable th) {
        this.c.setValue(th);
    }

    private void D(C23677xK3 c23677xK3) {
        this.b.setValue(c23677xK3);
    }

    public boolean A() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public boolean B() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final synchronized void f(C23677xK3 c23677xK3) {
        AbstractC13042fc3.i(c23677xK3, "composition");
        if (A()) {
            return;
        }
        D(c23677xK3);
        this.a.U(c23677xK3);
    }

    public final synchronized void i(Throwable th) {
        AbstractC13042fc3.i(th, "error");
        if (A()) {
            return;
        }
        C(th);
        this.a.e(th);
    }

    public Throwable j() {
        return (Throwable) this.c.getValue();
    }

    @Override // ir.nasim.InterfaceC9664aL6
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C23677xK3 getValue() {
        return (C23677xK3) this.b.getValue();
    }
}
