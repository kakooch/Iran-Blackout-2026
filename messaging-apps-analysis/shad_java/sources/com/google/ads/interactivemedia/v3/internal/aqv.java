package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class aqv {
    private static final aqv a = new aqt();
    private static final aqv b = new aqu(-1);
    private static final aqv c = new aqu(1);

    /* synthetic */ aqv() {
    }

    public static aqv g() {
        return a;
    }

    public abstract <T> aqv a(T t, T t2, Comparator<T> comparator);

    public abstract aqv b(int i, int i2);

    public abstract aqv c(boolean z, boolean z2);

    public abstract aqv d(boolean z, boolean z2);

    public abstract int e();
}
