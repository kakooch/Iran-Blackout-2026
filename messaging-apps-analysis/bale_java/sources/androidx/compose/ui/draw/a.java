package androidx.compose.ui.draw;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC4663Ga3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C14988ip0;
import ir.nasim.C16869m02;
import ir.nasim.C19938rB7;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC14380hp0;
import ir.nasim.InterfaceC20014rK2;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC8548Wl0;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.SA2;
import ir.nasim.SG4;
import ir.nasim.TG4;
import ir.nasim.UA2;
import ir.nasim.WH1;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
final class a extends e.c implements InterfaceC14380hp0, SG4, InterfaceC8548Wl0 {
    private final C14988ip0 o;
    private boolean p;
    private e q;
    private UA2 r;

    /* renamed from: androidx.compose.ui.draw.a$a, reason: collision with other inner class name */
    static final class C0062a extends AbstractC8614Ws3 implements SA2 {
        C0062a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20014rK2 invoke() {
            return a.this.w2();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C14988ip0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C14988ip0 c14988ip0) {
            super(0);
            this.f = c14988ip0;
        }

        public final void a() {
            a.this.v2().invoke(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public a(C14988ip0 c14988ip0, UA2 ua2) {
        this.o = c14988ip0;
        this.r = ua2;
        c14988ip0.o(this);
        c14988ip0.u(new C0062a());
    }

    private final C16869m02 x2(InterfaceC23919xk1 interfaceC23919xk1) {
        if (!this.p) {
            C14988ip0 c14988ip0 = this.o;
            c14988ip0.t(null);
            c14988ip0.p(interfaceC23919xk1);
            TG4.a(this, new b(c14988ip0));
            if (c14988ip0.b() == null) {
                M73.c("DrawResult not defined, did you forget to call onDraw?");
                throw new KotlinNothingValueException();
            }
            this.p = true;
        }
        C16869m02 c16869m02B = this.o.b();
        AbstractC13042fc3.f(c16869m02B);
        return c16869m02B;
    }

    @Override // ir.nasim.JG1, ir.nasim.InterfaceC8508Wg5
    public void E() {
        W0();
    }

    @Override // ir.nasim.InterfaceC14380hp0
    public void W0() {
        e eVar = this.q;
        if (eVar != null) {
            eVar.d();
        }
        this.p = false;
        this.o.t(null);
        AbstractC16278l02.a(this);
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public long d() {
        return AbstractC4663Ga3.d(KG1.j(this, AbstractC9572aB4.a(128)).a());
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        super.f2();
        e eVar = this.q;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public WH1 getDensity() {
        return KG1.k(this);
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public EnumC12613eu3 getLayoutDirection() {
        return KG1.n(this);
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void l1() {
        W0();
    }

    @Override // ir.nasim.JG1
    public void m0() {
        W0();
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        x2(interfaceC23919xk1).a().invoke(interfaceC23919xk1);
    }

    public final UA2 v2() {
        return this.r;
    }

    public final InterfaceC20014rK2 w2() {
        e eVar = this.q;
        if (eVar == null) {
            eVar = new e();
            this.q = eVar;
        }
        if (eVar.c() == null) {
            eVar.e(KG1.l(this));
        }
        return eVar;
    }

    @Override // ir.nasim.SG4
    public void x0() {
        W0();
    }

    public final void y2(UA2 ua2) {
        this.r = ua2;
        W0();
    }
}
