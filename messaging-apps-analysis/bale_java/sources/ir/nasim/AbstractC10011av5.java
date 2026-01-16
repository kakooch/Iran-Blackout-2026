package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C4081Dp3;

/* renamed from: ir.nasim.av5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10011av5 {
    private static final float a = C9409Zu5.a.a();
    private static final float b = C17784nZ1.q(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
    private static final float c = C17784nZ1.q(40);
    private static final C11397cw1 d = new C11397cw1(0.2f, 0.0f, 0.8f, 1.0f);
    private static final C11397cw1 e = new C11397cw1(0.4f, 0.0f, 1.0f, 1.0f);
    private static final C11397cw1 f = new C11397cw1(0.0f, 0.0f, 0.65f, 1.0f);
    private static final C11397cw1 g = new C11397cw1(0.1f, 0.0f, 0.45f, 1.0f);
    private static final C11397cw1 h = new C11397cw1(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: ir.nasim.av5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ long f;
        final /* synthetic */ C23815xZ6 g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, long j, C23815xZ6 c23815xZ6, long j2) {
            super(1);
            this.e = f;
            this.f = j;
            this.g = c23815xZ6;
            this.h = j2;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            float f = this.e * 360.0f;
            AbstractC10011av5.s(interfaceC17460n02, this.f, this.g);
            AbstractC10011av5.t(interfaceC17460n02, 270.0f, f, this.h, this.g);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ float e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ long i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, androidx.compose.ui.e eVar, long j, float f2, long j2, int i, int i2, int i3) {
            super(2);
            this.e = f;
            this.f = eVar;
            this.g = j;
            this.h = f2;
            this.i = j2;
            this.j = i;
            this.k = i2;
            this.l = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC10011av5.a(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ C23815xZ6 f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ InterfaceC9664aL6 i;
        final /* synthetic */ InterfaceC9664aL6 j;
        final /* synthetic */ InterfaceC9664aL6 k;
        final /* synthetic */ InterfaceC9664aL6 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, C23815xZ6 c23815xZ6, float f, long j2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64) {
            super(1);
            this.e = j;
            this.f = c23815xZ6;
            this.g = f;
            this.h = j2;
            this.i = interfaceC9664aL6;
            this.j = interfaceC9664aL62;
            this.k = interfaceC9664aL63;
            this.l = interfaceC9664aL64;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            AbstractC10011av5.s(interfaceC17460n02, this.e, this.f);
            AbstractC10011av5.u(interfaceC17460n02, AbstractC10011av5.e(this.k) + (((AbstractC10011av5.f(this.i) * 216.0f) % 360.0f) - 90.0f) + AbstractC10011av5.c(this.l), this.g, Math.abs(AbstractC10011av5.d(this.j) - AbstractC10011av5.e(this.k)), this.h, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ long f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.ui.e eVar, long j, float f, long j2, int i, int i2, int i3) {
            super(2);
            this.e = eVar;
            this.f = j;
            this.g = f;
            this.h = j2;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC10011av5.b(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final void a(C4081Dp3.b bVar) {
            bVar.d(1332);
            bVar.e(bVar.f(Float.valueOf(0.0f), 0), AbstractC10011av5.h);
            bVar.f(Float.valueOf(290.0f), 666);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C4081Dp3.b) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        public final void a(C4081Dp3.b bVar) {
            bVar.d(1332);
            bVar.e(bVar.f(Float.valueOf(0.0f), 666), AbstractC10011av5.h);
            bVar.f(Float.valueOf(290.0f), bVar.b());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C4081Dp3.b) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ int f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j, int i, float f, long j2) {
            super(1);
            this.e = j;
            this.f = i;
            this.g = f;
            this.h = j2;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            float fG = OD6.g(interfaceC17460n02.d());
            AbstractC10011av5.w(interfaceC17460n02, this.e, fG, this.f);
            AbstractC10011av5.v(interfaceC17460n02, 0.0f, this.g, this.h, fG, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ float e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(float f, androidx.compose.ui.e eVar, long j, long j2, int i, int i2, int i3) {
            super(2);
            this.e = f;
            this.f = eVar;
            this.g = j;
            this.h = j2;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC10011av5.g(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.av5$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ float e;

        /* renamed from: ir.nasim.av5$i$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC21430te5 e;
            final /* synthetic */ int f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC21430te5 abstractC21430te5, int i) {
                super(1);
                this.e = abstractC21430te5;
                this.f = i;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC21430te5.a.h(aVar, this.e, 0, -this.f, 0.0f, 4, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(float f) {
            super(3);
            this.e = f;
        }

        public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
            int iB0 = interfaceC12377eW3.B0(this.e);
            int i = iB0 * 2;
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, 0, i));
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0() - i, null, new a(abstractC21430te5L0, iB0), 4, null);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(float r26, androidx.compose.ui.e r27, long r28, float r30, long r31, int r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10011av5.a(float, androidx.compose.ui.e, long, float, long, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(androidx.compose.ui.e r33, long r34, float r36, long r37, int r39, ir.nasim.InterfaceC22053ub1 r40, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10011av5.b(androidx.compose.ui.e, long, float, long, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(float r25, androidx.compose.ui.e r26, long r27, long r29, int r31, ir.nasim.InterfaceC22053ub1 r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10011av5.g(float, androidx.compose.ui.e, long, long, int, ir.nasim.ub1, int, int):void");
    }

    private static final void r(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, long j2, C23815xZ6 c23815xZ6) {
        float f4 = 2;
        float f5 = c23815xZ6.f() / f4;
        float fI = OD6.i(interfaceC17460n02.d()) - (f4 * f5);
        InterfaceC17460n02.u1(interfaceC17460n02, j2, f2, f3, false, AbstractC10836cH4.a(f5, f5), UD6.a(fI, fI), 0.0f, c23815xZ6, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InterfaceC17460n02 interfaceC17460n02, long j2, C23815xZ6 c23815xZ6) {
        r(interfaceC17460n02, 0.0f, 360.0f, j2, c23815xZ6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, long j2, C23815xZ6 c23815xZ6) {
        r(interfaceC17460n02, f2, f3, j2, c23815xZ6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, float f4, long j2, C23815xZ6 c23815xZ6) {
        r(interfaceC17460n02, f2 + (AbstractC24405yZ6.e(c23815xZ6.b(), AbstractC24405yZ6.a.a()) ? 0.0f : ((f3 / C17784nZ1.q(c / 2)) * 57.29578f) / 2.0f), Math.max(f4, 0.1f), j2, c23815xZ6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, long j2, float f4, int i2) {
        float fI = OD6.i(interfaceC17460n02.d());
        float fG = OD6.g(interfaceC17460n02.d());
        float f5 = 2;
        float f6 = fG / f5;
        boolean z = interfaceC17460n02.getLayoutDirection() == EnumC12613eu3.a;
        float f7 = (z ? f2 : 1.0f - f3) * fI;
        float f8 = (z ? f3 : 1.0f - f2) * fI;
        if (AbstractC24405yZ6.e(i2, AbstractC24405yZ6.a.a()) || fG > fI) {
            InterfaceC17460n02.V0(interfaceC17460n02, j2, AbstractC10836cH4.a(f7, f6), AbstractC10836cH4.a(f8, f6), f4, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f9 = f4 / f5;
        InterfaceC10351bW0 interfaceC10351bW0B = AbstractC22457vG5.b(f9, fI - f9);
        float fFloatValue = ((Number) AbstractC23053wG5.p(Float.valueOf(f7), interfaceC10351bW0B)).floatValue();
        float fFloatValue2 = ((Number) AbstractC23053wG5.p(Float.valueOf(f8), interfaceC10351bW0B)).floatValue();
        if (Math.abs(f3 - f2) > 0.0f) {
            InterfaceC17460n02.V0(interfaceC17460n02, j2, AbstractC10836cH4.a(fFloatValue, f6), AbstractC10836cH4.a(fFloatValue2, f6), f4, i2, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(InterfaceC17460n02 interfaceC17460n02, long j2, float f2, int i2) {
        v(interfaceC17460n02, 0.0f, 1.0f, j2, f2, i2);
    }

    public static final androidx.compose.ui.e x(androidx.compose.ui.e eVar) {
        float fQ = C17784nZ1.q(10);
        return androidx.compose.foundation.layout.q.k(AbstractC6919Pn6.c(androidx.compose.ui.layout.b.a(eVar, new i(fQ)), true, j.e), 0.0f, fQ, 1, null);
    }

    /* renamed from: ir.nasim.av5$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        public static final j e = new j();

        j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
        }
    }
}
