package ir.nasim;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class VD1 implements InterfaceC7645Sp2 {
    private InterfaceC10163bB1 a;
    private final InterfaceC9309Zj4 b;
    private int c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ float e;
        final /* synthetic */ VD1 f;
        final /* synthetic */ InterfaceC8748Xd6 g;

        /* renamed from: ir.nasim.VD1$a$a, reason: collision with other inner class name */
        static final class C0695a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C10873cL5 e;
            final /* synthetic */ InterfaceC8748Xd6 f;
            final /* synthetic */ C10873cL5 g;
            final /* synthetic */ VD1 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0695a(C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6, C10873cL5 c10873cL52, VD1 vd1) {
                super(1);
                this.e = c10873cL5;
                this.f = interfaceC8748Xd6;
                this.g = c10873cL52;
                this.h = vd1;
            }

            public final void a(C5064Ht c5064Ht) {
                float fFloatValue = ((Number) c5064Ht.e()).floatValue() - this.e.a;
                float fE = this.f.e(fFloatValue);
                this.e.a = ((Number) c5064Ht.e()).floatValue();
                this.g.a = ((Number) c5064Ht.f()).floatValue();
                if (Math.abs(fFloatValue - fE) > 0.5f) {
                    c5064Ht.a();
                }
                VD1 vd1 = this.h;
                vd1.f(vd1.e() + 1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C5064Ht) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, VD1 vd1, InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = f;
            this.f = vd1;
            this.g = interfaceC8748Xd6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            float f;
            C10873cL5 c10873cL5;
            C6233Mt c6233Mt;
            InterfaceC10163bB1 interfaceC10163bB1;
            C0695a c0695a;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (Math.abs(this.e) > 1.0f) {
                    C10873cL5 c10873cL52 = new C10873cL5();
                    c10873cL52.a = this.e;
                    C10873cL5 c10873cL53 = new C10873cL5();
                    C6233Mt c6233MtC = AbstractC6483Nt.c(0.0f, this.e, 0L, 0L, false, 28, null);
                    try {
                        interfaceC10163bB1 = this.f.a;
                        c0695a = new C0695a(c10873cL53, this.g, c10873cL52, this.f);
                        this.b = c10873cL52;
                        this.c = c6233MtC;
                        this.d = 1;
                    } catch (CancellationException unused) {
                        c10873cL5 = c10873cL52;
                        c6233Mt = c6233MtC;
                        c10873cL5.a = ((Number) c6233Mt.z()).floatValue();
                        f = c10873cL5.a;
                        return AbstractC6392Nk0.c(f);
                    }
                    if (AbstractC18086o37.h(c6233MtC, interfaceC10163bB1, false, c0695a, this, 2, null) == objE) {
                        return objE;
                    }
                    c10873cL5 = c10873cL52;
                    f = c10873cL5.a;
                } else {
                    f = this.e;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c6233Mt = (C6233Mt) this.c;
                c10873cL5 = (C10873cL5) this.b;
                try {
                    AbstractC10685c16.b(obj);
                } catch (CancellationException unused2) {
                    c10873cL5.a = ((Number) c6233Mt.z()).floatValue();
                    f = c10873cL5.a;
                    return AbstractC6392Nk0.c(f);
                }
                f = c10873cL5.a;
            }
            return AbstractC6392Nk0.c(f);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public VD1(InterfaceC10163bB1 interfaceC10163bB1, InterfaceC9309Zj4 interfaceC9309Zj4) {
        this.a = interfaceC10163bB1;
        this.b = interfaceC9309Zj4;
    }

    @Override // ir.nasim.InterfaceC7645Sp2
    public Object a(InterfaceC8748Xd6 interfaceC8748Xd6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        this.c = 0;
        return AbstractC9323Zl0.g(this.b, new a(f, this, interfaceC8748Xd6, null), interfaceC20295rm1);
    }

    public final int e() {
        return this.c;
    }

    public final void f(int i) {
        this.c = i;
    }

    public void g(WH1 wh1) {
        this.a = JI6.c(wh1);
    }

    public /* synthetic */ VD1(InterfaceC10163bB1 interfaceC10163bB1, InterfaceC9309Zj4 interfaceC9309Zj4, int i, ED1 ed1) {
        this(interfaceC10163bB1, (i & 2) != 0 ? androidx.compose.foundation.gestures.d.f() : interfaceC9309Zj4);
    }
}
