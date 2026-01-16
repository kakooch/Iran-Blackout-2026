package ir.nasim;

import ir.nasim.C12443ed3;
import ir.nasim.Q12;
import ir.nasim.UO1;
import ir.nasim.database.dailogLists.DialogFolderEntity;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.ed3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12443ed3 {
    private final int a;
    private final C8590Wp6 b;
    private final ir.nasim.database.dailogLists.c c;
    private final InterfaceC20315ro1 d;
    private final InterfaceC24823zG1 e;
    private final String f;
    private final InterfaceC8327Vm4 g;
    private final AtomicBoolean h;
    private final AtomicBoolean i;
    private final long j;
    private final long k;
    private final long l;
    private final long m;
    private final C21254tN3 n;
    private final InterfaceC4557Fq2 o;

    /* renamed from: ir.nasim.ed3$a */
    public interface a {
        C12443ed3 a(int i, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC24823zG1 interfaceC24823zG1);
    }

    /* renamed from: ir.nasim.ed3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.ed3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12443ed3 c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* renamed from: ir.nasim.ed3$b$a$a, reason: collision with other inner class name */
            static final class C1054a implements InterfaceC4806Gq2 {
                final /* synthetic */ C12443ed3 a;
                final /* synthetic */ InterfaceC16204ks5 b;

                C1054a(C12443ed3 c12443ed3, InterfaceC16204ks5 interfaceC16204ks5) {
                    this.a = c12443ed3;
                    this.b = interfaceC16204ks5;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                    UO1.d.a.b(this.a.a, "immediateInvalidation", "InvalidationTracker");
                    Object objQ = this.a.q(this.b, interfaceC20295rm1);
                    return objQ == AbstractC14862ic3.e() ? objQ : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12443ed3 c12443ed3, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12443ed3;
                this.d = interfaceC16204ks5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8327Vm4 interfaceC8327Vm4 = this.c.g;
                    C1054a c1054a = new C1054a(this.c, this.d);
                    this.b = 1;
                    if (interfaceC8327Vm4.b(c1054a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ed3$b$b, reason: collision with other inner class name */
        static final class C1055b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12443ed3 c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* renamed from: ir.nasim.ed3$b$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C12443ed3 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C12443ed3 c12443ed3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                    this.d = c12443ed3;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    Throwable th = (Throwable) this.c;
                    UO1.d.a.c("getOrderedDialogPeerUIDSInFolder() crashed.", th, UO1.d.a.h, this.d.a);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = th;
                    return aVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.ed3$b$b$b, reason: collision with other inner class name */
            static final class C1056b extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ Object d;
                final /* synthetic */ C9663aL5 e;
                final /* synthetic */ C12443ed3 f;

                /* renamed from: ir.nasim.ed3$b$b$b$a */
                static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C12443ed3 c;

                    /* renamed from: ir.nasim.ed3$b$b$b$a$a, reason: collision with other inner class name */
                    static final class C1057a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;

                        C1057a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            return new C1057a(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            return AbstractC6392Nk0.a(true);
                        }

                        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C1057a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    a(C12443ed3 c12443ed3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c12443ed3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC10258bL6 interfaceC10258bL6A = this.c.b.a();
                            C1057a c1057a = new C1057a(null);
                            this.b = 1;
                            obj = AbstractC6459Nq2.H(interfaceC10258bL6A, c1057a, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        return obj;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1056b(C9663aL5 c9663aL5, C12443ed3 c12443ed3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                    this.e = c9663aL5;
                    this.f = c12443ed3;
                }

                /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0108 A[RETURN] */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                    /*
                        Method dump skipped, instructions count: 271
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12443ed3.b.C1055b.C1056b.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1056b c1056b = new C1056b(this.e, this.f, interfaceC20295rm1);
                    c1056b.c = interfaceC4806Gq2;
                    c1056b.d = list;
                    return c1056b.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.ed3$b$b$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C12443ed3 d;
                final /* synthetic */ InterfaceC16204ks5 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C12443ed3 c12443ed3, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c12443ed3;
                    this.e = interfaceC16204ks5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    c cVar = new c(this.d, this.e, interfaceC20295rm1);
                    cVar.c = obj;
                    return cVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        List list = (List) this.c;
                        UO1.d.a.b(this.d.a, "DataBaseOrderChanged SENT Count:" + list.size(), "Invalidation");
                        C12443ed3 c12443ed3 = this.d;
                        InterfaceC16204ks5 interfaceC16204ks5 = this.e;
                        this.b = 1;
                        if (c12443ed3.q(interfaceC16204ks5, this) == objE) {
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
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1055b(C12443ed3 c12443ed3, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12443ed3;
                this.d = interfaceC16204ks5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final long y(C12443ed3 c12443ed3) {
                if (!c12443ed3.i.get()) {
                    return c12443ed3.m;
                }
                if (c12443ed3.n()) {
                    return c12443ed3.l;
                }
                c12443ed3.i.set(false);
                return c12443ed3.m;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1055b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C9663aL5 c9663aL5 = new C9663aL5();
                    c9663aL5.a = true;
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.y(AbstractC6459Nq2.s0(AbstractC6459Nq2.h(ir.nasim.database.dailogLists.c.D(this.c.c, this.c.a, C8386Vt0.a.V3(), false, 4, null), new a(this.c, null)), new C1056b(c9663aL5, this.c, null)), 1));
                    final C12443ed3 c12443ed3 = this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC19146pr2.a(interfaceC4557Fq2V, new SA2() { // from class: ir.nasim.fd3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return Long.valueOf(C12443ed3.b.C1055b.y(c12443ed3));
                        }
                    });
                    c cVar = new c(this.c, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2A, cVar, this) == objE) {
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1055b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C12443ed3.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
            AbstractC10533bm0.d(interfaceC16204ks5, null, null, new a(C12443ed3.this, interfaceC16204ks5, null), 3, null);
            AbstractC10533bm0.d(interfaceC16204ks5, null, null, new C1055b(C12443ed3.this, interfaceC16204ks5, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ed3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            UO1.d.a.b(C12443ed3.this.a, "Tracker flow completed.", "Invalidation");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12443ed3.this.new c(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    public C12443ed3(int i, C8590Wp6 c8590Wp6, ir.nasim.database.dailogLists.c cVar, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC24823zG1 interfaceC24823zG1) {
        AbstractC13042fc3.i(c8590Wp6, "sequenceSyncStatus");
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = i;
        this.b = c8590Wp6;
        this.c = cVar;
        this.d = interfaceC20315ro1;
        this.e = interfaceC24823zG1;
        this.f = "InvalidationTracker";
        this.g = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);
        this.h = new AtomicBoolean(true);
        this.i = new AtomicBoolean(true);
        this.j = System.currentTimeMillis();
        Q12.a aVar = Q12.b;
        this.k = Q12.A(T12.s(3, W12.e));
        this.l = 500L;
        this.m = 100L;
        C21254tN3 c21254tN3 = new C21254tN3();
        this.n = c21254tN3;
        this.o = AbstractC9370Zq2.h(AbstractC6459Nq2.a0(AbstractC7420Rq2.b(AbstractC6459Nq2.j(new b(null)), -1, null, 2, null), new c(null)), interfaceC20315ro1, c21254tN3, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        return System.currentTimeMillis() - this.j < this.k && !((Boolean) this.b.a().getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!this.h.get()) {
            return C19938rB7.a;
        }
        UO1.d.a.b(this.a, DialogFolderEntity.COLUMN_IS_ACTIVE, this.f);
        Object objO = interfaceC16204ks5.o(AbstractC6392Nk0.e(System.currentTimeMillis()), interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }

    public final void k() {
        this.n.c();
        this.h.set(true);
        UO1.d.a.b(this.a, "Tracker enabled.", "Invalidation");
    }

    public final InterfaceC4557Fq2 l() {
        return this.o;
    }

    public final Object m(InterfaceC20295rm1 interfaceC20295rm1) {
        UO1.d.a.b(this.a, "Request for IMMEDIATE Invalidation", this.f);
        InterfaceC8327Vm4 interfaceC8327Vm4 = this.g;
        C19938rB7 c19938rB7 = C19938rB7.a;
        Object objA = interfaceC8327Vm4.a(c19938rB7, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : c19938rB7;
    }

    public final void o() {
        this.h.set(false);
    }

    public final void p() {
        this.h.set(true);
    }
}
