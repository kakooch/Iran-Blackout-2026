package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class az extends BroadcastReceiver implements Runnable {
    final /* synthetic */ bb a;
    private final ba b;
    private final Handler c;

    public az(bb bbVar, Handler handler, ba baVar) {
        this.a = bbVar;
        this.c = handler;
        this.b = baVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.c.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.c) {
            ((ei) this.b).a.ac(false, -1, 3);
        }
    }
}
