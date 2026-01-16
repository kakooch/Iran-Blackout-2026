package ir.nasim;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final class FE1 implements InterfaceC24572yq4 {
    private final GT4 a;
    private final EnumC24286yM4 b;

    public FE1(GT4 gt4, EnumC24286yM4 enumC24286yM4) {
        this.a = gt4;
        this.b = enumC24286yM4;
    }

    private final float b(long j) {
        return Float.intBitsToFloat((int) (this.b == EnumC24286yM4.b ? j >> 32 : j & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long H0(long j, long j2, int i) {
        if (!AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.b()) || b(j2) == 0.0f) {
            return ZG4.b.c();
        }
        throw new CancellationException("Scroll cancelled");
    }

    public final long a(long j, EnumC24286yM4 enumC24286yM4) {
        return enumC24286yM4 == EnumC24286yM4.a ? C17718nR7.e(j, 0.0f, 0.0f, 2, null) : C17718nR7.e(j, 0.0f, 0.0f, 1, null);
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public Object i0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return C17718nR7.b(a(j2, this.b));
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long s1(long j, int i) {
        if (!AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.c()) || Math.abs(this.a.w()) <= 1.0E-6d) {
            return ZG4.b.c();
        }
        float fW = this.a.w() * this.a.I();
        float fH = ((this.a.C().h() + this.a.C().l()) * (-Math.signum(this.a.w()))) + fW;
        if (this.a.w() > 0.0f) {
            fH = fW;
            fW = fH;
        }
        EnumC24286yM4 enumC24286yM4 = this.b;
        EnumC24286yM4 enumC24286yM42 = EnumC24286yM4.b;
        float fIntBitsToFloat = -this.a.f(-AbstractC23053wG5.l(Float.intBitsToFloat((int) (enumC24286yM4 == enumC24286yM42 ? j >> 32 : j & 4294967295L)), fW, fH));
        float fIntBitsToFloat2 = this.b == enumC24286yM42 ? fIntBitsToFloat : Float.intBitsToFloat((int) (j >> 32));
        if (this.b != EnumC24286yM4.a) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return ZG4.f(j, fIntBitsToFloat2, fIntBitsToFloat);
    }
}
