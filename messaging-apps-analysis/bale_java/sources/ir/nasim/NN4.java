package ir.nasim;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
abstract class NN4 {
    static void a(Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, 2147483647999999999L));
    }
}
