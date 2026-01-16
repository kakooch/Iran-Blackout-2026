package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.lG0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16430lG0 extends XC6 implements InterfaceC19385qG0 {
    private final InterfaceC3932Cy7 b;
    private final InterfaceC17612nG0 c;
    private final boolean d;
    private final InterfaceC4356Eu e;

    public /* synthetic */ C16430lG0(InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC17612nG0 interfaceC17612nG0, boolean z, InterfaceC4356Eu interfaceC4356Eu, int i, ED1 ed1) {
        this(interfaceC3932Cy7, (i & 2) != 0 ? new C18203oG0(interfaceC3932Cy7) : interfaceC17612nG0, (i & 4) != 0 ? false : z, (i & 8) != 0 ? InterfaceC4356Eu.W.b() : interfaceC4356Eu);
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public InterfaceC17612nG0 K0() {
        return this.c;
    }

    @Override // ir.nasim.XC6
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C16430lG0 O0(boolean z) {
        return z == L0() ? this : new C16430lG0(this.b, K0(), z, getAnnotations());
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public C16430lG0 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        InterfaceC3932Cy7 interfaceC3932Cy7A = this.b.a(abstractC5284Ir3);
        AbstractC13042fc3.h(interfaceC3932Cy7A, "typeProjection.refine(kotlinTypeRefiner)");
        return new C16430lG0(interfaceC3932Cy7A, K0(), L0(), getAnnotations());
    }

    @Override // ir.nasim.XC6
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public C16430lG0 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new C16430lG0(this.b, K0(), L0(), interfaceC4356Eu);
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        W24 w24I = AbstractC14230ha2.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        AbstractC13042fc3.h(w24I, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return w24I;
    }

    @Override // ir.nasim.XC6
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(L0() ? Separators.QUESTION : "");
        return sb.toString();
    }

    public C16430lG0(InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC17612nG0 interfaceC17612nG0, boolean z, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC3932Cy7, "typeProjection");
        AbstractC13042fc3.i(interfaceC17612nG0, "constructor");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        this.b = interfaceC3932Cy7;
        this.c = interfaceC17612nG0;
        this.d = z;
        this.e = interfaceC4356Eu;
    }
}
