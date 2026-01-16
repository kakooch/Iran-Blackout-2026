package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class d {
    final Intent a;
    private final BroadcastReceiver.PendingResult b;
    private boolean c = false;
    private final ScheduledFuture d;

    d(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.a = intent;
        this.b = pendingResult;
        this.d = scheduledExecutorService.schedule(new e(this, intent), 9500L, TimeUnit.MILLISECONDS);
    }

    final synchronized void a() {
        if (!this.c) {
            this.b.finish();
            this.d.cancel(false);
            this.c = true;
        }
    }
}
