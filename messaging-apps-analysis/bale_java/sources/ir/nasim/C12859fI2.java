package ir.nasim;

import ir.nasim.C12859fI2;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.fI2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12859fI2 extends VW7 {
    public static final b o = new b(null);
    public static final int p = 8;
    private final C16450lI2 b;
    private final InterfaceC3570Bk5 c;
    private final SettingsModule d;
    private final C14661iH2 e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC9173Yu3 h;
    private final InterfaceC4557Fq2 i;
    private final InterfaceC9336Zm4 j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC9336Zm4 l;
    private final InterfaceC10258bL6 m;
    private final InterfaceC9173Yu3 n;

    /* renamed from: ir.nasim.fI2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.fI2$a$a, reason: collision with other inner class name */
        static final class C1115a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12859fI2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1115a(C12859fI2 c12859fI2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12859fI2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1115a(this.c, interfaceC20295rm1);
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
                this.c.p1();
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1115a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12859fI2.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4A = C16450lI2.f.a();
                C1115a c1115a = new C1115a(C12859fI2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC8327Vm4A, c1115a, this) == objE) {
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

    /* renamed from: ir.nasim.fI2$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fI2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC18160oB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        /* synthetic */ Object e;
        /* synthetic */ Object f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
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
            boolean z = this.d;
            return new C18805pH2(list, list.isEmpty() || z, (Integer) this.e, (EM2) this.f);
        }

        public final Object n(List list, boolean z, Integer num, EM2 em2, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1);
            cVar.c = list;
            cVar.d = z;
            cVar.e = num;
            cVar.f = em2;
            return cVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC18160oB2
        public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return n((List) obj, ((Boolean) obj2).booleanValue(), (Integer) obj3, (EM2) obj4, (InterfaceC20295rm1) obj5);
        }
    }

    /* renamed from: ir.nasim.fI2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 d;

        /* renamed from: ir.nasim.fI2$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ExPeerType c;
            final /* synthetic */ C11458d25 d;
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ExPeerType exPeerType, C11458d25 c11458d25, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = exPeerType;
                this.d = c11458d25;
                this.e = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void D(SA2 sa2, Exception exc) {
                sa2.invoke();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void z(C11458d25 c11458d25, C14505i18 c14505i18) {
                C18987pb3.a.w1(c11458d25, null, false);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c != null) {
                    AbstractC6392Nk0.a(C18987pb3.a.w1(this.d, null, false));
                } else {
                    C6517Nv5 c6517Nv5B2 = AbstractC5969Lp4.e().E().B2(AbstractC10360bX0.g(AbstractC6392Nk0.d(this.d.getPeerId())), false);
                    final C11458d25 c11458d25 = this.d;
                    C6517Nv5 c6517Nv5M0 = c6517Nv5B2.m0(new InterfaceC24449ye1() { // from class: ir.nasim.gI2
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj2) {
                            C12859fI2.d.a.z(c11458d25, (C14505i18) obj2);
                        }
                    });
                    final SA2 sa2 = this.e;
                    c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.hI2
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj2) {
                            C12859fI2.d.a.D(sa2, (Exception) obj2);
                        }
                    });
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12859fI2.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25R = C11458d25.r(C12859fI2.this.d1());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeA = X25.a(c11458d25R);
                WM3 wm3C = C12366eV1.c();
                a aVar = new a(exPeerTypeA, c11458d25R, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fI2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12859fI2.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16450lI2 c16450lI2 = C12859fI2.this.b;
                this.b = 1;
                if (c16450lI2.h(null, this) == objE) {
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

    /* renamed from: ir.nasim.fI2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QG2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(QG2 qg2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qg2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12859fI2.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objI;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16450lI2 c16450lI2 = C12859fI2.this.b;
                long fileId = this.d.c().getFileId();
                long accessHash = this.d.c().getAccessHash();
                Integer fileStorageVersion = this.d.c().getFileStorageVersion();
                AbstractC13042fc3.f(fileStorageVersion);
                int iIntValue = fileStorageVersion.intValue();
                this.b = 1;
                objI = c16450lI2.i(fileId, accessHash, iIntValue, this);
                if (objI == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
                objI = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objI)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C12859fI2.this.k;
                Integer numD = AbstractC6392Nk0.d(AbstractC12217eE5.gif_removed_from_saved);
                this.b = 2;
                if (interfaceC9336Zm4.a(numD, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fI2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C12859fI2.this.new g(interfaceC20295rm1);
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
            List list = (List) this.c;
            C12859fI2 c12859fI2 = C12859fI2.this;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c12859fI2.e.a((C5845Lb6) it.next()));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fI2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QG2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(QG2 qg2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qg2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12859fI2.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16450lI2 c16450lI2 = C12859fI2.this.b;
                long fileId = this.d.c().getFileId();
                long accessHash = this.d.c().getAccessHash();
                Integer fileStorageVersion = this.d.c().getFileStorageVersion();
                AbstractC13042fc3.f(fileStorageVersion);
                int iIntValue = fileStorageVersion.intValue();
                this.b = 1;
                if (c16450lI2.k(fileId, accessHash, iIntValue, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12859fI2(final androidx.lifecycle.y yVar, C16450lI2 c16450lI2, InterfaceC3570Bk5 interfaceC3570Bk5, SettingsModule settingsModule, C14661iH2 c14661iH2) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(c16450lI2, "gifsRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c14661iH2, "gifEntityToGifMapper");
        this.b = c16450lI2;
        this.c = interfaceC3570Bk5;
        this.d = settingsModule;
        this.e = c14661iH2;
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12859fI2.o1(yVar);
            }
        });
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aI2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C12859fI2.m1(yVar));
            }
        });
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bI2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C12859fI2.i1(yVar));
            }
        });
        a1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.X(c16450lI2.g(), new g(null)), C12366eV1.a());
        this.i = interfaceC4557Fq2V;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        this.j = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.k = interfaceC9336Zm4A2;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(EM2.a);
        this.l = interfaceC9336Zm4A3;
        this.m = AbstractC6459Nq2.o0(AbstractC6459Nq2.n(interfaceC4557Fq2V, interfaceC9336Zm4A, interfaceC9336Zm4A2, interfaceC9336Zm4A3, new c(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), new C18805pH2(AbstractC10360bX0.m(), false, null, null, 14, null));
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cI2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(C12859fI2.h1(this.a));
            }
        });
    }

    private final void a1() {
        if (g1() == W25.b) {
            AbstractC5969Lp4.b().k(f1()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dI2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C12859fI2.b1(this.a, (C14733iO2) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(final C12859fI2 c12859fI2, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c12859fI2, "this$0");
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        c14733iO2.z().f(new InterfaceC14756iQ7() { // from class: ir.nasim.eI2
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C12859fI2.c1(this.a, (C24119y45) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(C12859fI2 c12859fI2, C24119y45 c24119y45, AbstractC13554gQ7 abstractC13554gQ7) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(c12859fI2, "this$0");
        if (c24119y45.s(EnumC3698By7.l)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = c12859fI2.l;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, EM2.a));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = c12859fI2.l;
        do {
            value = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value, EM2.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long d1() {
        return ((Number) this.n.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h1(C12859fI2 c12859fI2) {
        AbstractC13042fc3.i(c12859fI2, "this$0");
        return c12859fI2.d.f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        Boolean bool = (Boolean) yVar.c("ARG_IS_COMMENT");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m1(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        Object objC = yVar.c("ARG_PEER_ID");
        AbstractC13042fc3.f(objC);
        return ((Number) objC).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W25 o1(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        W25[] w25Arr = (W25[]) W25.j().toArray(new W25[0]);
        Object objC = yVar.c("ARG_PEER_TYPE");
        AbstractC13042fc3.f(objC);
        return w25Arr[((Number) objC).intValue()];
    }

    public final InterfaceC10258bL6 e1() {
        return this.m;
    }

    public final int f1() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final W25 g1() {
        return (W25) this.f.getValue();
    }

    public final boolean j1() {
        Object value;
        if (!((C18805pH2) this.m.getValue()).b() || !(!r0.a().isEmpty())) {
            return false;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
        return true;
    }

    public final void k1() {
        Object value;
        if (((C18805pH2) this.m.getValue()).b() && (!r0.a().isEmpty())) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
        }
    }

    public final InterfaceC13730gj3 l1(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onFail");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(sa2, null), 2, null);
    }

    public final void p1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final void q1(QG2 qg2) {
        AbstractC13042fc3.i(qg2, "gif");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(qg2, null), 3, null);
    }

    public final boolean s1() {
        return this.b.j();
    }

    public final boolean t1() {
        if (this.d.g2()) {
            return false;
        }
        this.d.S6(true);
        return true;
    }

    public final void u1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void v1(Integer num) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, num));
    }

    public final void w1(QG2 qg2) {
        AbstractC13042fc3.i(qg2, "gif");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(qg2, null), 3, null);
    }
}
