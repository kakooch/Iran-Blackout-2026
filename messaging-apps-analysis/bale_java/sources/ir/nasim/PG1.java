package ir.nasim;

/* loaded from: classes8.dex */
public abstract class PG1 extends AbstractC5117Hy7 {
    private final AbstractC5117Hy7 c;

    public PG1(AbstractC5117Hy7 abstractC5117Hy7) {
        AbstractC13042fc3.i(abstractC5117Hy7, "substitution");
        this.c = abstractC5117Hy7;
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean a() {
        return this.c.a();
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC4356Eu d(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        return this.c.d(interfaceC4356Eu);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "key");
        return this.c.e(abstractC4099Dr3);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean f() {
        return this.c.f();
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public AbstractC4099Dr3 g(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7) {
        AbstractC13042fc3.i(abstractC4099Dr3, "topLevelType");
        AbstractC13042fc3.i(kq7, "position");
        return this.c.g(abstractC4099Dr3, kq7);
    }
}
