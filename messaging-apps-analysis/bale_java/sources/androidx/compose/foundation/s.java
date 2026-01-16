package androidx.compose.foundation;

import ir.nasim.AbstractC10434bc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15324jO4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10459be6;
import ir.nasim.C19938rB7;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC11049ce6;
import ir.nasim.InterfaceC14124hO4;
import ir.nasim.InterfaceC14735iO4;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC7645Sp2;
import ir.nasim.InterfaceC8539Wk0;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.JG1;
import ir.nasim.KG1;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.SG4;
import ir.nasim.TG4;

/* loaded from: classes.dex */
final class s extends RG1 implements InterfaceC9814ac1, SG4 {
    private androidx.compose.foundation.gestures.f A;
    private JG1 B;
    private InterfaceC14735iO4 D;
    private InterfaceC14124hO4 G;
    private boolean H;
    private InterfaceC11049ce6 q;
    private EnumC24286yM4 r;
    private boolean s;
    private boolean t;
    private InterfaceC7645Sp2 u;
    private InterfaceC18507om4 v;
    private InterfaceC8539Wk0 w;
    private boolean x;
    private InterfaceC14124hO4 y;
    private final boolean z;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            s sVar = s.this;
            sVar.D = (InterfaceC14735iO4) AbstractC10434bc1.a(sVar, AbstractC15324jO4.a());
            s sVar2 = s.this;
            InterfaceC14735iO4 interfaceC14735iO4 = sVar2.D;
            sVar2.G = interfaceC14735iO4 != null ? interfaceC14735iO4.a() : null;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public s(InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0, boolean z3, InterfaceC14124hO4 interfaceC14124hO4) {
        this.q = interfaceC11049ce6;
        this.r = enumC24286yM4;
        this.s = z;
        this.t = z2;
        this.u = interfaceC7645Sp2;
        this.v = interfaceC18507om4;
        this.w = interfaceC8539Wk0;
        this.x = z3;
        this.y = interfaceC14124hO4;
    }

    private final void E2() {
        JG1 jg1 = this.B;
        if (jg1 != null) {
            if (jg1 == null || jg1.h().b2()) {
                return;
            }
            v2(jg1);
            return;
        }
        if (this.x) {
            TG4.a(this, new a());
        }
        InterfaceC14124hO4 interfaceC14124hO4F2 = F2();
        if (interfaceC14124hO4F2 != null) {
            JG1 jg1H = interfaceC14124hO4F2.h();
            if (jg1H.h().b2()) {
                return;
            }
            this.B = v2(jg1H);
        }
    }

    public final InterfaceC14124hO4 F2() {
        return this.x ? this.G : this.y;
    }

    public final boolean G2() {
        EnumC12613eu3 enumC12613eu3N = EnumC12613eu3.a;
        if (b2()) {
            enumC12613eu3N = KG1.n(this);
        }
        return C10459be6.a.b(enumC12613eu3N, this.r, this.t);
    }

    public final void H2(InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC14124hO4 interfaceC14124hO4, boolean z2, boolean z3, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        boolean z4;
        this.q = interfaceC11049ce6;
        this.r = enumC24286yM4;
        boolean z5 = true;
        if (this.x != z) {
            this.x = z;
            z4 = true;
        } else {
            z4 = false;
        }
        if (AbstractC13042fc3.d(this.y, interfaceC14124hO4)) {
            z5 = false;
        } else {
            this.y = interfaceC14124hO4;
        }
        if (z4 || (z5 && !z)) {
            JG1 jg1 = this.B;
            if (jg1 != null) {
                y2(jg1);
            }
            this.B = null;
            E2();
        }
        this.s = z2;
        this.t = z3;
        this.u = interfaceC7645Sp2;
        this.v = interfaceC18507om4;
        this.w = interfaceC8539Wk0;
        this.H = G2();
        androidx.compose.foundation.gestures.f fVar = this.A;
        if (fVar != null) {
            fVar.e3(interfaceC11049ce6, enumC24286yM4, F2(), z2, this.H, interfaceC7645Sp2, interfaceC18507om4, interfaceC8539Wk0);
        }
    }

    @Override // androidx.compose.ui.e.c
    /* renamed from: Z1 */
    public boolean getShouldAutoInvalidate() {
        return this.z;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        this.H = G2();
        E2();
        if (this.A == null) {
            this.A = (androidx.compose.foundation.gestures.f) v2(new androidx.compose.foundation.gestures.f(this.q, F2(), this.u, this.r, this.s, this.H, this.v, this.w));
        }
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        JG1 jg1 = this.B;
        if (jg1 != null) {
            y2(jg1);
        }
    }

    @Override // ir.nasim.JG1
    public void m0() {
        boolean zG2 = G2();
        if (this.H != zG2) {
            this.H = zG2;
            H2(this.q, this.r, this.x, F2(), this.s, this.t, this.u, this.v, this.w);
        }
    }

    @Override // ir.nasim.SG4
    public void x0() {
        InterfaceC14735iO4 interfaceC14735iO4 = (InterfaceC14735iO4) AbstractC10434bc1.a(this, AbstractC15324jO4.a());
        if (AbstractC13042fc3.d(interfaceC14735iO4, this.D)) {
            return;
        }
        this.D = interfaceC14735iO4;
        this.G = null;
        JG1 jg1 = this.B;
        if (jg1 != null) {
            y2(jg1);
        }
        this.B = null;
        E2();
        androidx.compose.foundation.gestures.f fVar = this.A;
        if (fVar != null) {
            fVar.e3(this.q, this.r, F2(), this.s, this.H, this.u, this.v, this.w);
        }
    }
}
