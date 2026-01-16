package ir.nasim;

/* renamed from: ir.nasim.du3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12000du3 {
    public static final CK5 a(InterfaceC11379cu3 interfaceC11379cu3) {
        CK5 ck5W;
        InterfaceC11379cu3 interfaceC11379cu3O0 = interfaceC11379cu3.o0();
        return (interfaceC11379cu3O0 == null || (ck5W = InterfaceC11379cu3.W(interfaceC11379cu3O0, interfaceC11379cu3, false, 2, null)) == null) ? new CK5(0.0f, 0.0f, (int) (interfaceC11379cu3.a() >> 32), (int) (interfaceC11379cu3.a() & 4294967295L)) : ck5W;
    }

    public static final CK5 b(InterfaceC11379cu3 interfaceC11379cu3) {
        return InterfaceC11379cu3.W(d(interfaceC11379cu3), interfaceC11379cu3, false, 2, null);
    }

    public static final CK5 c(InterfaceC11379cu3 interfaceC11379cu3) {
        InterfaceC11379cu3 interfaceC11379cu3D = d(interfaceC11379cu3);
        float fA = (int) (interfaceC11379cu3D.a() >> 32);
        float fA2 = (int) (interfaceC11379cu3D.a() & 4294967295L);
        CK5 ck5W = InterfaceC11379cu3.W(interfaceC11379cu3D, interfaceC11379cu3, false, 2, null);
        float fI = ck5W.i();
        if (fI < 0.0f) {
            fI = 0.0f;
        }
        if (fI > fA) {
            fI = fA;
        }
        float fL = ck5W.l();
        if (fL < 0.0f) {
            fL = 0.0f;
        }
        if (fL > fA2) {
            fL = fA2;
        }
        float fJ = ck5W.j();
        if (fJ < 0.0f) {
            fJ = 0.0f;
        }
        if (fJ <= fA) {
            fA = fJ;
        }
        float fE = ck5W.e();
        float f = fE >= 0.0f ? fE : 0.0f;
        if (f <= fA2) {
            fA2 = f;
        }
        if (fI == fA || fL == fA2) {
            return CK5.e.a();
        }
        long jA0 = interfaceC11379cu3D.a0(ZG4.e((Float.floatToRawIntBits(fI) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L)));
        long jA02 = interfaceC11379cu3D.a0(ZG4.e((Float.floatToRawIntBits(fL) & 4294967295L) | (Float.floatToRawIntBits(fA) << 32)));
        long jA03 = interfaceC11379cu3D.a0(ZG4.e((Float.floatToRawIntBits(fA) << 32) | (Float.floatToRawIntBits(fA2) & 4294967295L)));
        long jA04 = interfaceC11379cu3D.a0(ZG4.e((Float.floatToRawIntBits(fA2) & 4294967295L) | (Float.floatToRawIntBits(fI) << 32)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jA0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jA02 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jA04 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jA03 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jA0 & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jA02 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jA04 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jA03 & 4294967295L));
        return new CK5(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final InterfaceC11379cu3 d(InterfaceC11379cu3 interfaceC11379cu3) {
        InterfaceC11379cu3 interfaceC11379cu32;
        InterfaceC11379cu3 interfaceC11379cu3O0 = interfaceC11379cu3.o0();
        while (true) {
            InterfaceC11379cu3 interfaceC11379cu33 = interfaceC11379cu3O0;
            interfaceC11379cu32 = interfaceC11379cu3;
            interfaceC11379cu3 = interfaceC11379cu33;
            if (interfaceC11379cu3 == null) {
                break;
            }
            interfaceC11379cu3O0 = interfaceC11379cu3.o0();
        }
        XA4 xa4 = interfaceC11379cu32 instanceof XA4 ? (XA4) interfaceC11379cu32 : null;
        if (xa4 == null) {
            return interfaceC11379cu32;
        }
        XA4 xa4L2 = xa4.L2();
        while (true) {
            XA4 xa42 = xa4L2;
            XA4 xa43 = xa4;
            xa4 = xa42;
            if (xa4 == null) {
                return xa43;
            }
            xa4L2 = xa4.L2();
        }
    }

    public static final long e(InterfaceC11379cu3 interfaceC11379cu3) {
        return interfaceC11379cu3.p0(ZG4.b.c());
    }

    public static final long f(InterfaceC11379cu3 interfaceC11379cu3) {
        return interfaceC11379cu3.a0(ZG4.b.c());
    }

    public static final long g(InterfaceC11379cu3 interfaceC11379cu3) {
        return interfaceC11379cu3.u(ZG4.b.c());
    }
}
