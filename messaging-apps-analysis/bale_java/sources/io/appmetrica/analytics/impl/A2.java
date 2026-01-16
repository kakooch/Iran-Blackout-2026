package io.appmetrica.analytics.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* loaded from: classes3.dex */
public final class A2 extends BroadcastReceiver {
    public final BiConsumer a;
    public final ICommonExecutor b;

    public A2(V2 v2, ICommonExecutor iCommonExecutor) {
        this.a = v2;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.execute(new RunnableC3008z2(this, context, intent));
    }
}
