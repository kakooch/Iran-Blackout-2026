package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC16756lo6;
import ir.nasim.VS4;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public final class WS4 {
    private final UA2 a;
    private final Object b;
    private final MT4 c;
    private final C14259hd1 d;
    private final C14259hd1 e;
    private final InterfaceC4557Fq2 f;

    private static final class a {
        private final XS4 a;
        private final ZT4 b;
        private final InterfaceC13730gj3 c;

        public a(XS4 xs4, ZT4 zt4, InterfaceC13730gj3 interfaceC13730gj3) {
            AbstractC13042fc3.i(xs4, "snapshot");
            AbstractC13042fc3.i(interfaceC13730gj3, "job");
            this.a = xs4;
            this.b = zt4;
            this.c = interfaceC13730gj3;
        }

        public final InterfaceC13730gj3 a() {
            return this.c;
        }

        public final XS4 b() {
            return this.a;
        }

        public final ZT4 c() {
            return this.b;
        }
    }

    public final class b implements InterfaceC14823iY2 {
        private final XS4 a;
        final /* synthetic */ WS4 b;

        public b(WS4 ws4, XS4 xs4) {
            AbstractC13042fc3.i(xs4, "pageFetcherSnapshot");
            this.b = ws4;
            this.a = xs4;
        }

        @Override // ir.nasim.InterfaceC14823iY2
        public void a(AbstractC20754sY7 abstractC20754sY7) {
            AbstractC13042fc3.i(abstractC20754sY7, "viewportHint");
            this.a.o(abstractC20754sY7);
        }
    }

    public final class c implements MA7 {
        private final C14259hd1 a;
        final /* synthetic */ WS4 b;

        public c(WS4 ws4, C14259hd1 c14259hd1) {
            AbstractC13042fc3.i(c14259hd1, "retryEventBus");
            this.b = ws4;
            this.a = c14259hd1;
        }

        @Override // ir.nasim.MA7
        public void a() {
            this.a.b(C19938rB7.a);
        }

        @Override // ir.nasim.MA7
        public void b() {
            this.b.l();
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC20044rN5 d;
        final /* synthetic */ WS4 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC21256tN5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC21256tN5 interfaceC21256tN5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC21256tN5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.b
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L23
                    if (r1 == r4) goto L1b
                    if (r1 != r3) goto L13
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L53
                L13:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1b:
                    java.lang.Object r1 = r6.c
                    ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L3a
                L23:
                    ir.nasim.AbstractC10685c16.b(r7)
                    java.lang.Object r7 = r6.c
                    r1 = r7
                    ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                    ir.nasim.tN5 r7 = r6.d
                    if (r7 == 0) goto L3d
                    r6.c = r1
                    r6.b = r4
                    java.lang.Object r7 = r7.a(r6)
                    if (r7 != r0) goto L3a
                    return r0
                L3a:
                    ir.nasim.rN5$a r7 = (ir.nasim.AbstractC20044rN5.a) r7
                    goto L3e
                L3d:
                    r7 = r2
                L3e:
                    ir.nasim.rN5$a r5 = ir.nasim.AbstractC20044rN5.a.LAUNCH_INITIAL_REFRESH
                    if (r7 != r5) goto L43
                    goto L44
                L43:
                    r4 = 0
                L44:
                    java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r4)
                    r6.c = r2
                    r6.b = r3
                    java.lang.Object r7 = r1.a(r7, r6)
                    if (r7 != r0) goto L53
                    return r0
                L53:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WS4.d.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            Object b;
            int c;
            /* synthetic */ Object d;
            /* synthetic */ boolean e;
            final /* synthetic */ InterfaceC21256tN5 f;
            final /* synthetic */ WS4 g;

            /* synthetic */ class a extends EB2 implements SA2 {
                a(Object obj) {
                    super(0, obj, WS4.class, "refresh", "refresh()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((WS4) this.receiver).l();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC21256tN5 interfaceC21256tN5, WS4 ws4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.f = interfaceC21256tN5;
                this.g = ws4;
            }

            /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x00cf  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                /*
                    Method dump skipped, instructions count: 313
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WS4.d.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object n(a aVar, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.f, this.g, interfaceC20295rm1);
                bVar.d = aVar;
                bVar.e = z;
                return bVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n((a) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                VS4 vs4 = (VS4) this.c;
                XT4 xt4 = XT4.a;
                if (xt4.a(2)) {
                    xt4.b(2, "Sent " + vs4, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(VS4 vs4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(vs4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.WS4$d$d, reason: collision with other inner class name */
        /* synthetic */ class C0731d implements InterfaceC4806Gq2, InterfaceC22409vB2 {
            final /* synthetic */ OC6 a;

            C0731d(OC6 oc6) {
                this.a = oc6;
            }

            @Override // ir.nasim.InterfaceC22409vB2
            public final InterfaceC18751pB2 b() {
                return new EB2(2, this.a, OC6.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objO = this.a.o(nt4, interfaceC20295rm1);
                return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof InterfaceC4806Gq2) && (obj instanceof InterfaceC22409vB2)) {
                    return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
                }
                return false;
            }

            public final int hashCode() {
                return b().hashCode();
            }
        }

        public static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ WS4 e;
            final /* synthetic */ InterfaceC21256tN5 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(InterfaceC20295rm1 interfaceC20295rm1, WS4 ws4, InterfaceC21256tN5 interfaceC21256tN5) {
                super(3, interfaceC20295rm1);
                this.e = ws4;
                this.f = interfaceC21256tN5;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    a aVar = (a) this.d;
                    InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(this.e.j(aVar.b(), aVar.a(), this.f), new c(null));
                    WS4 ws4 = this.e;
                    NT4 nt4 = new NT4(interfaceC4557Fq2B0, new c(ws4, ws4.e), new b(this.e, aVar.b()), null, 8, null);
                    this.b = 1;
                    if (interfaceC4806Gq2.a(nt4, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(interfaceC20295rm1, this.e, this.f);
                eVar.c = interfaceC4806Gq2;
                eVar.d = obj;
                return eVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC20044rN5 abstractC20044rN5, WS4 ws4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC20044rN5;
            this.e = ws4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                OC6 oc6 = (OC6) this.c;
                AbstractC20044rN5 abstractC20044rN5 = this.d;
                InterfaceC21256tN5 interfaceC21256tN5A = abstractC20044rN5 != null ? AbstractC21930uN5.a(oc6, abstractC20044rN5) : null;
                InterfaceC4557Fq2 interfaceC4557Fq2D = AbstractC6209Mq2.d(AbstractC6459Nq2.F(AbstractC6209Mq2.c(AbstractC6459Nq2.c0(this.e.d.a(), new a(interfaceC21256tN5A, null)), null, new b(interfaceC21256tN5A, this.e, null))), new e(null, this.e, interfaceC21256tN5A));
                C0731d c0731d = new C0731d(oc6);
                this.b = 1;
                if (interfaceC4557Fq2D.b(c0731d, this) == objE) {
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
        public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return WS4.this.h(null, this);
        }
    }

    /* synthetic */ class f extends EB2 implements SA2 {
        f(Object obj) {
            super(0, obj, WS4.class, "invalidate", "invalidate()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((WS4) this.receiver).k();
        }
    }

    /* synthetic */ class g extends EB2 implements SA2 {
        g(Object obj) {
            super(0, obj, WS4.class, "invalidate", "invalidate()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((WS4) this.receiver).k();
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC21256tN5 d;
        final /* synthetic */ XS4 e;
        final /* synthetic */ C20889sm4 f;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ OC6 a;

            a(OC6 oc6) {
                this.a = oc6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(VS4 vs4, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objO = this.a.o(vs4, interfaceC20295rm1);
                return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
            }
        }

        public static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC4557Fq2 d;
            final /* synthetic */ InterfaceC4557Fq2 e;
            final /* synthetic */ C20889sm4 f;

            public static final class a extends AbstractC19859r37 implements InterfaceC16978mB2 {
                int b;
                /* synthetic */ Object c;
                /* synthetic */ Object d;
                /* synthetic */ Object e;
                final /* synthetic */ OC6 f;
                final /* synthetic */ C20889sm4 g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1, C20889sm4 c20889sm4) {
                    super(4, interfaceC20295rm1);
                    this.g = c20889sm4;
                    this.f = oc6;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        Object obj2 = this.c;
                        Object obj3 = this.d;
                        EnumC10994cZ0 enumC10994cZ0 = (EnumC10994cZ0) this.e;
                        OC6 oc6 = this.f;
                        Object cVar = (VS4) obj3;
                        C14653iG3 c14653iG3 = (C14653iG3) obj2;
                        if (enumC10994cZ0 == EnumC10994cZ0.RECEIVER) {
                            cVar = new VS4.c(this.g.d(), c14653iG3);
                        } else if (cVar instanceof VS4.b) {
                            VS4.b bVar = (VS4.b) cVar;
                            this.g.b(bVar.m());
                            cVar = VS4.b.g(bVar, null, null, 0, 0, bVar.m(), c14653iG3, 15, null);
                        } else if (cVar instanceof VS4.a) {
                            this.g.c(((VS4.a) cVar).e(), AbstractC13460gG3.c.b.b());
                        } else {
                            if (!(cVar instanceof VS4.c)) {
                                if (cVar instanceof VS4.d) {
                                    throw new IllegalStateException("Paging generated an event to display a static list that\n originated from a paginated source. If you see this\n exception, it is most likely a bug in the library.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            VS4.c cVar2 = (VS4.c) cVar;
                            this.g.b(cVar2.f());
                            cVar = new VS4.c(cVar2.f(), c14653iG3);
                        }
                        this.b = 1;
                        if (oc6.o(cVar, this) == objE) {
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

                @Override // ir.nasim.InterfaceC16978mB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object e(Object obj, Object obj2, EnumC10994cZ0 enumC10994cZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.f, interfaceC20295rm1, this.g);
                    aVar.c = obj;
                    aVar.d = obj2;
                    aVar.e = enumC10994cZ0;
                    return aVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.WS4$h$b$b, reason: collision with other inner class name */
            public static final class C0732b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ OC6 c;
                final /* synthetic */ InterfaceC4557Fq2 d;
                final /* synthetic */ AtomicInteger e;
                final /* synthetic */ VA7 f;
                final /* synthetic */ int g;

                /* renamed from: ir.nasim.WS4$h$b$b$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ VA7 a;
                    final /* synthetic */ int b;

                    /* renamed from: ir.nasim.WS4$h$b$b$a$a, reason: collision with other inner class name */
                    static final class C0733a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        C0733a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(VA7 va7, int i) {
                        this.a = va7;
                        this.b = i;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.WS4.h.b.C0732b.a.C0733a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.WS4$h$b$b$a$a r0 = (ir.nasim.WS4.h.b.C0732b.a.C0733a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.WS4$h$b$b$a$a r0 = new ir.nasim.WS4$h$b$b$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 2
                            r4 = 1
                            if (r2 == 0) goto L38
                            if (r2 == r4) goto L34
                            if (r2 != r3) goto L2c
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L51
                        L2c:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L34:
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L48
                        L38:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.VA7 r7 = r5.a
                            int r2 = r5.b
                            r0.b = r4
                            java.lang.Object r6 = r7.a(r2, r6, r0)
                            if (r6 != r1) goto L48
                            return r1
                        L48:
                            r0.b = r3
                            java.lang.Object r6 = ir.nasim.AbstractC23846xc8.a(r0)
                            if (r6 != r1) goto L51
                            return r1
                        L51:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WS4.h.b.C0732b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0732b(InterfaceC4557Fq2 interfaceC4557Fq2, AtomicInteger atomicInteger, OC6 oc6, VA7 va7, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC4557Fq2;
                    this.e = atomicInteger;
                    this.f = va7;
                    this.g = i;
                    this.c = oc6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0732b(this.d, this.e, this.c, this.f, this.g, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AtomicInteger atomicInteger;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    try {
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                            a aVar = new a(this.f, this.g);
                            this.b = 1;
                            if (interfaceC4557Fq2.b(aVar, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        if (atomicInteger.decrementAndGet() == 0) {
                            InterfaceC16756lo6.a.a(this.c, null, 1, null);
                        }
                        return C19938rB7.a;
                    } finally {
                        if (this.e.decrementAndGet() == 0) {
                            InterfaceC16756lo6.a.a(this.c, null, 1, null);
                        }
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0732b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class c extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ InterfaceC24075y01 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(InterfaceC24075y01 interfaceC24075y01) {
                    super(0);
                    this.e = interfaceC24075y01;
                }

                public final void a() {
                    InterfaceC13730gj3.a.a(this.e, null, 1, null);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC20295rm1 interfaceC20295rm1, C20889sm4 c20889sm4) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC4557Fq2;
                this.e = interfaceC4557Fq22;
                this.f = c20889sm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, interfaceC20295rm1, this.f);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                int i = 0;
                Object objE = AbstractC14862ic3.e();
                int i2 = this.b;
                if (i2 == 0) {
                    AbstractC10685c16.b(obj);
                    OC6 oc6 = (OC6) this.c;
                    AtomicInteger atomicInteger = new AtomicInteger(2);
                    VA7 va7 = new VA7(new a(oc6, null, this.f));
                    InterfaceC24075y01 interfaceC24075y01B = AbstractC20267rj3.b(null, 1, null);
                    InterfaceC4557Fq2[] interfaceC4557Fq2Arr = {this.d, this.e};
                    int i3 = 0;
                    while (i < 2) {
                        AbstractC10533bm0.d(oc6, interfaceC24075y01B, null, new C0732b(interfaceC4557Fq2Arr[i], atomicInteger, oc6, va7, i3, null), 2, null);
                        i++;
                        i3++;
                        interfaceC4557Fq2Arr = interfaceC4557Fq2Arr;
                    }
                    c cVar = new c(interfaceC24075y01B);
                    this.b = 1;
                    if (oc6.S(cVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(InterfaceC21256tN5 interfaceC21256tN5, XS4 xs4, C20889sm4 c20889sm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC21256tN5;
            this.e = xs4;
            this.f = c20889sm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, this.e, this.f, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                OC6 oc6 = (OC6) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2A = BC6.a(new b(this.d.getState(), this.e.u(), null, this.f));
                a aVar = new a(oc6);
                this.b = 1;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
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
        public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public WS4(UA2 ua2, Object obj, MT4 mt4, AbstractC20044rN5 abstractC20044rN5) {
        AbstractC13042fc3.i(ua2, "pagingSourceFactory");
        AbstractC13042fc3.i(mt4, "config");
        this.a = ua2;
        this.b = obj;
        this.c = mt4;
        this.d = new C14259hd1(null, 1, null);
        this.e = new C14259hd1(null, 1, null);
        this.f = BC6.a(new d(abstractC20044rN5, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.YT4 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.WS4.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.WS4$e r0 = (ir.nasim.WS4.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.WS4$e r0 = new ir.nasim.WS4$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            ir.nasim.YT4 r5 = (ir.nasim.YT4) r5
            java.lang.Object r0 = r0.a
            ir.nasim.WS4 r0 = (ir.nasim.WS4) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.UA2 r6 = r4.a
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            ir.nasim.YT4 r6 = (ir.nasim.YT4) r6
            if (r6 == r5) goto L86
            ir.nasim.WS4$f r1 = new ir.nasim.WS4$f
            r1.<init>(r0)
            r6.g(r1)
            if (r5 == 0) goto L62
            ir.nasim.WS4$g r1 = new ir.nasim.WS4$g
            r1.<init>(r0)
            r5.h(r1)
        L62:
            if (r5 == 0) goto L67
            r5.e()
        L67:
            ir.nasim.XT4 r5 = ir.nasim.XT4.a
            r0 = 3
            boolean r1 = r5.a(r0)
            if (r1 == 0) goto L85
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Generated new PagingSource "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r5.b(r0, r1, r2)
        L85:
            return r6
        L86:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WS4.h(ir.nasim.YT4, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 j(XS4 xs4, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC21256tN5 interfaceC21256tN5) {
        return interfaceC21256tN5 == null ? xs4.u() : DE0.a(interfaceC13730gj3, new h(interfaceC21256tN5, xs4, new C20889sm4(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        this.d.b(Boolean.FALSE);
    }

    public final InterfaceC4557Fq2 i() {
        return this.f;
    }

    public final void l() {
        this.d.b(Boolean.TRUE);
    }
}
