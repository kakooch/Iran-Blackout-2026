package androidx.room;

import android.os.CancellationSignal;
import androidx.room.d;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC5957Lo1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C17050mJ2;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.C9486a27;
import ir.nasim.D26;
import ir.nasim.DJ0;
import ir.nasim.ED1;
import ir.nasim.HE0;
import ir.nasim.IE0;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17639nJ0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22753vm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.UA2;
import ir.nasim.WA1;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class a {
    public static final C0116a a = new C0116a(null);

    /* renamed from: androidx.room.a$a, reason: collision with other inner class name */
    public static final class C0116a {

        /* renamed from: androidx.room.a$a$a, reason: collision with other inner class name */
        static final class C0117a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ boolean d;
            final /* synthetic */ D26 e;
            final /* synthetic */ String[] f;
            final /* synthetic */ Callable g;

            /* renamed from: androidx.room.a$a$a$a, reason: collision with other inner class name */
            static final class C0118a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ boolean d;
                final /* synthetic */ D26 e;
                final /* synthetic */ InterfaceC4806Gq2 f;
                final /* synthetic */ String[] g;
                final /* synthetic */ Callable h;

                /* renamed from: androidx.room.a$a$a$a$a, reason: collision with other inner class name */
                static final class C0119a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    int c;
                    final /* synthetic */ D26 d;
                    final /* synthetic */ b e;
                    final /* synthetic */ InterfaceC17639nJ0 f;
                    final /* synthetic */ Callable g;
                    final /* synthetic */ InterfaceC17639nJ0 h;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0119a(D26 d26, b bVar, InterfaceC17639nJ0 interfaceC17639nJ0, Callable callable, InterfaceC17639nJ0 interfaceC17639nJ02, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = d26;
                        this.e = bVar;
                        this.f = interfaceC17639nJ0;
                        this.g = callable;
                        this.h = interfaceC17639nJ02;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0119a(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:20:0x0047 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:7:0x0012, B:18:0x003d, B:22:0x004b, B:24:0x0053, B:14:0x0025, B:17:0x0037), top: B:31:0x0008 }] */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:8:0x0015). Please report as a decompilation issue!!! */
                    @Override // ir.nasim.E90
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                        /*
                            r6 = this;
                            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                            int r1 = r6.c
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L29
                            if (r1 == r3) goto L21
                            if (r1 != r2) goto L19
                            java.lang.Object r1 = r6.b
                            ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L17
                        L15:
                            r7 = r1
                            goto L3d
                        L17:
                            r7 = move-exception
                            goto L77
                        L19:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L21:
                            java.lang.Object r1 = r6.b
                            ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L17
                            goto L4b
                        L29:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.D26 r7 = r6.d
                            androidx.room.d r7 = r7.n()
                            androidx.room.a$a$a$a$b r1 = r6.e
                            r7.c(r1)
                            ir.nasim.nJ0 r7 = r6.f     // Catch: java.lang.Throwable -> L17
                            ir.nasim.CJ0 r7 = r7.iterator()     // Catch: java.lang.Throwable -> L17
                        L3d:
                            r6.b = r7     // Catch: java.lang.Throwable -> L17
                            r6.c = r3     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r1 = r7.a(r6)     // Catch: java.lang.Throwable -> L17
                            if (r1 != r0) goto L48
                            return r0
                        L48:
                            r5 = r1
                            r1 = r7
                            r7 = r5
                        L4b:
                            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L17
                            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L17
                            if (r7 == 0) goto L69
                            r1.next()     // Catch: java.lang.Throwable -> L17
                            java.util.concurrent.Callable r7 = r6.g     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r7 = r7.call()     // Catch: java.lang.Throwable -> L17
                            ir.nasim.nJ0 r4 = r6.h     // Catch: java.lang.Throwable -> L17
                            r6.b = r1     // Catch: java.lang.Throwable -> L17
                            r6.c = r2     // Catch: java.lang.Throwable -> L17
                            java.lang.Object r7 = r4.o(r7, r6)     // Catch: java.lang.Throwable -> L17
                            if (r7 != r0) goto L15
                            return r0
                        L69:
                            ir.nasim.D26 r7 = r6.d
                            androidx.room.d r7 = r7.n()
                            androidx.room.a$a$a$a$b r0 = r6.e
                            r7.p(r0)
                            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                            return r7
                        L77:
                            ir.nasim.D26 r0 = r6.d
                            androidx.room.d r0 = r0.n()
                            androidx.room.a$a$a$a$b r1 = r6.e
                            r0.p(r1)
                            throw r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.room.a.C0116a.C0117a.C0118a.C0119a.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0119a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: androidx.room.a$a$a$a$b */
                public static final class b extends d.c {
                    final /* synthetic */ InterfaceC17639nJ0 b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    b(String[] strArr, InterfaceC17639nJ0 interfaceC17639nJ0) {
                        super(strArr);
                        this.b = interfaceC17639nJ0;
                    }

                    @Override // androidx.room.d.c
                    public void c(Set set) {
                        this.b.h(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0118a(boolean z, D26 d26, InterfaceC4806Gq2 interfaceC4806Gq2, String[] strArr, Callable callable, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = z;
                    this.e = d26;
                    this.f = interfaceC4806Gq2;
                    this.g = strArr;
                    this.h = callable;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0118a c0118a = new C0118a(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                    c0118a.c = obj;
                    return c0118a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    InterfaceC22753vm1 interfaceC22753vm1B;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                        InterfaceC17639nJ0 interfaceC17639nJ0B = DJ0.b(-1, null, null, 6, null);
                        b bVar = new b(this.g, interfaceC17639nJ0B);
                        interfaceC17639nJ0B.h(C19938rB7.a);
                        g gVar = (g) interfaceC20315ro1.getCoroutineContext().a(g.c);
                        if (gVar == null || (interfaceC22753vm1B = gVar.h()) == null) {
                            interfaceC22753vm1B = this.d ? AbstractC5957Lo1.b(this.e) : AbstractC5957Lo1.a(this.e);
                        }
                        InterfaceC17639nJ0 interfaceC17639nJ0B2 = DJ0.b(0, null, null, 7, null);
                        AbstractC10533bm0.d(interfaceC20315ro1, interfaceC22753vm1B, null, new C0119a(this.e, bVar, interfaceC17639nJ0B, this.h, interfaceC17639nJ0B2, null), 2, null);
                        InterfaceC4806Gq2 interfaceC4806Gq2 = this.f;
                        this.b = 1;
                        if (AbstractC6459Nq2.B(interfaceC4806Gq2, interfaceC17639nJ0B2, this) == objE) {
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
                    return ((C0118a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0117a(boolean z, D26 d26, String[] strArr, Callable callable, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = z;
                this.e = d26;
                this.f = strArr;
                this.g = callable;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0117a c0117a = new C0117a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                c0117a.c = obj;
                return c0117a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C0118a c0118a = new C0118a(this.d, this.e, (InterfaceC4806Gq2) this.c, this.f, this.g, null);
                    this.b = 1;
                    if (AbstractC20906so1.e(c0118a, this) == objE) {
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
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0117a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: androidx.room.a$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Callable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Callable callable, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callable;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.c.call();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: androidx.room.a$a$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ CancellationSignal e;
            final /* synthetic */ InterfaceC13730gj3 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(CancellationSignal cancellationSignal, InterfaceC13730gj3 interfaceC13730gj3) {
                super(1);
                this.e = cancellationSignal;
                this.f = interfaceC13730gj3;
            }

            public final void a(Throwable th) {
                CancellationSignal cancellationSignal = this.e;
                if (cancellationSignal != null) {
                    C9486a27.a(cancellationSignal);
                }
                InterfaceC13730gj3.a.a(this.f, null, 1, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.room.a$a$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Callable c;
            final /* synthetic */ HE0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(Callable callable, HE0 he0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callable;
                this.d = he0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                try {
                    this.d.resumeWith(C9475a16.b(this.c.call()));
                } catch (Throwable th) {
                    HE0 he0 = this.d;
                    C9475a16.a aVar = C9475a16.b;
                    he0.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        private C0116a() {
        }

        public final InterfaceC4557Fq2 a(D26 d26, boolean z, String[] strArr, Callable callable) {
            return AbstractC6459Nq2.R(new C0117a(z, d26, strArr, callable, null));
        }

        public final Object b(D26 d26, boolean z, CancellationSignal cancellationSignal, Callable callable, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC22753vm1 interfaceC22753vm1B;
            if (d26.C() && d26.v()) {
                return callable.call();
            }
            g gVar = (g) interfaceC20295rm1.getContext().a(g.c);
            if (gVar == null || (interfaceC22753vm1B = gVar.h()) == null) {
                interfaceC22753vm1B = z ? AbstractC5957Lo1.b(d26) : AbstractC5957Lo1.a(d26);
            }
            InterfaceC22753vm1 interfaceC22753vm1 = interfaceC22753vm1B;
            IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
            ie0.w();
            ie0.J(new c(cancellationSignal, AbstractC10533bm0.d(C17050mJ2.a, interfaceC22753vm1, null, new d(callable, ie0, null), 2, null)));
            Object objT = ie0.t();
            if (objT == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objT;
        }

        public final Object c(D26 d26, boolean z, Callable callable, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC22753vm1 interfaceC22753vm1B;
            if (d26.C() && d26.v()) {
                return callable.call();
            }
            g gVar = (g) interfaceC20295rm1.getContext().a(g.c);
            if (gVar == null || (interfaceC22753vm1B = gVar.h()) == null) {
                interfaceC22753vm1B = z ? AbstractC5957Lo1.b(d26) : AbstractC5957Lo1.a(d26);
            }
            return AbstractC9323Zl0.g(interfaceC22753vm1B, new b(callable, null), interfaceC20295rm1);
        }

        public /* synthetic */ C0116a(ED1 ed1) {
            this();
        }
    }
}
