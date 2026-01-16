package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.P80;

/* loaded from: classes6.dex */
public abstract class P80 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GT4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = gt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002f -> B:11:0x001e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:11:0x001e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1b
            Lf:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L17:
                ir.nasim.AbstractC10685c16.b(r12)
                goto L29
            L1b:
                ir.nasim.AbstractC10685c16.b(r12)
            L1e:
                r11.b = r3
                r4 = 4000(0xfa0, double:1.9763E-320)
                java.lang.Object r12 = ir.nasim.HG1.b(r4, r11)
                if (r12 != r0) goto L29
                return r0
            L29:
                ir.nasim.GT4 r12 = r11.c
                int r12 = r12.H()
                if (r12 <= 0) goto L1e
                ir.nasim.GT4 r4 = r11.c
                int r12 = r4.v()
                int r12 = r12 + r3
                ir.nasim.GT4 r1 = r11.c
                int r1 = r1.H()
                int r5 = r12 % r1
                r12 = 1128792064(0x43480000, float:200.0)
                r1 = 5
                r6 = 0
                r7 = 0
                ir.nasim.pJ6 r7 = ir.nasim.AbstractC5999Lt.j(r6, r12, r7, r1, r7)
                r11.b = r2
                r9 = 2
                r10 = 0
                r8 = r11
                java.lang.Object r12 = ir.nasim.GT4.n(r4, r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L1e
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P80.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ AbstractC12710f43 b;
        final /* synthetic */ InterfaceC15796kB2 c;

        b(InterfaceC14603iB2 interfaceC14603iB2, AbstractC12710f43 abstractC12710f43, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC14603iB2;
            this.b = abstractC12710f43;
            this.c = interfaceC15796kB2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC14603iB2 interfaceC14603iB2, AbstractC12710f43 abstractC12710f43, int i) {
            AbstractC13042fc3.i(abstractC12710f43, "$bannerUIs");
            Object obj = abstractC12710f43.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            interfaceC14603iB2.invoke(obj, Integer.valueOf(i));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC15796kB2 interfaceC15796kB2, int i, AbstractC12710f43 abstractC12710f43, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(abstractC12710f43, "$bannerUIs");
            AbstractC13042fc3.i(interfaceC11379cu3, "it");
            interfaceC15796kB2.q(interfaceC11379cu3, Integer.valueOf(i), Integer.valueOf(((C5746Kq6) abstractC12710f43.get(i)).c()));
            return C19938rB7.a;
        }

        public final void c(InterfaceC22573vT4 interfaceC22573vT4, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC22573vT4, "$this$HorizontalPager");
            boolean z = true;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 3.8181f, false, 2, null), N46.d(C17784nZ1.q(14)));
            interfaceC22053ub1.W(-1203027951);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(this.b);
            int i3 = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48;
            boolean z2 = zV | ((i3 > 32 && interfaceC22053ub1.e(i)) || (i2 & 48) == 32);
            final InterfaceC14603iB2 interfaceC14603iB2 = this.a;
            final AbstractC12710f43 abstractC12710f43 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Q80
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P80.b.d(interfaceC14603iB2, abstractC12710f43, i);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC13313g10.D(eVarA, (SA2) objB);
            interfaceC22053ub1.W(-1203023473);
            boolean zV2 = interfaceC22053ub1.V(this.c);
            if ((i3 <= 32 || !interfaceC22053ub1.e(i)) && (i2 & 48) != 32) {
                z = false;
            }
            boolean zD = zV2 | z | interfaceC22053ub1.D(this.b);
            final InterfaceC15796kB2 interfaceC15796kB2 = this.c;
            final AbstractC12710f43 abstractC12710f432 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.R80
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return P80.b.f(interfaceC15796kB2, i, abstractC12710f432, (InterfaceC11379cu3) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            coil.compose.d.a(((C5746Kq6) this.b.get(i)).b(), null, androidx.compose.ui.layout.c.a(eVarD, (UA2) objB2), null, null, null, InterfaceC13157fl1.a.d(), 0.0f, null, 0, false, null, interfaceC22053ub1, 1572912, 0, 4024);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c((InterfaceC22573vT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(androidx.compose.ui.e r28, final ir.nasim.AbstractC12710f43 r29, ir.nasim.InterfaceC14603iB2 r30, ir.nasim.InterfaceC15796kB2 r31, ir.nasim.InterfaceC22053ub1 r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P80.i(androidx.compose.ui.e, ir.nasim.f43, ir.nasim.iB2, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C5746Kq6 c5746Kq6, int i) {
        AbstractC13042fc3.i(c5746Kq6, "<unused var>");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(InterfaceC11379cu3 interfaceC11379cu3, int i, int i2) {
        AbstractC13042fc3.i(interfaceC11379cu3, "<unused var>");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(AbstractC12710f43 abstractC12710f43) {
        if (abstractC12710f43 != null) {
            return abstractC12710f43.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(androidx.compose.ui.e eVar, AbstractC12710f43 abstractC12710f43, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        i(eVar, abstractC12710f43, interfaceC14603iB2, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final int r20, final ir.nasim.GT4 r21, androidx.compose.ui.e r22, float r23, ir.nasim.InterfaceC22053ub1 r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P80.n(int, ir.nasim.GT4, androidx.compose.ui.e, float, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(int i, GT4 gt4, androidx.compose.ui.e eVar, float f, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(gt4, "$pagerState");
        n(i, gt4, eVar, f, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void p(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1126840520);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            i(null, AbstractC12710f43.V(), null, null, interfaceC22053ub1J, C5746Kq6.h << 3, 13);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.H80
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return P80.q(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        p(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void r(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1220807466);
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
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.k(androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null), 3.8181f, false, 2, null), 0.0f, C17784nZ1.q(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER), 1, null), N46.d(C17784nZ1.q(14))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.N80
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return P80.s(eVar3, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        r(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void t(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1467986491);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            r(null, interfaceC22053ub1J, 0, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.I80
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return P80.u(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        t(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
