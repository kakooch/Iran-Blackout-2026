package ir.nasim;

/* renamed from: ir.nasim.Gn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4783Gn6 {
    private static final CK5 a = new CK5(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final boolean a(CK5 ck5, long j) {
        float fI = ck5.i();
        float fJ = ck5.j();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (fI <= fIntBitsToFloat && fIntBitsToFloat <= fJ) {
            float fL = ck5.l();
            float fE = ck5.e();
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
            if (fL <= fIntBitsToFloat2 && fIntBitsToFloat2 <= fE) {
                return true;
            }
        }
        return false;
    }

    public static final CK5 b(InterfaceC11379cu3 interfaceC11379cu3) {
        CK5 ck5C = AbstractC12000du3.c(interfaceC11379cu3);
        return FK5.a(interfaceC11379cu3.M(ck5C.m()), interfaceC11379cu3.M(ck5C.g()));
    }
}
