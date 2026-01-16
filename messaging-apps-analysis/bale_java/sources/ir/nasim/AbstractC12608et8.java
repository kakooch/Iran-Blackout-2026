package ir.nasim;

/* renamed from: ir.nasim.et8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12608et8 {
    public static int a(int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z = false;
            }
        }
        AbstractC3795Cj5.c(z, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i));
        return i;
    }

    public static String b(int i) {
        if (i == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
