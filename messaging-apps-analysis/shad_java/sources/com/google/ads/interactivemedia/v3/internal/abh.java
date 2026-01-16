package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class abh implements Runnable {
    final /* synthetic */ abi a;
    private float b;
    private float c;
    private boolean d;
    private boolean e;

    public final void a(float f, float f2, boolean z) {
        this.b = f;
        this.c = f2;
        this.d = z;
        if (this.e) {
            return;
        }
        this.e = true;
        this.a.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e = false;
    }
}
