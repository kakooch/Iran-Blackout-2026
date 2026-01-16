package io.appmetrica.analytics.impl;

import android.app.Activity;

/* renamed from: io.appmetrica.analytics.impl.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2622j implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ C2670l b;

    public RunnableC2622j(C2670l c2670l, Activity activity) {
        this.b = c2670l;
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
