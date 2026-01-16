package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.AbstractC23884xg6;
import ir.nasim.C22445vF2;
import ir.nasim.RY1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: ir.nasim.vF2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22445vF2 {
    private final Cache a;
    private final InterfaceC12532em2 b;
    private final AbstractC13778go1 c;
    private final IT7 d;

    /* renamed from: ir.nasim.vF2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.vF2$a$a, reason: collision with other inner class name */
        public static final class C1657a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.vF2$a$a$a, reason: collision with other inner class name */
            public static final class C1658a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1658a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C1657a.this.a(null, this);
                }
            }

            public C1657a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                    boolean r0 = r6 instanceof ir.nasim.C22445vF2.a.C1657a.C1658a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.vF2$a$a$a r0 = (ir.nasim.C22445vF2.a.C1657a.C1658a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.vF2$a$a$a r0 = new ir.nasim.vF2$a$a$a
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
                    java.util.Set r5 = (java.util.Set) r5
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.Set r5 = ir.nasim.ZW0.r1(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22445vF2.a.C1657a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C1657a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vF2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC18505om2 g;

        /* renamed from: ir.nasim.vF2$b$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Float.valueOf(((C17942np0) obj).b()), Float.valueOf(((C17942np0) obj2).b()));
            }
        }

        /* renamed from: ir.nasim.vF2$b$b, reason: collision with other inner class name */
        public static final class C1659b implements Cache.a {
            final /* synthetic */ SortedSet a;
            final /* synthetic */ C22445vF2 b;
            final /* synthetic */ InterfaceC18505om2 c;
            final /* synthetic */ InterfaceC16204ks5 d;

            C1659b(SortedSet sortedSet, C22445vF2 c22445vF2, InterfaceC18505om2 interfaceC18505om2, InterfaceC16204ks5 interfaceC16204ks5) {
                this.a = sortedSet;
                this.b = c22445vF2;
                this.c = interfaceC18505om2;
                this.d = interfaceC16204ks5;
            }

            @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
            public void a(Cache cache, AbstractC18533op0 abstractC18533op0, AbstractC18533op0 abstractC18533op02) {
                AbstractC13042fc3.i(cache, "cache");
                AbstractC13042fc3.i(abstractC18533op0, "oldSpan");
                AbstractC13042fc3.i(abstractC18533op02, "newSpan");
            }

            @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
            public void b(Cache cache, AbstractC18533op0 abstractC18533op0) {
                AbstractC13042fc3.i(cache, "cache");
                AbstractC13042fc3.i(abstractC18533op0, "span");
                if (this.a.add(this.b.e(abstractC18533op0, ((C11920dm2) this.c).b().getFileSize()))) {
                    this.d.h(this.a);
                }
            }

            @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
            public void c(Cache cache, AbstractC18533op0 abstractC18533op0) {
                AbstractC13042fc3.i(cache, "cache");
                AbstractC13042fc3.i(abstractC18533op0, "span");
                if (this.a.remove(this.b.e(abstractC18533op0, ((C11920dm2) this.c).b().getFileSize()))) {
                    this.d.h(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC18505om2 interfaceC18505om2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = str;
            this.g = interfaceC18505om2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C22445vF2 c22445vF2, String str, C1659b c1659b) {
            c22445vF2.a.n(str, c1659b);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C22445vF2.this.new b(this.f, this.g, interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC16204ks5 interfaceC16204ks5;
            SortedSet sortedSetD0;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC16204ks5 = (InterfaceC16204ks5) this.d;
                NavigableSet<AbstractC18533op0> navigableSetM = C22445vF2.this.a.m(this.f);
                AbstractC13042fc3.h(navigableSetM, "getCachedSpans(...)");
                C22445vF2 c22445vF2 = C22445vF2.this;
                InterfaceC18505om2 interfaceC18505om2 = this.g;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(navigableSetM, 10));
                for (AbstractC18533op0 abstractC18533op0 : navigableSetM) {
                    AbstractC13042fc3.f(abstractC18533op0);
                    arrayList.add(c22445vF2.e(abstractC18533op0, ((C11920dm2) interfaceC18505om2).b().getFileSize()));
                }
                sortedSetD0 = AbstractC14812iX0.d0(arrayList, new a());
                interfaceC16204ks5.h(sortedSetD0);
                InterfaceC12532em2 interfaceC12532em2 = C22445vF2.this.b;
                long fileId = ((C11920dm2) this.g).b().getFileId();
                long accessHash = ((C11920dm2) this.g).b().getAccessHash();
                this.d = interfaceC16204ks5;
                this.b = sortedSetD0;
                this.c = 1;
                obj = interfaceC12532em2.l(fileId, accessHash, true, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                sortedSetD0 = (SortedSet) this.b;
                interfaceC16204ks5 = (InterfaceC16204ks5) this.d;
                AbstractC10685c16.b(obj);
            }
            if (((RY1) obj) instanceof RY1.a) {
                interfaceC16204ks5.h(AbstractC4363Eu6.c(new C17942np0(0.0f, 1.0f)));
                this.d = null;
                this.b = null;
                this.c = 2;
                if (AbstractC13822gs5.b(interfaceC16204ks5, null, this, 1, null) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }
            final C1659b c1659b = new C1659b(sortedSetD0, C22445vF2.this, this.g, interfaceC16204ks5);
            C22445vF2.this.a.l(this.f, c1659b);
            final C22445vF2 c22445vF22 = C22445vF2.this;
            final String str = this.f;
            SA2 sa2 = new SA2() { // from class: ir.nasim.wF2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C22445vF2.b.y(c22445vF22, str, c1659b);
                }
            };
            this.d = null;
            this.b = null;
            this.c = 3;
            if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vF2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

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
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Set setD = AbstractC4597Fu6.d();
                this.b = 1;
                if (interfaceC4806Gq2.a(setD, this) == objE) {
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
            return ((c) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22445vF2(Cache cache, InterfaceC12532em2 interfaceC12532em2, AbstractC13778go1 abstractC13778go1, IT7 it7) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(it7, "cacheKeyGenerator");
        this.a = cache;
        this.b = interfaceC12532em2;
        this.c = abstractC13778go1;
        this.d = it7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17942np0 e(AbstractC18533op0 abstractC18533op0, long j) {
        float f = j;
        return new C17942np0(abstractC18533op0.b / f, (r1 + abstractC18533op0.c) / f);
    }

    public final InterfaceC4557Fq2 d(AbstractC23884xg6.c cVar) {
        AbstractC13042fc3.i(cVar, "searchMessage");
        InterfaceC18505om2 interfaceC18505om2J = cVar.j();
        if (interfaceC18505om2J instanceof C4512Fl2) {
            return AbstractC6459Nq2.T(AbstractC4363Eu6.c(new C17942np0(0.0f, 1.0f)));
        }
        if (!(interfaceC18505om2J instanceof C11920dm2)) {
            throw new IllegalArgumentException();
        }
        C11920dm2 c11920dm2 = (C11920dm2) interfaceC18505om2J;
        return AbstractC6459Nq2.c0(new a(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new b(this.d.a(c11920dm2.b().getFileId(), c11920dm2.b().getAccessHash()), interfaceC18505om2J, null)), this.c)), new c(null));
    }
}
