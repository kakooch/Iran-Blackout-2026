package ir.nasim;

/* renamed from: ir.nasim.Xh0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8778Xh0 {
    public static int a(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean b(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }
}
