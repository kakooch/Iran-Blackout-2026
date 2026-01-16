package ir.nasim;

/* renamed from: ir.nasim.Jx3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5572Jx3 extends AbstractC24426yb8 {
    private final ON6 b;
    private final SA2 c;
    private final InterfaceC23016wC4 d;

    /* renamed from: ir.nasim.Jx3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC5284Ir3 e;
        final /* synthetic */ C5572Jx3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC5284Ir3 abstractC5284Ir3, C5572Jx3 c5572Jx3) {
            super(0);
            this.e = abstractC5284Ir3;
            this.f = c5572Jx3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke() {
            return this.e.g((AbstractC4099Dr3) this.f.c.invoke());
        }
    }

    public C5572Jx3(ON6 on6, SA2 sa2) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(sa2, "computation");
        this.b = on6;
        this.c = sa2;
        this.d = on6.c(sa2);
    }

    @Override // ir.nasim.AbstractC24426yb8
    protected AbstractC4099Dr3 O0() {
        return (AbstractC4099Dr3) this.d.invoke();
    }

    @Override // ir.nasim.AbstractC24426yb8
    public boolean P0() {
        return this.d.m();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public C5572Jx3 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new C5572Jx3(this.b, new a(abstractC5284Ir3, this));
    }
}
