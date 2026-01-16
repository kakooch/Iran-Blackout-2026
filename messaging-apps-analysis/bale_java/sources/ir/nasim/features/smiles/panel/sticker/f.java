package ir.nasim.features.smiles.panel.sticker;

import android.gov.nist.core.Separators;
import android.util.SparseIntArray;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9773aX7;
import ir.nasim.BN6;
import ir.nasim.C11458d25;
import ir.nasim.C12366eV1;
import ir.nasim.C14505i18;
import ir.nasim.C14733iO2;
import ir.nasim.C18987pb3;
import ir.nasim.C19938rB7;
import ir.nasim.C20298rm4;
import ir.nasim.C23698xM6;
import ir.nasim.C24119y45;
import ir.nasim.C5735Kp4;
import ir.nasim.C6287Mz;
import ir.nasim.C6517Nv5;
import ir.nasim.C7183Qq;
import ir.nasim.ED1;
import ir.nasim.EM2;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC3698By7;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.KB5;
import ir.nasim.OM6;
import ir.nasim.SA2;
import ir.nasim.VW7;
import ir.nasim.W25;
import ir.nasim.WM3;
import ir.nasim.X25;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.smiles.panel.sticker.d;
import ir.nasim.features.smiles.panel.sticker.f;
import ir.nasim.features.smiles.panel.sticker.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class f extends VW7 {
    public static final b l = new b(null);
    public static final int m = 8;
    private final BN6 b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;
    private final SparseIntArray e;
    private c f;
    private final InterfaceC10258bL6 g;
    private final C20298rm4 h;
    private final C20298rm4 i;
    private final int j;
    private final l.b k;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;

        /* renamed from: ir.nasim.features.smiles.panel.sticker.f$a$a, reason: collision with other inner class name */
        static final class C1232a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ f c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1232a(f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1232a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.u1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1232a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            f fVar;
            int i;
            Object objE = AbstractC14862ic3.e();
            int i2 = this.d;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                fVar = f.this;
                BN6 bn6 = fVar.b;
                this.b = fVar;
                this.c = 1;
                this.d = 1;
                obj = bn6.q(this);
                if (obj == objE) {
                    return objE;
                }
                i = 1;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                i = this.c;
                fVar = (f) this.b;
                AbstractC10685c16.b(obj);
            }
            fVar.f = new c(i != 0, (List) obj);
            InterfaceC10258bL6 interfaceC10258bL6 = f.this.g;
            C1232a c1232a = new C1232a(f.this, null);
            this.b = null;
            this.d = 2;
            if (AbstractC6459Nq2.l(interfaceC10258bL6, c1232a, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private static final class c {
        private final boolean a;
        private final List b;

        public c(boolean z, List list) {
            AbstractC13042fc3.i(list, "data");
            this.a = z;
            this.b = list;
        }

        public final List a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "RecentData(isLoaded=" + this.a + ", data=" + this.b + Separators.RPAREN;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C23698xM6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C23698xM6 c23698xM6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c23698xM6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BN6 bn6 = f.this.b;
                C23698xM6 c23698xM6 = this.d;
                this.b = 1;
                if (bn6.k(c23698xM6, this) == objE) {
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

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                f.this.f = new c(true, AbstractC10360bX0.m());
                f.this.u1();
                BN6 bn6 = f.this.b;
                this.b = 1;
                if (bn6.m(this) == objE) {
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

    /* renamed from: ir.nasim.features.smiles.panel.sticker.f$f, reason: collision with other inner class name */
    static final class C1233f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1233f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new C1233f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            f.this.e.clear();
            ArrayList arrayList = new ArrayList();
            List<OM6> list = this.d;
            f fVar = f.this;
            int size = 0;
            for (OM6 om6 : list) {
                arrayList.add(new d.a(null, om6.getName(), om6.u()));
                fVar.e.put(om6.u(), size);
                size = om6.w().size() + size + 1;
                List listW = om6.w();
                AbstractC13042fc3.h(listW, "getStickers(...)");
                List<C23698xM6> list2 = listW;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (C23698xM6 c23698xM6 : list2) {
                    AbstractC13042fc3.f(c23698xM6);
                    Integer numU = c23698xM6.u();
                    arrayList2.add(new d.b(c23698xM6, false, numU != null ? numU.intValue() : -1));
                }
                arrayList.addAll(arrayList2);
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C1233f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            l.a aVar;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List<OM6> list = this.c;
            ArrayList arrayList = new ArrayList();
            for (OM6 om6 : list) {
                if (om6.w().isEmpty()) {
                    aVar = null;
                } else {
                    Object obj2 = om6.w().get(0);
                    AbstractC13042fc3.h(obj2, "get(...)");
                    aVar = new l.a((C23698xM6) obj2);
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return f.this.j1(null, null, this);
        }
    }

    static final class i extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return f.this.k1(null, null, this);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 c;

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
                    C6517Nv5 c6517Nv5M0 = c6517Nv5B2.m0(new InterfaceC24449ye1() { // from class: ir.nasim.features.smiles.panel.sticker.g
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj2) {
                            f.j.a.z(c11458d25, (C14505i18) obj2);
                        }
                    });
                    final SA2 sa2 = this.e;
                    c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.features.smiles.panel.sticker.h
                        @Override // ir.nasim.InterfaceC24449ye1
                        public final void apply(Object obj2) {
                            f.j.a.D(sa2, (Exception) obj2);
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
        j(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25R = C11458d25.r(5313168347L);
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeA = X25.a(c11458d25R);
                WM3 wm3C = C12366eV1.c();
                a aVar = new a(exPeerTypeA, c11458d25R, this.c, null);
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C20298rm4 c20298rm4;
            C20298rm4 c20298rm42;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c20298rm4 = f.this.h;
                f fVar = f.this;
                List listA = fVar.f.a();
                List list = (List) f.this.g.getValue();
                this.b = c20298rm4;
                this.c = 1;
                obj = fVar.k1(listA, list, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c20298rm42 = (C20298rm4) this.b;
                    AbstractC10685c16.b(obj);
                    c20298rm42.n(obj);
                    return C19938rB7.a;
                }
                c20298rm4 = (C20298rm4) this.b;
                AbstractC10685c16.b(obj);
            }
            c20298rm4.n(obj);
            C20298rm4 c20298rm43 = f.this.i;
            f fVar2 = f.this;
            List listA2 = fVar2.f.a();
            List list2 = (List) f.this.g.getValue();
            this.b = c20298rm43;
            this.c = 2;
            Object objJ1 = fVar2.j1(listA2, list2, this);
            if (objJ1 == objE) {
                return objE;
            }
            c20298rm42 = c20298rm43;
            obj = objJ1;
            c20298rm42.n(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(final f fVar, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(fVar, "this$0");
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        c14733iO2.z().f(new InterfaceC14756iQ7() { // from class: ir.nasim.yN6
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                ir.nasim.features.smiles.panel.sticker.f.f1(this.a, (C24119y45) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(f fVar, C24119y45 c24119y45, AbstractC13554gQ7 abstractC13554gQ7) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(fVar, "this$0");
        if (c24119y45.s(EnumC3698By7.l)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = fVar.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, EM2.a));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = fVar.c;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, EM2.b));
    }

    private final Object h1(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.a(), new C1233f(list, null), interfaceC20295rm1);
    }

    private final Object i1(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.a(), new g(list, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j1(java.util.List r10, java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            boolean r2 = r12 instanceof ir.nasim.features.smiles.panel.sticker.f.h
            if (r2 == 0) goto L15
            r2 = r12
            ir.nasim.features.smiles.panel.sticker.f$h r2 = (ir.nasim.features.smiles.panel.sticker.f.h) r2
            int r3 = r2.e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L15
            int r3 = r3 - r4
            r2.e = r3
            goto L1a
        L15:
            ir.nasim.features.smiles.panel.sticker.f$h r2 = new ir.nasim.features.smiles.panel.sticker.f$h
            r2.<init>(r12)
        L1a:
            java.lang.Object r12 = r2.c
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.e
            if (r4 == 0) goto L3a
            if (r4 != r1) goto L32
            java.lang.Object r10 = r2.b
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r2.a
            ir.nasim.features.smiles.panel.sticker.f r11 = (ir.nasim.features.smiles.panel.sticker.f) r11
            ir.nasim.AbstractC10685c16.b(r12)
            goto L4b
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            ir.nasim.AbstractC10685c16.b(r12)
            r2.a = r9
            r2.b = r10
            r2.e = r1
            java.lang.Object r12 = r9.h1(r11, r2)
            if (r12 != r3) goto L4a
            return r3
        L4a:
            r11 = r9
        L4b:
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.List r12 = ir.nasim.ZW0.p1(r12)
            boolean r2 = r11.l1()
            if (r2 == 0) goto Lb2
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto Lb2
            ir.nasim.features.smiles.panel.sticker.d$a r2 = new ir.nasim.features.smiles.panel.sticker.d$a
            int r3 = ir.nasim.AbstractC12217eE5.smiles_sticker_recent
            java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r3)
            ir.nasim.features.smiles.panel.sticker.l$b r3 = r11.k
            int r6 = r3.a()
            r7 = 2
            r8 = 0
            r5 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            ir.nasim.features.smiles.panel.sticker.d[] r3 = new ir.nasim.features.smiles.panel.sticker.d[r1]
            r3[r0] = r2
            java.util.List r2 = ir.nasim.ZW0.s(r3)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = ir.nasim.ZW0.x(r10, r4)
            r3.<init>(r4)
            java.util.Iterator r10 = r10.iterator()
        L8f:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto Laa
            java.lang.Object r4 = r10.next()
            ir.nasim.xM6 r4 = (ir.nasim.C23698xM6) r4
            ir.nasim.features.smiles.panel.sticker.d$b r5 = new ir.nasim.features.smiles.panel.sticker.d$b
            ir.nasim.features.smiles.panel.sticker.l$b r6 = r11.k
            int r6 = r6.a()
            r5.<init>(r4, r1, r6)
            r3.add(r5)
            goto L8f
        Laa:
            r2.addAll(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            r12.addAll(r0, r2)
        Lb2:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.smiles.panel.sticker.f.j1(java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k1(java.util.List r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.features.smiles.panel.sticker.f.i
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.features.smiles.panel.sticker.f$i r0 = (ir.nasim.features.smiles.panel.sticker.f.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.features.smiles.panel.sticker.f$i r0 = new ir.nasim.features.smiles.panel.sticker.f$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r0.a
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L5f
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 == 0) goto L4f
            ir.nasim.features.smiles.panel.sticker.l$b r5 = r4.k
            r7.add(r5)
        L4f:
            r0.a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r5 = r4.i1(r6, r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            r6 = r7
            r7 = r5
            r5 = r6
        L5f:
            java.util.Collection r7 = (java.util.Collection) r7
            r5.addAll(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.smiles.panel.sticker.f.k1(java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean l1() {
        return this.f.b() && (this.f.a().isEmpty() ^ true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 u1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    public final InterfaceC13730gj3 c1(C23698xM6 c23698xM6) {
        AbstractC13042fc3.i(c23698xM6, "sticker");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(c23698xM6, null), 3, null);
    }

    public final void d1(W25 w25, int i2) {
        AbstractC13042fc3.i(w25, "peerType");
        if (w25 == W25.b) {
            AbstractC5969Lp4.b().k(i2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.xN6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.smiles.panel.sticker.f.e1(this.a, (C14733iO2) obj);
                }
            });
        }
    }

    public final InterfaceC13730gj3 g1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final r m1() {
        return this.i;
    }

    public final r o1() {
        return this.h;
    }

    public final int p1(int i2) {
        if (i2 == this.k.a()) {
            return this.j;
        }
        int i3 = this.e.get(i2);
        Integer numValueOf = Integer.valueOf(this.f.a().size());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        return i3 + (numValueOf != null ? numValueOf.intValue() + 1 : 0);
    }

    public final InterfaceC10258bL6 q1() {
        return this.d;
    }

    public final int s1(int i2) {
        List list = (List) this.h.f();
        if (list == null) {
            return -1;
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((l) it.next()).a() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final InterfaceC13730gj3 t1(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onFail");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new j(sa2, null), 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ f(BN6 bn6, int i2, ED1 ed1) {
        if ((i2 & 1) != 0) {
            BN6.b bVar = BN6.e;
            C6287Mz c6287MzS = C5735Kp4.w().i().o2().s();
            AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
            InterfaceC3570Bk5 interfaceC3570Bk5C = C5735Kp4.w().i().o2().c();
            AbstractC13042fc3.h(interfaceC3570Bk5C, "<get-preferences>(...)");
            InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
            AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
            bn6 = bVar.a(c6287MzS, interfaceC3570Bk5C, interfaceC3570Bk5Q);
        }
        this(bn6);
    }

    public f(BN6 bn6) {
        AbstractC13042fc3.i(bn6, "stickersRepository");
        this.b = bn6;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(EM2.a);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.e = new SparseIntArray();
        this.f = new c(false, AbstractC10360bX0.m());
        this.g = bn6.p();
        this.h = new C20298rm4();
        this.i = new C20298rm4();
        this.k = new l.b(this.j, KB5.smiles_emoji_recent);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(null), 2, null);
    }
}
