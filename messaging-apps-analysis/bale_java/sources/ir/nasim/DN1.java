package ir.nasim;

import androidx.lifecycle.j;
import ir.nasim.YO1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class DN1 {

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ YO1 e;
        final /* synthetic */ androidx.navigation.d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(YO1 yo1, androidx.navigation.d dVar) {
            super(0);
            this.e = yo1;
            this.f = dVar;
        }

        public final void a() {
            this.e.m(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.navigation.d e;
        final /* synthetic */ InterfaceC9809ab6 f;
        final /* synthetic */ C14063hH6 g;
        final /* synthetic */ YO1 h;
        final /* synthetic */ YO1.b i;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C14063hH6 e;
            final /* synthetic */ androidx.navigation.d f;
            final /* synthetic */ YO1 g;

            /* renamed from: ir.nasim.DN1$b$a$a, reason: collision with other inner class name */
            public static final class C0317a implements KV1 {
                final /* synthetic */ YO1 a;
                final /* synthetic */ androidx.navigation.d b;
                final /* synthetic */ C14063hH6 c;

                public C0317a(YO1 yo1, androidx.navigation.d dVar, C14063hH6 c14063hH6) {
                    this.a = yo1;
                    this.b = dVar;
                    this.c = c14063hH6;
                }

                @Override // ir.nasim.KV1
                public void dispose() {
                    this.a.p(this.b);
                    this.c.remove(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14063hH6 c14063hH6, androidx.navigation.d dVar, YO1 yo1) {
                super(1);
                this.e = c14063hH6;
                this.f = dVar;
                this.g = yo1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KV1 invoke(LV1 lv1) {
                this.e.add(this.f);
                return new C0317a(this.g, this.f, this.e);
            }
        }

        /* renamed from: ir.nasim.DN1$b$b, reason: collision with other inner class name */
        static final class C0318b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ YO1.b e;
            final /* synthetic */ androidx.navigation.d f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0318b(YO1.b bVar, androidx.navigation.d dVar) {
                super(2);
                this.e = bVar;
                this.f = dVar;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-497631156, i, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous>.<anonymous> (DialogHost.kt:66)");
                }
                this.e.W().q(this.f, interfaceC22053ub1, 8);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.navigation.d dVar, InterfaceC9809ab6 interfaceC9809ab6, C14063hH6 c14063hH6, YO1 yo1, YO1.b bVar) {
            super(2);
            this.e = dVar;
            this.f = interfaceC9809ab6;
            this.g = c14063hH6;
            this.h = yo1;
            this.i = bVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1129586364, i, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous> (DialogHost.kt:55)");
            }
            androidx.navigation.d dVar = this.e;
            AbstractC10721c52.a(dVar, new a(this.g, dVar, this.h), interfaceC22053ub1, 8);
            androidx.navigation.d dVar2 = this.e;
            AbstractC7413Rp4.a(dVar2, this.f, AbstractC19242q11.b(interfaceC22053ub1, -497631156, true, new C0318b(this.i, dVar2)), interfaceC22053ub1, 456);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ YO1 d;
        final /* synthetic */ C14063hH6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9664aL6 interfaceC9664aL6, YO1 yo1, C14063hH6 c14063hH6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = yo1;
            this.e = c14063hH6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Set<androidx.navigation.d> setC = DN1.c(this.c);
            YO1 yo1 = this.d;
            C14063hH6 c14063hH6 = this.e;
            for (androidx.navigation.d dVar : setC) {
                if (!((List) yo1.n().getValue()).contains(dVar) && !c14063hH6.contains(dVar)) {
                    yo1.p(dVar);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ YO1 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(YO1 yo1, int i) {
            super(2);
            this.e = yo1;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            DN1.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.navigation.d e;
        final /* synthetic */ boolean f;
        final /* synthetic */ List g;

        public static final class a implements KV1 {
            final /* synthetic */ androidx.navigation.d a;
            final /* synthetic */ androidx.lifecycle.n b;

            public a(androidx.navigation.d dVar, androidx.lifecycle.n nVar) {
                this.a = dVar;
                this.b = nVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.getLifecycle().d(this.b);
            }
        }

        static final class b implements androidx.lifecycle.n {
            final /* synthetic */ boolean a;
            final /* synthetic */ List b;
            final /* synthetic */ androidx.navigation.d c;

            b(boolean z, List list, androidx.navigation.d dVar) {
                this.a = z;
                this.b = list;
                this.c = dVar;
            }

            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                if (this.a && !this.b.contains(this.c)) {
                    this.b.add(this.c);
                }
                if (aVar == j.a.ON_START && !this.b.contains(this.c)) {
                    this.b.add(this.c);
                }
                if (aVar == j.a.ON_STOP) {
                    this.b.remove(this.c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(androidx.navigation.d dVar, boolean z, List list) {
            super(1);
            this.e = dVar;
            this.f = z;
            this.g = list;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            b bVar = new b(this.f, this.g, this.e);
            this.e.getLifecycle().a(bVar);
            return new a(this.e, bVar);
        }
    }

    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ List e;
        final /* synthetic */ Collection f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(List list, Collection collection, int i) {
            super(2);
            this.e = list;
            this.f = collection;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            DN1.d(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(YO1 yo1, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(294589392);
        int i2 = (i & 14) == 0 ? (interfaceC22053ub1J.V(yo1) ? 4 : 2) | i : i;
        if ((i2 & 11) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(294589392, i2, -1, "androidx.navigation.compose.DialogHost (DialogHost.kt:40)");
            }
            InterfaceC9809ab6 interfaceC9809ab6A = AbstractC11019cb6.a(interfaceC22053ub1J, 0);
            InterfaceC20295rm1 interfaceC20295rm1 = null;
            boolean z = true;
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(yo1.n(), null, interfaceC22053ub1J, 8, 1);
            C14063hH6<androidx.navigation.d> c14063hH6F = f(b(interfaceC9664aL6B), interfaceC22053ub1J, 8);
            d(c14063hH6F, b(interfaceC9664aL6B), interfaceC22053ub1J, 64);
            InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(yo1.o(), null, interfaceC22053ub1J, 8, 1);
            interfaceC22053ub1J.A(-492369756);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.f();
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.U();
            C14063hH6 c14063hH6 = (C14063hH6) objB;
            interfaceC22053ub1J.A(875188318);
            for (androidx.navigation.d dVar : c14063hH6F) {
                androidx.navigation.i iVarE = dVar.e();
                AbstractC13042fc3.g(iVarE, "null cannot be cast to non-null type androidx.navigation.compose.DialogNavigator.Destination");
                YO1.b bVar = (YO1.b) iVarE;
                AbstractC6687Oo.a(new a(yo1, dVar), bVar.Y(), AbstractC19242q11.b(interfaceC22053ub1J, 1129586364, z, new b(dVar, interfaceC9809ab6A, c14063hH6, yo1, bVar)), interfaceC22053ub1J, 384, 0);
                interfaceC9664aL6B2 = interfaceC9664aL6B2;
                interfaceC20295rm1 = null;
                c14063hH6 = c14063hH6;
                z = z;
            }
            C14063hH6 c14063hH62 = c14063hH6;
            InterfaceC9664aL6 interfaceC9664aL6 = interfaceC9664aL6B2;
            InterfaceC20295rm1 interfaceC20295rm12 = interfaceC20295rm1;
            interfaceC22053ub1J.U();
            Set setC = c(interfaceC9664aL6);
            interfaceC22053ub1J.A(1618982084);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6) | interfaceC22053ub1J.V(yo1) | interfaceC22053ub1J.V(c14063hH62);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new c(interfaceC9664aL6, yo1, c14063hH62, interfaceC20295rm12);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.U();
            AbstractC10721c52.f(setC, c14063hH62, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 568);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new d(yo1, i));
    }

    private static final List b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set c(InterfaceC9664aL6 interfaceC9664aL6) {
        return (Set) interfaceC9664aL6.getValue();
    }

    public static final void d(List list, Collection collection, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1537894851);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1537894851, i, -1, "androidx.navigation.compose.PopulateVisibleList (DialogHost.kt:86)");
        }
        boolean zBooleanValue = ((Boolean) interfaceC22053ub1J.H(R93.a())).booleanValue();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            androidx.navigation.d dVar = (androidx.navigation.d) it.next();
            AbstractC10721c52.a(dVar.getLifecycle(), new e(dVar, zBooleanValue, list), interfaceC22053ub1J, 8);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M == null) {
            return;
        }
        interfaceC20208rd6M.a(new f(list, collection, i));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C14063hH6 f(java.util.Collection r5, ir.nasim.InterfaceC22053ub1 r6, int r7) {
        /*
            r0 = 467378629(0x1bdba1c5, float:3.6335052E-22)
            r6.A(r0)
            boolean r1 = ir.nasim.AbstractC5138Ib1.I()
            if (r1 == 0) goto L12
            r1 = -1
            java.lang.String r2 = "androidx.navigation.compose.rememberVisibleList (DialogHost.kt:119)"
            ir.nasim.AbstractC5138Ib1.Q(r0, r7, r1, r2)
        L12:
            ir.nasim.Nx5 r7 = ir.nasim.R93.a()
            java.lang.Object r7 = r6.H(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = 1157296644(0x44faf204, float:2007.563)
            r6.A(r0)
            boolean r0 = r6.V(r5)
            java.lang.Object r1 = r6.B()
            if (r0 != 0) goto L38
            ir.nasim.ub1$a r0 = ir.nasim.InterfaceC22053ub1.a
            java.lang.Object r0 = r0.a()
            if (r1 != r0) goto L72
        L38:
            ir.nasim.hH6 r1 = ir.nasim.AbstractC10222bH6.f()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L47:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L6c
            java.lang.Object r2 = r5.next()
            r3 = r2
            androidx.navigation.d r3 = (androidx.navigation.d) r3
            if (r7 == 0) goto L58
            r3 = 1
            goto L66
        L58:
            androidx.lifecycle.j r3 = r3.getLifecycle()
            androidx.lifecycle.j$b r3 = r3.b()
            androidx.lifecycle.j$b r4 = androidx.lifecycle.j.b.STARTED
            boolean r3 = r3.j(r4)
        L66:
            if (r3 == 0) goto L47
            r0.add(r2)
            goto L47
        L6c:
            r1.addAll(r0)
            r6.s(r1)
        L72:
            r6.U()
            ir.nasim.hH6 r1 = (ir.nasim.C14063hH6) r1
            boolean r5 = ir.nasim.AbstractC5138Ib1.I()
            if (r5 == 0) goto L80
            ir.nasim.AbstractC5138Ib1.P()
        L80:
            r6.U()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DN1.f(java.util.Collection, ir.nasim.ub1, int):ir.nasim.hH6");
    }
}
