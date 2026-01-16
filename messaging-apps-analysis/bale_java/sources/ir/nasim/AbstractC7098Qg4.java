package ir.nasim;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ir.nasim.Qg4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7098Qg4 {
    private static final ConcurrentMap a = new ConcurrentHashMap();

    public static final C23560x76 a(Class cls) {
        AbstractC13042fc3.i(cls, "$this$getOrCreateModule");
        ClassLoader classLoaderG = AbstractC21912uL5.g(cls);
        B48 b48 = new B48(classLoaderG);
        ConcurrentMap concurrentMap = a;
        WeakReference weakReference = (WeakReference) concurrentMap.get(b48);
        if (weakReference != null) {
            C23560x76 c23560x76 = (C23560x76) weakReference.get();
            if (c23560x76 != null) {
                AbstractC13042fc3.h(c23560x76, "it");
                return c23560x76;
            }
            concurrentMap.remove(b48, weakReference);
        }
        C23560x76 c23560x76A = C23560x76.c.a(classLoaderG);
        while (true) {
            try {
                ConcurrentMap concurrentMap2 = a;
                WeakReference weakReference2 = (WeakReference) concurrentMap2.putIfAbsent(b48, new WeakReference(c23560x76A));
                if (weakReference2 == null) {
                    return c23560x76A;
                }
                C23560x76 c23560x762 = (C23560x76) weakReference2.get();
                if (c23560x762 != null) {
                    return c23560x762;
                }
                concurrentMap2.remove(b48, weakReference2);
            } finally {
                b48.a(null);
            }
        }
    }
}
