package ir.nasim;

import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.oG0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18203oG0 implements InterfaceC17612nG0 {
    private final InterfaceC3932Cy7 a;
    private C24592ys4 b;

    public C18203oG0(InterfaceC3932Cy7 interfaceC3932Cy7) {
        AbstractC13042fc3.i(interfaceC3932Cy7, "projection");
        this.a = interfaceC3932Cy7;
        c().c();
        KQ7 kq7 = KQ7.INVARIANT;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public Collection b() {
        AbstractC4099Dr3 type = c().c() == KQ7.OUT_VARIANCE ? c().getType() : n().I();
        AbstractC13042fc3.h(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return AbstractC9766aX0.e(type);
    }

    @Override // ir.nasim.InterfaceC17612nG0
    public InterfaceC3932Cy7 c() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: d */
    public /* bridge */ /* synthetic */ MU0 t() {
        return (MU0) f();
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public boolean e() {
        return false;
    }

    public Void f() {
        return null;
    }

    public final C24592ys4 g() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public List getParameters() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C18203oG0 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        InterfaceC3932Cy7 interfaceC3932Cy7A = c().a(abstractC5284Ir3);
        AbstractC13042fc3.h(interfaceC3932Cy7A, "projection.refine(kotlinTypeRefiner)");
        return new C18203oG0(interfaceC3932Cy7A);
    }

    public final void i(C24592ys4 c24592ys4) {
        this.b = c24592ys4;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public AbstractC19738qr3 n() {
        AbstractC19738qr3 abstractC19738qr3N = c().getType().K0().n();
        AbstractC13042fc3.h(abstractC19738qr3N, "projection.type.constructor.builtIns");
        return abstractC19738qr3N;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + c() + ')';
    }
}
