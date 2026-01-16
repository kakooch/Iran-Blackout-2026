package ir.nasim;

/* loaded from: classes8.dex */
public final class RJ6 extends AbstractC4166Dy7 {
    private final InterfaceC22882vy7 a;
    private final InterfaceC9173Yu3 b;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke() {
            return SJ6.a(RJ6.this.a);
        }
    }

    public RJ6(InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(interfaceC22882vy7, "typeParameter");
        this.a = interfaceC22882vy7;
        this.b = AbstractC13269fw3.b(EnumC4870Gx3.b, new a());
    }

    private final AbstractC4099Dr3 e() {
        return (AbstractC4099Dr3) this.b.getValue();
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public InterfaceC3932Cy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return this;
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public KQ7 c() {
        return KQ7.OUT_VARIANCE;
    }

    @Override // ir.nasim.InterfaceC3932Cy7
    public AbstractC4099Dr3 getType() {
        return e();
    }
}
