package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes.dex */
final /* synthetic */ class yx implements Runnable {
    private final yz a;

    private yx(yz yzVar) {
        this.a = yzVar;
    }

    static Runnable a(yz yzVar) {
        return new yx(yzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.p();
    }
}
