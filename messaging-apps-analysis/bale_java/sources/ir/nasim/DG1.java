package ir.nasim;

/* loaded from: classes8.dex */
public final class DG1 extends TG1 implements InterfaceC4385Ex1, EG1 {
    public static final a d = new a(null);
    private final XC6 b;
    private final boolean c;

    public static final class a {
        private a() {
        }

        private final boolean a(AbstractC18174oC7 abstractC18174oC7) {
            abstractC18174oC7.K0();
            return (abstractC18174oC7.K0().t() instanceof InterfaceC22882vy7) || (abstractC18174oC7 instanceof C24002xs4);
        }

        private final boolean c(AbstractC18174oC7 abstractC18174oC7, boolean z) {
            if (a(abstractC18174oC7)) {
                return (z && (abstractC18174oC7.K0().t() instanceof InterfaceC22882vy7)) ? AbstractC7497Ry7.l(abstractC18174oC7) : !C13452gF4.a.a(abstractC18174oC7);
            }
            return false;
        }

        public final DG1 b(AbstractC18174oC7 abstractC18174oC7, boolean z) {
            AbstractC13042fc3.i(abstractC18174oC7, "type");
            if (abstractC18174oC7 instanceof DG1) {
                return (DG1) abstractC18174oC7;
            }
            ED1 ed1 = null;
            if (!c(abstractC18174oC7, z)) {
                return null;
            }
            if (abstractC18174oC7 instanceof AbstractC6200Mp2) {
                AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7;
                AbstractC13042fc3.d(abstractC6200Mp2.S0().K0(), abstractC6200Mp2.T0().K0());
            }
            return new DG1(AbstractC7411Rp2.c(abstractC18174oC7), z, ed1);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ DG1(XC6 xc6, boolean z, ED1 ed1) {
        this(xc6, z);
    }

    @Override // ir.nasim.TG1, ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public AbstractC4099Dr3 M(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "replacement");
        return AbstractC24252yI6.e(abstractC4099Dr3.N0(), this.c);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return z ? T0().O0(z) : this;
    }

    @Override // ir.nasim.TG1
    protected XC6 T0() {
        return this.b;
    }

    public final XC6 W0() {
        return this.b;
    }

    @Override // ir.nasim.XC6
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public DG1 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new DG1(T0().Q0(interfaceC4356Eu), this.c);
    }

    @Override // ir.nasim.TG1
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public DG1 V0(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        return new DG1(xc6, this.c);
    }

    @Override // ir.nasim.XC6
    public String toString() {
        return T0() + "!!";
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public boolean x() {
        T0().K0();
        return T0().K0().t() instanceof InterfaceC22882vy7;
    }

    private DG1(XC6 xc6, boolean z) {
        this.b = xc6;
        this.c = z;
    }
}
