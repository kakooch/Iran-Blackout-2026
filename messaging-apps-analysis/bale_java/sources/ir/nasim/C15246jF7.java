package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.jF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15246jF7 {
    private final InterfaceC6334Nd5 a;
    private final InterfaceC20315ro1 b;

    /* renamed from: ir.nasim.jF7$a */
    public static final class a {
        private final C11458d25 a;
        private final List b;
        private final List c;

        public a(C11458d25 c11458d25, List list, List list2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(list, "rids");
            AbstractC13042fc3.i(list2, "dates");
            this.a = c11458d25;
            this.b = list;
            this.c = list2;
        }

        public final List a() {
            return this.c;
        }

        public final C11458d25 b() {
            return this.a;
        }

        public final List c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.jF7$b */
    public static final class b {
        private final C11458d25 a;
        private final long b;
        private final long c;

        public b(C11458d25 c11458d25, long j, long j2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = c11458d25;
            this.b = j;
            this.c = j2;
        }

        public final long a() {
            return this.c;
        }

        public final C11458d25 b() {
            return this.a;
        }

        public final long c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.jF7$c */
    public static final class c {
        private final KE7 a;

        public c(KE7 ke7) {
            AbstractC13042fc3.i(ke7, "value");
            this.a = ke7;
        }

        public final KE7 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.jF7$d */
    public static final class d {
        private final C9611aF7 a;

        public d(C9611aF7 c9611aF7) {
            AbstractC13042fc3.i(c9611aF7, "value");
            this.a = c9611aF7;
        }

        public final C9611aF7 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.jF7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15246jF7.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6334Nd5 interfaceC6334Nd5 = C15246jF7.this.a;
                C11458d25 c11458d25B = this.d.b();
                List listC = this.d.c();
                List listA = this.d.a();
                this.b = 1;
                if (interfaceC6334Nd5.d(c11458d25B, listC, listA, false, this) == objE) {
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

    /* renamed from: ir.nasim.jF7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15246jF7.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6334Nd5 interfaceC6334Nd5 = C15246jF7.this.a;
                Long lE = AbstractC6392Nk0.e(this.d.c());
                Long lE2 = AbstractC6392Nk0.e(this.d.a());
                C11458d25 c11458d25B = this.d.b();
                this.b = 1;
                if (interfaceC6334Nd5.g(lE, lE2, c11458d25B, this) == objE) {
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

    /* renamed from: ir.nasim.jF7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ J44 d;
        final /* synthetic */ C11458d25 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(J44 j44, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j44;
            this.e = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15246jF7.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6334Nd5 interfaceC6334Nd5 = C15246jF7.this.a;
                Long lE = AbstractC6392Nk0.e(this.d.i());
                Long lE2 = AbstractC6392Nk0.e(this.d.h());
                C11458d25 c11458d25 = this.e;
                this.b = 1;
                if (interfaceC6334Nd5.f(lE, lE2, c11458d25, this) == objE) {
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

    /* renamed from: ir.nasim.jF7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ List e;
        final /* synthetic */ List f;
        final /* synthetic */ C9611aF7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C11458d25 c11458d25, List list, List list2, C9611aF7 c9611aF7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = list;
            this.f = list2;
            this.g = c9611aF7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15246jF7.this.new h(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6334Nd5 interfaceC6334Nd5 = C15246jF7.this.a;
                C11458d25 c11458d25 = this.d;
                List list = this.e;
                List list2 = this.f;
                boolean zA = this.g.a();
                this.b = 1;
                if (interfaceC6334Nd5.d(c11458d25, list, list2, zA, this) == objE) {
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

    public C15246jF7(InterfaceC6334Nd5 interfaceC6334Nd5, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC6334Nd5, "pinMessagesRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = interfaceC6334Nd5;
        this.b = interfaceC20315ro1;
    }

    private final void b(a aVar) {
        if (aVar.c().size() != aVar.a().size()) {
            return;
        }
        AbstractC10533bm0.d(this.b, null, null, new e(aVar, null), 3, null);
    }

    private final void c(b bVar) {
        AbstractC10533bm0.d(this.b, null, null, new f(bVar, null), 3, null);
    }

    private final void e(c cVar) {
        J44 j44M;
        KE7 ke7A = cVar.a();
        C11458d25 c11458d25 = new C11458d25(ke7A.a());
        C25247zz c25247zzB = ke7A.b();
        if (c25247zzB == null || (j44M = C18732p92.M(c25247zzB)) == null) {
            return;
        }
        AbstractC10533bm0.d(this.b, null, null, new g(j44M, c11458d25, null), 3, null);
    }

    private final void f(d dVar) {
        C9611aF7 c9611aF7A = dVar.a();
        C11458d25 c11458d25C = c9611aF7A.c();
        List listB = c9611aF7A.b();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C3460Az) it.next()).i()));
        }
        List listB2 = c9611aF7A.b();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listB2, 10));
        Iterator it2 = listB2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((C3460Az) it2.next()).h()));
        }
        AbstractC10533bm0.d(this.b, null, null, new h(c11458d25C, arrayList, arrayList2, c9611aF7A, null), 3, null);
    }

    public final void d(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (C8386Vt0.r9()) {
            if (obj instanceof c) {
                e((c) obj);
                return;
            }
            if (obj instanceof d) {
                f((d) obj);
            } else if (obj instanceof a) {
                b((a) obj);
            } else if (obj instanceof b) {
                c((b) obj);
            }
        }
    }
}
