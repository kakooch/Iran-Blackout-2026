package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adm {
    private boolean a;

    public final synchronized boolean a() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized void b() throws InterruptedException {
        while (!this.a) {
            wait();
        }
    }

    public final synchronized boolean c() {
        return this.a;
    }

    public final synchronized void d() {
        this.a = false;
    }
}
