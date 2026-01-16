package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10274bN4;

/* renamed from: ir.nasim.fX1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
final class C12993fX1 implements InterfaceC10031ax6 {
    private final float a;

    public /* synthetic */ C12993fX1(float f, ED1 ed1) {
        this(f);
    }

    @Override // ir.nasim.InterfaceC10031ax6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC10274bN4.a a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
        AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
        AbstractC13042fc3.i(wh1, "density");
        V05 v05A = AbstractC21611tq.a();
        int i = (int) (j >> 32);
        int iD = AbstractC20723sV3.d(Float.intBitsToFloat(i) / wh1.w1(this.a));
        float fIntBitsToFloat = Float.intBitsToFloat(i) / iD;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        long jD = OD6.d((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat / 2) << 32));
        for (int i2 = 0; i2 < iD; i2++) {
            V05.o(v05A, FK5.b(ZG4.e((Float.floatToRawIntBits(i2 * fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), jD), null, 2, null);
        }
        v05A.close();
        return new AbstractC10274bN4.a(v05A);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C12993fX1) && C17784nZ1.s(this.a, ((C12993fX1) obj).a);
    }

    public int hashCode() {
        return C17784nZ1.t(this.a);
    }

    public String toString() {
        return "DottedShape(step=" + C17784nZ1.u(this.a) + Separators.RPAREN;
    }

    private C12993fX1(float f) {
        this.a = f;
    }
}
