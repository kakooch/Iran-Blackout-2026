package ir.nasim;

import android.util.SparseIntArray;

/* loaded from: classes3.dex */
public final class Pk8 {
    private static final Object c = new Object();
    private static int d;
    private final SparseIntArray a = new SparseIntArray();
    private final SparseIntArray b = new SparseIntArray();

    public final int a(int i) {
        synchronized (c) {
            try {
                int i2 = this.a.get(i, -1);
                if (i2 != -1) {
                    return i2;
                }
                int i3 = d;
                d = i3 + 1;
                this.a.append(i, i3);
                this.b.append(i3, i);
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
