package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public abstract class N37 {
    private static final float a = C17784nZ1.q(125);

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ O37 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;

        /* renamed from: ir.nasim.N37$a$a, reason: collision with other inner class name */
        static final class C0529a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ boolean f;
            final /* synthetic */ float g;
            final /* synthetic */ boolean h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0529a(boolean z, boolean z2, float f, boolean z3) {
                super(1);
                this.e = z;
                this.f = z2;
                this.g = f;
                this.h = z3;
            }

            public final void a(LZ1 lz1) {
                lz1.a(P37.Settled, 0.0f);
                if (this.e) {
                    lz1.a(P37.StartToEnd, this.f ? -this.g : this.g);
                }
                if (this.h) {
                    lz1.a(P37.EndToStart, this.f ? this.g : -this.g);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((LZ1) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(O37 o37, boolean z, boolean z2, boolean z3) {
            super(2);
            this.e = o37;
            this.f = z;
            this.g = z2;
            this.h = z3;
        }

        public final XV4 a(long j, long j2) {
            return AbstractC4616Fw7.a(androidx.compose.material3.internal.b.a(new C0529a(this.f, this.g, C4414Fa3.g(j), this.h)), this.e.d());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((C4414Fa3) obj).j(), ((C17833ne1) obj2).r());
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ O37 e;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC15796kB2 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(O37 o37, InterfaceC15796kB2 interfaceC15796kB2, androidx.compose.ui.e eVar, boolean z, boolean z2, boolean z3, InterfaceC15796kB2 interfaceC15796kB22, int i, int i2) {
            super(2);
            this.e = o37;
            this.f = interfaceC15796kB2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = z3;
            this.k = interfaceC15796kB22;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            N37.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(P37 p37) {
            return Boolean.TRUE;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ P37 e;
        final /* synthetic */ WH1 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(P37 p37, WH1 wh1, UA2 ua2, UA2 ua22) {
            super(0);
            this.e = p37;
            this.f = wh1;
            this.g = ua2;
            this.h = ua22;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final O37 invoke() {
            return new O37(this.e, this.f, this.g, this.h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.O37 r27, ir.nasim.InterfaceC15796kB2 r28, androidx.compose.ui.e r29, boolean r30, boolean r31, boolean r32, ir.nasim.InterfaceC15796kB2 r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.N37.a(ir.nasim.O37, ir.nasim.kB2, androidx.compose.ui.e, boolean, boolean, boolean, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    public static final O37 c(P37 p37, UA2 ua2, UA2 ua22, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            p37 = P37.Settled;
        }
        if ((i2 & 2) != 0) {
            ua2 = c.e;
        }
        if ((i2 & 4) != 0) {
            ua22 = M37.a.a(interfaceC22053ub1, 6);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-246335487, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)");
        }
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = O37.c.a(ua2, ua22, wh1);
        boolean zV = (((6 ^ (i & 14)) > 4 && interfaceC22053ub1.V(p37)) || (i & 6) == 4) | interfaceC22053ub1.V(wh1) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(ua2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.V(ua22)) || (i & 384) == 256);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new d(p37, wh1, ua2, ua22);
            interfaceC22053ub1.s(objB);
        }
        O37 o37 = (O37) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return o37;
    }
}
