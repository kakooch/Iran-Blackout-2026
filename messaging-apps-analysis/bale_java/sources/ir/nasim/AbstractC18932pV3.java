package ir.nasim;

/* renamed from: ir.nasim.pV3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18932pV3 {
    public static final float a(float f) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f) & 8589934591L) / 3)) + 709952852);
        float f2 = fIntBitsToFloat - ((fIntBitsToFloat - (f / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f2 - ((f2 - (f / (f2 * f2))) * 0.33333334f);
    }

    public static final float b(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final int c(int i, int i2, float f) {
        return i + ((int) Math.round((i2 - i) * f));
    }
}
