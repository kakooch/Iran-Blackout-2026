package ir.nasim;

/* renamed from: ir.nasim.fF2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12832fF2 {
    public static final String a(float f, int i) {
        if (Float.isNaN(f)) {
            return "NaN";
        }
        if (Float.isInfinite(f)) {
            return f < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(i, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f2 = f * fPow;
        int i2 = (int) f2;
        if (f2 - i2 >= 0.5f) {
            i2++;
        }
        float f3 = i2 / fPow;
        return iMax > 0 ? String.valueOf(f3) : String.valueOf((int) f3);
    }
}
