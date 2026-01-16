package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class aqa<T> implements Serializable {
    private static final long serialVersionUID = 0;

    aqa() {
    }

    public static <T> aqa<T> c(T t) {
        return t == null ? apu.a : new aqc(t);
    }

    public abstract T a();

    public abstract <V> aqa<V> b(apw<? super T, V> apwVar);
}
