package ir.nasim;

/* renamed from: ir.nasim.gl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13746gl {
    public static final C13746gl a = new C13746gl();

    private C13746gl() {
    }

    public final float a(int i, float f) {
        return ((i & 8) * f) / 8;
    }

    public final float b(int i, float f) {
        return ((i & 4) * f) / 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int c(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        int i = z2;
        if (z) {
            if (z3) {
                i = (z2 ? 1 : 0) | 2;
            }
            if (z4) {
                i = (i == true ? 1 : 0) | 4;
            }
            return z5 ? i | 8 : i;
        }
        int i2 = z2 ? 2 : 0;
        if (z3) {
            i2 |= 1;
        }
        if (z4) {
            i2 |= 8;
        }
        int i3 = i2;
        return z5 ? i3 | 4 : i3;
    }

    public final float d(int i, float f) {
        return ((i & 2) * f) / 2;
    }

    public final float e(int i, float f) {
        return ((i & 1) * f) / 1;
    }
}
