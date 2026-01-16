package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.compose.ui.e;
import ir.nasim.F9;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class F9 {

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-770267218);
            A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC13346g43 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC13819gs2 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    this.b = 1;
                    if (c19818qz6.j(this) == objE) {
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

        b(InterfaceC13346g43 interfaceC13346g43, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, SA2 sa2, InterfaceC13819gs2 interfaceC13819gs2) {
            this.a = interfaceC13346g43;
            this.b = interfaceC20315ro1;
            this.c = c19818qz6;
            this.d = sa2;
            this.e = interfaceC13819gs2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.H9
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return F9.b.f(c19818qz6, sa2, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C19818qz6 c19818qz6, SA2 sa2, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(zy0) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.k(eVarH, g10.c(interfaceC22053ub1, i3).b().s(), 0.0f, 2, null), g10.c(interfaceC22053ub1, i3).b().f(), g10.c(interfaceC22053ub1, i3).b().d());
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            androidx.compose.ui.e eVarC = zy0.c(eVarJ, aVar2.g());
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            AbstractC9339Zm7.b(UY6.c(FD5.create_new_folder, interfaceC22053ub1, 0), androidx.compose.foundation.layout.h.a.h(aVar, aVar2.e()), g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).l(), interfaceC22053ub1, 0, 0, 65016);
            interfaceC22053ub1.u();
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), null, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            InterfaceC13346g43 interfaceC13346g43 = this.a;
            interfaceC22053ub1.W(-997319824);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.d);
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final C19818qz6 c19818qz6 = this.c;
            final SA2 sa2 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.G9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return F9.b.d(interfaceC20315ro1, c19818qz6, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            F9.q(interfaceC13346g43, (SA2) objB, this.e, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC13819gs2 a;

        c(InterfaceC13819gs2 interfaceC13819gs2) {
            this.a = interfaceC13819gs2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC13819gs2 interfaceC13819gs2) {
            AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
            interfaceC13819gs2.V0().invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(aVar, g10.c(interfaceC22053ub1, i2).b().q(), 0.0f, 2, null);
            String strC = UY6.c(FD5.create_folder, interfaceC22053ub1, 0);
            int i3 = AbstractC16390lB5.add_to_folder;
            C11984ds7 c11984ds7 = new C11984ds7(g10.a(interfaceC22053ub1, i2).M(), g10.a(interfaceC22053ub1, i2).I(), g10.a(interfaceC22053ub1, i2).z(), g10.a(interfaceC22053ub1, i2).I(), null);
            interfaceC22053ub1.W(1329282590);
            boolean zV = interfaceC22053ub1.V(this.a);
            final InterfaceC13819gs2 interfaceC13819gs2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.I9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return F9.c.c(interfaceC13819gs2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.i(strC, i3, eVarK, null, null, null, c11984ds7, (SA2) objB, null, false, interfaceC22053ub1, C11984ds7.f << 18, 824);
            MY2.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), null, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        d(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().c());
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC = UY6.c(FD5.cancel, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(1329309031);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.J9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return F9.d.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A((SA2) objB, c1454b, strC, eVarI, null, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 3) | 24576, 32);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class h extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ InterfaceC13819gs2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List list, InterfaceC13819gs2 interfaceC13819gs2) {
            super(4);
            this.e = list;
            this.f = interfaceC13819gs2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            C8870Xr2 c8870Xr2 = (C8870Xr2) this.e.get(i);
            interfaceC22053ub1.W(-1742579570);
            F9.m(c8870Xr2.d(), c8870Xr2.c(), c8870Xr2.e(), c8870Xr2.f(), this.f.C3(), this.f.p(), interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    static final class i implements InterfaceC14603iB2 {
        final /* synthetic */ C8870Xr2 a;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8870Xr2 a;

            a(C8870Xr2 c8870Xr2) {
                this.a = c8870Xr2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(int i) {
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(String str, int i, boolean z) {
                AbstractC13042fc3.i(str, "<unused var>");
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strD = this.a.d();
                int iC = this.a.c();
                boolean zE = this.a.e();
                interfaceC22053ub1.W(-1753563540);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.K9
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return F9.i.a.d(((Integer) obj).intValue());
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1753561864);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new InterfaceC15796kB2() { // from class: ir.nasim.L9
                        @Override // ir.nasim.InterfaceC15796kB2
                        public final Object q(Object obj, Object obj2, Object obj3) {
                            return F9.i.a.f((String) obj, ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                F9.m(strD, iC, zE, false, ua2, (InterfaceC15796kB2) objB2, interfaceC22053ub1, 221184, 8);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        i(C8870Xr2 c8870Xr2) {
            this.a = c8870Xr2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(384526882, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class j implements InterfaceC14603iB2 {
        final /* synthetic */ C8870Xr2 a;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8870Xr2 a;

            a(C8870Xr2 c8870Xr2) {
                this.a = c8870Xr2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(int i) {
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(String str, int i, boolean z) {
                AbstractC13042fc3.i(str, "<unused var>");
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strD = this.a.d();
                int iC = this.a.c();
                boolean zE = this.a.e();
                interfaceC22053ub1.W(-1624400002);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.M9
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return F9.j.a.d(((Integer) obj).intValue());
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1624398326);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new InterfaceC15796kB2() { // from class: ir.nasim.N9
                        @Override // ir.nasim.InterfaceC15796kB2
                        public final Object q(Object obj, Object obj2, Object obj3) {
                            return F9.j.a.f((String) obj, ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                F9.m(strD, iC, zE, false, ua2, (InterfaceC15796kB2) objB2, interfaceC22053ub1, 221184, 8);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        j(C8870Xr2 c8870Xr2) {
            this.a = c8870Xr2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(99157940, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void k(androidx.compose.ui.e eVar, final C19818qz6 c19818qz6, final InterfaceC13346g43 interfaceC13346g43, final InterfaceC13819gs2 interfaceC13819gs2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c19818qz6, "sheetState");
        AbstractC13042fc3.i(interfaceC13346g43, "folders");
        AbstractC13042fc3.i(interfaceC13819gs2, "folderListActions");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(843563845);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(c19818qz6) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC13346g43) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC13819gs2) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        int i6 = i4;
        if ((i6 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar4 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB);
            }
            eVar3 = eVar4;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9273Zf4.a(sa2, AbstractC22050ua8.c(eVar4, AbstractC21393ta8.g(AbstractC24416ya8.e(A98.a, interfaceC22053ub1J, 6), AbstractC23236wa8.a.g())), c19818qz6, 0.0f, null, G10.a.a(interfaceC22053ub1J, G10.b).M(), 0L, 0.0f, 0L, null, a.a, null, AbstractC19242q11.e(1729232098, true, new b(interfaceC13346g43, (InterfaceC20315ro1) objB, c19818qz6, sa2, interfaceC13819gs2), interfaceC22053ub1J, 54), interfaceC22053ub12, ((i6 >> 12) & 14) | 805306368 | ((i6 << 3) & 896), 384, 2520);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar5 = eVar3;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.y9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F9.l(eVar5, c19818qz6, interfaceC13346g43, interfaceC13819gs2, sa2, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(androidx.compose.ui.e eVar, C19818qz6 c19818qz6, InterfaceC13346g43 interfaceC13346g43, InterfaceC13819gs2 interfaceC13819gs2, SA2 sa2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c19818qz6, "$sheetState");
        AbstractC13042fc3.i(interfaceC13346g43, "$folders");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        k(eVar, c19818qz6, interfaceC13346g43, interfaceC13819gs2, sa2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(final java.lang.String r36, final int r37, final boolean r38, boolean r39, final ir.nasim.UA2 r40, final ir.nasim.InterfaceC15796kB2 r41, ir.nasim.InterfaceC22053ub1 r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F9.m(java.lang.String, int, boolean, boolean, ir.nasim.UA2, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC15796kB2 interfaceC15796kB2, int i2, String str, Resources resources) {
        AbstractC13042fc3.i(interfaceC15796kB2, "$onDeleteReservedFolderClicked");
        AbstractC13042fc3.i(str, "$folderName");
        AbstractC13042fc3.f(resources);
        interfaceC15796kB2.q(AbstractC9978as2.a(i2, str, resources), Integer.valueOf(i2), Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(UA2 ua2, int i2) {
        AbstractC13042fc3.i(ua2, "$onAddReservedFolderClick");
        ua2.invoke(Integer.valueOf(i2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(String str, int i2, boolean z, boolean z2, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$folderName");
        AbstractC13042fc3.i(ua2, "$onAddReservedFolderClick");
        AbstractC13042fc3.i(interfaceC15796kB2, "$onDeleteReservedFolderClicked");
        m(str, i2, z, z2, ua2, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    public static final void q(final InterfaceC13346g43 interfaceC13346g43, final SA2 sa2, final InterfaceC13819gs2 interfaceC13819gs2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(interfaceC13346g43, "folders");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(interfaceC13819gs2, "folderListActions");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1651201000);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(interfaceC13346g43) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(interfaceC13819gs2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(856424743);
            boolean z = ((i3 & 14) == 4) | ((i3 & 896) == 256) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.C9
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return F9.r(interfaceC13346g43, interfaceC13819gs2, sa2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1J, 0, 511);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.D9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F9.t(interfaceC13346g43, sa2, interfaceC13819gs2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC13346g43 interfaceC13346g43, InterfaceC13819gs2 interfaceC13819gs2, SA2 sa2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC13346g43, "$folders");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        if (!interfaceC13346g43.isEmpty()) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, H11.a.a(), 3, null);
        }
        interfaceC15069ix3.a(interfaceC13346g43.size(), new f(new UA2() { // from class: ir.nasim.E9
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return F9.s((C8870Xr2) obj);
            }
        }, interfaceC13346g43), new g(e.e, interfaceC13346g43), AbstractC19242q11.c(-632812321, true, new h(interfaceC13346g43, interfaceC13819gs2)));
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1043246989, true, new c(interfaceC13819gs2)), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-981160100, true, new d(sa2)), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object s(C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(c8870Xr2, "it");
        return Integer.valueOf(c8870Xr2.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(InterfaceC13346g43 interfaceC13346g43, SA2 sa2, InterfaceC13819gs2 interfaceC13819gs2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC13346g43, "$folders");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        q(interfaceC13346g43, sa2, interfaceC13819gs2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(java.lang.String r33, java.lang.String r34, ir.nasim.InterfaceC22053ub1 r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F9.u(java.lang.String, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(String str, String str2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        u(str, str2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void w(final C8870Xr2 c8870Xr2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(c8870Xr2, "params");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2065506215);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c8870Xr2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(94946658, true, new i(c8870Xr2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.w9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F9.x(c8870Xr2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(C8870Xr2 c8870Xr2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8870Xr2, "$params");
        w(c8870Xr2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void y(final C8870Xr2 c8870Xr2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(c8870Xr2, "params");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1780137273);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c8870Xr2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-190422284, true, new j(c8870Xr2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.x9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F9.z(c8870Xr2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C8870Xr2 c8870Xr2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8870Xr2, "$params");
        y(c8870Xr2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }
}
