package androidx.compose.foundation;

import androidx.compose.ui.e;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC19859r37;
import ir.nasim.C11637dL5;
import ir.nasim.C12403eZ2;
import ir.nasim.C13012fZ2;
import ir.nasim.C19938rB7;
import ir.nasim.C23400wr2;
import ir.nasim.C23990xr2;
import ir.nasim.C24381yX0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22645vb3;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.JG1;

/* loaded from: classes.dex */
final class h implements InterfaceC17521n63 {
    public static final h a = new h();

    private static final class a extends e.c implements InterfaceC15687k02 {
        private final InterfaceC23241wb3 o;
        private boolean p;
        private boolean q;
        private boolean r;

        /* renamed from: androidx.compose.foundation.h$a$a, reason: collision with other inner class name */
        static final class C0041a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            /* renamed from: androidx.compose.foundation.h$a$a$a, reason: collision with other inner class name */
            static final class C0042a implements InterfaceC4806Gq2 {
                final /* synthetic */ C11637dL5 a;
                final /* synthetic */ C11637dL5 b;
                final /* synthetic */ C11637dL5 c;
                final /* synthetic */ a d;

                C0042a(C11637dL5 c11637dL5, C11637dL5 c11637dL52, C11637dL5 c11637dL53, a aVar) {
                    this.a = c11637dL5;
                    this.b = c11637dL52;
                    this.c = c11637dL53;
                    this.d = aVar;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                    boolean z = true;
                    if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                        this.a.a++;
                    } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                        C11637dL5 c11637dL5 = this.a;
                        c11637dL5.a--;
                    } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                        C11637dL5 c11637dL52 = this.a;
                        c11637dL52.a--;
                    } else if (interfaceC22645vb3 instanceof C12403eZ2) {
                        this.b.a++;
                    } else if (interfaceC22645vb3 instanceof C13012fZ2) {
                        C11637dL5 c11637dL53 = this.b;
                        c11637dL53.a--;
                    } else if (interfaceC22645vb3 instanceof C23400wr2) {
                        this.c.a++;
                    } else if (interfaceC22645vb3 instanceof C23990xr2) {
                        C11637dL5 c11637dL54 = this.c;
                        c11637dL54.a--;
                    }
                    boolean z2 = false;
                    boolean z3 = this.a.a > 0;
                    boolean z4 = this.b.a > 0;
                    boolean z5 = this.c.a > 0;
                    if (this.d.p != z3) {
                        this.d.p = z3;
                        z2 = true;
                    }
                    if (this.d.q != z4) {
                        this.d.q = z4;
                        z2 = true;
                    }
                    if (this.d.r != z5) {
                        this.d.r = z5;
                    } else {
                        z = z2;
                    }
                    if (z) {
                        AbstractC16278l02.a(this.d);
                    }
                    return C19938rB7.a;
                }
            }

            C0041a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return a.this.new C0041a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C11637dL5 c11637dL5 = new C11637dL5();
                    C11637dL5 c11637dL52 = new C11637dL5();
                    C11637dL5 c11637dL53 = new C11637dL5();
                    InterfaceC4557Fq2 interfaceC4557Fq2B = a.this.o.b();
                    C0042a c0042a = new C0042a(c11637dL5, c11637dL52, c11637dL53, a.this);
                    this.b = 1;
                    if (interfaceC4557Fq2B.b(c0042a, this) == objE) {
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
                return ((C0041a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public a(InterfaceC23241wb3 interfaceC23241wb3) {
            this.o = interfaceC23241wb3;
        }

        @Override // androidx.compose.ui.e.c
        public void e2() {
            AbstractC10533bm0.d(U1(), null, null, new C0041a(null), 3, null);
        }

        @Override // ir.nasim.InterfaceC15687k02
        public void o(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            if (this.p) {
                InterfaceC17460n02.C1(interfaceC23919xk1, C24381yX0.o(C24381yX0.b.a(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, interfaceC23919xk1.d(), 0.0f, null, null, 0, 122, null);
            } else if (this.q || this.r) {
                InterfaceC17460n02.C1(interfaceC23919xk1, C24381yX0.o(C24381yX0.b.a(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, interfaceC23919xk1.d(), 0.0f, null, null, 0, 122, null);
            }
        }
    }

    private h() {
    }

    @Override // ir.nasim.InterfaceC17521n63
    public JG1 b(InterfaceC23241wb3 interfaceC23241wb3) {
        return new a(interfaceC23241wb3);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // ir.nasim.InterfaceC17521n63
    public int hashCode() {
        return -1;
    }
}
