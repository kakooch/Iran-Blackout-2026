package ir.nasim;

import androidx.lifecycle.j;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.ez3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12660ez3 implements InterfaceC20315ro1 {
    private final XZ a;
    private final InterfaceC24075y01 b;
    private final InterfaceC11938do1 c;

    /* renamed from: ir.nasim.ez3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12660ez3.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12660ez3 c12660ez3 = C12660ez3.this;
                j.b bVar = j.b.RESUMED;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (c12660ez3.d(bVar, interfaceC14603iB2, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ez3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ androidx.lifecycle.j d;
        final /* synthetic */ C12660ez3 e;
        final /* synthetic */ j.b f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* renamed from: ir.nasim.ez3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            int i;
            final /* synthetic */ androidx.lifecycle.j j;
            final /* synthetic */ C12660ez3 k;
            final /* synthetic */ j.b l;
            final /* synthetic */ InterfaceC20315ro1 m;
            final /* synthetic */ InterfaceC14603iB2 n;

            /* renamed from: ir.nasim.ez3$b$a$a, reason: collision with other inner class name */
            static final class C1063a implements androidx.lifecycle.n {
                final /* synthetic */ j.a a;
                final /* synthetic */ C12889fL5 b;
                final /* synthetic */ InterfaceC20315ro1 c;
                final /* synthetic */ j.a d;
                final /* synthetic */ HE0 e;
                final /* synthetic */ InterfaceC19699qn4 f;
                final /* synthetic */ InterfaceC14603iB2 g;

                /* renamed from: ir.nasim.ez3$b$a$a$a, reason: collision with other inner class name */
                static final class C1064a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    Object c;
                    int d;
                    final /* synthetic */ InterfaceC19699qn4 e;
                    final /* synthetic */ InterfaceC14603iB2 f;

                    /* renamed from: ir.nasim.ez3$b$a$a$a$a, reason: collision with other inner class name */
                    static final class C1065a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        private /* synthetic */ Object c;
                        final /* synthetic */ InterfaceC14603iB2 d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1065a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = interfaceC14603iB2;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C1065a c1065a = new C1065a(this.d, interfaceC20295rm1);
                            c1065a.c = obj;
                            return c1065a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            Object objE = AbstractC14862ic3.e();
                            int i = this.b;
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                                this.b = 1;
                                if (interfaceC14603iB2.invoke(interfaceC20315ro1, this) == objE) {
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
                            return ((C1065a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1064a(InterfaceC19699qn4 interfaceC19699qn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.e = interfaceC19699qn4;
                        this.f = interfaceC14603iB2;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1064a(this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        InterfaceC19699qn4 interfaceC19699qn4;
                        InterfaceC14603iB2 interfaceC14603iB2;
                        InterfaceC19699qn4 interfaceC19699qn42;
                        Throwable th;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.d;
                        try {
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                interfaceC19699qn4 = this.e;
                                interfaceC14603iB2 = this.f;
                                this.b = interfaceC19699qn4;
                                this.c = interfaceC14603iB2;
                                this.d = 1;
                                if (interfaceC19699qn4.a(null, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                                    try {
                                        AbstractC10685c16.b(obj);
                                        C19938rB7 c19938rB7 = C19938rB7.a;
                                        interfaceC19699qn42.e(null);
                                        return C19938rB7.a;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        interfaceC19699qn42.e(null);
                                        throw th;
                                    }
                                }
                                interfaceC14603iB2 = (InterfaceC14603iB2) this.c;
                                InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                                AbstractC10685c16.b(obj);
                                interfaceC19699qn4 = interfaceC19699qn43;
                            }
                            C1065a c1065a = new C1065a(interfaceC14603iB2, null);
                            this.b = interfaceC19699qn4;
                            this.c = null;
                            this.d = 2;
                            if (AbstractC20906so1.e(c1065a, this) == objE) {
                                return objE;
                            }
                            interfaceC19699qn42 = interfaceC19699qn4;
                            C19938rB7 c19938rB72 = C19938rB7.a;
                            interfaceC19699qn42.e(null);
                            return C19938rB7.a;
                        } catch (Throwable th3) {
                            interfaceC19699qn42 = interfaceC19699qn4;
                            th = th3;
                            interfaceC19699qn42.e(null);
                            throw th;
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1064a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                C1063a(j.a aVar, C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, j.a aVar2, HE0 he0, InterfaceC19699qn4 interfaceC19699qn4, InterfaceC14603iB2 interfaceC14603iB2) {
                    this.a = aVar;
                    this.b = c12889fL5;
                    this.c = interfaceC20315ro1;
                    this.d = aVar2;
                    this.e = he0;
                    this.f = interfaceC19699qn4;
                    this.g = interfaceC14603iB2;
                }

                @Override // androidx.lifecycle.n
                public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                    AbstractC13042fc3.i(interfaceC18633oz3, "<unused var>");
                    AbstractC13042fc3.i(aVar, "event");
                    if (aVar == this.a) {
                        this.b.a = AbstractC10533bm0.d(this.c, null, null, new C1064a(this.f, this.g, null), 3, null);
                        return;
                    }
                    if (aVar == this.d) {
                        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.b.a;
                        if (interfaceC13730gj3 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                        }
                        this.b.a = null;
                    }
                    if (aVar == j.a.ON_DESTROY) {
                        HE0 he0 = this.e;
                        C9475a16.a aVar2 = C9475a16.b;
                        he0.resumeWith(C9475a16.b(C19938rB7.a));
                    }
                }
            }

            /* renamed from: ir.nasim.ez3$b$a$b, reason: collision with other inner class name */
            public static final class C1066b implements WZ {
                final /* synthetic */ C12889fL5 a;
                final /* synthetic */ C12660ez3 b;

                C1066b(C12889fL5 c12889fL5, C12660ez3 c12660ez3) {
                    this.a = c12889fL5;
                    this.b = c12660ez3;
                }

                @Override // ir.nasim.WZ
                public void k() {
                    androidx.lifecycle.n nVar = (androidx.lifecycle.n) this.a.a;
                    if (nVar != null) {
                        nVar.s(this.b.a, j.a.ON_PAUSE);
                    }
                }

                @Override // ir.nasim.WZ
                public void m() {
                    androidx.lifecycle.n nVar = (androidx.lifecycle.n) this.a.a;
                    if (nVar != null) {
                        nVar.s(this.b.a, j.a.ON_RESUME);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.lifecycle.j jVar, C12660ez3 c12660ez3, j.b bVar, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.j = jVar;
                this.k = c12660ez3;
                this.l = bVar;
                this.m = interfaceC20315ro1;
                this.n = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.j, this.k, this.l, this.m, this.n, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 249
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12660ez3.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.lifecycle.j jVar, C12660ez3 c12660ez3, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = jVar;
            this.e = c12660ez3;
            this.f = bVar;
            this.g = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                WM3 wm3F0 = C12366eV1.c().F0();
                a aVar = new a(this.d, this.e, this.f, interfaceC20315ro1, this.g, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3F0, aVar, this) == objE) {
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

    public C12660ez3(XZ xz) {
        AbstractC13042fc3.i(xz, "lifecycleOwner");
        this.a = xz;
        InterfaceC24075y01 interfaceC24075y01A = P17.a(AbstractC19067pj3.p(AbstractC19224pz3.a(xz).getCoroutineContext()));
        this.b = interfaceC24075y01A;
        this.c = interfaceC24075y01A.X(C12366eV1.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        androidx.lifecycle.j lifecycle = this.a.getLifecycle();
        if (bVar == j.b.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        }
        if (lifecycle.b() == j.b.DESTROYED) {
            return C19938rB7.a;
        }
        Object objE = AbstractC20906so1.e(new b(lifecycle, this, bVar, interfaceC14603iB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final InterfaceC13730gj3 c(InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC11938do1, "coroutineContext");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(this, interfaceC11938do1, null, new a(interfaceC14603iB2, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.c;
    }
}
