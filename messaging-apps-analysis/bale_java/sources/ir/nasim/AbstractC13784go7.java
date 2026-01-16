package ir.nasim;

/* renamed from: ir.nasim.go7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13784go7 {
    public static final long a(float f, long j) {
        return i(j, f);
    }

    public static final void b(long j) {
        if (!(C13193fo7.f(j) == 0)) {
            return;
        }
        O73.a("Cannot perform operation for Unspecified type.");
    }

    public static final void c(long j, long j2) {
        if (!((C13193fo7.f(j) == 0 || C13193fo7.f(j2) == 0) ? false : true)) {
            O73.a("Cannot perform operation for Unspecified type.");
        }
        if (C14377ho7.g(C13193fo7.g(j), C13193fo7.g(j2))) {
            return;
        }
        O73.a("Cannot perform operation for " + ((Object) C14377ho7.i(C13193fo7.g(j))) + " and " + ((Object) C14377ho7.i(C13193fo7.g(j2))));
    }

    public static final long d(float f) {
        return i(8589934592L, f);
    }

    public static final long e(double d) {
        return i(4294967296L, (float) d);
    }

    public static final long f(float f) {
        return i(4294967296L, f);
    }

    public static final long g(int i) {
        return i(4294967296L, i);
    }

    public static final long h(long j, long j2, float f) {
        c(j, j2);
        return i(C13193fo7.f(j), AbstractC18932pV3.b(C13193fo7.h(j), C13193fo7.h(j2), f));
    }

    public static final long i(long j, float f) {
        return C13193fo7.c(j | (Float.floatToRawIntBits(f) & 4294967295L));
    }
}
