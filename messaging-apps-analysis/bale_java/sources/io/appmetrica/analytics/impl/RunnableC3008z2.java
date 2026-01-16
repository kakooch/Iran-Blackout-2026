package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;

/* renamed from: io.appmetrica.analytics.impl.z2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC3008z2 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ A2 c;

    public RunnableC3008z2(A2 a2, Context context, Intent intent) {
        this.c = a2;
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.consume(this.a, this.b);
    }
}
