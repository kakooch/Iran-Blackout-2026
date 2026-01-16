package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C21669tv7;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.x44, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23528x44 {
    private static final float a;
    private static final float b;
    private static final float d;
    private static final float g;
    private static final float c = C17784nZ1.q(16);
    private static final float e = C17784nZ1.q(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
    private static final float f = C17784nZ1.q(280);

    /* renamed from: ir.nasim.x44$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
            super(1);
            this.e = interfaceC9102Ym4;
            this.f = interfaceC9664aL6;
            this.g = interfaceC9664aL62;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            cVar.g(AbstractC23528x44.b(this.f));
            cVar.m(AbstractC23528x44.b(this.f));
            cVar.c(AbstractC23528x44.c(this.g));
            cVar.C0(((androidx.compose.ui.graphics.f) this.e.getValue()).j());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.x44$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C9023Yd6 f;
        final /* synthetic */ InterfaceC15796kB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, C9023Yd6 c9023Yd6, InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = eVar;
            this.f = c9023Yd6;
            this.g = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(895555282, i, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:211)");
            }
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(androidx.compose.foundation.layout.k.b(androidx.compose.foundation.layout.q.k(this.e, 0.0f, AbstractC23528x44.i(), 1, null), EnumC11821dc3.b), this.f, false, null, false, 14, null);
            InterfaceC15796kB2 interfaceC15796kB2 = this.g;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
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

    /* renamed from: ir.nasim.x44$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C11932dn4 e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C9023Yd6 g;
        final /* synthetic */ androidx.compose.ui.e h;
        final /* synthetic */ InterfaceC15796kB2 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11932dn4 c11932dn4, InterfaceC9102Ym4 interfaceC9102Ym4, C9023Yd6 c9023Yd6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = c11932dn4;
            this.f = interfaceC9102Ym4;
            this.g = c9023Yd6;
            this.h = eVar;
            this.i = interfaceC15796kB2;
            this.j = i;
            this.k = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC23528x44.a(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.x44$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final d e = new d();

        d() {
            super(3);
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-2065494304);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2065494304, i, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:184)");
            }
            C7479Rw7 c7479Rw7L = bVar.c(Boolean.FALSE, Boolean.TRUE) ? AbstractC5999Lt.l(30, 0, null, 6, null) : AbstractC5999Lt.l(75, 0, null, 6, null);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.x44$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final e e = new e();

        e() {
            super(3);
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-800950068);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-800950068, i, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:163)");
            }
            C7479Rw7 c7479Rw7L = bVar.c(Boolean.FALSE, Boolean.TRUE) ? AbstractC5999Lt.l(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 0, T22.f(), 2, null) : AbstractC5999Lt.l(1, 74, null, 4, null);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.x44$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ L66 g;

        /* renamed from: ir.nasim.x44$f$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 e;
            final /* synthetic */ L66 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC15796kB2 interfaceC15796kB2, L66 l66) {
                super(2);
                this.e = interfaceC15796kB2;
                this.f = l66;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1705995688, i, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:254)");
                }
                this.e.q(this.f, interfaceC22053ub1, 0);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z, InterfaceC15796kB2 interfaceC15796kB2, L66 l66) {
            super(2);
            this.e = z;
            this.f = interfaceC15796kB2;
            this.g = l66;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            float fB;
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1190489496, i, -1, "androidx.compose.material.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:253)");
            }
            if (this.e) {
                interfaceC22053ub1.W(-186854702);
                fB = C16120kk1.a.c(interfaceC22053ub1, 6);
            } else {
                interfaceC22053ub1.W(-186853962);
                fB = C16120kk1.a.b(interfaceC22053ub1, 6);
            }
            interfaceC22053ub1.Q();
            AbstractC11024cc1.a(AbstractC16711lk1.a().d(Float.valueOf(fB)), AbstractC19242q11.e(-1705995688, true, new a(this.f, this.g), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
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

    /* renamed from: ir.nasim.x44$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ boolean g;
        final /* synthetic */ TS4 h;
        final /* synthetic */ InterfaceC18507om4 i;
        final /* synthetic */ InterfaceC15796kB2 j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(SA2 sa2, androidx.compose.ui.e eVar, boolean z, TS4 ts4, InterfaceC18507om4 interfaceC18507om4, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = sa2;
            this.f = eVar;
            this.g = z;
            this.h = ts4;
            this.i = interfaceC18507om4;
            this.j = interfaceC15796kB2;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC23528x44.d(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float f2 = 8;
        a = C17784nZ1.q(f2);
        float f3 = 48;
        b = C17784nZ1.q(f3);
        d = C17784nZ1.q(f2);
        g = C17784nZ1.q(f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C11932dn4 r23, ir.nasim.InterfaceC9102Ym4 r24, ir.nasim.C9023Yd6 r25, androidx.compose.ui.e r26, ir.nasim.InterfaceC15796kB2 r27, ir.nasim.InterfaceC22053ub1 r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23528x44.a(ir.nasim.dn4, ir.nasim.Ym4, ir.nasim.Yd6, androidx.compose.ui.e, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(ir.nasim.SA2 r25, androidx.compose.ui.e r26, boolean r27, ir.nasim.TS4 r28, ir.nasim.InterfaceC18507om4 r29, ir.nasim.InterfaceC15796kB2 r30, ir.nasim.InterfaceC22053ub1 r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23528x44.d(ir.nasim.SA2, androidx.compose.ui.e, boolean, ir.nasim.TS4, ir.nasim.om4, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long h(ir.nasim.C25005za3 r5, ir.nasim.C25005za3 r6) {
        /*
            int r0 = r6.g()
            int r1 = r5.h()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto Lf
        Ld:
            r0 = r3
            goto L49
        Lf:
            int r0 = r6.h()
            int r1 = r5.g()
            if (r0 > r1) goto L1b
            r0 = r2
            goto L49
        L1b:
            int r0 = r6.l()
            if (r0 != 0) goto L22
            goto Ld
        L22:
            int r0 = r5.g()
            int r1 = r6.g()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.h()
            int r4 = r6.h()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.g()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.l()
            float r1 = (float) r1
            float r0 = r0 / r1
        L49:
            int r1 = r6.j()
            int r4 = r5.d()
            if (r1 < r4) goto L55
        L53:
            r2 = r3
            goto L8f
        L55:
            int r1 = r6.d()
            int r4 = r5.j()
            if (r1 > r4) goto L60
            goto L8f
        L60:
            int r1 = r6.f()
            if (r1 != 0) goto L67
            goto L53
        L67:
            int r1 = r5.j()
            int r2 = r6.j()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.d()
            int r2 = r6.d()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.j()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.f()
            float r6 = (float) r6
            float r2 = r5 / r6
        L8f:
            long r5 = ir.nasim.AbstractC13854gv7.a(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23528x44.h(ir.nasim.za3, ir.nasim.za3):long");
    }

    public static final float i() {
        return d;
    }

    public static final float j() {
        return b;
    }
}
