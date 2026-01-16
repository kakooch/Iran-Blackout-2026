package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC21163tD2;
import ir.nasim.AbstractC22427vD2;
import ir.nasim.C10798cD2;
import ir.nasim.C4993Hl0;
import ir.nasim.InterfaceC11562dD2;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC21791u83;
import ir.nasim.KW3;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class NC2 extends VW7 {
    public static final a s = new a(null);
    public static final int t = 8;
    private final C15634ju6 b;
    private final C4993Hl0.b c;
    private final C10798cD2.a d;
    private final C11458d25 e;
    private final ExPeerType f;
    private final TC2 g;
    private final String h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9336Zm4 j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC4557Fq2 l;
    private final InterfaceC9336Zm4 m;
    private final InterfaceC4557Fq2 n;
    private Integer o;
    private final InterfaceC9336Zm4 p;
    private final InterfaceC9336Zm4 q;
    private final InterfaceC4557Fq2 r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ int c;
        /* synthetic */ boolean d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                int i2 = this.c;
                boolean z = this.d;
                if (i2 > 0) {
                    NC2.this.o = AbstractC6392Nk0.d(i2);
                    return new InterfaceC11562dD2.b(i2);
                }
                if (!z) {
                    return InterfaceC11562dD2.a.a;
                }
                NC2 nc2 = NC2.this;
                this.b = 1;
                obj = nc2.m1(i2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return new InterfaceC11562dD2.c((Integer) obj);
        }

        public final Object n(int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = NC2.this.new b(interfaceC20295rm1);
            bVar.c = i;
            bVar.d = z;
            return bVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n(((Number) obj).intValue(), ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C4993Hl0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C4993Hl0 c4993Hl0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = c4993Hl0;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return this.e.e((List) this.c, (List) this.d);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.e, interfaceC20295rm1);
            cVar.c = list;
            cVar.d = list2;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC18160oB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;
        /* synthetic */ Object f;
        final /* synthetic */ C10798cD2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C10798cD2 c10798cD2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(5, interfaceC20295rm1);
            this.g = c10798cD2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C5227Il0 c5227Il0 = (C5227Il0) this.c;
            List list = (List) this.d;
            List list2 = (List) this.e;
            List list3 = (List) this.f;
            List list4 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC6392Nk0.e(((C5227Il0) it.next()).d()));
            }
            if (!AbstractC15401jX0.i0(arrayList, c5227Il0 != null ? AbstractC6392Nk0.e(c5227Il0.d()) : null)) {
                c5227Il0 = (C5227Il0) AbstractC15401jX0.s0(list);
            }
            if (c5227Il0 == null) {
                return null;
            }
            UA2 ua2A = c5227Il0.a();
            ArrayList<C9588aD2> arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (((Boolean) ua2A.invoke(obj2)).booleanValue()) {
                    arrayList2.add(obj2);
                }
            }
            C10798cD2 c10798cD2 = this.g;
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            for (C9588aD2 c9588aD2 : arrayList2) {
                Iterator it2 = list3.iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (((C17337mn6) it2.next()).d() == c9588aD2.c()) {
                        break;
                    }
                    i++;
                }
                arrayList3.add(i < 0 ? c10798cD2.b(c9588aD2, null, null) : c10798cD2.b(c9588aD2, AbstractC6392Nk0.d(i), (C17337mn6) list3.get(i)));
            }
            return new C9929an6(c5227Il0.d(), c5227Il0.e(), arrayList3);
        }

        @Override // ir.nasim.InterfaceC18160oB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object s(C5227Il0 c5227Il0, List list, List list2, List list3, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.g, interfaceC20295rm1);
            dVar.c = c5227Il0;
            dVar.d = list;
            dVar.e = list2;
            dVar.f = list3;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC18160oB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;
        /* synthetic */ Object f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(5, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            List list2 = (List) this.d;
            InterfaceC11562dD2 interfaceC11562dD2 = (InterfaceC11562dD2) this.e;
            C9929an6 c9929an6 = (C9929an6) this.f;
            return new AbstractC22427vD2.c(list2.size(), interfaceC11562dD2, NC2.this.j1(list2), list, c9929an6, NC2.this.g.A());
        }

        @Override // ir.nasim.InterfaceC18160oB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object s(List list, List list2, InterfaceC11562dD2 interfaceC11562dD2, C9929an6 c9929an6, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = NC2.this.new e(interfaceC20295rm1);
            eVar.c = list;
            eVar.d = list2;
            eVar.e = interfaceC11562dD2;
            eVar.f = c9929an6;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class f extends C23553x7 implements InterfaceC14603iB2 {
        f(Object obj) {
            super(2, obj, NC2.class, "unSelectRemovedItems", "unSelectRemovedItems(Ljava/util/List;)V", 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return NC2.i1((NC2) this.a, list, interfaceC20295rm1);
        }
    }

    public static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ NC2 e;
        final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC20295rm1 interfaceC20295rm1, NC2 nc2, Context context) {
            super(3, interfaceC20295rm1);
            this.e = nc2;
            this.f = context;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2T = ((Boolean) this.d).booleanValue() ? AbstractC6459Nq2.T(AbstractC22427vD2.a.a) : this.e.f1(this.f);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2T, this) == objE) {
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
            g gVar = new g(interfaceC20295rm1, this.e, this.f);
            gVar.c = interfaceC4806Gq2;
            gVar.d = obj;
            return gVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC22427vD2.b bVar = AbstractC22427vD2.b.a;
                this.b = 1;
                if (interfaceC4806Gq2.a(bVar, this) == objE) {
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
            return ((h) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Integer numD = AbstractC6392Nk0.d(C7183Qq.p().getInt("keyboard_height", -1));
            if (numD.intValue() != -1) {
                return numD;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NC2.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NC2 nc2 = NC2.this;
                EnumC20560sD2 enumC20560sD2 = EnumC20560sD2.b;
                this.b = 1;
                if (nc2.C1(enumC20560sD2, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NC2.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NC2 nc2 = NC2.this;
                EnumC20560sD2 enumC20560sD2 = EnumC20560sD2.a;
                this.b = 1;
                if (nc2.C1(enumC20560sD2, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NC2.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NC2 nc2 = NC2.this;
                EnumC20560sD2 enumC20560sD2 = EnumC20560sD2.c;
                this.b = 1;
                if (nc2.C1(enumC20560sD2, this) == objE) {
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

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC20560sD2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(EnumC20560sD2 enumC20560sD2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC20560sD2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NC2.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            KW3 aVar;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Iterable<C17337mn6> iterable = (Iterable) NC2.this.m.getValue();
            EnumC20560sD2 enumC20560sD2 = this.d;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            for (C17337mn6 c17337mn6 : iterable) {
                if (c17337mn6.h()) {
                    aVar = new KW3.b(c17337mn6.f(), c17337mn6.c(), false, enumC20560sD2 == EnumC20560sD2.a, c17337mn6.g());
                } else {
                    aVar = new KW3.a(c17337mn6.f(), c17337mn6.c(), enumC20560sD2 == EnumC20560sD2.a);
                }
                arrayList.add(aVar);
            }
            NC2.this.b.a(NC2.this.h, new C19951rD2(this.d, arrayList));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public NC2(androidx.lifecycle.y yVar, InterfaceC4906Hb3 interfaceC4906Hb3, C15634ju6 c15634ju6, C4993Hl0.b bVar, C10798cD2.a aVar) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(interfaceC4906Hb3, "galleryRepository");
        AbstractC13042fc3.i(c15634ju6, "setGalleryResultUseCase");
        AbstractC13042fc3.i(bVar, "bucketMapperFactory");
        AbstractC13042fc3.i(aVar, "galleryMapperFactory");
        this.b = c15634ju6;
        this.c = bVar;
        this.d = aVar;
        Object objC = yVar.c("peerUniqueId");
        AbstractC13042fc3.f(objC);
        C11458d25 c11458d25R = C11458d25.r(((Number) objC).longValue());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.e = c11458d25R;
        Object objC2 = yVar.c("exPeerTypeValue");
        AbstractC13042fc3.f(objC2);
        this.f = (ExPeerType) objC2;
        Object objC3 = yVar.c("galleryConfig");
        AbstractC13042fc3.f(objC3);
        TC2 tc2 = (TC2) objC3;
        this.g = tc2;
        Object objC4 = yVar.c("galleryResultKey");
        AbstractC13042fc3.f(objC4);
        this.h = (String) objC4;
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.LC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NC2.S0();
            }
        });
        Boolean bool = Boolean.FALSE;
        this.j = AbstractC12281eL6.a(bool);
        this.k = AbstractC12281eL6.a(null);
        InterfaceC4557Fq2 interfaceC4557Fq2A = interfaceC4906Hb3.a();
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        this.l = AbstractC6459Nq2.F(AbstractC6459Nq2.o0(interfaceC4557Fq2A, interfaceC20315ro1A, aVar2.c(), null));
        this.m = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.n = AbstractC6459Nq2.F(AbstractC6459Nq2.o0(AbstractC6459Nq2.V(AbstractC6459Nq2.b0(interfaceC4906Hb3.b(tc2.getContentType()), new f(this)), C12366eV1.a()), AbstractC9773aX7.a(this), aVar2.c(), null));
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(0);
        this.p = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(bool);
        this.q = interfaceC9336Zm4A2;
        this.r = AbstractC6459Nq2.p(interfaceC9336Zm4A, interfaceC9336Zm4A2, new b(null));
    }

    private static final void B1(NC2 nc2, C21837uD2 c21837uD2, String str) {
        Object next;
        Iterator it = ((Iterable) nc2.m.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((C17337mn6) next).d() == c21837uD2.c()) {
                    break;
                }
            }
        }
        C17337mn6 c17337mn6 = (C17337mn6) next;
        if (c17337mn6 != null) {
            nc2.K1(c17337mn6, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object C1(EnumC20560sD2 enumC20560sD2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.b(), new m(enumC20560sD2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void G1(final List list) {
        Object value;
        List listP1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = AbstractC15401jX0.p1((List) value);
            AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.MC2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(NC2.H1(list, (C17337mn6) obj));
                }
            });
        } while (!interfaceC9336Zm4.f(value, listP1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H1(List list, C17337mn6 c17337mn6) {
        AbstractC13042fc3.i(list, "$newItems");
        AbstractC13042fc3.i(c17337mn6, "oldItem");
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((C9588aD2) it.next()).c() == c17337mn6.d()) {
                return false;
            }
        }
        return true;
    }

    private final void K1(C17337mn6 c17337mn6, String str) {
        Object value;
        List listP1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = (List) value;
            Iterator it = listP1.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (((C17337mn6) it.next()).d() == c17337mn6.d()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                listP1 = AbstractC15401jX0.p1(listP1);
                listP1.set(i2, C17337mn6.b(c17337mn6, 0, null, str, false, null, null, 59, null));
            }
        } while (!interfaceC9336Zm4.f(value, listP1));
    }

    private final void L1(C17337mn6 c17337mn6, String str, ir.nasim.tgwidgets.editor.messenger.H h2, MediaController.l lVar) {
        Object value;
        List listP1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            listP1 = (List) value;
            Iterator it = listP1.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (((C17337mn6) it.next()).d() == c17337mn6.d()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                listP1 = AbstractC15401jX0.p1(listP1);
                listP1.set(i2, C17337mn6.b(c17337mn6, 0, str, null, false, h2, lVar, 13, null));
            }
        } while (!interfaceC9336Zm4.f(value, listP1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8327Vm4 S0() {
        return AbstractC11420cy6.b(0, 1, EnumC6162Ml0.DROP_OLDEST, 1, null);
    }

    private final InterfaceC4557Fq2 d1(Context context) {
        return AbstractC6459Nq2.p(this.n, this.l, new c(this.c.a(context), null));
    }

    private final InterfaceC4557Fq2 e1(Context context, InterfaceC4557Fq2 interfaceC4557Fq2) {
        return AbstractC6459Nq2.F(AbstractC6459Nq2.n(this.k, interfaceC4557Fq2, this.n, this.m, new d(this.d.a(context), null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 f1(Context context) {
        InterfaceC4557Fq2 interfaceC4557Fq2D1 = d1(context);
        return AbstractC6459Nq2.V(AbstractC6459Nq2.n(interfaceC4557Fq2D1, this.m, this.r, e1(context, interfaceC4557Fq2D1), new e(null)), C12366eV1.a());
    }

    private final C17337mn6 h1(List list) {
        Object next;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C17337mn6) next).c() != null) {
                break;
            }
        }
        C17337mn6 c17337mn6 = (C17337mn6) next;
        return c17337mn6 == null ? (C17337mn6) AbstractC15401jX0.s0(list) : c17337mn6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object i1(NC2 nc2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        nc2.G1(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21791u83 j1(List list) {
        return (this.g.t() && (list.isEmpty() ^ true)) ? this.g.x() ? new InterfaceC21791u83.a(h1(list)) : InterfaceC21791u83.c.a : InterfaceC21791u83.b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m1(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (i2 > 0) {
            return AbstractC6392Nk0.d(i2);
        }
        Integer num = this.o;
        return num == null ? t1(interfaceC20295rm1) : num;
    }

    private final InterfaceC8327Vm4 q1() {
        return (InterfaceC8327Vm4) this.i.getValue();
    }

    private final Object t1(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new i(null), interfaceC20295rm1);
    }

    private final void w1() {
        q1().c(new AbstractC21163tD2.a(this.g.B()));
    }

    public final void A1(C21837uD2 c21837uD2, String str) {
        AbstractC13042fc3.i(c21837uD2, "item");
        if (c21837uD2.g() != null) {
            B1(this, c21837uD2, str);
        } else if (((List) this.m.getValue()).size() >= this.g.B()) {
            w1();
        } else {
            B1(this, c21837uD2, str);
        }
    }

    public final void D1(C21837uD2 c21837uD2, String str, ir.nasim.tgwidgets.editor.messenger.H h2, MediaController.l lVar) {
        Object next;
        AbstractC13042fc3.i(c21837uD2, "item");
        AbstractC13042fc3.i(str, "path");
        Iterator it = ((Iterable) this.m.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((C17337mn6) next).d() == c21837uD2.c()) {
                    break;
                }
            }
        }
        C17337mn6 c17337mn6 = (C17337mn6) next;
        if (c17337mn6 != null) {
            L1(c17337mn6, str, h2, lVar);
        }
    }

    public final void E1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.q;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final boolean F1(C21837uD2 c21837uD2) {
        AbstractC13042fc3.i(c21837uD2, "galleryUIItem");
        Iterable iterable = (Iterable) this.m.getValue();
        boolean z = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((C17337mn6) it.next()).d() == c21837uD2.c()) {
                    z = true;
                    break;
                }
            }
        }
        return v1(c21837uD2, !z);
    }

    public final void I1(String str) {
        C17337mn6 c17337mn6H1 = h1((List) this.m.getValue());
        if (c17337mn6H1 != null) {
            String str2 = null;
            if (str != null) {
                if (str.length() == 0) {
                    str = null;
                }
                str2 = str;
            }
            K1(c17337mn6H1, str2);
        }
    }

    public final void J1(int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).intValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i2)));
    }

    public final void g1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
    }

    public final C11458d25 k1() {
        return this.e;
    }

    public final int l1() {
        return ((List) this.m.getValue()).size();
    }

    public final InterfaceC10040ay6 o1() {
        return AbstractC6459Nq2.b(q1());
    }

    public final InterfaceC4557Fq2 p1(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC6459Nq2.c0(AbstractC6459Nq2.s0(this.j, new g(null, this, context)), new h(null));
    }

    public final boolean s1(int i2) {
        Iterable iterable = (Iterable) this.m.getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((C17337mn6) it.next()).d() == i2) {
                return true;
            }
        }
        return false;
    }

    public final void u1(C5227Il0 c5227Il0) {
        Object value;
        AbstractC13042fc3.i(c5227Il0, "bucket");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, c5227Il0));
    }

    public final boolean v1(C21837uD2 c21837uD2, boolean z) {
        Object value;
        List listP1;
        Object value2;
        AbstractC13042fc3.i(c21837uD2, "item");
        if (!z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
            do {
                value = interfaceC9336Zm4.getValue();
                listP1 = AbstractC15401jX0.p1((List) value);
                Iterator it = listP1.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((C17337mn6) it.next()).d() == c21837uD2.c()) {
                        it.remove();
                        break;
                    }
                }
            } while (!interfaceC9336Zm4.f(value, listP1));
        } else {
            if (((List) this.m.getValue()).size() < this.g.B()) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.m;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value2, AbstractC15401jX0.S0((List) value2, new C17337mn6(c21837uD2.c(), c21837uD2.f(), c21837uD2.a(), c21837uD2.b() != null, c21837uD2.i(), null, 32, null))));
                return true;
            }
            w1();
        }
        return false;
    }

    public final InterfaceC13730gj3 x1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(null), 3, null);
    }

    public final InterfaceC13730gj3 y1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    public final InterfaceC13730gj3 z1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(null), 3, null);
    }
}
