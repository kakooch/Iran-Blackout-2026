package com.google.android.gms.common.api.internal;

/* loaded from: classes3.dex */
final class p implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ s b;

    p(s sVar, int i) {
        this.b = sVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.h(this.a);
    }
}
