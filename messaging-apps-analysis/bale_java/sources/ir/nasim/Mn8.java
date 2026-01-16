package ir.nasim;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class Mn8 extends WeakReference {
    private final int a;

    public Mn8(Throwable th, ReferenceQueue referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Mn8.class) {
            if (this == obj) {
                return true;
            }
            Mn8 mn8 = (Mn8) obj;
            if (this.a == mn8.a && get() == mn8.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
