package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ga2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C13639ga2 extends XC6 {
    private final InterfaceC13882gy7 b;
    private final W24 c;
    private final List d;
    private final boolean e;
    private final String f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C13639ga2(InterfaceC13882gy7 interfaceC13882gy7, W24 w24) {
        this(interfaceC13882gy7, w24, null, false, null, 28, null);
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(w24, "memberScope");
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public InterfaceC13882gy7 K0() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return new C13639ga2(K0(), o(), J0(), z, null, 16, null);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: S0 */
    public XC6 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return this;
    }

    public String T0() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC18174oC7
    public C13639ga2 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return this;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return InterfaceC4356Eu.W.b();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        return this.c;
    }

    @Override // ir.nasim.XC6
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(K0());
        sb.append(J0().isEmpty() ? "" : AbstractC15401jX0.z0(J0(), ", ", Separators.LESS_THAN, Separators.GREATER_THAN, -1, "...", null));
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C13639ga2(InterfaceC13882gy7 interfaceC13882gy7, W24 w24, List list, boolean z) {
        this(interfaceC13882gy7, w24, list, z, null, 16, null);
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(w24, "memberScope");
        AbstractC13042fc3.i(list, "arguments");
    }

    public /* synthetic */ C13639ga2(InterfaceC13882gy7 interfaceC13882gy7, W24 w24, List list, boolean z, String str, int i, ED1 ed1) {
        this(interfaceC13882gy7, w24, (i & 4) != 0 ? AbstractC10360bX0.m() : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "???" : str);
    }

    public C13639ga2(InterfaceC13882gy7 interfaceC13882gy7, W24 w24, List list, boolean z, String str) {
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(w24, "memberScope");
        AbstractC13042fc3.i(list, "arguments");
        AbstractC13042fc3.i(str, "presentableName");
        this.b = interfaceC13882gy7;
        this.c = w24;
        this.d = list;
        this.e = z;
        this.f = str;
    }
}
