package androidx.compose.foundation.lazy.layout;

import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C15607js;
import ir.nasim.C19938rB7;
import ir.nasim.C21226tK2;
import ir.nasim.C22045ua3;
import ir.nasim.C9361Zp2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20014rK2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.PQ7;
import ir.nasim.SA2;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public final class c {
    public static final a s = new a(null);
    public static final int t = 8;
    private static final long u;
    private final InterfaceC20315ro1 a;
    private final InterfaceC20014rK2 b;
    private final SA2 c;
    private InterfaceC4788Go2 d;
    private InterfaceC4788Go2 e;
    private InterfaceC4788Go2 f;
    private boolean g;
    private final InterfaceC9102Ym4 h;
    private final InterfaceC9102Ym4 i;
    private final InterfaceC9102Ym4 j;
    private final InterfaceC9102Ym4 k;
    private long l;
    private long m;
    private C21226tK2 n;
    private final C15607js o;
    private final C15607js p;
    private final InterfaceC9102Ym4 q;
    private long r;

    public static final class a {
        private a() {
        }

        public final long a() {
            return c.u;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.p;
                Float fC = AbstractC6392Nk0.c(1.0f);
                this.b = 1;
                if (c15607js.x(fC, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: androidx.compose.foundation.lazy.layout.c$c, reason: collision with other inner class name */
    static final class C0045c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ c d;
        final /* synthetic */ InterfaceC4788Go2 e;
        final /* synthetic */ C21226tK2 f;

        /* renamed from: androidx.compose.foundation.lazy.layout.c$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C21226tK2 e;
            final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21226tK2 c21226tK2, c cVar) {
                super(1);
                this.e = c21226tK2;
                this.f = cVar;
            }

            public final void a(C15607js c15607js) {
                this.e.K(((Number) c15607js.q()).floatValue());
                this.f.c.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C15607js) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0045c(boolean z, c cVar, InterfaceC4788Go2 interfaceC4788Go2, C21226tK2 c21226tK2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = cVar;
            this.e = interfaceC4788Go2;
            this.f = c21226tK2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C0045c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (this.c) {
                        C15607js c15607js = this.d.p;
                        Float fC = AbstractC6392Nk0.c(0.0f);
                        this.b = 1;
                        if (c15607js.x(fC, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.d.z(false);
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                C15607js c15607js2 = this.d.p;
                Float fC2 = AbstractC6392Nk0.c(1.0f);
                InterfaceC4788Go2 interfaceC4788Go2 = this.e;
                a aVar = new a(this.f, this.d);
                this.b = 2;
                if (C15607js.h(c15607js2, fC2, interfaceC4788Go2, null, aVar, this, 4, null) == objE) {
                    return objE;
                }
                this.d.z(false);
                return C19938rB7.a;
            } catch (Throwable th) {
                this.d.z(false);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C0045c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4788Go2 d;
        final /* synthetic */ C21226tK2 e;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C21226tK2 e;
            final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21226tK2 c21226tK2, c cVar) {
                super(1);
                this.e = c21226tK2;
                this.f = cVar;
            }

            public final void a(C15607js c15607js) {
                this.e.K(((Number) c15607js.q()).floatValue());
                this.f.c.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C15607js) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC4788Go2 interfaceC4788Go2, C21226tK2 c21226tK2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4788Go2;
            this.e = c21226tK2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C15607js c15607js = c.this.p;
                    Float fC = AbstractC6392Nk0.c(0.0f);
                    InterfaceC4788Go2 interfaceC4788Go2 = this.d;
                    a aVar = new a(this.e, c.this);
                    this.b = 1;
                    if (C15607js.h(c15607js, fC, interfaceC4788Go2, null, aVar, this, 4, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                c.this.A(true);
                c.this.B(false);
                return C19938rB7.a;
            } catch (Throwable th) {
                c.this.B(false);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ InterfaceC4788Go2 e;
        final /* synthetic */ long f;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ c e;
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c cVar, long j) {
                super(1);
                this.e = cVar;
                this.f = j;
            }

            public final void a(C15607js c15607js) {
                this.e.H(C22045ua3.n(((C22045ua3) c15607js.q()).r(), this.f));
                this.e.c.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C15607js) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC4788Go2 interfaceC4788Go2, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC4788Go2;
            this.f = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new e(this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a9 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                goto Laa
            L13:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1b:
                java.lang.Object r1 = r11.b
                ir.nasim.Go2 r1 = (ir.nasim.InterfaceC4788Go2) r1
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                goto L67
            L23:
                ir.nasim.AbstractC10685c16.b(r12)
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.js r12 = androidx.compose.foundation.lazy.layout.c.c(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                boolean r12 = r12.t()     // Catch: java.util.concurrent.CancellationException -> Lb5
                if (r12 == 0) goto L41
                ir.nasim.Go2 r12 = r11.e     // Catch: java.util.concurrent.CancellationException -> Lb5
                boolean r1 = r12 instanceof ir.nasim.C18827pJ6     // Catch: java.util.concurrent.CancellationException -> Lb5
                if (r1 == 0) goto L3b
                ir.nasim.pJ6 r12 = (ir.nasim.C18827pJ6) r12     // Catch: java.util.concurrent.CancellationException -> Lb5
                goto L3f
            L3b:
                ir.nasim.pJ6 r12 = ir.nasim.AbstractC18015nw3.a()     // Catch: java.util.concurrent.CancellationException -> Lb5
            L3f:
                r1 = r12
                goto L44
            L41:
                ir.nasim.Go2 r12 = r11.e     // Catch: java.util.concurrent.CancellationException -> Lb5
                goto L3f
            L44:
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.js r12 = androidx.compose.foundation.lazy.layout.c.c(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                boolean r12 = r12.t()     // Catch: java.util.concurrent.CancellationException -> Lb5
                if (r12 != 0) goto L70
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.js r12 = androidx.compose.foundation.lazy.layout.c.c(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                long r4 = r11.f     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.ua3 r4 = ir.nasim.C22045ua3.c(r4)     // Catch: java.util.concurrent.CancellationException -> Lb5
                r11.b = r1     // Catch: java.util.concurrent.CancellationException -> Lb5
                r11.c = r3     // Catch: java.util.concurrent.CancellationException -> Lb5
                java.lang.Object r12 = r12.x(r4, r11)     // Catch: java.util.concurrent.CancellationException -> Lb5
                if (r12 != r0) goto L67
                return r0
            L67:
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.SA2 r12 = androidx.compose.foundation.lazy.layout.c.b(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lb5
            L70:
                r5 = r1
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.js r12 = androidx.compose.foundation.lazy.layout.c.c(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                java.lang.Object r12 = r12.q()     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.ua3 r12 = (ir.nasim.C22045ua3) r12     // Catch: java.util.concurrent.CancellationException -> Lb5
                long r3 = r12.r()     // Catch: java.util.concurrent.CancellationException -> Lb5
                long r6 = r11.f     // Catch: java.util.concurrent.CancellationException -> Lb5
                long r3 = ir.nasim.C22045ua3.n(r3, r6)     // Catch: java.util.concurrent.CancellationException -> Lb5
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.js r12 = androidx.compose.foundation.lazy.layout.c.c(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
                ir.nasim.ua3 r1 = ir.nasim.C22045ua3.c(r3)     // Catch: java.util.concurrent.CancellationException -> Lb5
                androidx.compose.foundation.lazy.layout.c$e$a r7 = new androidx.compose.foundation.lazy.layout.c$e$a     // Catch: java.util.concurrent.CancellationException -> Lb5
                androidx.compose.foundation.lazy.layout.c r6 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                r7.<init>(r6, r3)     // Catch: java.util.concurrent.CancellationException -> Lb5
                r3 = 0
                r11.b = r3     // Catch: java.util.concurrent.CancellationException -> Lb5
                r11.c = r2     // Catch: java.util.concurrent.CancellationException -> Lb5
                r6 = 0
                r9 = 4
                r10 = 0
                r3 = r12
                r4 = r1
                r8 = r11
                java.lang.Object r12 = ir.nasim.C15607js.h(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> Lb5
                if (r12 != r0) goto Laa
                return r0
            Laa:
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                r0 = 0
                androidx.compose.foundation.lazy.layout.c.h(r12, r0)     // Catch: java.util.concurrent.CancellationException -> Lb5
                androidx.compose.foundation.lazy.layout.c r12 = androidx.compose.foundation.lazy.layout.c.this     // Catch: java.util.concurrent.CancellationException -> Lb5
                androidx.compose.foundation.lazy.layout.c.j(r12, r0)     // Catch: java.util.concurrent.CancellationException -> Lb5
            Lb5:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.c.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.o;
                C22045ua3 c22045ua3C = C22045ua3.c(C22045ua3.b.b());
                this.b = 1;
                if (c15607js.x(c22045ua3C, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            c.this.H(C22045ua3.b.b());
            c.this.G(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.o;
                this.b = 1;
                if (c15607js.y(this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.p;
                this.b = 1;
                if (c15607js.y(this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = c.this.p;
                this.b = 1;
                if (c15607js.y(this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        long j = Integer.MAX_VALUE;
        u = C22045ua3.f((j & 4294967295L) | (j << 32));
    }

    public c(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20014rK2 interfaceC20014rK2, SA2 sa2) {
        this.a = interfaceC20315ro1;
        this.b = interfaceC20014rK2;
        this.c = sa2;
        Boolean bool = Boolean.FALSE;
        this.h = AbstractC13472gH6.d(bool, null, 2, null);
        this.i = AbstractC13472gH6.d(bool, null, 2, null);
        this.j = AbstractC13472gH6.d(bool, null, 2, null);
        this.k = AbstractC13472gH6.d(bool, null, 2, null);
        long j = u;
        this.l = j;
        C22045ua3.a aVar = C22045ua3.b;
        this.m = aVar.b();
        this.n = interfaceC20014rK2 != null ? interfaceC20014rK2.a() : null;
        this.o = new C15607js(C22045ua3.c(aVar.b()), PQ7.f(aVar), null, null, 12, null);
        this.p = new C15607js(Float.valueOf(1.0f), PQ7.d(C9361Zp2.a), null, null, 12, null);
        this.q = AbstractC13472gH6.d(C22045ua3.c(aVar.b()), null, 2, null);
        this.r = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(long j) {
        this.q.setValue(C22045ua3.c(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }

    public final void C(InterfaceC4788Go2 interfaceC4788Go2) {
        this.d = interfaceC4788Go2;
    }

    public final void D(InterfaceC4788Go2 interfaceC4788Go2) {
        this.f = interfaceC4788Go2;
    }

    public final void E(long j) {
        this.m = j;
    }

    public final void F(long j) {
        this.r = j;
    }

    public final void I(InterfaceC4788Go2 interfaceC4788Go2) {
        this.e = interfaceC4788Go2;
    }

    public final void J(long j) {
        this.l = j;
    }

    public final void k() {
        C21226tK2 c21226tK2 = this.n;
        InterfaceC4788Go2 interfaceC4788Go2 = this.d;
        if (t() || interfaceC4788Go2 == null || c21226tK2 == null) {
            if (v()) {
                if (c21226tK2 != null) {
                    c21226tK2.K(1.0f);
                }
                AbstractC10533bm0.d(this.a, null, null, new b(null), 3, null);
                return;
            }
            return;
        }
        z(true);
        boolean z = !v();
        if (z) {
            c21226tK2.K(0.0f);
        }
        AbstractC10533bm0.d(this.a, null, null, new C0045c(z, this, interfaceC4788Go2, c21226tK2, null), 3, null);
    }

    public final void l() {
        C21226tK2 c21226tK2 = this.n;
        InterfaceC4788Go2 interfaceC4788Go2 = this.f;
        if (c21226tK2 == null || v() || interfaceC4788Go2 == null) {
            return;
        }
        B(true);
        AbstractC10533bm0.d(this.a, null, null, new d(interfaceC4788Go2, c21226tK2, null), 3, null);
    }

    public final void m(long j, boolean z) {
        InterfaceC4788Go2 interfaceC4788Go2 = this.e;
        if (interfaceC4788Go2 == null) {
            return;
        }
        long jN = C22045ua3.n(r(), j);
        H(jN);
        G(true);
        this.g = z;
        AbstractC10533bm0.d(this.a, null, null, new e(interfaceC4788Go2, jN, null), 3, null);
    }

    public final void n() {
        if (w()) {
            AbstractC10533bm0.d(this.a, null, null, new f(null), 3, null);
        }
    }

    public final long o() {
        return this.m;
    }

    public final C21226tK2 p() {
        return this.n;
    }

    public final long q() {
        return this.r;
    }

    public final long r() {
        return ((C22045ua3) this.q.getValue()).r();
    }

    public final long s() {
        return this.l;
    }

    public final boolean t() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    public final boolean x() {
        return this.g;
    }

    public final void y() {
        InterfaceC20014rK2 interfaceC20014rK2;
        if (w()) {
            G(false);
            AbstractC10533bm0.d(this.a, null, null, new g(null), 3, null);
        }
        if (t()) {
            z(false);
            AbstractC10533bm0.d(this.a, null, null, new h(null), 3, null);
        }
        if (v()) {
            B(false);
            AbstractC10533bm0.d(this.a, null, null, new i(null), 3, null);
        }
        this.g = false;
        H(C22045ua3.b.b());
        this.l = u;
        C21226tK2 c21226tK2 = this.n;
        if (c21226tK2 != null && (interfaceC20014rK2 = this.b) != null) {
            interfaceC20014rK2.b(c21226tK2);
        }
        this.n = null;
        this.d = null;
        this.f = null;
        this.e = null;
    }
}
