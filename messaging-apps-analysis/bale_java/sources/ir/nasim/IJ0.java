package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes8.dex */
public abstract /* synthetic */ class IJ0 {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
