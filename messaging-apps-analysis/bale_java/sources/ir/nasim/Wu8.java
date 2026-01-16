package ir.nasim;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class Wu8 extends WeakReference {
    private final int a;

    public Wu8(Throwable th, ReferenceQueue referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Wu8.class) {
            if (this == obj) {
                return true;
            }
            Wu8 wu8 = (Wu8) obj;
            if (this.a == wu8.a && get() == wu8.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
