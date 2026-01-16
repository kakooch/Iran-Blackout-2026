package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Ms7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC6232Ms7 {

    /* renamed from: ir.nasim.Ms7$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ InterfaceC14603iB2 b;
        final /* synthetic */ InterfaceC14603iB2 c;
        final /* synthetic */ String d;

        a(List list, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, String str) {
            this.a = list;
            this.b = interfaceC14603iB2;
            this.c = interfaceC14603iB22;
            this.d = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C4346Es7 c4346Es7 = (C4346Es7) this.a.get(i);
                AbstractC6232Ms7.g(null, c4346Es7.a(), c4346Es7.d(), c4346Es7, i, this.b, this.c, this.d, interfaceC22053ub1, (i2 << 9) & 57344, 1);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void g(androidx.compose.ui.e eVar, final Avatar avatar, final String str, final C4346Es7 c4346Es7, final int i, final InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC14603iB2 interfaceC14603iB22, final String str2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub12;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(str, "username");
        AbstractC13042fc3.i(c4346Es7, "topPeer");
        AbstractC13042fc3.i(interfaceC14603iB2, "onPeerClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "onPeerLongClick");
        AbstractC13042fc3.i(str2, "specialPrefixes");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1084776950);
        if ((i3 & 2) != 0) {
            i4 = i2 | 48;
        } else if ((i2 & 48) == 0) {
            i4 = (interfaceC22053ub1J.V(avatar) ? 32 : 16) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(c4346Es7) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 131072 : 65536;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 1048576 : 524288;
        }
        if ((599185 & i4) == 599184 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar3 = (i3 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(avatar, null, false, 0, interfaceC22053ub1J, (i4 >> 3) & 14, 14);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(72)), C17784nZ1.q(92));
            interfaceC22053ub1J.W(-1213767268);
            int i5 = i4 & 7168;
            int i6 = i4 & 57344;
            boolean z = ((3670016 & i4) == 1048576) | (i5 == 2048) | (i6 == 16384);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Js7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6232Ms7.h(interfaceC14603iB22, c4346Es7, i);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1213770440);
            boolean z2 = ((458752 & i4) == 131072) | (i5 == 2048) | (i6 == 16384);
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Ks7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6232Ms7.i(interfaceC14603iB2, c4346Es7, i);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI2 = androidx.compose.foundation.e.i(eVarI, (WKSRecord.Service.SUNRPC & 1) != 0, (WKSRecord.Service.SUNRPC & 2) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 16) != 0 ? null : sa2, (WKSRecord.Service.SUNRPC & 32) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 64) != 0, (SA2) objB2);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI2);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            int i7 = i4;
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            float fQ = C17784nZ1.q(50);
            UU uu = new UU(false, null, null, null, str, 0, false, WKSRecord.Service.SUNRPC, null);
            G10 g10 = G10.a;
            int i8 = G10.b;
            TU.m(ev4H, uu, androidx.compose.foundation.layout.q.l(aVar, g10.c(interfaceC22053ub1J, i8).b().n(), g10.c(interfaceC22053ub1J, i8).b().b(), g10.c(interfaceC22053ub1J, i8).b().n(), g10.c(interfaceC22053ub1J, i8).b().n()), fQ, 0.0f, 0.0f, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9105Ym7.b(str, androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(64)), 0.0f, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i8).b().u(), 7, null), g10.a(interfaceC22053ub1J, i8).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, g10.d(interfaceC22053ub1J, i8).f(), interfaceC22053ub12, (i7 >> 6) & 14, 3120, 54776);
            interfaceC22053ub12.u();
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ls7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6232Ms7.j(eVar2, avatar, str, c4346Es7, i, interfaceC14603iB2, interfaceC14603iB22, str2, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(InterfaceC14603iB2 interfaceC14603iB2, C4346Es7 c4346Es7, int i) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onPeerLongClick");
        AbstractC13042fc3.i(c4346Es7, "$topPeer");
        interfaceC14603iB2.invoke(c4346Es7, Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC14603iB2 interfaceC14603iB2, C4346Es7 c4346Es7, int i) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onPeerClick");
        AbstractC13042fc3.i(c4346Es7, "$topPeer");
        interfaceC14603iB2.invoke(c4346Es7, Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, Avatar avatar, String str, C4346Es7 c4346Es7, int i, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, String str2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$username");
        AbstractC13042fc3.i(c4346Es7, "$topPeer");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onPeerClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "$onPeerLongClick");
        AbstractC13042fc3.i(str2, "$specialPrefixes");
        g(eVar, avatar, str, c4346Es7, i, interfaceC14603iB2, interfaceC14603iB22, str2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void k(androidx.compose.ui.e eVar, final List list, final InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC14603iB2 interfaceC14603iB22, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(list, "topPeers");
        AbstractC13042fc3.i(interfaceC14603iB2, "onPeerClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "onPeerLongClick");
        AbstractC13042fc3.i(str, "specialPrefixes");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-943509844);
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = (interfaceC22053ub1J.D(list) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 16384 : 8192;
        }
        if ((i3 & 9361) == 9360 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            androidx.compose.ui.e eVar3 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            interfaceC22053ub1J.W(-1494546438);
            boolean zV = interfaceC22053ub1J.V(list);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                interfaceC22053ub1J.s(list);
                objB = list;
            }
            final List list2 = (List) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(92));
            TS4 ts4C = androidx.compose.foundation.layout.q.c(G10.a.c(interfaceC22053ub1J, G10.b).b().u(), 0.0f, 2, null);
            interfaceC22053ub1J.W(-1494538438);
            boolean zD = ((i3 & 896) == 256) | interfaceC22053ub1J.D(list2) | ((i3 & 7168) == 2048) | ((i3 & 57344) == 16384);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Gs7
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC6232Ms7.m(list2, interfaceC14603iB2, interfaceC14603iB22, str, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.d(eVarI, null, ts4C, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 6, 506);
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Hs7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6232Ms7.l(eVar2, list, interfaceC14603iB2, interfaceC14603iB22, str, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(androidx.compose.ui.e eVar, List list, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, String str, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$topPeers");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onPeerClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "$onPeerLongClick");
        AbstractC13042fc3.i(str, "$specialPrefixes");
        k(eVar, list, interfaceC14603iB2, interfaceC14603iB22, str, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(final List list, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, String str, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$topPeersList");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onPeerClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "$onPeerLongClick");
        AbstractC13042fc3.i(str, "$specialPrefixes");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.Is7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC6232Ms7.n(list, ((Integer) obj).intValue());
            }
        }, null, AbstractC19242q11.c(1748928896, true, new a(list, interfaceC14603iB2, interfaceC14603iB22, str)), 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object n(List list, int i) {
        AbstractC13042fc3.i(list, "$topPeersList");
        return Long.valueOf(((C4346Es7) list.get(i)).b().u() + AbstractC17026mG5.a.j(1, 9999));
    }
}
