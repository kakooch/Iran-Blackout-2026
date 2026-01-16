package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.YK1;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class YK1 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ ZJ1 a;

        /* renamed from: ir.nasim.YK1$a$a, reason: collision with other inner class name */
        static final class C0788a implements InterfaceC15796kB2 {
            final /* synthetic */ ZJ1 a;

            C0788a(ZJ1 zj1) {
                this.a = zj1;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(eVar, "textModifier");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strC = this.a.c();
                G10 g10 = G10.a;
                int i3 = G10.b;
                C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i3).a();
                AbstractC9339Zm7.b(strC, eVar, g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : C4049Dl7.b.a(), (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ ZJ1 a;

            b(ZJ1 zj1) {
                this.a = zj1;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(eVar, "descriptionModifier");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                ZJ1 zj1 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                M66 m66 = M66.a;
                String strE = zj1.e();
                G10 g10 = G10.a;
                int i3 = G10.b;
                AbstractC9339Zm7.b(strE, null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, 0, 0, 65530);
                AbstractC9339Zm7.b(" | " + UY6.c(QD5.this_device_time_title, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, 0, 0, 65530);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        static final class c implements InterfaceC15796kB2 {
            final /* synthetic */ ZJ1 a;

            c(ZJ1 zj1) {
                this.a = zj1;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(eVar, "leadingModifier");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                ZJ1 zj1 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
                AbstractC24077y03.b(FV4.c(YK1.p(zj1), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(eVar, C17784nZ1.q(24)), G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 48, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(ZJ1 zj1) {
            this.a = zj1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC9459a00.c(null, UY6.c(QD5.this_device_title, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(610170733);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.XK1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return YK1.a.c((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.h(AbstractC19242q11.e(1031209765, true, new C0788a(this.a), interfaceC22053ub1, 54), AbstractC6919Pn6.c(aVar, true, (UA2) objB), null, AbstractC19242q11.e(2064899842, true, new b(this.a), interfaceC22053ub1, 54), AbstractC19242q11.e(-1885504095, true, new c(this.a), interfaceC22053ub1, 54), null, null, null, null, interfaceC22053ub1, 27654, 484);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ QJ1 a;

        b(QJ1 qj1) {
            this.a = qj1;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC9459a00.c(null, UY6.c(QD5.other_device_title, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
            String strC = UY6.c(QD5.terminate_all, interfaceC22053ub1, 0);
            int i2 = AbstractC21822uB5.log_out;
            SA2 sa2A = this.a.a();
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC16797ls7.i(strC, i2, null, null, null, null, new C11984ds7(g10.a(interfaceC22053ub1, i3).r(), g10.a(interfaceC22053ub1, i3).t(), g10.a(interfaceC22053ub1, i3).t(), g10.a(interfaceC22053ub1, i3).t(), null), sa2A, null, false, interfaceC22053ub1, C11984ds7.f << 18, 828);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ ZJ1 a;

        c(ZJ1 zj1) {
            this.a = zj1;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "textModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = this.a.c();
            G10 g10 = G10.a;
            int i3 = G10.b;
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i3).a();
            AbstractC9339Zm7.b(strC, eVar, g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : C4049Dl7.b.a(), (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ ZJ1 a;
        final /* synthetic */ Context b;

        d(ZJ1 zj1, Context context) {
            this.a = zj1;
            this.b = context;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "descriptionModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            ZJ1 zj1 = this.a;
            Context context = this.b;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            String strE = zj1.e();
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strE, null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, 0, 0, 65530);
            AbstractC9339Zm7.b(" | " + YK1.r(zj1.d(), context), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).d(), interfaceC22053ub1, 0, 0, 65530);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ ZJ1 a;

        e(ZJ1 zj1) {
            this.a = zj1;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "leadingModifier");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            ZJ1 zj1 = this.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
            AbstractC24077y03.b(FV4.c(YK1.p(zj1), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(eVar, C17784nZ1.q(24)), G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class f implements SA2 {
        final /* synthetic */ QJ1 a;
        final /* synthetic */ ZJ1 b;

        f(QJ1 qj1, ZJ1 zj1) {
            this.a = qj1;
            this.b = zj1;
        }

        public final void a() {
            this.a.b().invoke(Integer.valueOf(this.b.b()));
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(UA2 ua2, List list) {
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

    public static final class i extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ QJ1 f;
        final /* synthetic */ Context g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list, QJ1 qj1, Context context) {
            super(4);
            this.e = list;
            this.f = qj1;
            this.g = context;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
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
            ZJ1 zj1 = (ZJ1) this.e.get(i);
            interfaceC22053ub1.W(-1480117680);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1592216835, true, new c(zj1), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(563565408, true, new d(zj1, this.g), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E3 = AbstractC19242q11.e(220681599, true, new e(zj1), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-1433165261);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(zj1);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new f(this.f, zj1);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.h(interfaceC18060o11E, null, null, interfaceC18060o11E2, interfaceC18060o11E3, null, null, (SA2) objB, null, interfaceC22053ub1, 27654, 358);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
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

    static final class j implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        j(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.settings_devices_title, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class k implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        k(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, L41.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class l implements InterfaceC15796kB2 {
        final /* synthetic */ ZF6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C23675xK1 c;
        final /* synthetic */ QJ1 d;
        final /* synthetic */ C19391qG6 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ZF6 c;
            final /* synthetic */ C19391qG6 d;
            final /* synthetic */ Resources e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ZF6 zf6, C19391qG6 c19391qG6, Resources resources, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = zf6;
                this.d = c19391qG6;
                this.e = resources;
                this.f = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(SA2 sa2) {
                sa2.invoke();
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    ZF6 zf6 = this.c;
                    if (zf6 != null) {
                        C19391qG6 c19391qG6 = this.d;
                        Resources resources = this.e;
                        final SA2 sa2 = this.f;
                        AbstractC13042fc3.f(resources);
                        SA2 sa22 = new SA2() { // from class: ir.nasim.ZK1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return YK1.l.a.y(sa2);
                            }
                        };
                        this.b = 1;
                        if (YK1.q(c19391qG6, zf6, resources, sa22, this) == objE) {
                            return objE;
                        }
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(ZF6 zf6, SA2 sa2, C23675xK1 c23675xK1, QJ1 qj1, C19391qG6 c19391qG6) {
            this.a = zf6;
            this.b = sa2;
            this.c = c23675xK1;
            this.d = qj1;
            this.e = c19391qG6;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 ??, still in use, count: 1, list:
              (r3v6 ?? I:java.lang.Object) from 0x006f: INVOKE (r16v0 ?? I:ir.nasim.ub1), (r3v6 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:112)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final void a(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 ??, still in use, count: 1, list:
              (r3v6 ?? I:java.lang.Object) from 0x006f: INVOKE (r16v0 ?? I:ir.nasim.ub1), (r3v6 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:112)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class m implements InterfaceC14603iB2 {
        final /* synthetic */ List a;
        final /* synthetic */ n b;

        m(List list, n nVar) {
            this.a = list;
            this.b = nVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f() {
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C23675xK1 c23675xK1 = new C23675xK1(false, this.a);
            interfaceC22053ub1.W(1567551324);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.aL1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return YK1.m.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            n nVar = this.b;
            interfaceC22053ub1.W(1567552508);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.bL1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return YK1.m.f();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            YK1.h(sa2, nVar, c23675xK1, null, (SA2) objB2, interfaceC22053ub1, 27654);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class n implements QJ1 {
        private final SA2 a = new SA2() { // from class: ir.nasim.cL1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return YK1.n.g();
            }
        };
        private final UA2 b = new UA2() { // from class: ir.nasim.dL1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return YK1.n.h(((Integer) obj).intValue());
            }
        };
        private final UA2 c = new UA2() { // from class: ir.nasim.eL1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return YK1.n.i(((Integer) obj).intValue());
            }
        };

        n() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(int i) {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(int i) {
            return C19938rB7.a;
        }

        @Override // ir.nasim.QJ1
        public SA2 a() {
            return this.a;
        }

        @Override // ir.nasim.QJ1
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.QJ1
        public UA2 c() {
            return this.c;
        }
    }

    static final class o extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return YK1.q(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final ir.nasim.C23675xK1 r19, final ir.nasim.QJ1 r20, androidx.compose.ui.e r21, ir.nasim.InterfaceC22053ub1 r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YK1.e(ir.nasim.xK1, ir.nasim.QJ1, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(ZJ1 zj1, List list, QJ1 qj1, Context context, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$otherDevices");
        AbstractC13042fc3.i(qj1, "$deviceAction");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        if (zj1 != null) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1479254884, true, new a(zj1)), 3, null);
        }
        if (!list.isEmpty()) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1535513588, true, new b(qj1)), 3, null);
            interfaceC15069ix3.a(list.size(), null, new h(g.e, list), AbstractC19242q11.c(-632812321, true, new i(list, qj1, context)));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C23675xK1 c23675xK1, QJ1 qj1, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c23675xK1, "$deviceState");
        AbstractC13042fc3.i(qj1, "$deviceAction");
        e(c23675xK1, qj1, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void h(final SA2 sa2, final QJ1 qj1, final C23675xK1 c23675xK1, final ZF6 zf6, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(qj1, "deviceAction");
        AbstractC13042fc3.i(c23675xK1, "deviceState");
        AbstractC13042fc3.i(sa22, "resetSnackBarState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(452960266);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(qj1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(c23675xK1) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(zf6) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-673033331);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-105599546, true, new j(sa2), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(403179268, true, new k(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1286894629, true, new l(zf6, sa22, c23675xK1, qj1, c19391qG6), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805309494, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.UK1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return YK1.i(sa2, qj1, c23675xK1, zf6, sa22, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(SA2 sa2, QJ1 qj1, C23675xK1 c23675xK1, ZF6 zf6, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(qj1, "$deviceAction");
        AbstractC13042fc3.i(c23675xK1, "$deviceState");
        AbstractC13042fc3.i(sa22, "$resetSnackBarState");
        h(sa2, qj1, c23675xK1, zf6, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void j(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1136159005);
        if (i2 == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(986562306, true, new m(AbstractC11342cq6.K(new C17649nK1().a()), new n()), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.TK1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return YK1.k(i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        j(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final /* synthetic */ void l(C23675xK1 c23675xK1, QJ1 qj1, androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        e(c23675xK1, qj1, eVar, interfaceC22053ub1, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(ZJ1 zj1) {
        return zj1.a() == 1 ? AbstractC21822uB5.mobile : AbstractC21822uB5.monitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(ir.nasim.C19391qG6 r9, ir.nasim.ZF6 r10, android.content.res.Resources r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) throws android.content.res.Resources.NotFoundException {
        /*
            boolean r0 = r13 instanceof ir.nasim.YK1.o
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.YK1$o r0 = (ir.nasim.YK1.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.YK1$o r0 = new ir.nasim.YK1$o
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L52
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            java.lang.String r10 = ir.nasim.AbstractC11593dG6.a(r10, r11)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L52
            return r0
        L52:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YK1.q(ir.nasim.qG6, ir.nasim.ZF6, android.content.res.Resources, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r(long j2, Context context) {
        return C14593iA1.k(context, j2, false);
    }
}
