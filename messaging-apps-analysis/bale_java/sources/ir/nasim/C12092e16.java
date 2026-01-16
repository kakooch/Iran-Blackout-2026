package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.e16, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C12092e16 {
    private final float a;
    private final float b;

    public C12092e16(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    private static float a(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163) {
        float f = c12092e162.a;
        float f2 = c12092e162.b;
        return ((c12092e163.a - f) * (c12092e16.b - f2)) - ((c12092e163.b - f2) * (c12092e16.a - f));
    }

    public static float b(C12092e16 c12092e16, C12092e16 c12092e162) {
        return AbstractC23186wV3.a(c12092e16.a, c12092e16.b, c12092e162.a, c12092e162.b);
    }

    public static void e(C12092e16[] c12092e16Arr) {
        C12092e16 c12092e16;
        C12092e16 c12092e162;
        C12092e16 c12092e163;
        float fB = b(c12092e16Arr[0], c12092e16Arr[1]);
        float fB2 = b(c12092e16Arr[1], c12092e16Arr[2]);
        float fB3 = b(c12092e16Arr[0], c12092e16Arr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            c12092e16 = c12092e16Arr[0];
            c12092e162 = c12092e16Arr[1];
            c12092e163 = c12092e16Arr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            c12092e16 = c12092e16Arr[2];
            c12092e162 = c12092e16Arr[0];
            c12092e163 = c12092e16Arr[1];
        } else {
            c12092e16 = c12092e16Arr[1];
            c12092e162 = c12092e16Arr[0];
            c12092e163 = c12092e16Arr[2];
        }
        if (a(c12092e162, c12092e16, c12092e163) < 0.0f) {
            C12092e16 c12092e164 = c12092e163;
            c12092e163 = c12092e162;
            c12092e162 = c12092e164;
        }
        c12092e16Arr[0] = c12092e162;
        c12092e16Arr[1] = c12092e16;
        c12092e16Arr[2] = c12092e163;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C12092e16) {
            C12092e16 c12092e16 = (C12092e16) obj;
            if (this.a == c12092e16.a && this.b == c12092e16.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return Separators.LPAREN + this.a + ',' + this.b + ')';
    }
}
