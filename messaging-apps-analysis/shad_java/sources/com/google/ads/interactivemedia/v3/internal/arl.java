package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arl implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    arl(Object[] objArr) {
        this.a = objArr;
    }

    Object readResolve() {
        return arn.m(this.a);
    }
}
