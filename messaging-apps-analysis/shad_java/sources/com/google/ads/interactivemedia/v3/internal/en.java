package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class en extends BroadcastReceiver {
    final /* synthetic */ eo a;

    /* synthetic */ en(eo eoVar) {
        this.a = eoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Handler handler = this.a.b;
        final eo eoVar = this.a;
        handler.post(new Runnable(eoVar) { // from class: com.google.ads.interactivemedia.v3.internal.em
            private final eo a;

            {
                this.a = eoVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        });
    }
}
