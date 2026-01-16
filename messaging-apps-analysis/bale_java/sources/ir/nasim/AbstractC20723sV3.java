package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.sV3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20723sV3 extends AbstractC20114rV3 {
    public static int a(int i) {
        return Integer.signum(i);
    }

    public static int b(long j) {
        return Long.signum(j);
    }

    public static int c(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        return d < -2.147483648E9d ? RecyclerView.UNDEFINED_DURATION : (int) Math.round(d);
    }

    public static int d(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    public static long e(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    public static long f(float f) {
        return e(f);
    }
}
