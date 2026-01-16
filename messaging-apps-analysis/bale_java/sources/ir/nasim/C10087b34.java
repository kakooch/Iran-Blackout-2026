package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.b34, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10087b34 {
    private final InterfaceC20315ro1 a;
    private final int b;
    private final AbstractC13778go1 c;
    private final InterfaceC4308Eo5 d;
    private final InterfaceC5943Lm5 e;
    private final Context f;
    private final CopyOnWriteArrayList g;
    private InterfaceC13730gj3 h;
    private final InterfaceC9336Zm4 i;
    private final Map j;

    /* renamed from: ir.nasim.b34$a */
    public interface a {
        C10087b34 a(InterfaceC20315ro1 interfaceC20315ro1);
    }

    /* renamed from: ir.nasim.b34$b */
    public interface b {
        int a();

        void b();

        void c(String str);

        void d(String str);

        void e();
    }

    /* renamed from: ir.nasim.b34$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.b34$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            int g;
            /* synthetic */ Object h;
            final /* synthetic */ C10087b34 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10087b34 c10087b34, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.i = c10087b34;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.i, interfaceC20295rm1);
                aVar.h = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0187  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0198  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x01ce  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0176 -> B:55:0x0177). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instructions count: 499
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10087b34.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(set, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.b34$c$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.b34$c$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.b34$c$b$a$a, reason: collision with other inner class name */
                public static final class C0891a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0891a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C10087b34.c.b.a.C0891a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.b34$c$b$a$a r0 = (ir.nasim.C10087b34.c.b.a.C0891a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.b34$c$b$a$a r0 = new ir.nasim.b34$c$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.util.Set r2 = (java.util.Set) r2
                        java.util.Collection r2 = (java.util.Collection) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10087b34.c.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10087b34.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(AbstractC6459Nq2.s(C10087b34.this.i, 100L));
                a aVar = new a(C10087b34.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.b34$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C10087b34.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            C10087b34.this.o(interfaceC20315ro1);
            C10087b34.this.n(interfaceC20315ro1);
            if (C8386Vt0.a.n9()) {
                C10087b34.this.l(interfaceC20315ro1);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.b34$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.b34$e$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C10087b34 a;

            a(C10087b34 c10087b34) {
                this.a = c10087b34;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a.g;
                C10087b34 c10087b34 = this.a;
                for (b bVar : copyOnWriteArrayList) {
                    PI7 pi7 = (PI7) map.get(AbstractC6392Nk0.d(bVar.a()));
                    if (pi7 != null) {
                        bVar.d(C14593iA1.y(c10087b34.f, pi7, false, 4, null));
                    }
                }
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.b34$e$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.b34$e$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.b34$e$b$a$a, reason: collision with other inner class name */
                public static final class C0892a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0892a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C10087b34.e.b.a.C0892a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.b34$e$b$a$a r0 = (ir.nasim.C10087b34.e.b.a.C0892a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.b34$e$b$a$a r0 = new ir.nasim.b34$e$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.util.Set r2 = (java.util.Set) r2
                        java.util.Collection r2 = (java.util.Collection) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10087b34.e.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.b34$e$c */
        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C10087b34 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, C10087b34 c10087b34) {
                super(3, interfaceC20295rm1);
                this.e = c10087b34;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Set set = (Set) this.d;
                    Set set2 = set;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
                    Iterator it = set2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.e(((Number) it.next()).intValue()));
                    }
                    InterfaceC4557Fq2 interfaceC4557Fq2C = arrayList.isEmpty() ? AbstractC6459Nq2.C() : new d(this.e.d.a(arrayList), set);
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2C, this) == objE) {
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
                c cVar = new c(interfaceC20295rm1, this.e);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.b34$e$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ Set b;

            /* renamed from: ir.nasim.b34$e$d$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ Set b;

                /* renamed from: ir.nasim.b34$e$d$a$a, reason: collision with other inner class name */
                public static final class C0893a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0893a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, Set set) {
                    this.a = interfaceC4806Gq2;
                    this.b = set;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r9, ir.nasim.InterfaceC20295rm1 r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof ir.nasim.C10087b34.e.d.a.C0893a
                        if (r0 == 0) goto L13
                        r0 = r10
                        ir.nasim.b34$e$d$a$a r0 = (ir.nasim.C10087b34.e.d.a.C0893a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.b34$e$d$a$a r0 = new ir.nasim.b34$e$d$a$a
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r10)
                        goto L7e
                    L29:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L31:
                        ir.nasim.AbstractC10685c16.b(r10)
                        ir.nasim.Gq2 r10 = r8.a
                        java.util.Map r9 = (java.util.Map) r9
                        java.util.Set r2 = r8.b
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                        r5 = 10
                        int r5 = ir.nasim.ZW0.x(r2, r5)
                        int r5 = ir.nasim.AbstractC18278oO3.f(r5)
                        r6 = 16
                        int r5 = ir.nasim.AbstractC21867uG5.e(r5, r6)
                        r4.<init>(r5)
                        java.util.Iterator r2 = r2.iterator()
                    L55:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L75
                        java.lang.Object r5 = r2.next()
                        r6 = r5
                        java.lang.Number r6 = (java.lang.Number) r6
                        int r6 = r6.intValue()
                        long r6 = (long) r6
                        java.lang.Long r6 = ir.nasim.AbstractC6392Nk0.e(r6)
                        java.lang.Object r6 = r9.get(r6)
                        ir.nasim.PI7 r6 = (ir.nasim.PI7) r6
                        r4.put(r5, r6)
                        goto L55
                    L75:
                        r0.b = r3
                        java.lang.Object r9 = r10.a(r4, r0)
                        if (r9 != r1) goto L7e
                        return r1
                    L7e:
                        ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10087b34.e.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2, Set set) {
                this.a = interfaceC4557Fq2;
                this.b = set;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10087b34.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.s0(new b(C10087b34.this.i), new c(null, C10087b34.this)), C10087b34.this.c);
                a aVar = new a(C10087b34.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.b34$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.b34$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10087b34 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10087b34 c10087b34, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10087b34;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Set set = (Set) this.c;
                    if (!set.isEmpty()) {
                        InterfaceC4308Eo5 interfaceC4308Eo5 = this.d.d;
                        List listM1 = AbstractC15401jX0.m1(set);
                        this.b = 1;
                        if (interfaceC4308Eo5.f(listM1, true, this) == objE) {
                            return objE;
                        }
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
            public final Object invoke(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(set, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.b34$f$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.b34$f$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.b34$f$b$a$a, reason: collision with other inner class name */
                public static final class C0894a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0894a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C10087b34.f.b.a.C0894a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.b34$f$b$a$a r0 = (ir.nasim.C10087b34.f.b.a.C0894a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.b34$f$b$a$a r0 = new ir.nasim.b34$f$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.util.Set r2 = (java.util.Set) r2
                        java.util.Collection r2 = (java.util.Collection) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10087b34.f.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10087b34.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(AbstractC6459Nq2.s(C10087b34.this.i, 100L));
                a aVar = new a(C10087b34.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10087b34(InterfaceC20315ro1 interfaceC20315ro1, int i, AbstractC13778go1 abstractC13778go1, InterfaceC4308Eo5 interfaceC4308Eo5, InterfaceC5943Lm5 interfaceC5943Lm5, Context context) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "defaultDispatcher");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(context, "context");
        this.a = interfaceC20315ro1;
        this.b = i;
        this.c = abstractC13778go1;
        this.d = interfaceC4308Eo5;
        this.e = interfaceC5943Lm5;
        this.f = context;
        this.g = new CopyOnWriteArrayList();
        this.i = AbstractC12281eL6.a(AbstractC4597Fu6.d());
        this.j = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 l(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(null), 3, null);
    }

    private final InterfaceC13730gj3 m() {
        return AbstractC10533bm0.d(this.a, null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 n(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new e(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 o(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new f(null), 3, null);
    }

    public final void p(b bVar) {
        AbstractC13042fc3.i(bVar, "adapter");
        this.g.add(bVar);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        CopyOnWriteArrayList copyOnWriteArrayList = this.g;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(copyOnWriteArrayList, 10));
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((b) it.next()).a()));
        }
        interfaceC9336Zm4.setValue(AbstractC15401jX0.r1(arrayList));
        if (C8386Vt0.a.n9() && bVar.a() != this.b) {
            String str = (String) this.j.get(Integer.valueOf(bVar.a()));
            if (str != null) {
                bVar.c(str);
            } else {
                bVar.c(null);
            }
        }
        bVar.e();
    }

    public final void q() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.h;
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
            this.h = m();
        }
    }

    public final void r() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.h;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.h = null;
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
        this.g.clear();
        this.j.clear();
    }

    public final void s(b bVar) {
        AbstractC13042fc3.i(bVar, "adapter");
        this.g.remove(bVar);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        CopyOnWriteArrayList copyOnWriteArrayList = this.g;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(copyOnWriteArrayList, 10));
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((b) it.next()).a()));
        }
        interfaceC9336Zm4.setValue(AbstractC15401jX0.r1(arrayList));
        bVar.b();
    }
}
