package ir.nasim;

import ir.nasim.AbstractC23884xg6;
import ir.nasim.Y06;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.dh6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11874dh6 implements InterfaceC11079ch6 {
    private final C4471Fg6 a;
    private final AbstractC13778go1 b;
    private final InterfaceC14123hO3 c;
    private final InterfaceC14123hO3 d;
    private final InterfaceC14123hO3 e;

    /* renamed from: ir.nasim.dh6$a */
    /* synthetic */ class a implements InterfaceC14123hO3, InterfaceC22409vB2 {
        final /* synthetic */ C19414qJ2 a;

        a(C19414qJ2 c19414qJ2) {
            this.a = c19414qJ2;
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return new EB2(1, this.a, C19414qJ2.class, "searchEntityToSearchMessagePhoto", "searchEntityToSearchMessagePhoto(Lir/nasim/core/modules/search/entity/GlobalSearchEntity;)Lir/nasim/data/model/search/SearchMessage$Image;", 0);
        }

        @Override // ir.nasim.InterfaceC14123hO3
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AbstractC23884xg6.b a(C18823pJ2 c18823pJ2) {
            AbstractC13042fc3.i(c18823pJ2, "p0");
            return this.a.b(c18823pJ2);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof InterfaceC14123hO3) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* renamed from: ir.nasim.dh6$b */
    /* synthetic */ class b implements InterfaceC14123hO3, InterfaceC22409vB2 {
        final /* synthetic */ C19414qJ2 a;

        b(C19414qJ2 c19414qJ2) {
            this.a = c19414qJ2;
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return new EB2(1, this.a, C19414qJ2.class, "searchEntityToSearchMessageVideo", "searchEntityToSearchMessageVideo(Lir/nasim/core/modules/search/entity/GlobalSearchEntity;)Lir/nasim/data/model/search/SearchMessage$Video;", 0);
        }

        @Override // ir.nasim.InterfaceC14123hO3
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AbstractC23884xg6.c a(C18823pJ2 c18823pJ2) {
            AbstractC13042fc3.i(c18823pJ2, "p0");
            return this.a.c(c18823pJ2);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof InterfaceC14123hO3) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* renamed from: ir.nasim.dh6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ long e;
        final /* synthetic */ EnumC20831sg6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = j;
            this.f = enumC20831sg6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11874dh6.this.new c(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11874dh6 c11874dh6 = C11874dh6.this;
                C6517Nv5 c6517Nv5T = c11874dh6.a.T(this.d, this.e, (EnumC19631qg6) C11874dh6.this.e.a(this.f), EnumC7325Rf6.a);
                this.b = 1;
                obj = c11874dh6.h(c6517Nv5T, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Y06 y06 = (Y06) obj;
            C11874dh6 c11874dh62 = C11874dh6.this;
            if (!(y06 instanceof Y06.b)) {
                if (y06 instanceof Y06.a) {
                    return new Y06.a(((Y06.a) y06).a());
                }
                throw new NoWhenBranchMatchedException();
            }
            C22372v74 c22372v74 = (C22372v74) ((Y06.b) y06).a();
            int iB = c22372v74.b() - c22372v74.a().size();
            List listA = c22372v74.a();
            AbstractC13042fc3.h(listA, "getGlobalSearchEntities(...)");
            InterfaceC14123hO3 interfaceC14123hO3 = c11874dh62.c;
            ArrayList arrayList = new ArrayList();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                AbstractC23884xg6.b bVar = (AbstractC23884xg6.b) interfaceC14123hO3.a((C18823pJ2) it.next());
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
            return new Y06.b(new C12486eh6(iB + arrayList.size(), arrayList));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dh6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ long e;
        final /* synthetic */ EnumC20831sg6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C11458d25 c11458d25, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = j;
            this.f = enumC20831sg6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11874dh6.this.new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11874dh6 c11874dh6 = C11874dh6.this;
                C6517Nv5 c6517Nv5T = c11874dh6.a.T(this.d, this.e, (EnumC19631qg6) C11874dh6.this.e.a(this.f), EnumC7325Rf6.b);
                this.b = 1;
                obj = c11874dh6.h(c6517Nv5T, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Y06 y06 = (Y06) obj;
            C11874dh6 c11874dh62 = C11874dh6.this;
            if (!(y06 instanceof Y06.b)) {
                if (y06 instanceof Y06.a) {
                    return new Y06.a(((Y06.a) y06).a());
                }
                throw new NoWhenBranchMatchedException();
            }
            C22372v74 c22372v74 = (C22372v74) ((Y06.b) y06).a();
            int iB = c22372v74.b() - c22372v74.a().size();
            List listA = c22372v74.a();
            AbstractC13042fc3.h(listA, "getGlobalSearchEntities(...)");
            InterfaceC14123hO3 interfaceC14123hO3 = c11874dh62.d;
            ArrayList arrayList = new ArrayList();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                AbstractC23884xg6.c cVar = (AbstractC23884xg6.c) interfaceC14123hO3.a((C18823pJ2) it.next());
                if (cVar != null) {
                    arrayList.add(cVar);
                }
            }
            return new Y06.b(new C12486eh6(iB + arrayList.size(), arrayList));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dh6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C6517Nv5 d;

        /* renamed from: ir.nasim.dh6$e$a */
        static final class a implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;

            a(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AbstractC24549yo1.c(this.a, new Y06.b(obj));
            }
        }

        /* renamed from: ir.nasim.dh6$e$b */
        static final class b implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;

            b(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(Exception exc) {
                HE0 he0 = this.a;
                AbstractC13042fc3.f(exc);
                AbstractC24549yo1.c(he0, new Y06.a(exc));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C6517Nv5 c6517Nv5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c6517Nv5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5 = this.d;
                this.b = c6517Nv5;
                this.c = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                c6517Nv5.m0(new a(ie0)).E(new b(ie0));
                obj = ie0.t();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11874dh6(C4471Fg6 c4471Fg6, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33) {
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "photoMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "videoMapper");
        AbstractC13042fc3.i(interfaceC14123hO33, "searchLoadModeSearchListLoadModeMapper");
        this.a = c4471Fg6;
        this.b = abstractC13778go1;
        this.c = interfaceC14123hO3;
        this.d = interfaceC14123hO32;
        this.e = interfaceC14123hO33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(C6517Nv5 c6517Nv5, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new e(c6517Nv5, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC11079ch6
    public Object a(C11458d25 c11458d25, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new c(c11458d25, j, enumC20831sg6, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC11079ch6
    public Object b(C11458d25 c11458d25, long j, EnumC20831sg6 enumC20831sg6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(c11458d25, j, enumC20831sg6, null), interfaceC20295rm1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11874dh6(C4471Fg6 c4471Fg6, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        C19414qJ2 c19414qJ2 = C19414qJ2.a;
        this(c4471Fg6, abstractC13778go1, new a(c19414qJ2), new b(c19414qJ2), new C22108ug6());
    }
}
