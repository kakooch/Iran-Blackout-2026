package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aun {
    private final Object a;
    private final int b;

    aun(Object obj) {
        this.b = System.identityHashCode(obj);
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aun)) {
            return false;
        }
        aun aunVar = (aun) obj;
        return this.b == aunVar.b && this.a == aunVar.a;
    }

    public final int hashCode() {
        return this.b;
    }
}
