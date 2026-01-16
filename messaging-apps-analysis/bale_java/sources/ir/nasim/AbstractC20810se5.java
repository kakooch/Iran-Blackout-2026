package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.se5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20810se5 {
    private static Random a = new Random();
    private static final float[] b = new float[3];
    private static final float[] c = new float[3];

    public static int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }
}
