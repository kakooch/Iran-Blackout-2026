package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.xs4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24002xs4 extends XC6 implements InterfaceC19385qG0 {
    private final EnumC15839kG0 b;
    private final C24592ys4 c;
    private final AbstractC18174oC7 d;
    private final InterfaceC4356Eu e;
    private final boolean f;
    private final boolean g;

    public /* synthetic */ C24002xs4(EnumC15839kG0 enumC15839kG0, C24592ys4 c24592ys4, AbstractC18174oC7 abstractC18174oC7, InterfaceC4356Eu interfaceC4356Eu, boolean z, boolean z2, int i, ED1 ed1) {
        this(enumC15839kG0, c24592ys4, abstractC18174oC7, (i & 8) != 0 ? InterfaceC4356Eu.W.b() : interfaceC4356Eu, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return this.f;
    }

    public final EnumC15839kG0 T0() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C24592ys4 K0() {
        return this.c;
    }

    public final AbstractC18174oC7 V0() {
        return this.d;
    }

    public final boolean W0() {
        return this.g;
    }

    @Override // ir.nasim.XC6
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public C24002xs4 O0(boolean z) {
        return new C24002xs4(this.b, K0(), this.d, getAnnotations(), z, false, 32, null);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public C24002xs4 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        EnumC15839kG0 enumC15839kG0 = this.b;
        C24592ys4 c24592ys4J = K0().a(abstractC5284Ir3);
        AbstractC18174oC7 abstractC18174oC7 = this.d;
        return new C24002xs4(enumC15839kG0, c24592ys4J, abstractC18174oC7 == null ? null : abstractC5284Ir3.g(abstractC18174oC7).N0(), getAnnotations(), L0(), false, 32, null);
    }

    @Override // ir.nasim.XC6
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public C24002xs4 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new C24002xs4(this.b, K0(), this.d, interfaceC4356Eu, L0(), false, 32, null);
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        W24 w24I = AbstractC14230ha2.i("No member resolution should be done on captured type!", true);
        AbstractC13042fc3.h(w24I, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return w24I;
    }

    public C24002xs4(EnumC15839kG0 enumC15839kG0, C24592ys4 c24592ys4, AbstractC18174oC7 abstractC18174oC7, InterfaceC4356Eu interfaceC4356Eu, boolean z, boolean z2) {
        AbstractC13042fc3.i(enumC15839kG0, "captureStatus");
        AbstractC13042fc3.i(c24592ys4, "constructor");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        this.b = enumC15839kG0;
        this.c = c24592ys4;
        this.d = abstractC18174oC7;
        this.e = interfaceC4356Eu;
        this.f = z;
        this.g = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C24002xs4(EnumC15839kG0 enumC15839kG0, AbstractC18174oC7 abstractC18174oC7, InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(enumC15839kG0, "captureStatus");
        AbstractC13042fc3.i(interfaceC3932Cy7, "projection");
        AbstractC13042fc3.i(interfaceC22882vy7, "typeParameter");
        InterfaceC4356Eu interfaceC4356Eu = null;
        boolean z = false;
        boolean z2 = false;
        this(enumC15839kG0, new C24592ys4(interfaceC3932Cy7, null, null, interfaceC22882vy7, 6, null), abstractC18174oC7, interfaceC4356Eu, z, z2, 56, null);
    }
}
