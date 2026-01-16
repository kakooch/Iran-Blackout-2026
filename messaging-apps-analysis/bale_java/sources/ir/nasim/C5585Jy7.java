package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Jy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C5585Jy7 {
    public static final C5585Jy7 b = g(AbstractC5117Hy7.b);
    private final AbstractC5117Hy7 a;

    /* renamed from: ir.nasim.Jy7$a */
    static class a implements UA2 {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // ir.nasim.UA2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(C9424Zw2 c9424Zw2) {
            if (c9424Zw2 == null) {
                a(0);
            }
            return Boolean.valueOf(!c9424Zw2.equals(PJ6.a.L));
        }
    }

    /* renamed from: ir.nasim.Jy7$b */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: ir.nasim.Jy7$c */
    private static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* renamed from: ir.nasim.Jy7$d */
    private enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    protected C5585Jy7(AbstractC5117Hy7 abstractC5117Hy7) {
        if (abstractC5117Hy7 == null) {
            a(6);
        }
        this.a = abstractC5117Hy7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5585Jy7.a(int):void");
    }

    private static void b(int i, InterfaceC3932Cy7 interfaceC3932Cy7, AbstractC5117Hy7 abstractC5117Hy7) {
        if (i <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(interfaceC3932Cy7) + "; substitution: " + o(abstractC5117Hy7));
    }

    public static KQ7 c(KQ7 kq7, InterfaceC3932Cy7 interfaceC3932Cy7) {
        if (kq7 == null) {
            a(33);
        }
        if (interfaceC3932Cy7 == null) {
            a(34);
        }
        if (!interfaceC3932Cy7.b()) {
            return d(kq7, interfaceC3932Cy7.c());
        }
        KQ7 kq72 = KQ7.OUT_VARIANCE;
        if (kq72 == null) {
            a(35);
        }
        return kq72;
    }

    public static KQ7 d(KQ7 kq7, KQ7 kq72) {
        if (kq7 == null) {
            a(36);
        }
        if (kq72 == null) {
            a(37);
        }
        KQ7 kq73 = KQ7.INVARIANT;
        if (kq7 == kq73) {
            if (kq72 == null) {
                a(38);
            }
            return kq72;
        }
        if (kq72 == kq73) {
            if (kq7 == null) {
                a(39);
            }
            return kq7;
        }
        if (kq7 == kq72) {
            if (kq72 == null) {
                a(40);
            }
            return kq72;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + kq7 + "' and projection kind '" + kq72 + "' cannot be combined");
    }

    private static d e(KQ7 kq7, KQ7 kq72) {
        KQ7 kq73 = KQ7.IN_VARIANCE;
        return (kq7 == kq73 && kq72 == KQ7.OUT_VARIANCE) ? d.OUT_IN_IN_POSITION : (kq7 == KQ7.OUT_VARIANCE && kq72 == kq73) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static C5585Jy7 f(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(5);
        }
        return g(AbstractC15082iy7.h(abstractC4099Dr3.K0(), abstractC4099Dr3.J0()));
    }

    public static C5585Jy7 g(AbstractC5117Hy7 abstractC5117Hy7) {
        if (abstractC5117Hy7 == null) {
            a(0);
        }
        return new C5585Jy7(abstractC5117Hy7);
    }

    public static C5585Jy7 h(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5117Hy7 abstractC5117Hy72) {
        if (abstractC5117Hy7 == null) {
            a(2);
        }
        if (abstractC5117Hy72 == null) {
            a(3);
        }
        return g(C20712sU1.h(abstractC5117Hy7, abstractC5117Hy72));
    }

    private static InterfaceC4356Eu i(InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC4356Eu == null) {
            a(31);
        }
        return !interfaceC4356Eu.M1(PJ6.a.L) ? interfaceC4356Eu : new C19116po2(interfaceC4356Eu, new a());
    }

    private static InterfaceC3932Cy7 l(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC22882vy7 interfaceC22882vy7, InterfaceC3932Cy7 interfaceC3932Cy72) {
        if (abstractC4099Dr3 == null) {
            a(24);
        }
        if (interfaceC3932Cy7 == null) {
            a(25);
        }
        if (interfaceC3932Cy72 == null) {
            a(26);
        }
        if (!abstractC4099Dr3.getAnnotations().M1(PJ6.a.L)) {
            if (interfaceC3932Cy7 == null) {
                a(27);
            }
            return interfaceC3932Cy7;
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = interfaceC3932Cy7.getType().K0();
        if (!(interfaceC13882gy7K0 instanceof C24592ys4)) {
            return interfaceC3932Cy7;
        }
        InterfaceC3932Cy7 interfaceC3932Cy7C = ((C24592ys4) interfaceC13882gy7K0).c();
        KQ7 kq7C = interfaceC3932Cy7C.c();
        d dVarE = e(interfaceC3932Cy72.c(), kq7C);
        d dVar = d.OUT_IN_IN_POSITION;
        return dVarE == dVar ? new C4400Ey7(interfaceC3932Cy7C.getType()) : (interfaceC22882vy7 != null && e(interfaceC22882vy7.m(), kq7C) == dVar) ? new C4400Ey7(interfaceC3932Cy7C.getType()) : interfaceC3932Cy7;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (AbstractC13659gc2.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    private InterfaceC3932Cy7 r(InterfaceC3932Cy7 interfaceC3932Cy7, int i) {
        AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
        KQ7 kq7C = interfaceC3932Cy7.c();
        if (type.K0().d() instanceof InterfaceC22882vy7) {
            return interfaceC3932Cy7;
        }
        XC6 xc6B = AbstractC24252yI6.b(type);
        AbstractC4099Dr3 abstractC4099Dr3P = xc6B != null ? m().p(xc6B, KQ7.INVARIANT) : null;
        AbstractC4099Dr3 abstractC4099Dr3B = AbstractC5351Iy7.b(type, s(type.K0().getParameters(), type.J0(), i), this.a.d(type.getAnnotations()));
        if ((abstractC4099Dr3B instanceof XC6) && (abstractC4099Dr3P instanceof XC6)) {
            abstractC4099Dr3B = AbstractC24252yI6.j((XC6) abstractC4099Dr3B, (XC6) abstractC4099Dr3P);
        }
        return new C4400Ey7(kq7C, abstractC4099Dr3B);
    }

    private List s(List list, List list2, int i) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) list.get(i2);
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) list2.get(i2);
            InterfaceC3932Cy7 interfaceC3932Cy7U = u(interfaceC3932Cy7, interfaceC22882vy7, i + 1);
            int i3 = b.a[e(interfaceC22882vy7.m(), interfaceC3932Cy7U.c()).ordinal()];
            if (i3 == 1 || i3 == 2) {
                interfaceC3932Cy7U = AbstractC7497Ry7.s(interfaceC22882vy7);
            } else if (i3 == 3) {
                KQ7 kq7M = interfaceC22882vy7.m();
                KQ7 kq7 = KQ7.INVARIANT;
                if (kq7M != kq7 && !interfaceC3932Cy7U.b()) {
                    interfaceC3932Cy7U = new C4400Ey7(kq7, interfaceC3932Cy7U.getType());
                }
            }
            if (interfaceC3932Cy7U != interfaceC3932Cy7) {
                z = true;
            }
            arrayList.add(interfaceC3932Cy7U);
        }
        return !z ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InterfaceC3932Cy7 u(InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC22882vy7 interfaceC22882vy7, int i) throws c {
        if (interfaceC3932Cy7 == null) {
            a(17);
        }
        b(i, interfaceC3932Cy7, this.a);
        if (interfaceC3932Cy7.b()) {
            return interfaceC3932Cy7;
        }
        AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
        if (type instanceof InterfaceC8438Vy7) {
            InterfaceC8438Vy7 interfaceC8438Vy7 = (InterfaceC8438Vy7) type;
            AbstractC18174oC7 origin = interfaceC8438Vy7.getOrigin();
            AbstractC4099Dr3 abstractC4099Dr3I0 = interfaceC8438Vy7.i0();
            InterfaceC3932Cy7 interfaceC3932Cy7U = u(new C4400Ey7(interfaceC3932Cy7.c(), origin), interfaceC22882vy7, i + 1);
            return new C4400Ey7(interfaceC3932Cy7U.c(), AbstractC8692Wy7.d(interfaceC3932Cy7U.getType().N0(), p(abstractC4099Dr3I0, interfaceC3932Cy7.c())));
        }
        if (!AbstractC21730u22.a(type) && !(type.N0() instanceof EG5)) {
            InterfaceC3932Cy7 interfaceC3932Cy7E = this.a.e(type);
            InterfaceC3932Cy7 interfaceC3932Cy7L = interfaceC3932Cy7E != null ? l(type, interfaceC3932Cy7E, interfaceC22882vy7, interfaceC3932Cy7) : null;
            KQ7 kq7C = interfaceC3932Cy7.c();
            if (interfaceC3932Cy7L == null && AbstractC7411Rp2.b(type) && !AbstractC10041ay7.b(type)) {
                AbstractC6200Mp2 abstractC6200Mp2A = AbstractC7411Rp2.a(type);
                int i2 = i + 1;
                InterfaceC3932Cy7 interfaceC3932Cy7U2 = u(new C4400Ey7(kq7C, abstractC6200Mp2A.S0()), interfaceC22882vy7, i2);
                InterfaceC3932Cy7 interfaceC3932Cy7U3 = u(new C4400Ey7(kq7C, abstractC6200Mp2A.T0()), interfaceC22882vy7, i2);
                return (interfaceC3932Cy7U2.getType() == abstractC6200Mp2A.S0() && interfaceC3932Cy7U3.getType() == abstractC6200Mp2A.T0()) ? interfaceC3932Cy7 : new C4400Ey7(interfaceC3932Cy7U2.c(), C4567Fr3.d(AbstractC5351Iy7.a(interfaceC3932Cy7U2.getType()), AbstractC5351Iy7.a(interfaceC3932Cy7U3.getType())));
            }
            if (!AbstractC19738qr3.t0(type) && !AbstractC4816Gr3.a(type)) {
                if (interfaceC3932Cy7L != null) {
                    d dVarE = e(kq7C, interfaceC3932Cy7L.c());
                    if (!AbstractC18794pG0.d(type)) {
                        int i3 = b.a[dVarE.ordinal()];
                        if (i3 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i3 == 2) {
                            return new C4400Ey7(KQ7.OUT_VARIANCE, type.K0().n().I());
                        }
                    }
                    InterfaceC4385Ex1 interfaceC4385Ex1A = AbstractC10041ay7.a(type);
                    if (interfaceC3932Cy7L.b()) {
                        return interfaceC3932Cy7L;
                    }
                    AbstractC4099Dr3 abstractC4099Dr3M = interfaceC4385Ex1A != null ? interfaceC4385Ex1A.M(interfaceC3932Cy7L.getType()) : AbstractC7497Ry7.q(interfaceC3932Cy7L.getType(), type.L0());
                    if (!type.getAnnotations().isEmpty()) {
                        abstractC4099Dr3M = AbstractC7731Sy7.l(abstractC4099Dr3M, new C5840Lb1(abstractC4099Dr3M.getAnnotations(), i(this.a.d(type.getAnnotations()))));
                    }
                    if (dVarE == d.NO_CONFLICT) {
                        kq7C = d(kq7C, interfaceC3932Cy7L.c());
                    }
                    return new C4400Ey7(kq7C, abstractC4099Dr3M);
                }
                interfaceC3932Cy7 = r(interfaceC3932Cy7, i);
                if (interfaceC3932Cy7 == null) {
                    a(23);
                }
            }
        }
        return interfaceC3932Cy7;
    }

    public AbstractC5117Hy7 j() {
        AbstractC5117Hy7 abstractC5117Hy7 = this.a;
        if (abstractC5117Hy7 == null) {
            a(7);
        }
        return abstractC5117Hy7;
    }

    public boolean k() {
        return this.a.f();
    }

    public C5585Jy7 m() {
        AbstractC5117Hy7 abstractC5117Hy7 = this.a;
        return ((abstractC5117Hy7 instanceof C13957h63) && abstractC5117Hy7.b()) ? new C5585Jy7(new C13957h63(((C13957h63) this.a).i(), ((C13957h63) this.a).h(), false)) : this;
    }

    public AbstractC4099Dr3 n(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7) {
        if (abstractC4099Dr3 == null) {
            a(8);
        }
        if (kq7 == null) {
            a(9);
        }
        if (k()) {
            if (abstractC4099Dr3 == null) {
                a(10);
            }
            return abstractC4099Dr3;
        }
        try {
            AbstractC4099Dr3 type = u(new C4400Ey7(kq7, abstractC4099Dr3), null, 0).getType();
            if (type == null) {
                a(11);
            }
            return type;
        } catch (c e) {
            XC6 xc6J = AbstractC14230ha2.j(e.getMessage());
            if (xc6J == null) {
                a(12);
            }
            return xc6J;
        }
    }

    public AbstractC4099Dr3 p(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7) {
        if (abstractC4099Dr3 == null) {
            a(13);
        }
        if (kq7 == null) {
            a(14);
        }
        InterfaceC3932Cy7 interfaceC3932Cy7Q = q(new C4400Ey7(kq7, j().g(abstractC4099Dr3, kq7)));
        if (interfaceC3932Cy7Q == null) {
            return null;
        }
        return interfaceC3932Cy7Q.getType();
    }

    public InterfaceC3932Cy7 q(InterfaceC3932Cy7 interfaceC3932Cy7) {
        if (interfaceC3932Cy7 == null) {
            a(15);
        }
        InterfaceC3932Cy7 interfaceC3932Cy7T = t(interfaceC3932Cy7);
        return (this.a.a() || this.a.b()) ? AbstractC17021mG0.c(interfaceC3932Cy7T, this.a.b()) : interfaceC3932Cy7T;
    }

    public InterfaceC3932Cy7 t(InterfaceC3932Cy7 interfaceC3932Cy7) {
        if (interfaceC3932Cy7 == null) {
            a(16);
        }
        if (k()) {
            return interfaceC3932Cy7;
        }
        try {
            return u(interfaceC3932Cy7, null, 0);
        } catch (c unused) {
            return null;
        }
    }
}
