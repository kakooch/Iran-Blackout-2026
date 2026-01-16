package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC8628Wu;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Wu, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8628Wu {

    /* renamed from: ir.nasim.Wu$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ List b;
        final /* synthetic */ UA2 c;

        /* renamed from: ir.nasim.Wu$a$a, reason: collision with other inner class name */
        static final class C0738a implements InterfaceC16978mB2 {
            final /* synthetic */ List a;
            final /* synthetic */ UA2 b;

            C0738a(List list, UA2 ua2) {
                this.a = list;
                this.b = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2, C11458d25 c11458d25) {
                AbstractC13042fc3.i(ua2, "$onGroupClicked");
                AbstractC13042fc3.i(c11458d25, "it");
                ua2.invoke(c11458d25);
                return C19938rB7.a;
            }

            public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 48) == 0) {
                    i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C14697iL2 c14697iL2 = (C14697iL2) this.a.get(i);
                if (c14697iL2 == null) {
                    return;
                }
                final UA2 ua2 = this.b;
                interfaceC22053ub1.W(786512527);
                boolean zV = interfaceC22053ub1.V(ua2);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Vu
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC8628Wu.a.C0738a.c(ua2, (C11458d25) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC8628Wu.h(null, c14697iL2, (UA2) objB, interfaceC22053ub1, 0, 1);
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, List list, UA2 ua2) {
            this.a = sa2;
            this.b = list;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$groups");
            AbstractC13042fc3.i(ua2, "$onGroupClicked");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), null, null, AbstractC19242q11.c(-846235222, true, new C0738a(list, ua2)), 6, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1, G10.b).w(), null, 2, null);
            SA2 sa2 = this.a;
            final List list = this.b;
            final UA2 ua2 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC21639ts7.i(UY6.c(DD5.common_groups, interfaceC22053ub1, 0), null, sa2, null, null, null, null, interfaceC22053ub1, 0, 122);
            interfaceC22053ub1.W(442096870);
            boolean zD = interfaceC22053ub1.D(list) | interfaceC22053ub1.V(ua2);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Uu
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8628Wu.a.c(list, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 511);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(androidx.compose.ui.e eVar, SA2 sa2, final List list, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        final SA2 sa22;
        int i3;
        SA2 sa23;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(list, "groups");
        AbstractC13042fc3.i(ua2, "onGroupClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(597936987);
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 = i | 48;
            sa22 = sa2;
        } else if ((i & 48) == 0) {
            sa22 = sa2;
            i3 = (interfaceC22053ub1J.D(sa2) ? 32 : 16) | i;
        } else {
            sa22 = sa2;
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(list) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i3 & 1169) == 1168 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            androidx.compose.ui.e eVar3 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            if (i4 != 0) {
                interfaceC22053ub1J.W(1684002029);
                Object objB = interfaceC22053ub1J.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Su
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8628Wu.f();
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                sa23 = (SA2) objB;
                interfaceC22053ub1J.Q();
            } else {
                sa23 = sa22;
            }
            M10.f(false, AbstractC19242q11.e(-1372622570, true, new a(sa23, list, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
            sa22 = sa23;
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tu
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8628Wu.g(eVar2, sa22, list, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(androidx.compose.ui.e eVar, SA2 sa2, List list, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$groups");
        AbstractC13042fc3.i(ua2, "$onGroupClicked");
        e(eVar, sa2, list, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void h(androidx.compose.ui.e eVar, final C14697iL2 c14697iL2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2064523078);
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = (interfaceC22053ub1J.D(c14697iL2) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        int i4 = i3;
        if ((i4 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            androidx.compose.ui.e eVar3 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c14697iL2.h0(), null, false, 0, interfaceC22053ub1J, 0, 14);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1J.W(-2145731384);
            boolean zD = ((i4 & 896) == 256) | interfaceC22053ub1J.D(c14697iL2);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Qu
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8628Wu.j(ua2, c14697iL2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.e eVarC = c24254yJ.c();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarC, aVar2.l(), interfaceC22053ub1J, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            float fQ = C17784nZ1.q(50);
            UU uu = new UU(false, null, null, null, c14697iL2.G0(), 0, false, WKSRecord.Service.SUNRPC, null);
            G10 g10 = G10.a;
            int i5 = G10.b;
            TU.m(ev4H, uu, androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, i5).b().c()), fQ, 0.0f, 0.0f, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1J, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1J, i5).b().c(), 0.0f, 0.0f, 13, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.c(), aVar2.l(), interfaceC22053ub1J, 6);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
            SA2 sa2A3 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            AbstractC24077y03.a(XQ7.b(C12700f33.k, AbstractC15208jB5.ic_contact_group, interfaceC22053ub1J, 6), "", null, g10.a(interfaceC22053ub1J, i5).F(), interfaceC22053ub1J, 48, 4);
            String strG0 = c14697iL2.G0();
            AbstractC13042fc3.h(strG0, "getTitle(...)");
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1J, i5).l();
            AbstractC9339Zm7.b(strG0, androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(4), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : g10.a(interfaceC22053ub1J, i5).F(), (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1J, 48, 0, 65532);
            interfaceC22053ub1J.u();
            InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar2.l(), interfaceC22053ub1J, 0);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            SA2 sa2A4 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A4);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B3, aVar3.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
            String str = XY6.v(String.valueOf(c14697iL2.t0())) + UY6.c(DD5.member, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1J, i5).c();
            AbstractC9339Zm7.b(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : g10.a(interfaceC22053ub1J, i5).z(), (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1J, 0, 0, 65534);
            String strV0 = c14697iL2.v0();
            interfaceC22053ub1J.W(1779900319);
            if (strV0 != null) {
                interfaceC22053ub1J.W(1779901107);
                if (strV0.length() > 0) {
                    C9348Zn7 c9348Zn7C2 = g10.d(interfaceC22053ub1J, i5).c();
                    AbstractC9339Zm7.b(" | " + strV0, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C2.b((16744447 & 1) != 0 ? c9348Zn7C2.a.g() : g10.a(interfaceC22053ub1J, i5).z(), (16744447 & 2) != 0 ? c9348Zn7C2.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C2.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C2.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C2.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C2.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C2.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C2.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C2.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C2.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C2.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C2.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C2.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C2.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C2.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C2.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7C2.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C2.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C2.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C2.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C2.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C2.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C2.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C2.b.k() : null), interfaceC22053ub1J, 0, 0, 65534);
                }
                interfaceC22053ub1J.Q();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(12)), interfaceC22053ub1J, 6);
            AbstractC9758aW1.a(null, 0L, 0.0f, 0.0f, interfaceC22053ub1J, 0, 15);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ru
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8628Wu.i(eVar2, c14697iL2, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(androidx.compose.ui.e eVar, C14697iL2 c14697iL2, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(ua2, "$onClick");
        h(eVar, c14697iL2, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(UA2 ua2, C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(c14697iL2, "$group");
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        ua2.invoke(c11458d25I0);
        return C19938rB7.a;
    }
}
