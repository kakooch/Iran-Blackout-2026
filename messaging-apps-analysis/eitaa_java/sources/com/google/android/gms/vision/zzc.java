package com.google.android.gms.vision;

import android.util.SparseArray;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzc {
    private static final Object lock = new Object();

    @GuardedBy("lock")
    private static int zzau;

    @GuardedBy("lock")
    private SparseArray<Integer> zzav = new SparseArray<>();

    @GuardedBy("lock")
    private SparseArray<Integer> zzaw = new SparseArray<>();

    public final int zzb(int i) {
        synchronized (lock) {
            Integer num = this.zzav.get(i);
            if (num != null) {
                return num.intValue();
            }
            int i2 = zzau;
            zzau = i2 + 1;
            this.zzav.append(i, Integer.valueOf(i2));
            this.zzaw.append(i2, Integer.valueOf(i));
            return i2;
        }
    }
}
