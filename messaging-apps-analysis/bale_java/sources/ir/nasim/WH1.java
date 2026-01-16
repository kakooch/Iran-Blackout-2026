package ir.nasim;

/* loaded from: classes2.dex */
public interface WH1 extends InterfaceC23430wu2 {
    default int A1(long j) {
        return Math.round(I0(j));
    }

    default int B0(float f) {
        float fW1 = w1(f);
        if (Float.isInfinite(fW1)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fW1);
    }

    default float D(int i) {
        return C17784nZ1.q(i / getDensity());
    }

    default float I0(long j) {
        if (!C14377ho7.g(C13193fo7.g(j), C14377ho7.b.b())) {
            O73.b("Only Sp can convert to Px");
        }
        return w1(Y(j));
    }

    default long I1(long j) {
        if (j == 9205357640488583168L) {
            return OD6.b.a();
        }
        float fW1 = w1(C20148rZ1.j(j));
        float fW12 = w1(C20148rZ1.i(j));
        return OD6.d((Float.floatToRawIntBits(fW12) & 4294967295L) | (Float.floatToRawIntBits(fW1) << 32));
    }

    default long U(long j) {
        return j != 9205357640488583168L ? AbstractC18966pZ1.b(o1(Float.intBitsToFloat((int) (j >> 32))), o1(Float.intBitsToFloat((int) (j & 4294967295L)))) : C20148rZ1.b.a();
    }

    float getDensity();

    default long j0(float f) {
        return T(o1(f));
    }

    default float o1(float f) {
        return C17784nZ1.q(f / getDensity());
    }

    default float w1(float f) {
        return f * getDensity();
    }
}
