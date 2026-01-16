package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12443ed3;
import ir.nasim.C17730nT1;
import ir.nasim.C20058rP1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.UO1;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* renamed from: ir.nasim.fN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12903fN1 {
    private final C20058rP1.a a;
    private final KB7 b;
    private final C17730nT1.a c;
    private final AbstractC13778go1 d;
    private final C12443ed3.a e;
    private final C18912pT1 f;
    private final ConcurrentHashMap g;
    private final ConcurrentHashMap h;

    /* renamed from: ir.nasim.fN1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 c;
        final /* synthetic */ InterfaceC20315ro1 d;
        final /* synthetic */ C12903fN1 e;
        final /* synthetic */ C12443ed3 f;
        final /* synthetic */ C12889fL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, C12903fN1 c12903fN1, C12443ed3 c12443ed3, C12889fL5 c12889fL52, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c12889fL5;
            this.d = interfaceC20315ro1;
            this.e = c12903fN1;
            this.f = c12443ed3;
            this.g = c12889fL52;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12889fL5 c12889fL5 = this.c;
                InterfaceC20315ro1 interfaceC20315ro1 = this.d;
                C12903fN1 c12903fN1 = this.e;
                C12443ed3 c12443ed3 = this.f;
                C12889fL5 c12889fL52 = this.g;
                this.b = 1;
                if (C12903fN1.k(c12889fL5, interfaceC20315ro1, c12903fN1, c12443ed3, c12889fL52, this) == objE) {
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
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fN1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        final /* synthetic */ C12889fL5 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.c = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12903fN1.l(this.c);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fN1$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C12903fN1.k(null, null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.fN1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12443ed3 c;
        final /* synthetic */ C12889fL5 d;

        /* renamed from: ir.nasim.fN1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12889fL5 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12889fL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).longValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C12889fL5 c12889fL5 = this.c;
                YT4 yt4 = (YT4) c12889fL5.a;
                if (yt4 != null) {
                    c12889fL5.a = null;
                    yt4.e();
                }
                return C19938rB7.a;
            }

            public final Object n(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Long.valueOf(j), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C12443ed3 c12443ed3, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c12443ed3;
            this.d = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2L = this.c.l();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2L, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fN1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12903fN1.this.g.remove(AbstractC6392Nk0.d(this.d));
            C12903fN1.this.h.remove(AbstractC6392Nk0.d(this.d));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12903fN1.this.new e(this.d, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    public C12903fN1(C20058rP1.a aVar, KB7 kb7, C17730nT1.a aVar2, AbstractC13778go1 abstractC13778go1, C12443ed3.a aVar3, C18912pT1 c18912pT1) {
        AbstractC13042fc3.i(aVar, "dialogRemoteMediatorFactory");
        AbstractC13042fc3.i(kb7, "unreadDialogsRemoteMediator");
        AbstractC13042fc3.i(aVar2, "dialogPagingSourceFactory");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(aVar3, "invalidationTrackerFactory");
        AbstractC13042fc3.i(c18912pT1, "dialogsPreFetchImpl");
        this.a = aVar;
        this.b = kb7;
        this.c = aVar2;
        this.d = abstractC13778go1;
        this.e = aVar3;
        this.f = c18912pT1;
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
    }

    private final C12443ed3 h(int i, InterfaceC20315ro1 interfaceC20315ro1) {
        InterfaceC24823zG1 interfaceC24823zG1F = this.f.f(i);
        C12443ed3 c12443ed3A = this.e.a(i, interfaceC20315ro1, interfaceC24823zG1F);
        if (interfaceC24823zG1F == null) {
            c12443ed3A.k();
        }
        return c12443ed3A;
    }

    private final InterfaceC4557Fq2 i(final int i, int i2, int i3, InterfaceC20315ro1 interfaceC20315ro1, C12443ed3 c12443ed3) {
        final C12889fL5 c12889fL5 = new C12889fL5();
        C12889fL5 c12889fL52 = new C12889fL5();
        return AbstractC9395Zt0.a(AbstractC6459Nq2.a0(AbstractC6459Nq2.c0(AbstractC6459Nq2.V(new C12960fT4(new MT4(i2, 0, false, i3, 0, 0, 50, null), null, i == 10 ? this.b : this.a.a(i, c12443ed3), new SA2() { // from class: ir.nasim.eN1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12903fN1.j(this.a, i, c12889fL5);
            }
        }, 2, null).a(), this.d), new a(c12889fL52, interfaceC20315ro1, this, c12443ed3, c12889fL5, null)), new b(c12889fL52, null)), interfaceC20315ro1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 j(C12903fN1 c12903fN1, int i, C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(c12903fN1, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$currentPagingSource");
        C17730nT1 c17730nT1B = C17730nT1.a.b(c12903fN1.c, i, null, 2, null);
        c12889fL5.a = c17730nT1B;
        return c17730nT1B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(ir.nasim.C12889fL5 r6, ir.nasim.InterfaceC20315ro1 r7, ir.nasim.C12903fN1 r8, ir.nasim.C12443ed3 r9, ir.nasim.C12889fL5 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            boolean r0 = r11 instanceof ir.nasim.C12903fN1.c
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.fN1$c r0 = (ir.nasim.C12903fN1.c) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.fN1$c r0 = new ir.nasim.fN1$c
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r6 = r0.e
            r10 = r6
            ir.nasim.fL5 r10 = (ir.nasim.C12889fL5) r10
            java.lang.Object r6 = r0.d
            r9 = r6
            ir.nasim.ed3 r9 = (ir.nasim.C12443ed3) r9
            java.lang.Object r6 = r0.c
            r8 = r6
            ir.nasim.fN1 r8 = (ir.nasim.C12903fN1) r8
            java.lang.Object r6 = r0.b
            r7 = r6
            ir.nasim.ro1 r7 = (ir.nasim.InterfaceC20315ro1) r7
            java.lang.Object r6 = r0.a
            ir.nasim.fL5 r6 = (ir.nasim.C12889fL5) r6
            ir.nasim.AbstractC10685c16.b(r11)
            goto L65
        L41:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L49:
            ir.nasim.AbstractC10685c16.b(r11)
            java.lang.Object r11 = r6.a
            ir.nasim.gj3 r11 = (ir.nasim.InterfaceC13730gj3) r11
            if (r11 == 0) goto L65
            r0.a = r6
            r0.b = r7
            r0.c = r8
            r0.d = r9
            r0.e = r10
            r0.g = r3
            java.lang.Object r11 = ir.nasim.AbstractC19067pj3.g(r11, r0)
            if (r11 != r1) goto L65
            return r1
        L65:
            r0 = r7
            ir.nasim.go1 r1 = r8.d
            ir.nasim.fN1$d r3 = new ir.nasim.fN1$d
            r7 = 0
            r3.<init>(r9, r10, r7)
            r4 = 2
            r5 = 0
            r2 = 0
            ir.nasim.gj3 r7 = ir.nasim.AbstractC9323Zl0.d(r0, r1, r2, r3, r4, r5)
            r6.a = r7
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12903fN1.k(ir.nasim.fL5, ir.nasim.ro1, ir.nasim.fN1, ir.nasim.ed3, ir.nasim.fL5, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(C12889fL5 c12889fL5) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) c12889fL5.a;
        if (interfaceC13730gj3 == null) {
            return null;
        }
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        return C19938rB7.a;
    }

    public static /* synthetic */ InterfaceC4557Fq2 o(C12903fN1 c12903fN1, int i, InterfaceC20315ro1 interfaceC20315ro1, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 30;
        }
        if ((i4 & 8) != 0) {
            i3 = 90;
        }
        return c12903fN1.n(i, interfaceC20315ro1, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 p(C12903fN1 c12903fN1, int i, InterfaceC20315ro1 interfaceC20315ro1, int i2, int i3, Integer num) {
        AbstractC13042fc3.i(c12903fN1, "this$0");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(num, "it");
        C12443ed3 c12443ed3H = c12903fN1.h(i, interfaceC20315ro1);
        c12903fN1.h.put(Integer.valueOf(i), c12443ed3H);
        return AbstractC6459Nq2.a0(c12903fN1.i(i, i2, i3, interfaceC20315ro1, c12443ed3H), c12903fN1.new e(i, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 q(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        return (InterfaceC4557Fq2) ua2.invoke(obj);
    }

    public final void m(int i) {
        C12443ed3 c12443ed3 = (C12443ed3) this.h.get(Integer.valueOf(i));
        if (c12443ed3 != null) {
            c12443ed3.k();
        } else {
            UO1.d.d(UO1.d.a, "The enableInvalidationTracker() called but the tracker was null!", null, UO1.d.a.b, i, 2, null);
        }
    }

    public final InterfaceC4557Fq2 n(final int i, final InterfaceC20315ro1 interfaceC20315ro1, final int i2, final int i3) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        ConcurrentHashMap concurrentHashMap = this.g;
        Integer numValueOf = Integer.valueOf(i);
        final UA2 ua2 = new UA2() { // from class: ir.nasim.cN1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C12903fN1.p(this.a, i, interfaceC20315ro1, i2, i3, (Integer) obj);
            }
        };
        Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(numValueOf, new Function() { // from class: ir.nasim.dN1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12903fN1.q(ua2, obj);
            }
        });
        AbstractC13042fc3.h(objComputeIfAbsent, "computeIfAbsent(...)");
        return (InterfaceC4557Fq2) objComputeIfAbsent;
    }
}
