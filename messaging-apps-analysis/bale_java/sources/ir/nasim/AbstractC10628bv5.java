package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C4081Dp3;

/* renamed from: ir.nasim.bv5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10628bv5 {
    private static final float a;
    private static final androidx.compose.ui.e b;
    private static final float c;
    private static final float d;
    private static final float e;
    private static final C11397cw1 f;
    private static final C11397cw1 g;
    private static final C11397cw1 h;
    private static final C11397cw1 i;
    private static final C11397cw1 j;

    /* renamed from: ir.nasim.bv5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ C23815xZ6 f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ InterfaceC9664aL6 h;
        final /* synthetic */ InterfaceC9664aL6 i;
        final /* synthetic */ InterfaceC9664aL6 j;
        final /* synthetic */ float k;
        final /* synthetic */ long l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, C23815xZ6 c23815xZ6, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64, float f, long j2) {
            super(1);
            this.e = j;
            this.f = c23815xZ6;
            this.g = interfaceC9664aL6;
            this.h = interfaceC9664aL62;
            this.i = interfaceC9664aL63;
            this.j = interfaceC9664aL64;
            this.k = f;
            this.l = j2;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            AbstractC10628bv5.g(interfaceC17460n02, this.e, this.f);
            AbstractC10628bv5.h(interfaceC17460n02, ((Number) this.i.getValue()).floatValue() + (((((Number) this.g.getValue()).floatValue() * 216.0f) % 360.0f) - 90.0f) + ((Number) this.j.getValue()).floatValue(), this.k, Math.abs(((Number) this.h.getValue()).floatValue() - ((Number) this.i.getValue()).floatValue()), this.l, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bv5$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ long f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, long j, float f, long j2, int i, int i2, int i3) {
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
            AbstractC10628bv5.a(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bv5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final void a(C4081Dp3.b bVar) {
            bVar.d(1332);
            bVar.e(bVar.f(Float.valueOf(0.0f), 0), AbstractC10628bv5.j);
            bVar.f(Float.valueOf(290.0f), 666);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C4081Dp3.b) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bv5$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final void a(C4081Dp3.b bVar) {
            bVar.d(1332);
            bVar.e(bVar.f(Float.valueOf(0.0f), 666), AbstractC10628bv5.j);
            bVar.f(Float.valueOf(290.0f), bVar.b());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C4081Dp3.b) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bv5$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final e e = new e();

        /* renamed from: ir.nasim.bv5$e$a */
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

        e() {
            super(3);
        }

        public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
            int iB0 = interfaceC12377eW3.B0(AbstractC10628bv5.a);
            int i = iB0 * 2;
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, 0, i));
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0() - i, null, new a(abstractC21430te5L0, iB0), 4, null);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
        }
    }

    static {
        float fQ = C17784nZ1.q(10);
        a = fQ;
        b = androidx.compose.foundation.layout.q.k(AbstractC6919Pn6.c(androidx.compose.ui.layout.b.a(androidx.compose.ui.e.a, e.e), true, f.e), 0.0f, fQ, 1, null);
        c = C17784nZ1.q(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
        C11391cv5 c11391cv5 = C11391cv5.a;
        d = c11391cv5.e();
        e = C17784nZ1.q(c11391cv5.c() - C17784nZ1.q(c11391cv5.e() * 2));
        f = new C11397cw1(0.2f, 0.0f, 0.8f, 1.0f);
        g = new C11397cw1(0.4f, 0.0f, 1.0f, 1.0f);
        h = new C11397cw1(0.0f, 0.0f, 0.65f, 1.0f);
        i = new C11397cw1(0.1f, 0.0f, 0.45f, 1.0f);
        j = new C11397cw1(0.4f, 0.0f, 0.2f, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(androidx.compose.ui.e r36, long r37, float r39, long r40, int r42, ir.nasim.InterfaceC22053ub1 r43, int r44, int r45) {
        /*
            Method dump skipped, instructions count: 793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10628bv5.a(androidx.compose.ui.e, long, float, long, int, ir.nasim.ub1, int, int):void");
    }

    private static final void f(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, long j2, C23815xZ6 c23815xZ6) {
        float f4 = 2;
        float f5 = c23815xZ6.f() / f4;
        float fI = OD6.i(interfaceC17460n02.d()) - (f4 * f5);
        InterfaceC17460n02.u1(interfaceC17460n02, j2, f2, f3, false, AbstractC10836cH4.a(f5, f5), UD6.a(fI, fI), 0.0f, c23815xZ6, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC17460n02 interfaceC17460n02, long j2, C23815xZ6 c23815xZ6) {
        f(interfaceC17460n02, 0.0f, 360.0f, j2, c23815xZ6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC17460n02 interfaceC17460n02, float f2, float f3, float f4, long j2, C23815xZ6 c23815xZ6) {
        f(interfaceC17460n02, f2 + (AbstractC24405yZ6.e(c23815xZ6.b(), AbstractC24405yZ6.a.a()) ? 0.0f : ((f3 / C17784nZ1.q(e / 2)) * 57.29578f) / 2.0f), Math.max(f4, 0.1f), j2, c23815xZ6);
    }

    /* renamed from: ir.nasim.bv5$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
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
