package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arw implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    arw(Object[] objArr) {
        this.a = objArr;
    }

    Object readResolve() {
        return arx.k(this.a);
    }
}
