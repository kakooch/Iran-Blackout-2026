package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23693xM1;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xM1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23693xM1 {

    /* renamed from: ir.nasim.xM1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 a;

        a(InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                this.a.invoke(interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ SA2 b;

        b(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
            this.a = interfaceC14603iB2;
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                this.a.invoke(interfaceC22053ub1, 0);
                AbstractC23693xM1.T(this.b, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ float b;

        c(int i, float f) {
            this.a = i;
            this.b = f;
        }

        public final void a(List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C24411ya3 c24411ya3N;
            C7824Ti7 c7824Ti7 = (list == null || (c24411ya3N = AbstractC10360bX0.n(list)) == null || !c24411ya3N.B(this.a)) ? list != null ? (C7824Ti7) list.get(0) : null : (C7824Ti7) list.get(this.a);
            interfaceC22053ub1.W(1196674883);
            androidx.compose.ui.e eVarK = c7824Ti7 != null ? androidx.compose.foundation.layout.q.k(AbstractC16065ke6.o(androidx.compose.ui.e.a, c7824Ti7), G10.a.c(interfaceC22053ub1, G10.b).b().e(), 0.0f, 2, null) : null;
            interfaceC22053ub1.Q();
            if (eVarK != null) {
                C8528Wi7.a.b(eVarK, this.b, G10.a.a(interfaceC22053ub1, G10.b).I(), interfaceC22053ub1, C8528Wi7.c << 9, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((List) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ int c;
        final /* synthetic */ EnumC23487x03 d;

        /* renamed from: ir.nasim.xM1$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strC = UY6.c(this.a, interfaceC22053ub1, 0);
                G10 g10 = G10.a;
                int i2 = G10.b;
                AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 0, 0, 65530);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.xM1$d$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ EnumC23487x03 a;

            b(EnumC23487x03 enumC23487x03) {
                this.a = enumC23487x03;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC24077y03.a(FN1.d(this.a, interfaceC22053ub1, 0), null, null, G10.a.a(interfaceC22053ub1, G10.b).F(), interfaceC22053ub1, 48, 4);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(SA2 sa2, SA2 sa22, int i, EnumC23487x03 enumC23487x03) {
            this.a = sa2;
            this.b = sa22;
            this.c = i;
            this.d = enumC23487x03;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "$onDeleteClicked");
            AbstractC13042fc3.i(sa22, "$onDismissRequest");
            sa2.invoke();
            sa22.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-706668900, true, new a(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-261588043);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.a;
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.yM1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23693xM1.d.c(sa2, sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC6197Mp.b(interfaceC18060o11E, (SA2) objB, null, AbstractC19242q11.e(467422879, true, new b(this.d), interfaceC22053ub1, 54), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC13346g43 a;
        final /* synthetic */ int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ float f;
        final /* synthetic */ Integer g;
        final /* synthetic */ InterfaceC13819gs2 h;

        e(InterfaceC13346g43 interfaceC13346g43, int i, UA2 ua2, UA2 ua22, SA2 sa2, float f, Integer num, InterfaceC13819gs2 interfaceC13819gs2) {
            this.a = interfaceC13346g43;
            this.b = i;
            this.c = ua2;
            this.d = ua22;
            this.e = sa2;
            this.f = f;
            this.g = num;
            this.h = interfaceC13819gs2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC23693xM1.Z(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$f */
    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        f(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(sa2, "$onEditClicked");
            AbstractC13042fc3.i(sa22, "$onDismissRequest");
            sa2.invoke();
            sa22.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Q41 q41 = Q41.a;
            InterfaceC14603iB2 interfaceC14603iB2C = q41.c();
            interfaceC22053ub1.W(-1340474446);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.a;
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.zM1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23693xM1.f.c(sa2, sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC6197Mp.b(interfaceC14603iB2C, (SA2) objB, null, q41.d(), null, false, null, null, null, interfaceC22053ub1, 3078, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$g */
    static final class g implements InterfaceC15796kB2 {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$Badge");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(AbstractC12152e76.d(String.valueOf(this.a), interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, G10.a.d(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 57342);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xM1$h */
    static final class h implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;

        /* renamed from: ir.nasim.xM1$h$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ boolean a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ SA2 d;

            a(boolean z, SA2 sa2, SA2 sa22, SA2 sa23) {
                this.a = z;
                this.b = sa2;
                this.c = sa22;
                this.d = sa23;
            }

            public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$DropdownMenu");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-438433140);
                if (this.a) {
                    AbstractC23693xM1.I(this.b, this.c, interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
                AbstractC23693xM1.D(this.a, this.d, this.c, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        h(boolean z, SA2 sa2, boolean z2, SA2 sa22, SA2 sa23) {
            this.a = z;
            this.b = sa2;
            this.c = z2;
            this.d = sa22;
            this.e = sa23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            InterfaceC17460n02.C1(interfaceC17460n02, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i2 = G10.b;
            final long jM = g10.a(interfaceC22053ub1, i2).M();
            M46 m46D = N46.d(g10.c(interfaceC22053ub1, i2).a().b());
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(1929781140);
            boolean zF = interfaceC22053ub1.f(jM);
            Object objB = interfaceC22053ub1.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.AM1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC23693xM1.h.c(jM, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.draw.b.b(aVar, (UA2) objB), g10.c(interfaceC22053ub1, i2).b().g(), 0.0f, 2, null);
            boolean z = this.a;
            SA2 sa2 = this.b;
            AbstractC6197Mp.a(z, sa2, eVarK, 0L, null, null, m46D, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(377163250, true, new a(this.c, this.d, sa2, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 0, 48, 1976);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    private static final boolean A(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(long j, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        InterfaceC17460n02.C1(interfaceC17460n02, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(int i, InterfaceC13346g43 interfaceC13346g43, int i2, androidx.compose.ui.e eVar, float f2, float f3, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(interfaceC13346g43, "$tabs");
        AbstractC13042fc3.i(sa2, "$onPlusIconClicked");
        AbstractC13042fc3.i(interfaceC14603iB2, "$content");
        w(i, interfaceC13346g43, i2, eVar, f2, f3, sa2, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final boolean z, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-900803631);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            XV4 xv4 = z ? new XV4(Integer.valueOf(FD5.delete_folder), EnumC23487x03.k) : new XV4(Integer.valueOf(FD5.dective_folder), EnumC23487x03.l);
            M10.f(false, AbstractC19242q11.e(-527960372, true, new d(sa2, sa22, ((Number) xv4.a()).intValue(), (EnumC23487x03) xv4.b()), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.oM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.E(z, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(boolean z, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDeleteClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        D(z, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(final ir.nasim.InterfaceC13346g43 r27, final int r28, final ir.nasim.UA2 r29, final ir.nasim.UA2 r30, final ir.nasim.SA2 r31, final ir.nasim.SA2 r32, float r33, float r34, java.lang.Integer r35, final ir.nasim.InterfaceC13819gs2 r36, ir.nasim.InterfaceC22053ub1 r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23693xM1.F(ir.nasim.g43, int, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.SA2, float, float, java.lang.Integer, ir.nasim.gs2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 4.0f);
        AbstractC9939ao6.E0(interfaceC11943do6, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(InterfaceC13346g43 interfaceC13346g43, int i, UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22, float f2, float f3, Integer num, InterfaceC13819gs2 interfaceC13819gs2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC13346g43, "$tabs");
        AbstractC13042fc3.i(ua2, "$onTabSelected");
        AbstractC13042fc3.i(ua22, "$onTabLongPressed");
        AbstractC13042fc3.i(sa2, "$onPlusIconClicked");
        AbstractC13042fc3.i(sa22, "$onFolderMenuDismissed");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        F(interfaceC13346g43, i, ua2, ua22, sa2, sa22, f2, f3, num, interfaceC13819gs2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2003107628);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(1153012111, true, new f(sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.J(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onEditClicked");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        I(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void K(androidx.compose.ui.e r50, final int r51, final boolean r52, float r53, final ir.nasim.InterfaceC13521gN1 r54, final ir.nasim.SA2 r55, final ir.nasim.UA2 r56, final ir.nasim.SA2 r57, boolean r58, final ir.nasim.InterfaceC13819gs2 r59, ir.nasim.InterfaceC22053ub1 r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23693xM1.K(androidx.compose.ui.e, int, boolean, float, ir.nasim.gN1, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.SA2, boolean, ir.nasim.gs2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(InterfaceC13521gN1 interfaceC13521gN1, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC13521gN1, "$tab");
        AbstractC13042fc3.i(ua2, "$onTabLongPressed");
        if (C8386Vt0.u8() && (interfaceC13521gN1 instanceof InterfaceC13521gN1.b)) {
            ua2.invoke(Integer.valueOf(((InterfaceC13521gN1.b) interfaceC13521gN1).e()));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(boolean z, String str, int i, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$selectedDescription");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.h());
        if (!z) {
            str = Separators.SP;
        }
        AbstractC9939ao6.u0(interfaceC11943do6, str);
        AbstractC9939ao6.b0(interfaceC11943do6, new QW0(0, 1, i, 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$fullContentDescription");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        AbstractC9939ao6.e0(interfaceC11943do6, str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(InterfaceC13819gs2 interfaceC13819gs2, InterfaceC13521gN1 interfaceC13521gN1) {
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        AbstractC13042fc3.i(interfaceC13521gN1, "$tab");
        interfaceC13819gs2.getOnEditFolderClicked().invoke(Integer.valueOf(((InterfaceC13521gN1.b) interfaceC13521gN1).e()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(InterfaceC13819gs2 interfaceC13819gs2, InterfaceC13521gN1 interfaceC13521gN1, String str, Resources resources) {
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        AbstractC13042fc3.i(interfaceC13521gN1, "$tab");
        AbstractC13042fc3.i(str, "$title");
        InterfaceC15796kB2 interfaceC15796kB2P = interfaceC13819gs2.getOnDeleteFolderClicked();
        InterfaceC13521gN1.b bVar = (InterfaceC13521gN1.b) interfaceC13521gN1;
        int iE = bVar.e();
        AbstractC13042fc3.f(resources);
        interfaceC15796kB2P.q(AbstractC9978as2.a(iE, str, resources), Integer.valueOf(bVar.e()), Boolean.valueOf(!bVar.g()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(androidx.compose.ui.e eVar, int i, boolean z, float f2, InterfaceC13521gN1 interfaceC13521gN1, SA2 sa2, UA2 ua2, SA2 sa22, boolean z2, InterfaceC13819gs2 interfaceC13819gs2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC13521gN1, "$tab");
        AbstractC13042fc3.i(sa2, "$onTabSelected");
        AbstractC13042fc3.i(ua2, "$onTabLongPressed");
        AbstractC13042fc3.i(sa22, "$onFolderMenuDismissed");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        K(eVar, i, z, f2, interfaceC13521gN1, sa2, ua2, sa22, z2, interfaceC13819gs2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void R(final boolean z, final boolean z2, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(sa22, "onEditFolderClicked");
        AbstractC13042fc3.i(sa23, "onDeleteFolderClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1664513490);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.a(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(70840333, true, new h(z, sa2, z2, sa22, sa23), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.kM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.S(z, z2, sa2, sa22, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onEditFolderClicked");
        AbstractC13042fc3.i(sa23, "$onDeleteFolderClicked");
        R(z, z2, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(123850033);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(40));
            InterfaceC17521n63 interfaceC17521n63F = androidx.compose.material.a.f(false, 0.0f, 0L, 7, null);
            interfaceC22053ub1J.W(-2106467823);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC20434s03.a(sa2, androidx.compose.foundation.e.d(eVarT, (InterfaceC18507om4) objB, interfaceC17521n63F, false, null, null, sa2, 28, null), false, null, null, Q41.a.b(), interfaceC22053ub1J, (i2 & 14) | 196608, 28);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.cM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.U(sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U(SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onPlusIconClicked");
        T(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void V(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1233324658);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, Q41.a.e(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.W(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        V(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void X(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1353992511);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, Q41.a.f(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.Y(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        X(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Z(final ir.nasim.InterfaceC13346g43 r24, final int r25, final ir.nasim.UA2 r26, final ir.nasim.UA2 r27, final ir.nasim.SA2 r28, final float r29, final java.lang.Integer r30, final ir.nasim.InterfaceC13819gs2 r31, ir.nasim.InterfaceC22053ub1 r32, final int r33) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23693xM1.Z(ir.nasim.g43, int, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.SA2, float, java.lang.Integer, ir.nasim.gs2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a0(UA2 ua2, int i) {
        AbstractC13042fc3.i(ua2, "$onTabSelected");
        ua2.invoke(Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0(InterfaceC13346g43 interfaceC13346g43, int i, UA2 ua2, UA2 ua22, SA2 sa2, float f2, Integer num, InterfaceC13819gs2 interfaceC13819gs2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC13346g43, "$tabs");
        AbstractC13042fc3.i(ua2, "$onTabSelected");
        AbstractC13042fc3.i(ua22, "$onTabLongPressed");
        AbstractC13042fc3.i(sa2, "$onFolderMenuDismissed");
        AbstractC13042fc3.i(interfaceC13819gs2, "$folderListActions");
        Z(interfaceC13346g43, i, ua2, ua22, sa2, f2, num, interfaceC13819gs2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void c0(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2113272346);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(eVar, C17784nZ1.q(48)), C17784nZ1.q(90));
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarY);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            float f2 = 8;
            ZH6.a(AbstractC7329Rg1.f(FV0.a(androidx.compose.foundation.layout.t.v(androidx.compose.ui.e.a, C17784nZ1.q(45), C17784nZ1.q(f2)), N46.d(C17784nZ1.q(f2)))), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.dM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23693xM1.d0(eVar, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d0(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        c0(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final float i0(int i, float f2, WH1 wh1) {
        AbstractC13042fc3.i(wh1, "density");
        return AbstractC23053wG5.d(i + Math.max(f2, wh1.w1(C17784nZ1.q(24))) + (f2 != 0.0f ? wh1.w1(C17784nZ1.q(4)) : 0.0f) + (wh1.w1(C17784nZ1.q(14)) * 2), wh1.w1(C17784nZ1.q(70)));
    }

    public static final androidx.compose.ui.e j0(androidx.compose.ui.e eVar, boolean z, final long j, final float f2, final float f3) {
        AbstractC13042fc3.i(eVar, "$this$drawVerticalDividerIfEligible");
        return z ? androidx.compose.ui.draw.b.b(eVar, new UA2() { // from class: ir.nasim.lM1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC23693xM1.l0(f2, f3, j, (InterfaceC17460n02) obj);
            }
        }) : eVar;
    }

    public static /* synthetic */ androidx.compose.ui.e k0(androidx.compose.ui.e eVar, boolean z, long j, float f2, float f3, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = C17784nZ1.q(1);
        }
        float f4 = f2;
        if ((i & 8) != 0) {
            f3 = C17784nZ1.q(12);
        }
        return j0(eVar, z, j, f4, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(float f2, float f3, long j, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        float fW1 = interfaceC17460n02.w1(f2);
        float fW12 = interfaceC17460n02.w1(f3);
        float fIntBitsToFloat = interfaceC17460n02.getLayoutDirection() == EnumC12613eu3.b ? fW1 : Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) - fW1;
        InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fW12) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - fW12) & 4294967295L)), fW1, 0, null, 0.0f, null, 0, 496, null);
        return C19938rB7.a;
    }

    public static final InterfaceC13521gN1.b m0(int i, int i2, int i3) {
        return new InterfaceC13521gN1.b(i, InterfaceC13521gN1.b.a.C1252a.c(InterfaceC13521gN1.b.a.C1252a.d(i2)), false, false, i3);
    }

    public static final String n0(InterfaceC13521gN1 interfaceC13521gN1) {
        AbstractC13042fc3.i(interfaceC13521gN1, "<this>");
        if (interfaceC13521gN1 instanceof InterfaceC13521gN1.b) {
            return String.valueOf(((InterfaceC13521gN1.b) interfaceC13521gN1).e());
        }
        if (interfaceC13521gN1 instanceof InterfaceC13521gN1.a) {
            return "callLogs";
        }
        if (!AbstractC13042fc3.d(interfaceC13521gN1, InterfaceC13521gN1.c.a)) {
            throw new NoWhenBranchMatchedException();
        }
        return "loading-" + AbstractC17026mG5.a.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void w(final int r36, final ir.nasim.InterfaceC13346g43 r37, final int r38, androidx.compose.ui.e r39, final float r40, final float r41, final ir.nasim.SA2 r42, final ir.nasim.InterfaceC14603iB2 r43, ir.nasim.InterfaceC22053ub1 r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 1233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23693xM1.w(int, ir.nasim.g43, int, androidx.compose.ui.e, float, float, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float x(C14063hH6 c14063hH6) {
        AbstractC13042fc3.i(c14063hH6, "$measuredTabWidths");
        return AbstractC15401jX0.c1(c14063hH6);
    }

    private static final float y(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(float f2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$totalTextWidthPx$delegate");
        return y(interfaceC9664aL6) < f2;
    }
}
