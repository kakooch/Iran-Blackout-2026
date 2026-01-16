package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC12129e53;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13356g53;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC7975Tz3;
import ir.nasim.S43;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class S43 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ String b;
        final /* synthetic */ List c;

        /* renamed from: ir.nasim.S43$a$a, reason: collision with other inner class name */
        static final class C0609a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C0609a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String str;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C24254yJ c24254yJ = C24254yJ.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i2).b().e());
                InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
                String str2 = this.a;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, bVarG, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.change_log, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(72)), null, null, 0.0f, null, interfaceC22053ub1, 432, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                String strC = UY6.c(UD5.new_version_changes, interfaceC22053ub1, 0);
                if (str2 == null || AbstractC20762sZ6.n0(str2)) {
                    str = "";
                } else {
                    str = " (" + str2 + Separators.RPAREN;
                }
                AbstractC9339Zm7.b(strC + str, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65018);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ List a;

            /* renamed from: ir.nasim.S43$a$b$a, reason: collision with other inner class name */
            public static final class C0610a extends AbstractC8614Ws3 implements UA2 {
                public static final C0610a e = new C0610a();

                public C0610a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.S43$a$b$b, reason: collision with other inner class name */
            public static final class C0611b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0611b(UA2 ua2, List list) {
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

            public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(List list) {
                    super(4);
                    this.e = list;
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
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, 1 & i3)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    String str = (String) this.e.get(i);
                    interfaceC22053ub1.W(-1083766353);
                    C24254yJ c24254yJ = C24254yJ.a;
                    G10 g10 = G10.a;
                    int i4 = G10.b;
                    C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i4).b().u());
                    InterfaceC12529em.c cVarL = InterfaceC12529em.a.l();
                    e.a aVar = androidx.compose.ui.e.a;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarL, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                    InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar2.a();
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    M66 m66 = M66.a;
                    AbstractC9339Zm7.b("•", null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 6, 0, 65530);
                    AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 0, 0, 65530);
                    interfaceC22053ub1.u();
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

            b(List list) {
                this.a = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(list, "$changes");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                interfaceC15069ix3.a(list.size(), null, new C0611b(C0610a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                int i2 = ((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenHeightDp;
                final List list = this.a;
                if (list == null) {
                    return;
                }
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q((float) (i2 / 2.5d)), 1, null);
                C24254yJ.f fVarO = C24254yJ.a.o(G10.a.c(interfaceC22053ub1, G10.b).b().u());
                interfaceC22053ub1.W(-1749610952);
                boolean zD = interfaceC22053ub1.D(list);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.T43
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return S43.a.b.c(list, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 494);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC9102Ym4 interfaceC9102Ym4, String str, List list) {
            this.a = interfaceC9102Ym4;
            this.b = str;
            this.c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            interfaceC9102Ym4.setValue(Boolean.FALSE);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(216195084, true, new C0609a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1779107638, true, new b(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
            interfaceC22053ub1.W(400165422);
            boolean zV = interfaceC22053ub1.V(this.a);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.R43
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S43.a.c(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC18060o11E, cVar, interfaceC18060o11E2, bVar, null, null, (SA2) objB, UD5.dialog_positive_button_i_got_it, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.b.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String str;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C24254yJ c24254yJ = C24254yJ.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i2).b().e());
                InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
                String str2 = this.a;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, bVarG, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.change_log, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(72)), null, null, 0.0f, null, interfaceC22053ub1, 432, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                String strC = UY6.c(UD5.new_version_changes, interfaceC22053ub1, 0);
                if (str2 == null || AbstractC20762sZ6.n0(str2)) {
                    str = "";
                } else {
                    str = " (" + str2 + Separators.RPAREN;
                }
                AbstractC9339Zm7.b(strC + str, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65018);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.S43$b$b, reason: collision with other inner class name */
        static final class C0612b implements InterfaceC14603iB2 {
            final /* synthetic */ List a;

            /* renamed from: ir.nasim.S43$b$b$a */
            public static final class a extends AbstractC8614Ws3 implements UA2 {
                public static final a e = new a();

                public a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.S43$b$b$b, reason: collision with other inner class name */
            public static final class C0613b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0613b(UA2 ua2, List list) {
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

            /* renamed from: ir.nasim.S43$b$b$c */
            public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(List list) {
                    super(4);
                    this.e = list;
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
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, 1 & i3)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    String str = (String) this.e.get(i);
                    interfaceC22053ub1.W(566669202);
                    C24254yJ c24254yJ = C24254yJ.a;
                    G10 g10 = G10.a;
                    int i4 = G10.b;
                    C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i4).b().u());
                    InterfaceC12529em.c cVarL = InterfaceC12529em.a.l();
                    e.a aVar = androidx.compose.ui.e.a;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarL, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                    InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar2.a();
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    M66 m66 = M66.a;
                    AbstractC9339Zm7.b("•", null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 6, 0, 65530);
                    AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 0, 0, 65530);
                    interfaceC22053ub1.u();
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

            C0612b(List list) {
                this.a = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(list, "$changes");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                interfaceC15069ix3.a(list.size(), null, new C0613b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                int i2 = ((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenHeightDp;
                final List list = this.a;
                if (list == null) {
                    return;
                }
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q((float) (i2 / 2.5d)), 1, null);
                C24254yJ.f fVarO = C24254yJ.a.o(G10.a.c(interfaceC22053ub1, G10.b).b().u());
                interfaceC22053ub1.W(-1415816587);
                boolean zD = interfaceC22053ub1.D(list);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.W43
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return S43.b.C0612b.c(list, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 494);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, String str, List list) {
            this.a = interfaceC9102Ym4;
            this.b = sa2;
            this.c = str;
            this.d = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            interfaceC9102Ym4.setValue(Boolean.FALSE);
            if (sa2 != null) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            interfaceC9102Ym4.setValue(Boolean.FALSE);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            int i2 = UD5.update_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i3 = UD5.dialog_negative_button_cancel;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(152155576, true, new a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(397963450, true, new C0612b(this.d), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(1755106479);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            final SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.U43
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S43.b.d(interfaceC9102Ym4, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1755110763);
            boolean zV2 = interfaceC22053ub1.V(this.a);
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.V43
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S43.b.f(interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, bVar, aVar, sa22, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ float b;
        final /* synthetic */ AbstractC12129e53.c.a c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ float a;
            final /* synthetic */ AbstractC12129e53.c.a b;
            final /* synthetic */ UA2 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* renamed from: ir.nasim.S43$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0614a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[AbstractC12129e53.c.a.values().length];
                    try {
                        iArr[AbstractC12129e53.c.a.a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AbstractC12129e53.c.a.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AbstractC12129e53.c.a.c.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            a(float f, AbstractC12129e53.c.a aVar, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = f;
                this.b = aVar;
                this.c = ua2;
                this.d = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2, InterfaceC7975Tz3 interfaceC7975Tz3) {
                Object obj;
                AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
                AbstractC13042fc3.i(interfaceC7975Tz3, "linearProgressState");
                if (interfaceC7975Tz3 instanceof InterfaceC7975Tz3.a) {
                    obj = InterfaceC13356g53.e.a;
                } else {
                    if (!(interfaceC7975Tz3 instanceof InterfaceC7975Tz3.b) && !(interfaceC7975Tz3 instanceof InterfaceC7975Tz3.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = InterfaceC13356g53.f.a;
                }
                ua2.invoke(obj);
                return C19938rB7.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                InterfaceC7975Tz3 aVar;
                AbstractC13042fc3.i(eVar, "descriptionModifier");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                float f = this.a;
                String strH = S43.H(this.d);
                int i2 = C0614a.a[this.b.ordinal()];
                int i3 = 0;
                int i4 = 3;
                InterfaceC14603iB2 interfaceC14603iB2 = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                Object[] objArr4 = 0;
                Object[] objArr5 = 0;
                if (i2 == 1) {
                    aVar = new InterfaceC7975Tz3.a(objArr2 == true ? 1 : 0, i3, i4, objArr == true ? 1 : 0);
                } else if (i2 == 2) {
                    aVar = new InterfaceC7975Tz3.b(objArr4 == true ? 1 : 0, i3, i4, objArr3 == true ? 1 : 0);
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    aVar = new InterfaceC7975Tz3.c(interfaceC14603iB2, i3, i4, objArr5 == true ? 1 : 0);
                }
                InterfaceC7975Tz3 interfaceC7975Tz3 = aVar;
                interfaceC22053ub1.W(1346439756);
                boolean zV = interfaceC22053ub1.V(this.c);
                final UA2 ua2 = this.c;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.X43
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return S43.c.a.c(ua2, (InterfaceC7975Tz3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC7502Rz3.d(eVar, f, strH, interfaceC7975Tz3, (UA2) objB, interfaceC22053ub1, i & 14, 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ InterfaceC9102Ym4 b;

            b(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = ua2;
                this.b = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
                AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
                interfaceC9102Ym4.setValue(Boolean.TRUE);
                ua2.invoke(InterfaceC13356g53.a.a);
                return C19938rB7.a;
            }

            public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(eVar, "it");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                int i3 = G10.b;
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(eVar, g10.c(interfaceC22053ub1, i3).b().b(), 0.0f, 2, null);
                B26 b26J = B26.j(B26.b.a());
                interfaceC22053ub1.W(1346464208);
                boolean zV = interfaceC22053ub1.V(this.a);
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                final UA2 ua2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Y43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.c.b.c(interfaceC9102Ym4, ua2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC9339Zm7.b(UY6.c(UD5.change_log, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarK, false, null, b26J, (SA2) objB, 3, null), g10.a(interfaceC22053ub1, i3).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).p(), interfaceC22053ub1, 0, 0, 65528);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        c(androidx.compose.ui.e eVar, float f, AbstractC12129e53.c.a aVar, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = eVar;
            this.b = f;
            this.c = aVar;
            this.d = ua2;
            this.e = interfaceC9664aL6;
            this.f = interfaceC9102Ym4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i2 = G10.b;
            TS4 ts4D = androidx.compose.foundation.layout.q.d(g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().e(), g10.c(interfaceC22053ub1, i2).b().r(), g10.c(interfaceC22053ub1, i2).b().e());
            X51 x51 = X51.a;
            AbstractC16797ls7.h(x51.c(), this.a, ts4D, AbstractC19242q11.e(2038097822, true, new a(this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), x51.d(), AbstractC19242q11.e(1164432220, true, new b(this.d, this.f), interfaceC22053ub1, 54), null, null, null, interfaceC22053ub1, 224262, 448);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ String g;

        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ String b;
            final /* synthetic */ long c;
            final /* synthetic */ InterfaceC9102Ym4 d;

            a(SA2 sa2, String str, long j, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = sa2;
                this.b = str;
                this.c = j;
                this.d = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
                if (sa2 != null) {
                    sa2.invoke();
                }
                interfaceC9102Ym4.setValue(Boolean.TRUE);
                return C19938rB7.a;
            }

            public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                androidx.compose.ui.e eVarD;
                AbstractC13042fc3.i(eVar, "it");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-547928109);
                G10 g10 = G10.a;
                int i3 = G10.b;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVar, g10.c(interfaceC22053ub1, i3).b().n());
                final SA2 sa2 = this.a;
                boolean z = sa2 != null;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
                if (z) {
                    interfaceC22053ub1.W(-565844527);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB == aVar.a()) {
                        objB = AbstractC23831xb3.a();
                        interfaceC22053ub1.s(objB);
                    }
                    InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-565842143);
                    boolean zV = interfaceC22053ub1.V(sa2);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == aVar.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.Z43
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return S43.d.a.c(sa2, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    eVarD = androidx.compose.foundation.e.d(eVarI, interfaceC18507om4, null, false, null, null, (SA2) objB2, 28, null);
                } else {
                    eVarD = eVarI;
                }
                interfaceC22053ub1.Q();
                AbstractC9339Zm7.b(this.b, eVarD, this.c, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).c(), interfaceC22053ub1, 0, 0, 65528);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC15796kB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ String b;

            b(SA2 sa2, String str) {
                this.a = sa2;
                this.b = str;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(eVar, "it");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC17932no0.Q(this.a, InterfaceC19114po0.b.a.a, this.b, androidx.compose.foundation.layout.t.G(androidx.compose.foundation.layout.q.k(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().b(), 0.0f, 2, null), null, true, 1, null), null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 3, 16);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        d(androidx.compose.ui.e eVar, SA2 sa2, String str, long j, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa22, String str2) {
            this.a = eVar;
            this.b = sa2;
            this.c = str;
            this.d = j;
            this.e = interfaceC9102Ym4;
            this.f = sa22;
            this.g = str2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i2 = G10.b;
            TS4 ts4D = androidx.compose.foundation.layout.q.d(g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().e(), g10.c(interfaceC22053ub1, i2).b().r(), g10.c(interfaceC22053ub1, i2).b().e());
            X51 x51 = X51.a;
            AbstractC16797ls7.h(x51.a(), this.a, ts4D, AbstractC19242q11.e(954607081, true, new a(this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), x51.b(), AbstractC19242q11.e(-1486850709, true, new b(this.f, this.g), interfaceC22053ub1, 54), null, null, null, interfaceC22053ub1, 224262, 448);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC12129e53.c.a.values().length];
            try {
                iArr[AbstractC12129e53.c.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC12129e53.c.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC12129e53.c.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.g.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.a.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.g.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.d.a);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0139  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void E(androidx.compose.ui.e r28, java.lang.String r29, java.util.List r30, final float r31, final int r32, final ir.nasim.AbstractC12129e53.c.a r33, final ir.nasim.UA2 r34, ir.nasim.InterfaceC22053ub1 r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S43.E(androidx.compose.ui.e, java.lang.String, java.util.List, float, int, ir.nasim.e53$c$a, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.g.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String G(int i, float f) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        float f2 = i;
        return aVar.o((f * f2) / 1024.0f) + " / " + aVar.o(f2 / 1024.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(androidx.compose.ui.e eVar, String str, List list, float f, int i, AbstractC12129e53.c.a aVar, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(aVar, "$mode");
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        E(eVar, str, list, f, i, aVar, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void J(androidx.compose.ui.e r32, final java.lang.String r33, final ir.nasim.SA2 r34, final java.lang.String r35, final long r36, java.lang.String r38, java.util.List r39, ir.nasim.SA2 r40, ir.nasim.SA2 r41, ir.nasim.InterfaceC22053ub1 r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S43.J(androidx.compose.ui.e, java.lang.String, ir.nasim.SA2, java.lang.String, long, java.lang.String, java.util.List, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    public static final void K(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1311517137);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, X51.a.f(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.B43
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return S43.L(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        K(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(androidx.compose.ui.e eVar, String str, SA2 sa2, String str2, long j, String str3, List list, SA2 sa22, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$buttonText");
        AbstractC13042fc3.i(sa2, "$onClickButton");
        AbstractC13042fc3.i(str2, "$descriptionText");
        J(eVar, str, sa2, str2, j, str3, list, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void q(final ir.nasim.InterfaceC9102Ym4 r13, java.lang.String r14, java.util.List r15, ir.nasim.InterfaceC22053ub1 r16, final int r17, final int r18) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S43.q(ir.nasim.Ym4, java.lang.String, java.util.List, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(InterfaceC9102Ym4 interfaceC9102Ym4, String str, List list, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        q(interfaceC9102Ym4, str, list, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void t(final ir.nasim.InterfaceC9102Ym4 r14, java.lang.String r15, java.util.List r16, ir.nasim.SA2 r17, ir.nasim.InterfaceC22053ub1 r18, final int r19, final int r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S43.t(ir.nasim.Ym4, java.lang.String, java.util.List, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(InterfaceC9102Ym4 interfaceC9102Ym4, String str, List list, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        t(interfaceC9102Ym4, str, list, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void w(androidx.compose.ui.e eVar, final AbstractC12129e53 abstractC12129e53, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        boolean z;
        AbstractC13042fc3.i(abstractC12129e53, "inAppUpdateState");
        AbstractC13042fc3.i(ua2, "handleInAppUpdateUiAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(992849122);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(abstractC12129e53) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            if (AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.d.b) || AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.f.b) || AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.b.b)) {
                interfaceC22053ub1J.W(452028836);
                interfaceC22053ub1J.Q();
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Q43
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return S43.x(eVar3, abstractC12129e53, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if (abstractC12129e53 instanceof AbstractC12129e53.a) {
                interfaceC22053ub1J.W(452110242);
                String strC = UY6.c(UD5.update_button, interfaceC22053ub1J, 0);
                AbstractC12129e53.a aVar = (AbstractC12129e53.a) abstractC12129e53;
                String strB = aVar.b();
                List listA = aVar.a();
                String strC2 = UY6.c(UD5.view_change_log, interfaceC22053ub1J, 0);
                long jI = G10.a.a(interfaceC22053ub1J, G10.b).I();
                interfaceC22053ub1J.W(-1370884783);
                int i5 = i3 & 896;
                boolean z2 = i5 == 256;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.C43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.A(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-1370873447);
                boolean z3 = i5 == 256;
                Object objB2 = interfaceC22053ub1J.B();
                if (z3 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.D43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.B(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                SA2 sa22 = (SA2) objB2;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-1370870287);
                z = i5 == 256;
                Object objB3 = interfaceC22053ub1J.B();
                if (z || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.E43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.C(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                interfaceC22053ub1J.Q();
                J(eVar3, strC, sa2, strC2, jI, strB, listA, sa22, (SA2) objB3, interfaceC22053ub1J, i3 & 14, 0);
                interfaceC22053ub1J.Q();
            } else if (abstractC12129e53 instanceof AbstractC12129e53.c) {
                interfaceC22053ub1J.W(452832976);
                AbstractC12129e53.c cVar = (AbstractC12129e53.c) abstractC12129e53;
                E(eVar3, cVar.g(), cVar.c(), cVar.f(), cVar.d(), cVar.e(), ua2, interfaceC22053ub1J, (i3 & 14) | ((i3 << 12) & 3670016), 0);
                interfaceC22053ub1J.Q();
            } else {
                if (!(abstractC12129e53 instanceof AbstractC12129e53.e)) {
                    interfaceC22053ub1J.W(-1370893509);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(-1370850704);
                String strC3 = UY6.c(UD5.install_button, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.W(-1370846126);
                int i6 = i3 & 896;
                boolean z4 = i6 == 256;
                Object objB4 = interfaceC22053ub1J.B();
                if (z4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.F43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.D(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                SA2 sa23 = (SA2) objB4;
                interfaceC22053ub1J.Q();
                String strC4 = UY6.c(UD5.install_description, interfaceC22053ub1J, 0);
                long jI2 = G10.a.a(interfaceC22053ub1J, G10.b).I();
                interfaceC22053ub1J.W(-1370838319);
                z = i6 == 256;
                Object objB5 = interfaceC22053ub1J.B();
                if (z || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.G43
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S43.y(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB5);
                }
                interfaceC22053ub1J.Q();
                J(eVar3, strC3, sa23, strC4, jI2, null, null, null, (SA2) objB5, interfaceC22053ub1J, i3 & 14, 224);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.H43
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return S43.z(eVar3, abstractC12129e53, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(androidx.compose.ui.e eVar, AbstractC12129e53 abstractC12129e53, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC12129e53, "$inAppUpdateState");
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        w(eVar, abstractC12129e53, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        ua2.invoke(InterfaceC13356g53.g.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(androidx.compose.ui.e eVar, AbstractC12129e53 abstractC12129e53, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC12129e53, "$inAppUpdateState");
        AbstractC13042fc3.i(ua2, "$handleInAppUpdateUiAction");
        w(eVar, abstractC12129e53, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
