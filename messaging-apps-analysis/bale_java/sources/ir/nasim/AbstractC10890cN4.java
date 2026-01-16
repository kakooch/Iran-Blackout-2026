package ir.nasim;

import ir.nasim.AbstractC10274bN4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.cN4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10890cN4 {
    public static final void a(InterfaceC17460n02 interfaceC17460n02, AbstractC10274bN4 abstractC10274bN4, AbstractC12520el0 abstractC12520el0, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        V05 v05B;
        if (abstractC10274bN4 instanceof AbstractC10274bN4.b) {
            CK5 ck5B = ((AbstractC10274bN4.b) abstractC10274bN4).b();
            interfaceC17460n02.R(abstractC12520el0, g(ck5B), e(ck5B), f, abstractC18051o02, abstractC24975zX0, i);
            return;
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.c) {
            AbstractC10274bN4.c cVar = (AbstractC10274bN4.c) abstractC10274bN4;
            v05B = cVar.c();
            if (v05B == null) {
                I46 i46B = cVar.b();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (i46B.b() >> 32));
                interfaceC17460n02.r0(abstractC12520el0, h(i46B), f(i46B), AbstractC8567Wn1.b((Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, abstractC18051o02, abstractC24975zX0, i);
                return;
            }
        } else {
            if (!(abstractC10274bN4 instanceof AbstractC10274bN4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            v05B = ((AbstractC10274bN4.a) abstractC10274bN4).b();
        }
        interfaceC17460n02.X(v05B, abstractC12520el0, f, abstractC18051o02, abstractC24975zX0, i);
    }

    public static /* synthetic */ void b(InterfaceC17460n02 interfaceC17460n02, AbstractC10274bN4 abstractC10274bN4, AbstractC12520el0 abstractC12520el0, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            abstractC18051o02 = C8568Wn2.a;
        }
        AbstractC18051o02 abstractC18051o022 = abstractC18051o02;
        if ((i2 & 16) != 0) {
            abstractC24975zX0 = null;
        }
        AbstractC24975zX0 abstractC24975zX02 = abstractC24975zX0;
        if ((i2 & 32) != 0) {
            i = InterfaceC17460n02.i0.a();
        }
        a(interfaceC17460n02, abstractC10274bN4, abstractC12520el0, f2, abstractC18051o022, abstractC24975zX02, i);
    }

    public static final void c(InterfaceC17460n02 interfaceC17460n02, AbstractC10274bN4 abstractC10274bN4, long j, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        V05 v05B;
        if (abstractC10274bN4 instanceof AbstractC10274bN4.b) {
            CK5 ck5B = ((AbstractC10274bN4.b) abstractC10274bN4).b();
            interfaceC17460n02.m1(j, g(ck5B), e(ck5B), f, abstractC18051o02, abstractC24975zX0, i);
            return;
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.c) {
            AbstractC10274bN4.c cVar = (AbstractC10274bN4.c) abstractC10274bN4;
            v05B = cVar.c();
            if (v05B == null) {
                I46 i46B = cVar.b();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (i46B.b() >> 32));
                interfaceC17460n02.v1(j, h(i46B), f(i46B), AbstractC8567Wn1.b((Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), abstractC18051o02, f, abstractC24975zX0, i);
                return;
            }
        } else {
            if (!(abstractC10274bN4 instanceof AbstractC10274bN4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            v05B = ((AbstractC10274bN4.a) abstractC10274bN4).b();
        }
        interfaceC17460n02.Q0(v05B, j, f, abstractC18051o02, abstractC24975zX0, i);
    }

    private static final long e(CK5 ck5) {
        float fJ = ck5.j() - ck5.i();
        float fE = ck5.e() - ck5.l();
        return OD6.d((Float.floatToRawIntBits(fE) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32));
    }

    private static final long f(I46 i46) {
        float fJ = i46.j();
        float fD = i46.d();
        return OD6.d((Float.floatToRawIntBits(fJ) << 32) | (Float.floatToRawIntBits(fD) & 4294967295L));
    }

    private static final long g(CK5 ck5) {
        float fI = ck5.i();
        float fL = ck5.l();
        return ZG4.e((Float.floatToRawIntBits(fI) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L));
    }

    private static final long h(I46 i46) {
        float fE = i46.e();
        float fG = i46.g();
        return ZG4.e((Float.floatToRawIntBits(fE) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
    }
}
