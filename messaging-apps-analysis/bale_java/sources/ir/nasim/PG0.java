package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes.dex */
public abstract class PG0 {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(664103990, i, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:96)");
            }
            InterfaceC15796kB2 interfaceC15796kB2 = this.e;
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
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

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC10031ax6 f;
        final /* synthetic */ LG0 g;
        final /* synthetic */ NG0 h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ InterfaceC15796kB2 j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, LG0 lg0, NG0 ng0, C10493bi0 c10493bi0, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = lg0;
            this.h = ng0;
            this.i = c10493bi0;
            this.j = interfaceC15796kB2;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            PG0.a(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, LG0 lg0, NG0 ng0, C10493bi0 c10493bi0, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        InterfaceC10031ax6 interfaceC10031ax62;
        LG0 lg02;
        NG0 ng02;
        C10493bi0 c10493bi02;
        androidx.compose.ui.e eVar3;
        InterfaceC10031ax6 interfaceC10031ax6E;
        LG0 lg0A;
        NG0 ng0C;
        C10493bi0 c10493bi03;
        int i4;
        NG0 ng03;
        NG0 ng04;
        C10493bi0 c10493bi04;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1179621553);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                interfaceC10031ax62 = interfaceC10031ax6;
                int i6 = interfaceC22053ub1J.V(interfaceC10031ax62) ? 32 : 16;
                i3 |= i6;
            } else {
                interfaceC10031ax62 = interfaceC10031ax6;
            }
            i3 |= i6;
        } else {
            interfaceC10031ax62 = interfaceC10031ax6;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                lg02 = lg0;
                int i7 = interfaceC22053ub1J.V(lg02) ? 256 : 128;
                i3 |= i7;
            } else {
                lg02 = lg0;
            }
            i3 |= i7;
        } else {
            lg02 = lg0;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            if ((i2 & 8) == 0) {
                ng02 = ng0;
                int i8 = interfaceC22053ub1J.V(ng02) ? 2048 : 1024;
                i3 |= i8;
            } else {
                ng02 = ng0;
            }
            i3 |= i8;
        } else {
            ng02 = ng0;
        }
        int i9 = i2 & 16;
        if (i9 != 0) {
            i3 |= 24576;
            c10493bi02 = c10493bi0;
        } else {
            c10493bi02 = c10493bi0;
            if ((i & 24576) == 0) {
                i3 |= interfaceC22053ub1J.V(c10493bi02) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 131072 : 65536;
        }
        if ((74899 & i3) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
            interfaceC10031ax6E = interfaceC10031ax62;
            ng04 = ng02;
            c10493bi04 = c10493bi02;
        } else {
            interfaceC22053ub1J.E();
            if ((i & 1) == 0 || interfaceC22053ub1J.O()) {
                eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
                if ((i2 & 2) != 0) {
                    interfaceC10031ax6E = MG0.a.e(interfaceC22053ub1J, 6);
                    i3 &= -113;
                } else {
                    interfaceC10031ax6E = interfaceC10031ax62;
                }
                if ((i2 & 4) != 0) {
                    lg0A = MG0.a.a(interfaceC22053ub1J, 6);
                    i3 &= -897;
                } else {
                    lg0A = lg02;
                }
                if ((i2 & 8) != 0) {
                    ng0C = MG0.a.c(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, interfaceC22053ub1J, 1572864, 63);
                    i3 &= -7169;
                } else {
                    ng0C = ng02;
                }
                c10493bi03 = i9 != 0 ? null : c10493bi0;
                NG0 ng05 = ng0C;
                i4 = i3;
                ng03 = ng05;
            } else {
                interfaceC22053ub1J.L();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                eVar3 = eVar2;
                interfaceC10031ax6E = interfaceC10031ax62;
                lg0A = lg02;
                c10493bi03 = c10493bi02;
                i4 = i3;
                ng03 = ng02;
            }
            interfaceC22053ub1J.w();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1179621553, i4, -1, "androidx.compose.material3.Card (Card.kt:87)");
            }
            NG0 ng06 = ng03;
            F27.a(eVar3, interfaceC10031ax6E, lg0A.a(true), lg0A.b(true), 0.0f, ((C17784nZ1) ng03.f(true, null, interfaceC22053ub1J, ((i4 >> 3) & 896) | 54).getValue()).v(), c10493bi03, AbstractC19242q11.e(664103990, true, new a(interfaceC15796kB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i4 & 14) | 12582912 | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (3670016 & (i4 << 6)), 16);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            lg02 = lg0A;
            ng04 = ng06;
            c10493bi04 = c10493bi03;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(eVar3, interfaceC10031ax6E, lg02, ng04, c10493bi04, interfaceC15796kB2, i, i2));
        }
    }
}
