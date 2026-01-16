package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.C17624nH3;
import ir.nasim.C19911r9;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.WF6;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.r9, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19911r9 extends VW7 {
    private final InterfaceC24010xt2 b;
    private final C17624nH3.b c;
    private final InterfaceC9145Yr2 d;
    private final AbstractC13778go1 e;
    private final VF2 f;
    private final E84 g;
    private final YF3 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;
    private final InterfaceC10258bL6 k;
    private final InterfaceC9336Zm4 l;
    private final InterfaceC10258bL6 m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC10258bL6 o;
    private final InterfaceC9336Zm4 p;
    private final InterfaceC10258bL6 q;
    private final InterfaceC9336Zm4 r;
    private boolean s;
    private final InterfaceC21797u9 t;
    private final InterfaceC10142b9 u;
    private final InterfaceC10258bL6 v;
    private final InterfaceC4557Fq2 w;

    /* renamed from: ir.nasim.r9$a */
    public static final class a implements InterfaceC10142b9 {
        private final UA2 a;
        private final InterfaceC14603iB2 b;
        private final UA2 c;
        private final UA2 d;

        /* renamed from: ir.nasim.r9$a$a, reason: collision with other inner class name */
        /* synthetic */ class C1490a extends EB2 implements UA2 {
            C1490a(Object obj) {
                super(1, obj, C19911r9.class, "setSearchQuery", "setSearchQuery(Ljava/lang/String;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                ((C19911r9) this.receiver).E1(str);
            }
        }

        /* renamed from: ir.nasim.r9$a$b */
        /* synthetic */ class b extends EB2 implements UA2 {
            b(Object obj) {
                super(1, obj, C19911r9.class, "deleteDialogFromFolder", "deleteDialogFromFolder(Lir/nasim/dialoglist/data/model/DialogFolderDTO;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((RM1) obj);
                return C19938rB7.a;
            }

            public final void y(RM1 rm1) {
                AbstractC13042fc3.i(rm1, "p0");
                ((C19911r9) this.receiver).l1(rm1);
            }
        }

        /* renamed from: ir.nasim.r9$a$c */
        /* synthetic */ class c extends EB2 implements UA2 {
            c(Object obj) {
                super(1, obj, C19911r9.class, "setSearchState", "setSearchState(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((AbstractC17858ng6) obj);
                return C19938rB7.a;
            }

            public final void y(AbstractC17858ng6 abstractC17858ng6) {
                AbstractC13042fc3.i(abstractC17858ng6, "p0");
                ((C19911r9) this.receiver).F1(abstractC17858ng6);
            }
        }

        /* renamed from: ir.nasim.r9$a$d */
        /* synthetic */ class d extends EB2 implements InterfaceC14603iB2 {
            d(Object obj) {
                super(2, obj, C19911r9.class, "toggleSelection", "toggleSelection(Lir/nasim/dialoglist/data/model/DialogFolderDTO;Z)V", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                y((RM1) obj, ((Boolean) obj2).booleanValue());
                return C19938rB7.a;
            }

            public final void y(RM1 rm1, boolean z) {
                AbstractC13042fc3.i(rm1, "p0");
                ((C19911r9) this.receiver).H1(rm1, z);
            }
        }

        a(C19911r9 c19911r9) {
            this.a = new b(c19911r9);
            this.b = new d(c19911r9);
            this.c = new C1490a(c19911r9);
            this.d = new c(c19911r9);
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10142b9
        public InterfaceC14603iB2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 c() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 d() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.r9$b */
    public static final class b implements InterfaceC21797u9 {
        private final InterfaceC14603iB2 a;
        private final UA2 b;
        private final InterfaceC15796kB2 c;
        private final UA2 d;
        private final UA2 e;
        private final SA2 f;

        /* renamed from: ir.nasim.r9$b$a */
        /* synthetic */ class a extends EB2 implements InterfaceC14603iB2 {
            a(Object obj) {
                super(2, obj, C19911r9.class, "createFolder", "createFolder(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                y((String) obj, (SA2) obj2);
                return C19938rB7.a;
            }

            public final void y(String str, SA2 sa2) {
                AbstractC13042fc3.i(str, "p0");
                AbstractC13042fc3.i(sa2, "p1");
                ((C19911r9) this.receiver).h1(str, sa2);
            }
        }

        /* renamed from: ir.nasim.r9$b$b, reason: collision with other inner class name */
        /* synthetic */ class C1491b extends EB2 implements UA2 {
            C1491b(Object obj) {
                super(1, obj, C19911r9.class, "deleteDialogFromFolder", "deleteDialogFromFolder(Lir/nasim/dialoglist/data/model/DialogFolderDTO;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((RM1) obj);
                return C19938rB7.a;
            }

            public final void y(RM1 rm1) {
                AbstractC13042fc3.i(rm1, "p0");
                ((C19911r9) this.receiver).l1(rm1);
            }
        }

        /* renamed from: ir.nasim.r9$b$c */
        /* synthetic */ class c extends EB2 implements InterfaceC15796kB2 {
            c(Object obj) {
                super(3, obj, C19911r9.class, "editFolder", "editFolder(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                y(((Number) obj).intValue(), (String) obj2, (SA2) obj3);
                return C19938rB7.a;
            }

            public final void y(int i, String str, SA2 sa2) {
                AbstractC13042fc3.i(str, "p1");
                AbstractC13042fc3.i(sa2, "p2");
                ((C19911r9) this.receiver).m1(i, str, sa2);
            }
        }

        /* renamed from: ir.nasim.r9$b$d */
        /* synthetic */ class d extends EB2 implements UA2 {
            d(Object obj) {
                super(1, obj, C19911r9.class, "setFolderName", "setFolderName(Ljava/lang/String;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                AbstractC13042fc3.i(str, "p0");
                ((C19911r9) this.receiver).C1(str);
            }
        }

        /* renamed from: ir.nasim.r9$b$e */
        /* synthetic */ class e extends EB2 implements UA2 {
            e(Object obj) {
                super(1, obj, C19911r9.class, "setFolderSaving", "setFolderSaving(Z)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y(((Boolean) obj).booleanValue());
                return C19938rB7.a;
            }

            public final void y(boolean z) {
                ((C19911r9) this.receiver).D1(z);
            }
        }

        b(final C19911r9 c19911r9) {
            this.a = new a(c19911r9);
            this.b = new C1491b(c19911r9);
            this.c = new c(c19911r9);
            this.d = new e(c19911r9);
            this.e = new d(c19911r9);
            this.f = new SA2() { // from class: ir.nasim.s9
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C19911r9.b.g(c19911r9);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(C19911r9 c19911r9) {
            AbstractC13042fc3.i(c19911r9, "this$0");
            c19911r9.G1(WF6.a.a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC21797u9
        public InterfaceC15796kB2 a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC21797u9
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC21797u9
        public SA2 c() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC21797u9
        public UA2 d() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC21797u9
        public InterfaceC14603iB2 e() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.r9$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ List d;
        final /* synthetic */ C19911r9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, C19911r9 c19911r9, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c19911r9;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            C19911r9 c19911r9;
            Object value;
            C8379Vs2 c8379Vs2;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = this.d;
                if (list != null) {
                    C19911r9 c19911r92 = this.e;
                    InterfaceC24010xt2 interfaceC24010xt2 = c19911r92.b;
                    this.b = c19911r92;
                    this.c = 1;
                    objG = interfaceC24010xt2.g(list, this);
                    if (objG == objE) {
                        return objE;
                    }
                    c19911r9 = c19911r92;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c19911r9 = (C19911r9) this.b;
            AbstractC10685c16.b(obj);
            objG = obj;
            List list2 = (List) objG;
            InterfaceC9336Zm4 interfaceC9336Zm4 = c19911r9.p;
            do {
                value = interfaceC9336Zm4.getValue();
                c8379Vs2 = (C8379Vs2) value;
                List<RM1> list3 = list2;
                arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
                for (RM1 rm1 : list3) {
                    String str = (String) ((Map) c19911r9.k.getValue()).get(AbstractC6392Nk0.e(rm1.f()));
                    if (str == null) {
                        str = "";
                    }
                    arrayList.add(rm1.a((383 & 1) != 0 ? rm1.a : 0L, (383 & 2) != 0 ? rm1.b : null, (383 & 4) != 0 ? rm1.c : null, (383 & 8) != 0 ? rm1.d : null, (383 & 16) != 0 ? rm1.e : false, (383 & 32) != 0 ? rm1.f : false, (383 & 64) != 0 ? rm1.g : false, (383 & 128) != 0 ? rm1.h : str, (383 & 256) != 0 ? rm1.i : null));
                }
            } while (!interfaceC9336Zm4.f(value, C8379Vs2.b(c8379Vs2, null, null, arrayList, false, 11, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19911r9.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19911r9.this.D1(true);
                List<RM1> listC = ((C8379Vs2) C19911r9.this.p.getValue()).c();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
                for (RM1 rm1 : listC) {
                    arrayList.add(new ExPeer(rm1.d(), C11458d25.r(rm1.f()).getPeerId()));
                }
                InterfaceC24010xt2 interfaceC24010xt2 = C19911r9.this.b;
                String str = this.d;
                this.b = 1;
                objA = interfaceC24010xt2.a(str, arrayList, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C19911r9 c19911r9 = C19911r9.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                c19911r9.D1(false);
                c19911r9.o1(thE);
            }
            C19911r9 c19911r92 = C19911r9.this;
            SA2 sa2 = this.e;
            if (C9475a16.j(objA)) {
                c19911r92.D1(false);
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C19911r9 b;

        /* renamed from: ir.nasim.r9$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C19911r9 b;

            /* renamed from: ir.nasim.r9$e$a$a, reason: collision with other inner class name */
            public static final class C1492a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1492a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C19911r9 c19911r9) {
                this.a = interfaceC4806Gq2;
                this.b = c19911r9;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C19911r9.e.a.C1492a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.r9$e$a$a r0 = (ir.nasim.C19911r9.e.a.C1492a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.r9$e$a$a r0 = new ir.nasim.r9$e$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4d
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.NT4 r7 = (ir.nasim.NT4) r7
                    ir.nasim.r9$g r2 = new ir.nasim.r9$g
                    ir.nasim.r9 r4 = r6.b
                    r5 = 0
                    r2.<init>(r5)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.g(r7, r2)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19911r9.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2, C19911r9 c19911r9) {
            this.a = interfaceC4557Fq2;
            this.b = c19911r9;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r9$f */
    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.r9$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C8379Vs2 d;
            final /* synthetic */ C19911r9 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8379Vs2 c8379Vs2, C19911r9 c19911r9, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c8379Vs2;
                this.e = c19911r9;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.c;
                List listC = this.d.c();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
                Iterator it = listC.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(((RM1) it.next()).f()));
                }
                boolean zContains = arrayList.contains(AbstractC6392Nk0.e(abstractC3769Cg6.d().u()));
                RM1 rm1A = this.e.d.a(abstractC3769Cg6);
                return rm1A.a((383 & 1) != 0 ? rm1A.a : 0L, (383 & 2) != 0 ? rm1A.b : null, (383 & 4) != 0 ? rm1A.c : null, (383 & 8) != 0 ? rm1A.d : null, (383 & 16) != 0 ? rm1A.e : false, (383 & 32) != 0 ? rm1A.f : zContains, (383 & 64) != 0 ? rm1A.g : false, (383 & 128) != 0 ? rm1A.h : null, (383 & 256) != 0 ? rm1A.i : null);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC3769Cg6 abstractC3769Cg6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC3769Cg6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.g((NT4) this.c, new a((C8379Vs2) this.d, C19911r9.this, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, C8379Vs2 c8379Vs2, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C19911r9.this.new f(interfaceC20295rm1);
            fVar.c = nt4;
            fVar.d = c8379Vs2;
            return fVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C19911r9.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            RM1 rm1 = (RM1) this.c;
            String str = (String) ((Map) C19911r9.this.k.getValue()).get(AbstractC6392Nk0.e(rm1.f()));
            if (str == null) {
                str = "";
            }
            return rm1.a((383 & 1) != 0 ? rm1.a : 0L, (383 & 2) != 0 ? rm1.b : null, (383 & 4) != 0 ? rm1.c : null, (383 & 8) != 0 ? rm1.d : null, (383 & 16) != 0 ? rm1.e : false, (383 & 32) != 0 ? rm1.f : false, (383 & 64) != 0 ? rm1.g : false, (383 & 128) != 0 ? rm1.h : str, (383 & 256) != 0 ? rm1.i : null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(RM1 rm1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(rm1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$h */
    static final class h implements QT4 {
        final /* synthetic */ C17624nH3 a;
        final /* synthetic */ C19911r9 b;

        /* renamed from: ir.nasim.r9$h$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            /* synthetic */ Object b;
            int d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= RecyclerView.UNDEFINED_DURATION;
                return h.this.a(0, 0, this);
            }
        }

        h(C17624nH3 c17624nH3, C19911r9 c19911r9) {
            this.a = c17624nH3;
            this.b = c19911r9;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        @Override // ir.nasim.QT4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(int r8, int r9, ir.nasim.InterfaceC20295rm1 r10) {
            /*
                r7 = this;
                boolean r0 = r10 instanceof ir.nasim.C19911r9.h.a
                if (r0 == 0) goto L14
                r0 = r10
                ir.nasim.r9$h$a r0 = (ir.nasim.C19911r9.h.a) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.d = r1
            L12:
                r4 = r0
                goto L1a
            L14:
                ir.nasim.r9$h$a r0 = new ir.nasim.r9$h$a
                r0.<init>(r10)
                goto L12
            L1a:
                java.lang.Object r10 = r4.b
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L45
                if (r1 == r3) goto L3d
                if (r1 != r2) goto L35
                java.lang.Object r8 = r4.a
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
                r10.l()
                goto L94
            L35:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3d:
                java.lang.Object r8 = r4.a
                ir.nasim.r9$h r8 = (ir.nasim.C19911r9.h) r8
                ir.nasim.AbstractC10685c16.b(r10)
                goto L56
            L45:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.nH3 r10 = r7.a
                r4.a = r7
                r4.d = r3
                java.lang.Object r10 = r10.a(r8, r9, r4)
                if (r10 != r0) goto L55
                return r0
            L55:
                r8 = r7
            L56:
                ir.nasim.r9 r8 = r8.b
                r9 = r10
                java.util.List r9 = (java.util.List) r9
                ir.nasim.YF3 r1 = ir.nasim.C19911r9.Z0(r8)
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r8 = new java.util.ArrayList
                r3 = 10
                int r3 = ir.nasim.ZW0.x(r9, r3)
                r8.<init>(r3)
                java.util.Iterator r9 = r9.iterator()
            L70:
                boolean r3 = r9.hasNext()
                if (r3 == 0) goto L84
                java.lang.Object r3 = r9.next()
                ir.nasim.Cg6 r3 = (ir.nasim.AbstractC3769Cg6) r3
                ir.nasim.d25 r3 = r3.d()
                r8.add(r3)
                goto L70
            L84:
                r4.a = r10
                r4.d = r2
                r3 = 0
                r5 = 2
                r6 = 0
                r2 = r8
                java.lang.Object r8 = ir.nasim.YF3.b(r1, r2, r3, r4, r5, r6)
                if (r8 != r0) goto L93
                return r0
            L93:
                r8 = r10
            L94:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19911r9.h.a(int, int, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.r9$i */
    static final class i extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            C8379Vs2 c8379Vs2 = (C8379Vs2) this.d;
            List<RM1> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (RM1 rm1 : list2) {
                List listC = c8379Vs2.c();
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listC, 10));
                Iterator it = listC.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.e(((RM1) it.next()).f()));
                }
                arrayList.add(rm1.a((383 & 1) != 0 ? rm1.a : 0L, (383 & 2) != 0 ? rm1.b : null, (383 & 4) != 0 ? rm1.c : null, (383 & 8) != 0 ? rm1.d : null, (383 & 16) != 0 ? rm1.e : false, (383 & 32) != 0 ? rm1.f : arrayList2.contains(AbstractC6392Nk0.e(rm1.f())), (383 & 64) != 0 ? rm1.g : false, (383 & 128) != 0 ? rm1.h : null, (383 & 256) != 0 ? rm1.i : null));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, C8379Vs2 c8379Vs2, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(interfaceC20295rm1);
            iVar.c = list;
            iVar.d = c8379Vs2;
            return iVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(int i, String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19911r9.this.new j(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objQ;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19911r9.this.D1(true);
                C19911r9 c19911r9 = C19911r9.this;
                List listP1 = c19911r9.p1(((C8379Vs2) c19911r9.p.getValue()).c(), ((C8379Vs2) C19911r9.this.p.getValue()).d());
                C19911r9 c19911r92 = C19911r9.this;
                List listP12 = c19911r92.p1(((C8379Vs2) c19911r92.p.getValue()).d(), ((C8379Vs2) C19911r9.this.p.getValue()).c());
                List<RM1> list = listP1;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (RM1 rm1 : list) {
                    arrayList.add(new ExPeer(rm1.d(), C11458d25.r(rm1.f()).getPeerId()));
                }
                List<RM1> list2 = listP12;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (RM1 rm12 : list2) {
                    arrayList2.add(new ExPeer(rm12.d(), C11458d25.r(rm12.f()).getPeerId()));
                }
                InterfaceC24010xt2 interfaceC24010xt2 = C19911r9.this.b;
                int i2 = this.d;
                String str = this.e;
                this.b = 1;
                objQ = interfaceC24010xt2.q(i2, str, arrayList, arrayList2, this);
                if (objQ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objQ = ((C9475a16) obj).l();
            }
            C19911r9 c19911r93 = C19911r9.this;
            Throwable thE = C9475a16.e(objQ);
            if (thE != null) {
                c19911r93.D1(false);
                c19911r93.o1(thE);
            }
            C19911r9 c19911r94 = C19911r9.this;
            SA2 sa2 = this.f;
            if (C9475a16.j(objQ)) {
                c19911r94.D1(false);
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ Integer d;
        final /* synthetic */ C19911r9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Integer num, C19911r9 c19911r9, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = num;
            this.e = c19911r9;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            C19911r9 c19911r9;
            Object value;
            C8379Vs2 c8379Vs2;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Integer num = this.d;
                if (num != null) {
                    C19911r9 c19911r92 = this.e;
                    InterfaceC4557Fq2 interfaceC4557Fq2K = c19911r92.b.k(num.intValue());
                    this.b = c19911r92;
                    this.c = 1;
                    objG = AbstractC6459Nq2.G(interfaceC4557Fq2K, this);
                    if (objG == objE) {
                        return objE;
                    }
                    c19911r9 = c19911r92;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c19911r9 = (C19911r9) this.b;
            AbstractC10685c16.b(obj);
            objG = obj;
            List list = (List) objG;
            InterfaceC9336Zm4 interfaceC9336Zm4 = c19911r9.p;
            do {
                value = interfaceC9336Zm4.getValue();
                c8379Vs2 = (C8379Vs2) value;
                List<RM1> list2 = list;
                arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (RM1 rm1 : list2) {
                    String str = (String) ((Map) c19911r9.k.getValue()).get(AbstractC6392Nk0.e(rm1.f()));
                    if (str == null) {
                        str = "";
                    }
                    arrayList.add(rm1.a((383 & 1) != 0 ? rm1.a : 0L, (383 & 2) != 0 ? rm1.b : null, (383 & 4) != 0 ? rm1.c : null, (383 & 8) != 0 ? rm1.d : null, (383 & 16) != 0 ? rm1.e : false, (383 & 32) != 0 ? rm1.f : false, (383 & 64) != 0 ? rm1.g : false, (383 & 128) != 0 ? rm1.h : str, (383 & 256) != 0 ? rm1.i : null));
                }
            } while (!interfaceC9336Zm4.f(value, C8379Vs2.b(c8379Vs2, null, list, arrayList, false, 9, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Integer d;

        /* renamed from: ir.nasim.r9$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ Integer d;
            final /* synthetic */ C19911r9 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Integer num, C19911r9 c19911r9, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = num;
                this.e = c19911r9;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C19911r9 c19911r9;
                Object value;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Integer num = this.d;
                    if (num != null) {
                        C19911r9 c19911r92 = this.e;
                        InterfaceC24010xt2 interfaceC24010xt2 = c19911r92.b;
                        int iIntValue = num.intValue();
                        this.b = c19911r92;
                        this.c = 1;
                        obj = interfaceC24010xt2.l(iIntValue, this);
                        if (obj == objE) {
                            return objE;
                        }
                        c19911r9 = c19911r92;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c19911r9 = (C19911r9) this.b;
                AbstractC10685c16.b(obj);
                String str = (String) obj;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c19911r9.i;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, str));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = num;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19911r9.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1 = C19911r9.this.e;
                a aVar = new a(this.d, C19911r9.this, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19911r9.this.new m(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0049 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0047 -> B:12:0x004a). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.e
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r6.d
                java.lang.Object r3 = r6.c
                ir.nasim.r9 r3 = (ir.nasim.C19911r9) r3
                java.lang.Object r4 = r6.b
                ir.nasim.Zm4 r4 = (ir.nasim.InterfaceC9336Zm4) r4
                ir.nasim.AbstractC10685c16.b(r7)
                goto L4a
            L19:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L21:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.r9 r7 = ir.nasim.C19911r9.this
                ir.nasim.Zm4 r7 = ir.nasim.C19911r9.c1(r7)
                ir.nasim.r9 r1 = ir.nasim.C19911r9.this
                r4 = r7
                r3 = r1
            L2e:
                java.lang.Object r1 = r4.getValue()
                r7 = r1
                java.util.List r7 = (java.util.List) r7
                ir.nasim.xt2 r7 = ir.nasim.C19911r9.X0(r3)
                r6.b = r4
                r6.c = r3
                r6.d = r1
                r6.e = r2
                r5 = 20
                java.lang.Object r7 = r7.i(r5, r6)
                if (r7 != r0) goto L4a
                return r0
            L4a:
                java.util.List r7 = (java.util.List) r7
                boolean r7 = r4.f(r1, r7)
                if (r7 == 0) goto L2e
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19911r9.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$n */
    public static final class n implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.r9$n$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.r9$n$a$a, reason: collision with other inner class name */
            public static final class C1493a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1493a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C19911r9.n.a.C1493a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.r9$n$a$a r0 = (ir.nasim.C19911r9.n.a.C1493a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.r9$n$a$a r0 = new ir.nasim.r9$n$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.util.List r5 = (java.util.List) r5
                    ir.nasim.NT4$d r2 = ir.nasim.NT4.e
                    ir.nasim.NT4 r5 = r2.b(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19911r9.n.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public n(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.r9$o */
    public static final class o extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C19911r9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(InterfaceC20295rm1 interfaceC20295rm1, C19911r9 c19911r9) {
            super(3, interfaceC20295rm1);
            this.e = c19911r9;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                String str = (String) this.d;
                InterfaceC4557Fq2 nVar = (str == null || str.length() == 0) ? new n(this.e.v) : this.e.i1(AbstractC20762sZ6.n1(XY6.o(str)).toString());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, nVar, this) == objE) {
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
            o oVar = new o(interfaceC20295rm1, this.e);
            oVar.c = interfaceC4806Gq2;
            oVar.d = obj;
            return oVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.r9$p */
    public static final class p implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C19911r9 b;

        /* renamed from: ir.nasim.r9$p$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C19911r9 b;

            /* renamed from: ir.nasim.r9$p$a$a, reason: collision with other inner class name */
            public static final class C1494a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1494a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C19911r9 c19911r9) {
                this.a = interfaceC4806Gq2;
                this.b = c19911r9;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r22, ir.nasim.InterfaceC20295rm1 r23) {
                /*
                    r21 = this;
                    r0 = r21
                    r1 = r23
                    boolean r2 = r1 instanceof ir.nasim.C19911r9.p.a.C1494a
                    if (r2 == 0) goto L17
                    r2 = r1
                    ir.nasim.r9$p$a$a r2 = (ir.nasim.C19911r9.p.a.C1494a) r2
                    int r3 = r2.b
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r5 = r3 & r4
                    if (r5 == 0) goto L17
                    int r3 = r3 - r4
                    r2.b = r3
                    goto L1c
                L17:
                    ir.nasim.r9$p$a$a r2 = new ir.nasim.r9$p$a$a
                    r2.<init>(r1)
                L1c:
                    java.lang.Object r1 = r2.a
                    java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
                    int r4 = r2.b
                    r5 = 1
                    if (r4 == 0) goto L35
                    if (r4 != r5) goto L2d
                    ir.nasim.AbstractC10685c16.b(r1)
                    goto L9c
                L2d:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L35:
                    ir.nasim.AbstractC10685c16.b(r1)
                    ir.nasim.Gq2 r1 = r0.a
                    r4 = r22
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.ArrayList r6 = new java.util.ArrayList
                    r7 = 10
                    int r7 = ir.nasim.ZW0.x(r4, r7)
                    r6.<init>(r7)
                    java.util.Iterator r4 = r4.iterator()
                L4f:
                    boolean r7 = r4.hasNext()
                    if (r7 == 0) goto L93
                    java.lang.Object r7 = r4.next()
                    r8 = r7
                    ir.nasim.RM1 r8 = (ir.nasim.RM1) r8
                    ir.nasim.r9 r7 = r0.b
                    ir.nasim.bL6 r7 = ir.nasim.C19911r9.W0(r7)
                    java.lang.Object r7 = r7.getValue()
                    java.util.Map r7 = (java.util.Map) r7
                    long r9 = r8.f()
                    java.lang.Long r9 = ir.nasim.AbstractC6392Nk0.e(r9)
                    java.lang.Object r7 = r7.get(r9)
                    java.lang.String r7 = (java.lang.String) r7
                    if (r7 != 0) goto L7a
                    java.lang.String r7 = ""
                L7a:
                    r17 = r7
                    r19 = 383(0x17f, float:5.37E-43)
                    r20 = 0
                    r9 = 0
                    r11 = 0
                    r12 = 0
                    r13 = 0
                    r14 = 0
                    r15 = 0
                    r16 = 0
                    r18 = 0
                    ir.nasim.RM1 r7 = ir.nasim.RM1.b(r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                    r6.add(r7)
                    goto L4f
                L93:
                    r2.b = r5
                    java.lang.Object r1 = r1.a(r6, r2)
                    if (r1 != r3) goto L9c
                    return r3
                L9c:
                    ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19911r9.p.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public p(InterfaceC4557Fq2 interfaceC4557Fq2, C19911r9 c19911r9) {
            this.a = interfaceC4557Fq2;
            this.b = c19911r9;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C19911r9(InterfaceC24010xt2 interfaceC24010xt2, C17624nH3.b bVar, InterfaceC9145Yr2 interfaceC9145Yr2, AbstractC13778go1 abstractC13778go1, VF2 vf2, E84 e84, YF3 yf3) {
        AbstractC13042fc3.i(interfaceC24010xt2, "foldersRepository");
        AbstractC13042fc3.i(bVar, "localSearchListDataLoaderFactory");
        AbstractC13042fc3.i(interfaceC9145Yr2, "folderDTOConverter");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(vf2, "getFoldersListForPeersUseCase");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(yf3, "loadPeersUseCase");
        this.b = interfaceC24010xt2;
        this.c = bVar;
        this.d = interfaceC9145Yr2;
        this.e = abstractC13778go1;
        this.f = vf2;
        this.g = e84;
        this.h = yf3;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a("");
        this.i = interfaceC9336Zm4A;
        this.j = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.k = vf2.i();
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.l = interfaceC9336Zm4A2;
        this.m = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(null);
        this.n = interfaceC9336Zm4A3;
        this.o = AbstractC6459Nq2.c(interfaceC9336Zm4A3);
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(new C8379Vs2(null, null, null, false, 15, null));
        this.p = interfaceC9336Zm4A4;
        this.q = AbstractC6459Nq2.c(interfaceC9336Zm4A4);
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.r = interfaceC9336Zm4A5;
        B1();
        e84.T0().l();
        this.t = new b(this);
        this.u = new a(this);
        this.v = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(new p(AbstractC6459Nq2.S(interfaceC9336Zm4A5, interfaceC9336Zm4A4, new i(null)), this), abstractC13778go1), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), AbstractC10360bX0.m());
        this.w = AbstractC6459Nq2.s0(AbstractC6459Nq2.s(interfaceC9336Zm4A3, 200L), new o(null, this));
    }

    private final void B1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(String str) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C8379Vs2.b((C8379Vs2) value, null, null, null, z, 7, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C8379Vs2.b((C8379Vs2) value, abstractC17858ng6, null, null, false, 14, null)));
    }

    private final List I1(List list, long j2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RM1) obj).f() != j2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 i1(final String str) {
        return AbstractC6459Nq2.V(new e(AbstractC6459Nq2.S(AbstractC9395Zt0.a(new C12960fT4(new MT4(20, 0, false, 40, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.q9
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19911r9.j1(this.a, str);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this)), this.p, new f(null)), this), this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 j1(C19911r9 c19911r9, String str) {
        AbstractC13042fc3.i(c19911r9, "this$0");
        AbstractC13042fc3.i(str, "$query");
        return new C20238rg6(c19911r9.k1(str));
    }

    private final QT4 k1(String str) {
        return new h(this.c.a(str), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(Throwable th) {
        Object value;
        String message;
        Object value2;
        Object value3;
        Object value4;
        if (!(th instanceof RpcException)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
            do {
                value = interfaceC9336Zm4.getValue();
                message = th.getMessage();
                if (message == null) {
                    message = "EXCEPTION";
                }
            } while (!interfaceC9336Zm4.f(value, new WF6.b(message)));
            return;
        }
        RpcException rpcException = (RpcException) th;
        String str = rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String();
        if (AbstractC13042fc3.d(str, "TIMEOUT")) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.l;
            do {
                value4 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value4, WF6.f.a));
            return;
        }
        if (AbstractC13042fc3.d(str, "folder creation limit exceeded")) {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.l;
            do {
                value3 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value3, new WF6.d(0, 1, null)));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm44 = this.l;
        do {
            value2 = interfaceC9336Zm44.getValue();
        } while (!interfaceC9336Zm44.f(value2, new WF6.b(rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List p1(List list, List list2) {
        List list3 = list2;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((RM1) it.next()).f()));
        }
        Set setR1 = AbstractC15401jX0.r1(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!setR1.contains(Long.valueOf(((RM1) obj).f()))) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final void w1(Integer num) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(num, null), 3, null);
    }

    public final void A1(Integer num, List list) {
        if (this.s) {
            return;
        }
        g1(list);
        w1(num);
        t1(num);
        this.s = true;
    }

    public final void E1(String str) {
        Object value;
        F1(new AbstractC17858ng6.a(false, !(str == null || str.length() == 0), false, 5, null));
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final void G1(WF6 wf6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, wf6));
    }

    public final void H1(RM1 rm1, boolean z) {
        Object value;
        C8379Vs2 c8379Vs2;
        AbstractC13042fc3.i(rm1, "dialogFolderDTO");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            c8379Vs2 = (C8379Vs2) value;
        } while (!interfaceC9336Zm4.f(value, C8379Vs2.b(c8379Vs2, null, null, z ? AbstractC15401jX0.R0(AbstractC9766aX0.e(rm1), c8379Vs2.c()) : I1(c8379Vs2.c(), rm1.f()), false, 11, null)));
    }

    public final void g1(List list) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(list, this, null), 3, null);
    }

    public final void h1(String str, SA2 sa2) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(sa2, "successCallBack");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str, sa2, null), 3, null);
    }

    public final void l1(RM1 rm1) {
        Object value;
        C8379Vs2 c8379Vs2;
        AbstractC13042fc3.i(rm1, "dialogFolderDTO");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            c8379Vs2 = (C8379Vs2) value;
        } while (!interfaceC9336Zm4.f(value, C8379Vs2.b(c8379Vs2, null, null, I1(c8379Vs2.c(), rm1.f()), false, 11, null)));
    }

    public final void m1(int i2, String str, SA2 sa2) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(sa2, "successCallBack");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(i2, str, sa2, null), 3, null);
    }

    public final InterfaceC10142b9 q1() {
        return this.u;
    }

    public final InterfaceC21797u9 s1() {
        return this.t;
    }

    public final void t1(Integer num) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(num, this, null), 3, null);
    }

    public final InterfaceC10258bL6 u1() {
        return this.j;
    }

    public final InterfaceC10258bL6 v1() {
        return this.q;
    }

    public final InterfaceC10258bL6 x1() {
        return this.o;
    }

    public final InterfaceC4557Fq2 y1() {
        return this.w;
    }

    public final InterfaceC10258bL6 z1() {
        return this.m;
    }
}
