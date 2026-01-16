package com.google.ads.interactivemedia.v3.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aua extends WeakReference<Throwable> {
    private final int a;

    public aua(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == aua.class) {
            if (this == obj) {
                return true;
            }
            aua auaVar = (aua) obj;
            if (this.a == auaVar.a && get() == auaVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
