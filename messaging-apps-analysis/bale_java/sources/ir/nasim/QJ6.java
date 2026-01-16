package ir.nasim;

/* loaded from: classes8.dex */
public final class QJ6 extends AbstractC4166Dy7 {
    private final AbstractC4099Dr3 a;

    public QJ6(AbstractC19738qr3 abstractC19738qr3) {
        AbstractC13042fc3.i(abstractC19738qr3, "kotlinBuiltIns");
        XC6 xc6I = abstractC19738qr3.I();
        AbstractC13042fc3.h(xc6I, "kotlinBuiltIns.nullableAnyType");
        this.a = xc6I;
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
        return this.a;
    }
}
