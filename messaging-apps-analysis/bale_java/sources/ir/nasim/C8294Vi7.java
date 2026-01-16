package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.Vi7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8294Vi7 {
    public static final C8294Vi7 a = new C8294Vi7();
    private static final float b = C17784nZ1.q(1);
    private static final float c = C17784nZ1.q(2);
    private static final float d = C17784nZ1.q(52);

    /* renamed from: ir.nasim.Vi7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, float f, long j, int i, int i2) {
            super(2);
            this.f = eVar;
            this.g = f;
            this.h = j;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8294Vi7.this.a(this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vi7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, float f, long j, int i, int i2) {
            super(2);
            this.f = eVar;
            this.g = f;
            this.h = j;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8294Vi7.this.b(this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vi7$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C8060Ui7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C8060Ui7 c8060Ui7) {
            super(1);
            this.e = c8060Ui7;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vi7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C8060Ui7 e;

        /* renamed from: ir.nasim.Vi7$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6) {
                super(1);
                this.e = interfaceC9664aL6;
            }

            public final long a(WH1 wh1) {
                return AbstractC22635va3.a(wh1.B0(d.d(this.e)), 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return C22045ua3.c(a((WH1) obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C8060Ui7 c8060Ui7) {
            super(3);
            this.e = c8060Ui7;
        }

        private static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-398757863);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-398757863, i, -1, "androidx.compose.material.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:393)");
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC4572Fs.c(this.e.c(), AbstractC5999Lt.l(Type.TSIG, 0, T22.d(), 2, null), null, null, interfaceC22053ub1, 0, 12);
            InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC4572Fs.c(this.e.a(), AbstractC5999Lt.l(Type.TSIG, 0, T22.d(), 2, null), null, null, interfaceC22053ub1, 0, 12);
            androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.t.h(eVar, 0.0f, 1, null), InterfaceC12529em.a.d(), false, 2, null);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC9664aL6C2);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.n.a(eVarE, (UA2) objB), c(interfaceC9664aL6C));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarY;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    private C8294Vi7() {
    }

    public final void a(androidx.compose.ui.e eVar, float f, long j, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        float f2;
        long jO;
        androidx.compose.ui.e eVar3;
        float f3;
        long j2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(910934799);
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
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                f2 = f;
                int i5 = interfaceC22053ub1J.c(f2) ? 32 : 16;
                i3 |= i5;
            } else {
                f2 = f;
            }
            i3 |= i5;
        } else {
            f2 = f;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jO = j;
                int i6 = interfaceC22053ub1J.f(jO) ? 256 : 128;
                i3 |= i6;
            } else {
                jO = j;
            }
            i3 |= i6;
        } else {
            jO = j;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(this) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i3 & 1171) != 1170, i3 & 1)) {
            interfaceC22053ub1J.E();
            if ((i & 1) == 0 || interfaceC22053ub1J.O()) {
                eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
                if ((i2 & 2) != 0) {
                    f3 = b;
                    i3 &= -113;
                } else {
                    f3 = f2;
                }
                if ((i2 & 4) != 0) {
                    jO = C24381yX0.o(((C24381yX0) interfaceC22053ub1J.H(AbstractC20866sk1.a())).y(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -897;
                }
            } else {
                interfaceC22053ub1J.L();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                eVar3 = eVar2;
                f3 = f2;
            }
            long j3 = jO;
            int i7 = i3;
            j2 = j3;
            interfaceC22053ub1J.w();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(910934799, i7, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:357)");
            }
            AbstractC9758aW1.a(eVar3, j2, f3, 0.0f, interfaceC22053ub1J, (i7 & 14) | ((i7 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i7 << 3) & 896), 8);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
            f3 = f2;
            j2 = jO;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(eVar3, f3, j2, i, i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.compose.ui.e r21, float r22, long r23, ir.nasim.InterfaceC22053ub1 r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8294Vi7.b(androidx.compose.ui.e, float, long, ir.nasim.ub1, int, int):void");
    }

    public final androidx.compose.ui.e c(androidx.compose.ui.e eVar, C8060Ui7 c8060Ui7) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new c(c8060Ui7) : Q93.a(), new d(c8060Ui7));
    }
}
