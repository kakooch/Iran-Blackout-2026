package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import ir.nasim.AbstractC9090Yl1;
import java.util.List;

/* renamed from: ir.nasim.Yl1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC9090Yl1 {

    /* renamed from: ir.nasim.Yl1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ long a;
        final /* synthetic */ boolean b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ long d;
        final /* synthetic */ List e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        /* renamed from: ir.nasim.Yl1$a$a, reason: collision with other inner class name */
        static final class C0797a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ long c;
            final /* synthetic */ long d;

            /* renamed from: ir.nasim.Yl1$a$a$a, reason: collision with other inner class name */
            static final class C0798a implements InterfaceC14603iB2 {
                final /* synthetic */ C7847Tl1 a;
                final /* synthetic */ long b;

                C0798a(C7847Tl1 c7847Tl1, long j) {
                    this.a = c7847Tl1;
                    this.b = j;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    G10 g10 = G10.a;
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1, 6).b().c(), 0.0f, 11, null);
                    AbstractC9339Zm7.b(this.a.e(), eVarM, this.b, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, 6).b(), interfaceC22053ub1, 0, 0, 65528);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Yl1$a$a$b */
            static final class b implements InterfaceC14603iB2 {
                final /* synthetic */ C7847Tl1 a;
                final /* synthetic */ long b;

                b(C7847Tl1 c7847Tl1, long j) {
                    this.a = c7847Tl1;
                    this.b = j;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC24077y03.b(FV4.c(this.a.c(), interfaceC22053ub1, 0), null, null, this.b, interfaceC22053ub1, 48, 4);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C0797a(List list, SA2 sa2, long j, long j2) {
                this.a = list;
                this.b = sa2;
                this.c = j;
                this.d = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C7847Tl1 c7847Tl1, SA2 sa2) {
                AbstractC13042fc3.i(c7847Tl1, "$it");
                AbstractC13042fc3.i(sa2, "$onMenuHide");
                c7847Tl1.f().invoke();
                sa2.invoke();
                return C19938rB7.a;
            }

            public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$DropdownMenu");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                List<C7847Tl1> list = this.a;
                final SA2 sa2 = this.b;
                long j = this.c;
                long j2 = this.d;
                for (final C7847Tl1 c7847Tl1 : list) {
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1358414226, true, new C0798a(c7847Tl1, j), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(-1725589583);
                    boolean zD = interfaceC22053ub1.D(c7847Tl1) | interfaceC22053ub1.V(sa2);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Xl1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC9090Yl1.a.C0797a.c(c7847Tl1, sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC6197Mp.b(interfaceC18060o11E, (SA2) objB, null, AbstractC19242q11.e(-926034731, true, new b(c7847Tl1, j2), interfaceC22053ub1, 54), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
                    j = j;
                    j2 = j2;
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(long j, boolean z, SA2 sa2, long j2, List list, long j3, long j4) {
            this.a = j;
            this.b = z;
            this.c = sa2;
            this.d = j2;
            this.e = list;
            this.f = j3;
            this.g = j4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.A(androidx.compose.ui.e.a, C17784nZ1.q(SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER), 0.0f, 2, null), this.a, null, 2, null);
            M46 m46D = N46.d(G10.a.c(interfaceC22053ub1, 6).a().b());
            boolean z = this.b;
            SA2 sa2 = this.c;
            AbstractC6197Mp.a(z, sa2, eVarD, this.d, null, null, m46D, this.a, 0.0f, 0.0f, null, AbstractC19242q11.e(1278994232, true, new C0797a(this.e, sa2, this.f, this.g), interfaceC22053ub1, 54), interfaceC22053ub1, 0, 48, 1840);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(long j, final List list, final boolean z, final SA2 sa2, long j2, long j3, long j4, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        final long j5;
        int i3;
        final long j6;
        long j7;
        long jB;
        long jB2;
        long j8;
        long j9;
        long j10;
        final long j11;
        final long j12;
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(sa2, "onMenuHide");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1364570045);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            j5 = j;
        } else if ((i & 6) == 0) {
            j5 = j;
            i3 = (interfaceC22053ub1J.f(j5) ? 4 : 2) | i;
        } else {
            j5 = j;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= ((i2 & 16) == 0 && interfaceC22053ub1J.f(j2)) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            j6 = j3;
            i3 |= ((i2 & 32) == 0 && interfaceC22053ub1J.f(j6)) ? 131072 : 65536;
        } else {
            j6 = j3;
        }
        if ((1572864 & i) == 0) {
            j7 = j4;
            i3 |= ((i2 & 64) == 0 && interfaceC22053ub1J.f(j7)) ? 1048576 : 524288;
        } else {
            j7 = j4;
        }
        if ((i3 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            j11 = j7;
            j12 = j2;
        } else {
            interfaceC22053ub1J.E();
            if ((i & 1) == 0 || interfaceC22053ub1J.O()) {
                if (i4 != 0) {
                    float fQ = C17784nZ1.q(12);
                    jB = C19557qZ1.b((Float.floatToRawIntBits(C17784nZ1.q(0)) & 4294967295L) | (Float.floatToRawIntBits(fQ) << 32));
                } else {
                    jB = j5;
                }
                long jM = (i2 & 16) != 0 ? G10.a.a(interfaceC22053ub1J, 6).M() : j2;
                long jF = (i2 & 32) != 0 ? G10.a.a(interfaceC22053ub1J, 6).F() : j6;
                jB2 = (i2 & 64) != 0 ? G10.a.a(interfaceC22053ub1J, 6).B() : j7;
                j8 = jF;
                j9 = jM;
                j10 = jB;
            } else {
                interfaceC22053ub1J.L();
                j9 = j2;
                j10 = j5;
                jB2 = j7;
                j8 = j6;
            }
            interfaceC22053ub1J.w();
            j6 = j8;
            j11 = jB2;
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(!JF5.g() ? EnumC12613eu3.a : EnumC12613eu3.b), AbstractC19242q11.e(-1740655875, true, new a(j9, z, sa2, j10, list, j6, j11), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            j5 = j10;
            j12 = j9;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Wl1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9090Yl1.c(j5, list, z, sa2, j12, j6, j11, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(long j, List list, boolean z, SA2 sa2, long j2, long j3, long j4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$items");
        AbstractC13042fc3.i(sa2, "$onMenuHide");
        b(j, list, z, sa2, j2, j3, j4, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
