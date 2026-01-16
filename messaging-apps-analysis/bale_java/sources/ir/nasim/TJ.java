package ir.nasim;

/* loaded from: classes5.dex */
public abstract class TJ {
    public static int a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static int b(int i) {
        return a(i * 4) / 4;
    }
}
