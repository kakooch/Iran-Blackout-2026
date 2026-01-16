package ir.nasim;

import ir.nasim.AbstractC14230ha2;
import java.util.List;

/* loaded from: classes8.dex */
final class YC6 extends XC6 {
    private final InterfaceC13882gy7 b;
    private final List c;
    private final boolean d;
    private final W24 e;
    private final UA2 f;

    public YC6(InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z, W24 w24, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(list, "arguments");
        AbstractC13042fc3.i(w24, "memberScope");
        AbstractC13042fc3.i(ua2, "refinedTypeFactory");
        this.b = interfaceC13882gy7;
        this.c = list;
        this.d = z;
        this.e = w24;
        this.f = ua2;
        if (o() instanceof AbstractC14230ha2.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + o() + '\n' + K0());
        }
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public InterfaceC13882gy7 K0() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return z == L0() ? this : z ? new C21857uF4(this) : new C23606xC4(this);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: S0 */
    public XC6 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return interfaceC4356Eu.isEmpty() ? this : new C12609eu(this, interfaceC4356Eu);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public XC6 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        XC6 xc6 = (XC6) this.f.invoke(abstractC5284Ir3);
        return xc6 == null ? this : xc6;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return InterfaceC4356Eu.W.b();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        return this.e;
    }
}
