package ir.nasim;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Kb3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5608Kb3 implements InterfaceC4906Hb3 {
    private final AbstractC13778go1 a;
    private final YC2 b;
    private final YC2 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.Kb3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VC2.values().length];
            try {
                iArr[VC2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VC2.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VC2.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Kb3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Kb3$b$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((C9588aD2) obj2).d()), Long.valueOf(((C9588aD2) obj).d()));
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC15401jX0.a1(AbstractC15401jX0.R0((List) this.c, (List) this.d), new a());
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = list;
            bVar.d = list2;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kb3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

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
            return AbstractC15401jX0.m1(C5608Kb3.this.h((Map) this.c, (Map) this.d).values());
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(Map map, Map map2, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C5608Kb3.this.new c(interfaceC20295rm1);
            cVar.c = map;
            cVar.d = map2;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    public C5608Kb3(AbstractC13778go1 abstractC13778go1, final InterfaceC20315ro1 interfaceC20315ro1, YC2 yc2, YC2 yc22) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(yc2, "imageDataSource");
        AbstractC13042fc3.i(yc22, "videoDataSource");
        this.a = abstractC13778go1;
        this.b = yc2;
        this.c = yc22;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ib3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5608Kb3.e(this.a, interfaceC20315ro1);
            }
        });
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Jb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5608Kb3.g(this.a, interfaceC20315ro1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 e(C5608Kb3 c5608Kb3, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c5608Kb3, "this$0");
        AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.F(AbstractC6459Nq2.o0(AbstractC6459Nq2.p(c5608Kb3.b.h(), c5608Kb3.c.h(), new b(null)), interfaceC20315ro1, InterfaceC16863lz6.a.c(), null)), c5608Kb3.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 g(C5608Kb3 c5608Kb3, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c5608Kb3, "this$0");
        AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.F(AbstractC6459Nq2.o0(AbstractC6459Nq2.p(c5608Kb3.b.g(), c5608Kb3.c.g(), c5608Kb3.new c(null)), interfaceC20315ro1, InterfaceC16863lz6.a.c(), null)), c5608Kb3.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map h(Map map, Map map2) {
        C3808Cl0 c3808Cl0B;
        HashMap map3 = new HashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            C3808Cl0 c3808Cl0 = (C3808Cl0) entry.getValue();
            C3808Cl0 c3808Cl02 = (C3808Cl0) map3.get(Long.valueOf(jLongValue));
            if (c3808Cl02 != null && (c3808Cl0B = C3808Cl0.b(c3808Cl0, 0L, c3808Cl0.e() + c3808Cl02.e(), null, 5, null)) != null) {
                c3808Cl0 = c3808Cl0B;
            }
            map3.put(Long.valueOf(jLongValue), c3808Cl0);
        }
        return map3;
    }

    private final InterfaceC4557Fq2 i() {
        return (InterfaceC4557Fq2) this.e.getValue();
    }

    private final InterfaceC4557Fq2 j() {
        return (InterfaceC4557Fq2) this.d.getValue();
    }

    @Override // ir.nasim.InterfaceC4906Hb3
    public InterfaceC4557Fq2 a() {
        return i();
    }

    @Override // ir.nasim.InterfaceC4906Hb3
    public InterfaceC4557Fq2 b(VC2 vc2) {
        AbstractC13042fc3.i(vc2, "galleryContentType");
        int i = a.a[vc2.ordinal()];
        if (i == 1) {
            return j();
        }
        if (i == 2) {
            return this.b.h();
        }
        if (i == 3) {
            return this.c.h();
        }
        throw new NoWhenBranchMatchedException();
    }
}
