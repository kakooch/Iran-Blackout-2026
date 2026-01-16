package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C21669tv7;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.w44, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22938w44 {
    private static final float a;
    private static final float b;
    private static final float c = C17784nZ1.q(12);
    private static final float d = C17784nZ1.q(8);
    private static final float e = C17784nZ1.q(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
    private static final float f = C17784nZ1.q(280);

    /* renamed from: ir.nasim.w44$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ C11932dn4 f;
        final /* synthetic */ InterfaceC9102Ym4 g;
        final /* synthetic */ InterfaceC9664aL6 h;
        final /* synthetic */ InterfaceC9664aL6 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, C11932dn4 c11932dn4, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
            super(1);
            this.e = z;
            this.f = c11932dn4;
            this.g = interfaceC9102Ym4;
            this.h = interfaceC9664aL6;
            this.i = interfaceC9664aL62;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            float fB = 0.8f;
            float fC = 1.0f;
            cVar.g(!this.e ? AbstractC22938w44.b(this.h) : ((Boolean) this.f.b()).booleanValue() ? 1.0f : 0.8f);
            if (!this.e) {
                fB = AbstractC22938w44.b(this.h);
            } else if (((Boolean) this.f.b()).booleanValue()) {
                fB = 1.0f;
            }
            cVar.m(fB);
            if (!this.e) {
                fC = AbstractC22938w44.c(this.i);
            } else if (!((Boolean) this.f.b()).booleanValue()) {
                fC = 0.0f;
            }
            cVar.c(fC);
            cVar.C0(((androidx.compose.ui.graphics.f) this.g.getValue()).j());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w44$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C9023Yd6 f;
        final /* synthetic */ InterfaceC15796kB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = eVar;
            this.f = c9023Yd6;
            this.g = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1573559053, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:429)");
            }
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(androidx.compose.foundation.layout.k.b(androidx.compose.foundation.layout.q.k(this.e, 0.0f, AbstractC22938w44.i(), 1, null), EnumC11821dc3.b), this.f, false, null, false, 14, null);
            InterfaceC15796kB2 interfaceC15796kB2 = this.g;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            interfaceC15796kB2.q(C9784aZ0.a, interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
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

    /* renamed from: ir.nasim.w44$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C11932dn4 f;
        final /* synthetic */ InterfaceC9102Ym4 g;
        final /* synthetic */ C9023Yd6 h;
        final /* synthetic */ InterfaceC10031ax6 i;
        final /* synthetic */ long j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;
        final /* synthetic */ C10493bi0 m;
        final /* synthetic */ InterfaceC15796kB2 n;
        final /* synthetic */ int o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(androidx.compose.ui.e eVar, C11932dn4 c11932dn4, InterfaceC9102Ym4 interfaceC9102Ym4, C9023Yd6 c9023Yd6, InterfaceC10031ax6 interfaceC10031ax6, long j, float f, float f2, C10493bi0 c10493bi0, InterfaceC15796kB2 interfaceC15796kB2, int i) {
            super(2);
            this.e = eVar;
            this.f = c11932dn4;
            this.g = interfaceC9102Ym4;
            this.h = c9023Yd6;
            this.i = interfaceC10031ax6;
            this.j = j;
            this.k = f;
            this.l = f2;
            this.m = c10493bi0;
            this.n = interfaceC15796kB2;
            this.o = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC22938w44.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC22053ub1, QJ5.a(this.o | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w44$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final d e = new d();

        d() {
            super(3);
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1355418157);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1355418157, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:396)");
            }
            C7479Rw7 c7479Rw7L = bVar.c(Boolean.FALSE, Boolean.TRUE) ? AbstractC5999Lt.l(30, 0, null, 6, null) : AbstractC5999Lt.l(75, 0, null, 6, null);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.w44$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final e e = new e();

        e() {
            super(3);
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1033023423);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1033023423, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:381)");
            }
            C7479Rw7 c7479Rw7L = bVar.c(Boolean.FALSE, Boolean.TRUE) ? AbstractC5999Lt.l(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, T22.f(), 2, null) : AbstractC5999Lt.l(1, 74, null, 4, null);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.w44$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ C19275q44 f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ L66 i;
        final /* synthetic */ InterfaceC14603iB2 j;

        /* renamed from: ir.nasim.w44$f$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(2035552199, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:477)");
                }
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, C11554dC3.a.i(), 0.0f, 2, null);
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
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

        /* renamed from: ir.nasim.w44$f$b */
        static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ L66 e;
            final /* synthetic */ InterfaceC14603iB2 f;
            final /* synthetic */ InterfaceC14603iB2 g;
            final /* synthetic */ InterfaceC14603iB2 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(L66 l66, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23) {
                super(2);
                this.e = l66;
                this.f = interfaceC14603iB2;
                this.g = interfaceC14603iB22;
                this.h = interfaceC14603iB23;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1728894036, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:483)");
                }
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(L66.b(this.e, androidx.compose.ui.e.a, 1.0f, false, 2, null), this.f != null ? AbstractC22938w44.c : C17784nZ1.q(0), 0.0f, this.g != null ? AbstractC22938w44.c : C17784nZ1.q(0), 0.0f, 10, null);
                InterfaceC14603iB2 interfaceC14603iB2 = this.h;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
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

        /* renamed from: ir.nasim.w44$f$c */
        static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(580312062, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:507)");
                }
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, C11554dC3.a.k(), 0.0f, 2, null);
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
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
        f(InterfaceC14603iB2 interfaceC14603iB2, C19275q44 c19275q44, boolean z, InterfaceC14603iB2 interfaceC14603iB22, L66 l66, InterfaceC14603iB2 interfaceC14603iB23) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = c19275q44;
            this.g = z;
            this.h = interfaceC14603iB22;
            this.i = l66;
            this.j = interfaceC14603iB23;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1065051884, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:473)");
            }
            interfaceC22053ub1.W(1264683960);
            if (this.e != null) {
                AbstractC11024cc1.a(AbstractC21553tk1.a().d(C24381yX0.k(this.f.a(this.g))), AbstractC19242q11.e(2035552199, true, new a(this.e), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
            interfaceC22053ub1.Q();
            C7252Qx5 c7252Qx5D = AbstractC21553tk1.a().d(C24381yX0.k(this.f.b(this.g)));
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1728894036, true, new b(this.i, this.e, this.h, this.j), interfaceC22053ub1, 54);
            int i2 = C7252Qx5.i;
            AbstractC11024cc1.a(c7252Qx5D, interfaceC18060o11E, interfaceC22053ub1, i2 | 48);
            if (this.h != null) {
                AbstractC11024cc1.a(AbstractC21553tk1.a().d(C24381yX0.k(this.f.c(this.g))), AbstractC19242q11.e(580312062, true, new c(this.h), interfaceC22053ub1, 54), interfaceC22053ub1, i2 | 48);
            }
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

    /* renamed from: ir.nasim.w44$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ C19275q44 k;
        final /* synthetic */ TS4 l;
        final /* synthetic */ InterfaceC18507om4 m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, boolean z, C19275q44 c19275q44, TS4 ts4, InterfaceC18507om4 interfaceC18507om4, int i) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = sa2;
            this.g = eVar;
            this.h = interfaceC14603iB22;
            this.i = interfaceC14603iB23;
            this.j = z;
            this.k = c19275q44;
            this.l = ts4;
            this.m = interfaceC18507om4;
            this.n = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC22938w44.d(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC22053ub1, QJ5.a(this.n | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float f2 = 48;
        a = C17784nZ1.q(f2);
        b = C17784nZ1.q(f2);
    }

    public static final void a(androidx.compose.ui.e eVar, C11932dn4 c11932dn4, InterfaceC9102Ym4 interfaceC9102Ym4, C9023Yd6 c9023Yd6, InterfaceC10031ax6 interfaceC10031ax6, long j, float f2, float f3, C10493bi0 c10493bi0, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-151448888);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c11932dn4) : interfaceC22053ub1J.D(c11932dn4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC9102Ym4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c9023Yd6) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC10031ax6) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.c(f2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= interfaceC22053ub1J.c(f3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= interfaceC22053ub1J.V(c10493bi0) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-151448888, i2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:374)");
            }
            C21669tv7 c21669tv7G = AbstractC4139Dv7.g(c11932dn4, "DropDownMenu", interfaceC22053ub1J, C11932dn4.d | 48 | ((i2 >> 3) & 14), 0);
            e eVar2 = e.e;
            C9361Zp2 c9361Zp2 = C9361Zp2.a;
            InterfaceC5342Ix7 interfaceC5342Ix7D = PQ7.d(c9361Zp2);
            boolean zBooleanValue = ((Boolean) c21669tv7G.h()).booleanValue();
            interfaceC22053ub1J.W(2139028452);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f4 = zBooleanValue ? 1.0f : 0.8f;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1J.Q();
            Float fValueOf = Float.valueOf(f4);
            boolean zBooleanValue2 = ((Boolean) c21669tv7G.o()).booleanValue();
            interfaceC22053ub1J.W(2139028452);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f5 = zBooleanValue2 ? 1.0f : 0.8f;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6E = AbstractC4139Dv7.e(c21669tv7G, fValueOf, Float.valueOf(f5), (InterfaceC4788Go2) eVar2.q(c21669tv7G.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D, "FloatAnimation", interfaceC22053ub1J, 0);
            d dVar = d.e;
            InterfaceC5342Ix7 interfaceC5342Ix7D2 = PQ7.d(c9361Zp2);
            boolean zBooleanValue3 = ((Boolean) c21669tv7G.h()).booleanValue();
            interfaceC22053ub1J.W(-249413128);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f6 = zBooleanValue3 ? 1.0f : 0.0f;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1J.Q();
            Float fValueOf2 = Float.valueOf(f6);
            boolean zBooleanValue4 = ((Boolean) c21669tv7G.o()).booleanValue();
            interfaceC22053ub1J.W(-249413128);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f7 = zBooleanValue4 ? 1.0f : 0.0f;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6E2 = AbstractC4139Dv7.e(c21669tv7G, fValueOf2, Float.valueOf(f7), (InterfaceC4788Go2) dVar.q(c21669tv7G.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D2, "FloatAnimation", interfaceC22053ub1J, 0);
            boolean zBooleanValue5 = ((Boolean) interfaceC22053ub1J.H(R93.a())).booleanValue();
            e.a aVar = androidx.compose.ui.e.a;
            boolean zA = interfaceC22053ub1J.a(zBooleanValue5) | interfaceC22053ub1J.V(interfaceC9664aL6E) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 || ((i2 & 64) != 0 && interfaceC22053ub1J.D(c11932dn4))) | interfaceC22053ub1J.V(interfaceC9664aL6E2) | ((i2 & 896) == 256);
            Object objB = interfaceC22053ub1J.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                i3 = i2;
                a aVar2 = new a(zBooleanValue5, c11932dn4, interfaceC9102Ym4, interfaceC9664aL6E, interfaceC9664aL6E2);
                interfaceC22053ub1J.s(aVar2);
                objB = aVar2;
            } else {
                i3 = i2;
            }
            int i4 = i3 >> 9;
            int i5 = i3 >> 6;
            F27.a(androidx.compose.ui.graphics.b.a(aVar, (UA2) objB), interfaceC10031ax6, j, 0L, f2, f3, c10493bi0, AbstractC19242q11.e(1573559053, true, new b(eVar, c9023Yd6, interfaceC15796kB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i4 & 896) | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 12582912 | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 8);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(eVar, c11932dn4, interfaceC9102Ym4, c9023Yd6, interfaceC10031ax6, j, f2, f3, c10493bi0, interfaceC15796kB2, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    public static final void d(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, boolean z, C19275q44 c19275q44, TS4 ts4, InterfaceC18507om4 interfaceC18507om4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1564716777);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(eVar) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(c19275q44) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(ts4) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC18507om4) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) == 38347922 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1564716777, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:451)");
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.layout.t.x(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.e.d(eVar, interfaceC18507om4, androidx.compose.material3.a.e(true, 0.0f, 0L, interfaceC22053ub1J, 6, 6), z, null, null, sa2, 24, null), 0.0f, 1, null), e, b, f, 0.0f, 8, null), ts4);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            AbstractC9339Zm7.a(C15386jV3.a.c(interfaceC22053ub1J, 6).j(), AbstractC19242q11.e(1065051884, true, new f(interfaceC14603iB22, c19275q44, z, interfaceC14603iB23, M66.a, interfaceC14603iB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48);
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new g(interfaceC14603iB2, sa2, eVar, interfaceC14603iB22, interfaceC14603iB23, z, c19275q44, ts4, interfaceC18507om4, i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long h(ir.nasim.C25005za3 r5, ir.nasim.C25005za3 r6) {
        /*
            int r0 = r6.g()
            int r1 = r5.h()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto Lf
        Ld:
            r0 = r3
            goto L49
        Lf:
            int r0 = r6.h()
            int r1 = r5.g()
            if (r0 > r1) goto L1b
            r0 = r2
            goto L49
        L1b:
            int r0 = r6.l()
            if (r0 != 0) goto L22
            goto Ld
        L22:
            int r0 = r5.g()
            int r1 = r6.g()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.h()
            int r4 = r6.h()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.g()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.l()
            float r1 = (float) r1
            float r0 = r0 / r1
        L49:
            int r1 = r6.j()
            int r4 = r5.d()
            if (r1 < r4) goto L55
        L53:
            r2 = r3
            goto L8f
        L55:
            int r1 = r6.d()
            int r4 = r5.j()
            if (r1 > r4) goto L60
            goto L8f
        L60:
            int r1 = r6.f()
            if (r1 != 0) goto L67
            goto L53
        L67:
            int r1 = r5.j()
            int r2 = r6.j()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.d()
            int r2 = r6.d()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.j()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.f()
            float r6 = (float) r6
            float r2 = r5 / r6
        L8f:
            long r5 = ir.nasim.AbstractC13854gv7.a(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22938w44.h(ir.nasim.za3, ir.nasim.za3):long");
    }

    public static final float i() {
        return d;
    }

    public static final float j() {
        return a;
    }
}
