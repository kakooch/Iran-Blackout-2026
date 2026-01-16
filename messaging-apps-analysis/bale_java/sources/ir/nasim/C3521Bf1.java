package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Bf1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3521Bf1 implements ir.nasim.contact.data.d {
    private final C5183Ig1 b;
    private final InterfaceC6118Mg1 c;
    private final OK7 d;
    private final C4471Fg6 e;
    private final InterfaceC4308Eo5 f;
    private final InterfaceC20315ro1 g;
    private final String h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;

    /* renamed from: ir.nasim.Bf1$a */
    public interface a {
        C3521Bf1 a(String str);
    }

    /* renamed from: ir.nasim.Bf1$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C3521Bf1.this.m(0, 0, this);
        }
    }

    /* renamed from: ir.nasim.Bf1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3521Bf1.this.new c(this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r7.b
                java.util.List r0 = (java.util.List) r0
                ir.nasim.AbstractC10685c16.b(r8)
                goto L89
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L22:
                java.lang.Object r1 = r7.b
                java.util.Collection r1 = (java.util.Collection) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L6b
            L2a:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L53
            L2e:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.Bf1 r8 = ir.nasim.C3521Bf1.this
                java.lang.String r8 = ir.nasim.C3521Bf1.h(r8)
                if (r8 == 0) goto L72
                int r8 = r8.length()
                if (r8 != 0) goto L40
                goto L72
            L40:
                ir.nasim.Bf1 r8 = ir.nasim.C3521Bf1.this
                java.lang.String r1 = ir.nasim.C3521Bf1.h(r8)
                int r5 = r7.e
                int r6 = r7.f
                r7.c = r4
                java.lang.Object r8 = ir.nasim.C3521Bf1.l(r8, r1, r5, r6, r7)
                if (r8 != r0) goto L53
                return r0
            L53:
                r1 = r8
                java.util.Collection r1 = (java.util.Collection) r1
                ir.nasim.Bf1 r8 = ir.nasim.C3521Bf1.this
                java.lang.String r4 = ir.nasim.C3521Bf1.h(r8)
                int r5 = r7.e
                int r6 = r7.f
                r7.b = r1
                r7.c = r3
                java.lang.Object r8 = ir.nasim.C3521Bf1.k(r8, r4, r5, r6, r7)
                if (r8 != r0) goto L6b
                return r0
            L6b:
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.List r8 = ir.nasim.ZW0.R0(r1, r8)
                goto L76
            L72:
                java.util.List r8 = ir.nasim.ZW0.m()
            L76:
                ir.nasim.Bf1 r1 = ir.nasim.C3521Bf1.this
                int r3 = r7.e
                int r4 = r7.f
                r7.b = r8
                r7.c = r2
                java.lang.Object r1 = ir.nasim.C3521Bf1.d(r1, r3, r4, r7)
                if (r1 != r0) goto L87
                return r0
            L87:
                r0 = r8
                r8 = r1
            L89:
                java.util.List r8 = (java.util.List) r8
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r8 = ir.nasim.ZW0.R0(r8, r0)
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.HashSet r0 = new java.util.HashSet
                r0.<init>()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r8 = r8.iterator()
            La3:
                boolean r2 = r8.hasNext()
                if (r2 == 0) goto Lc2
                java.lang.Object r2 = r8.next()
                r3 = r2
                ir.nasim.wY r3 = (ir.nasim.C23209wY) r3
                int r3 = r3.a()
                java.lang.Integer r3 = ir.nasim.AbstractC6392Nk0.d(r3)
                boolean r3 = r0.add(r3)
                if (r3 == 0) goto La3
                r1.add(r2)
                goto La3
            Lc2:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3521Bf1.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bf1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        int g;
        /* synthetic */ Object h;
        int j;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return C3521Bf1.this.p(null, 0, 0, this);
        }
    }

    /* renamed from: ir.nasim.Bf1$e */
    static final class e implements GB3 {
        final /* synthetic */ HE0 b;

        /* renamed from: ir.nasim.Bf1$e$a */
        static final class a implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;
            final /* synthetic */ List b;

            a(HE0 he0, List list) {
                this.a = he0;
                this.b = list;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(C14505i18 c14505i18) {
                AbstractC24549yo1.c(this.a, this.b);
            }
        }

        e(HE0 he0) {
            this.b = he0;
        }

        @Override // ir.nasim.GB3
        public final void a(List list, long j, long j2) {
            OK7 ok7 = C3521Bf1.this.d;
            AbstractC13042fc3.f(list);
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((C18823pJ2) it.next()).c.getPeerId()));
            }
            ok7.w0(arrayList, false).m0(new a(this.b, list));
        }
    }

    /* renamed from: ir.nasim.Bf1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bf1$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        int h;
        int i;
        /* synthetic */ Object j;
        int l;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= RecyclerView.UNDEFINED_DURATION;
            return C3521Bf1.this.q(null, 0, 0, this);
        }
    }

    /* renamed from: ir.nasim.Bf1$h */
    static final class h implements GB3 {
        final /* synthetic */ HE0 b;

        /* renamed from: ir.nasim.Bf1$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C3521Bf1 c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3521Bf1 c3521Bf1, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c3521Bf1;
                this.d = list;
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
                    InterfaceC4308Eo5 interfaceC4308Eo5 = this.c.f;
                    List list = this.d;
                    AbstractC13042fc3.f(list);
                    List list2 = list;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((C18823pJ2) it.next()).c.getPeerId()));
                    }
                    this.b = 1;
                    if (interfaceC4308Eo5.f(arrayList, true, this) == objE) {
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

        /* renamed from: ir.nasim.Bf1$h$b */
        static final class b implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;
            final /* synthetic */ List b;

            b(HE0 he0, List list) {
                this.a = he0;
                this.b = list;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(C14505i18 c14505i18) {
                AbstractC24549yo1.c(this.a, this.b);
            }
        }

        h(HE0 he0) {
            this.b = he0;
        }

        @Override // ir.nasim.GB3
        public final void a(List list, long j, long j2) {
            AbstractC10533bm0.d(C3521Bf1.this.g, null, null, new a(C3521Bf1.this, list, null), 3, null);
            OK7 ok7 = C3521Bf1.this.d;
            AbstractC13042fc3.f(list);
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((C18823pJ2) it.next()).c.getPeerId()));
            }
            ok7.w0(arrayList, false).m0(new b(this.b, list));
        }
    }

    public C3521Bf1(C5183Ig1 c5183Ig1, InterfaceC6118Mg1 interfaceC6118Mg1, OK7 ok7, C4471Fg6 c4471Fg6, InterfaceC4308Eo5 interfaceC4308Eo5, InterfaceC20315ro1 interfaceC20315ro1, String str) {
        AbstractC13042fc3.i(c5183Ig1, "newMapper");
        AbstractC13042fc3.i(interfaceC6118Mg1, "contactRepository");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.b = c5183Ig1;
        this.c = interfaceC6118Mg1;
        this.d = ok7;
        this.e = c4471Fg6;
        this.f = interfaceC4308Eo5;
        this.g = interfaceC20315ro1;
        this.h = str;
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zf1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3521Bf1.s(this.a);
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Af1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3521Bf1.r(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0098 -> B:27:0x0099). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r10, int r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.C3521Bf1.b
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.Bf1$b r0 = (ir.nasim.C3521Bf1.b) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.Bf1$b r0 = new ir.nasim.Bf1$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.e
            java.lang.Object r7 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.g
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L4c
            if (r1 == r2) goto L44
            if (r1 != r8) goto L3c
            java.lang.Object r10 = r0.d
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r11 = r0.c
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r1 = r0.b
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r2 = r0.a
            ir.nasim.Bf1 r2 = (ir.nasim.C3521Bf1) r2
            ir.nasim.AbstractC10685c16.b(r12)
            goto L99
        L3c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L44:
            java.lang.Object r10 = r0.a
            ir.nasim.Bf1 r10 = (ir.nasim.C3521Bf1) r10
            ir.nasim.AbstractC10685c16.b(r12)
            goto L65
        L4c:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.Mg1 r1 = r9.c
            java.lang.String r12 = r9.h
            ir.nasim.Gg1 r3 = ir.nasim.EnumC4715Gg1.c
            r0.a = r9
            r0.g = r2
            r2 = r12
            r4 = r10
            r5 = r11
            r6 = r0
            java.lang.Object r12 = r1.a(r2, r3, r4, r5, r6)
            if (r12 != r7) goto L64
            return r7
        L64:
            r10 = r9
        L65:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r11 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r12, r1)
            r11.<init>(r1)
            java.util.Iterator r12 = r12.iterator()
            r2 = r10
            r10 = r11
            r11 = r12
        L79:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto La0
            java.lang.Object r12 = r11.next()
            ir.nasim.database.entity.ContactEntity r12 = (ir.nasim.database.entity.ContactEntity) r12
            ir.nasim.Ig1 r1 = r2.b
            r0.a = r2
            r0.b = r10
            r0.c = r11
            r0.d = r10
            r0.g = r8
            java.lang.Object r12 = r1.a(r12, r0)
            if (r12 != r7) goto L98
            return r7
        L98:
            r1 = r10
        L99:
            ir.nasim.wY r12 = (ir.nasim.C23209wY) r12
            r10.add(r12)
            r10 = r1
            goto L79
        La0:
            java.util.List r10 = (java.util.List) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3521Bf1.m(int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK n() {
        return (WK) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK o() {
        return (WK) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e9 -> B:29:0x00ea). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r20, int r21, int r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3521Bf1.p(java.lang.String, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0187 -> B:55:0x0191). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r24, int r25, int r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3521Bf1.q(java.lang.String, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK r(C3521Bf1 c3521Bf1) {
        AbstractC13042fc3.i(c3521Bf1, "this$0");
        DB3 db3D = c3521Bf1.e.D();
        AbstractC13042fc3.g(db3D, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK s(C3521Bf1 c3521Bf1) {
        AbstractC13042fc3.i(c3521Bf1, "this$0");
        DB3 db3J = c3521Bf1.e.J();
        AbstractC13042fc3.g(db3J, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.search.entity.GlobalSearchEntity>");
        return (WK) db3J;
    }

    @Override // ir.nasim.contact.data.d
    public Object a(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(i, i2, null), interfaceC20295rm1);
    }
}
