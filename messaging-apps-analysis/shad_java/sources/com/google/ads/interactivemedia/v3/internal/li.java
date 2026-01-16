package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class li {
    protected final kr a;

    protected li(kr krVar) {
        this.a = krVar;
    }

    protected abstract boolean a(aee aeeVar) throws dt;

    protected abstract boolean b(aee aeeVar, long j) throws dt;

    public final boolean f(aee aeeVar, long j) throws dt {
        return a(aeeVar) && b(aeeVar, j);
    }
}
