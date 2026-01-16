package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC11912dl4;
import java.util.List;

/* renamed from: ir.nasim.dl4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11912dl4 {

    /* renamed from: ir.nasim.dl4$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C13160fl4 a;
        final /* synthetic */ EV4 b;
        final /* synthetic */ float c;

        a(C13160fl4 c13160fl4, EV4 ev4, float f) {
            this.a = c13160fl4;
            this.b = ev4;
            this.c = f;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                TU.m(this.b, this.a.b(), null, this.c, 0.0f, 0.0f, null, interfaceC22053ub1, 0, 116);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dl4$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C13160fl4 a;

        b(C13160fl4 c13160fl4) {
            this.a = c13160fl4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String str = Separators.AT + this.a.c().b();
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9105Ym7.b(str, androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(4), 0.0f, 0.0f, 13, null), g10.a(interfaceC22053ub1, i2).z(), 0L, null, null, null, 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 48, 3120, 55288);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dl4$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ XV4 a;

        c(XV4 xv4) {
            this.a = xv4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11912dl4.h((C13160fl4) this.a.f(), FV4.c(AbstractC21822uB5.avatar_placeholder, interfaceC22053ub1, 0), 0.0f, 0.0f, 0.0f, null, interfaceC22053ub1, 0, 60);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dl4$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ List a;

        /* renamed from: ir.nasim.dl4$d$a */
        public static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            public a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.dl4$d$b */
        public static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(UA2 ua2, List list) {
                super(1);
                this.e = ua2;
                this.f = list;
            }

            public final Object a(int i) {
                return this.e.invoke(this.f.get(i));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* renamed from: ir.nasim.dl4$d$c */
        public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list) {
                super(4);
                this.e = list;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 6) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                XV4 xv4 = (XV4) this.e.get(i);
                interfaceC22053ub1.W(-598222740);
                AbstractC11912dl4.h((C13160fl4) xv4.f(), FV4.c(AbstractC21822uB5.avatar_placeholder, interfaceC22053ub1, 0), 0.0f, 0.0f, 0.0f, null, interfaceC22053ub1, 0, 60);
                interfaceC22053ub1.Q();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        d(List list) {
            this.a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$items");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            interfaceC15069ix3.a(list.size(), null, new b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-1334124257);
            boolean zD = interfaceC22053ub1.D(this.a);
            final List list = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.el4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC11912dl4.d.c(list, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 511);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(ir.nasim.C13160fl4 r36, ir.nasim.EV4 r37, float r38, float r39, float r40, ir.nasim.UA2 r41, ir.nasim.InterfaceC22053ub1 r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11912dl4.h(ir.nasim.fl4, ir.nasim.EV4, float, float, float, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(UA2 ua2, C13160fl4 c13160fl4) {
        ua2.invoke(Integer.valueOf(c13160fl4.c().a()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(C13160fl4 c13160fl4, EV4 ev4, float f, float f2, float f3, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        h(c13160fl4, ev4, f, f2, f3, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void l(final XV4 xv4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(xv4, "pair");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1202366644);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(xv4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(xv4.e()), AbstractC19242q11.e(-1475626356, true, new c(xv4), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bl4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC11912dl4.m(xv4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(XV4 xv4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(xv4, "$pair");
        l(xv4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void n(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1196423893);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC23384wp6 interfaceC23384wp6A = new C13751gl4().a();
            interfaceC22053ub1J.W(-509865711);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Wk4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AbstractC11912dl4.o((XV4) obj));
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1325820395, true, new d(AbstractC11342cq6.K(AbstractC11342cq6.r(interfaceC23384wp6A, (UA2) objB))), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Xk4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC11912dl4.p(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "it");
        return xv4.e() == EnumC12613eu3.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        n(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e q(androidx.compose.ui.e eVar, final float f, final float f2, final long j) {
        AbstractC13042fc3.i(eVar, "$this$customBoarderColor");
        return eVar.i(androidx.compose.ui.draw.b.b(eVar, new UA2() { // from class: ir.nasim.cl4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC11912dl4.r(j, f, f2, (InterfaceC17460n02) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(long j, float f, float f2, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        s(j, interfaceC17460n02.w1(f), interfaceC17460n02.w1(f2), interfaceC17460n02);
        return C19938rB7.a;
    }

    private static final void s(long j, float f, float f2, InterfaceC17460n02 interfaceC17460n02) {
        float f3;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        if (interfaceC17460n02.getLayoutDirection() == EnumC12613eu3.b) {
            fIntBitsToFloat -= f2;
            f3 = 0.0f;
        } else {
            f3 = f2;
        }
        float f4 = fIntBitsToFloat2 - (f / 2);
        InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(f4) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), f, 0, null, 0.0f, null, 0, 496, null);
    }
}
