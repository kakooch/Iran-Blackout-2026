package ir.nasim;

import ir.nasim.AbstractC10274bN4;

/* renamed from: ir.nasim.vK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22490vK2 {
    public static final void a(InterfaceC17460n02 interfaceC17460n02, C21226tK2 c21226tK2) {
        c21226tK2.h(interfaceC17460n02.z1().e(), interfaceC17460n02.z1().i());
    }

    public static final void b(C21226tK2 c21226tK2, AbstractC10274bN4 abstractC10274bN4) {
        if (abstractC10274bN4 instanceof AbstractC10274bN4.b) {
            AbstractC10274bN4.b bVar = (AbstractC10274bN4.b) abstractC10274bN4;
            float fI = bVar.b().i();
            float fL = bVar.b().l();
            long jE = ZG4.e((Float.floatToRawIntBits(fI) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L));
            CK5 ck5B = bVar.b();
            float fJ = ck5B.j() - ck5B.i();
            CK5 ck5B2 = bVar.b();
            float fE = ck5B2.e() - ck5B2.l();
            c21226tK2.S(jE, OD6.d((Float.floatToRawIntBits(fE) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32)));
            return;
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.a) {
            c21226tK2.P(((AbstractC10274bN4.a) abstractC10274bN4).b());
            return;
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.c) {
            AbstractC10274bN4.c cVar = (AbstractC10274bN4.c) abstractC10274bN4;
            if (cVar.c() != null) {
                c21226tK2.P(cVar.c());
                return;
            }
            I46 i46B = cVar.b();
            float fE2 = i46B.e();
            float fG = i46B.g();
            long jE2 = ZG4.e((Float.floatToRawIntBits(fE2) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
            float fJ2 = i46B.j();
            float fD = i46B.d();
            c21226tK2.X(jE2, OD6.d((Float.floatToRawIntBits(fD) & 4294967295L) | (Float.floatToRawIntBits(fJ2) << 32)), Float.intBitsToFloat((int) (i46B.b() >> 32)));
        }
    }
}
