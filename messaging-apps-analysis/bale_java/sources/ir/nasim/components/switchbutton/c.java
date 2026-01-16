package ir.nasim.components.switchbutton;

import androidx.compose.ui.e;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19153ps;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.C11637dL5;
import ir.nasim.C14186hV3;
import ir.nasim.C15607js;
import ir.nasim.C17784nZ1;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC22645vb3;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5766Kt;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes4.dex */
final class c extends e.c implements InterfaceC21655tu3 {
    private InterfaceC23241wb3 o;
    private boolean p;
    private boolean q;
    private C15607js r;
    private C15607js s;
    private float t;
    private float u;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ float d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.s;
                if (c15607js != null) {
                    Float fC = AbstractC6392Nk0.c(this.d);
                    InterfaceC5766Kt interfaceC5766Kt = c.this.q ? ir.nasim.components.switchbutton.a.f : ir.nasim.components.switchbutton.a.g;
                    this.b = 1;
                    obj = C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ float d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.r;
                if (c15607js != null) {
                    Float fC = AbstractC6392Nk0.c(this.d);
                    InterfaceC5766Kt interfaceC5766Kt = c.this.q ? ir.nasim.components.switchbutton.a.f : ir.nasim.components.switchbutton.a.g;
                    this.b = 1;
                    obj = C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.components.switchbutton.c$c, reason: collision with other inner class name */
    static final class C0985c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.components.switchbutton.c$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C11637dL5 a;
            final /* synthetic */ c b;

            a(C11637dL5 c11637dL5, c cVar) {
                this.a = c11637dL5;
                this.b = cVar;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                    this.a.a++;
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                    C11637dL5 c11637dL5 = this.a;
                    c11637dL5.a--;
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                    C11637dL5 c11637dL52 = this.a;
                    c11637dL52.a--;
                }
                boolean z = this.a.a > 0;
                if (this.b.q != z) {
                    this.b.q = z;
                    AbstractC23431wu3.b(this.b);
                }
                return C19938rB7.a;
            }
        }

        C0985c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new C0985c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11637dL5 c11637dL5 = new C11637dL5();
                InterfaceC4557Fq2 interfaceC4557Fq2B = c.this.B2().b();
                a aVar = new a(c11637dL5, c.this);
                this.b = 1;
                if (interfaceC4557Fq2B.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C0985c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public c(InterfaceC23241wb3 interfaceC23241wb3, boolean z) {
        AbstractC13042fc3.i(interfaceC23241wb3, "interactionSource");
        this.o = interfaceC23241wb3;
        this.p = z;
        this.t = Float.NaN;
        this.u = Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C2(AbstractC21430te5 abstractC21430te5, c cVar, float f, AbstractC21430te5.a aVar) {
        AbstractC13042fc3.i(abstractC21430te5, "$placeable");
        AbstractC13042fc3.i(cVar, "this$0");
        AbstractC13042fc3.i(aVar, "$this$layout");
        C15607js c15607js = cVar.r;
        AbstractC21430te5.a.l(aVar, abstractC21430te5, c15607js != null ? (int) ((Number) c15607js.q()).floatValue() : (int) f, 0, 0.0f, 4, null);
        return C19938rB7.a;
    }

    public final boolean A2() {
        return this.p;
    }

    public final InterfaceC23241wb3 B2() {
        return this.o;
    }

    public final void D2(boolean z) {
        this.p = z;
    }

    public final void E2(InterfaceC23241wb3 interfaceC23241wb3) {
        AbstractC13042fc3.i(interfaceC23241wb3, "<set-?>");
        this.o = interfaceC23241wb3;
    }

    public final void F2() {
        if (this.s == null && !Float.isNaN(this.u)) {
            this.s = AbstractC19153ps.b(this.u, 0.0f, 2, null);
        }
        if (this.r != null || Float.isNaN(this.t)) {
            return;
        }
        this.r = AbstractC19153ps.b(this.t, 0.0f, 2, null);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC13042fc3.i(interfaceC12377eW3, "$this$measure");
        AbstractC13042fc3.i(zv3, "measurable");
        float fW1 = interfaceC12377eW3.w1(this.q ? C14186hV3.a.b() : ((zv3.z(C17833ne1.l(j)) != 0 && zv3.k0(C17833ne1.k(j)) != 0) || this.p) ? ir.nasim.components.switchbutton.a.l() : ir.nasim.components.switchbutton.a.m());
        C15607js c15607js = this.s;
        int iFloatValue = (int) (c15607js != null ? ((Number) c15607js.q()).floatValue() : fW1);
        final AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.b.c(iFloatValue, iFloatValue));
        final float fW12 = interfaceC12377eW3.w1(C17784nZ1.q(C17784nZ1.q(ir.nasim.components.switchbutton.a.d - interfaceC12377eW3.o1(fW1)) / 2.0f));
        float fW13 = interfaceC12377eW3.w1(C17784nZ1.q(C17784nZ1.q(ir.nasim.components.switchbutton.a.c - ir.nasim.components.switchbutton.a.l()) - ir.nasim.components.switchbutton.a.e));
        boolean z = this.q;
        if (z && this.p) {
            fW12 = fW13 - interfaceC12377eW3.w1(C14186hV3.a.f());
        } else if (z && !this.p) {
            fW12 = interfaceC12377eW3.w1(C14186hV3.a.f());
        } else if (this.p) {
            fW12 = fW13;
        }
        C15607js c15607js2 = this.s;
        if (!AbstractC13042fc3.b(c15607js2 != null ? (Float) c15607js2.n() : null, fW1)) {
            AbstractC10533bm0.d(U1(), null, null, new a(fW1, null), 3, null);
        }
        C15607js c15607js3 = this.r;
        if (!AbstractC13042fc3.b(c15607js3 != null ? (Float) c15607js3.n() : null, fW12)) {
            AbstractC10533bm0.d(U1(), null, null, new b(fW12, null), 3, null);
        }
        if (Float.isNaN(this.u) && Float.isNaN(this.t)) {
            this.u = fW1;
            this.t = fW12;
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iFloatValue, iFloatValue, null, new UA2() { // from class: ir.nasim.components.switchbutton.b
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return c.C2(abstractC21430te5L0, this, fW12, (AbstractC21430te5.a) obj);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        AbstractC10533bm0.d(U1(), null, null, new C0985c(null), 3, null);
    }
}
