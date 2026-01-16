package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ace extends BroadcastReceiver {
    private static ace a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final ArrayList<WeakReference<acf>> c = new ArrayList<>();

    private ace() {
    }

    public static synchronized ace a(Context context) {
        if (a == null) {
            a = new ace();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(a, intentFilter);
        }
        return a;
    }

    private final void c() {
        int size = this.c.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            if (this.c.get(size).get() == null) {
                this.c.remove(size);
            }
        }
    }

    public final synchronized void b(final acf acfVar) {
        c();
        this.c.add(new WeakReference<>(acfVar));
        this.b.post(new Runnable(this, acfVar) { // from class: com.google.ads.interactivemedia.v3.internal.acd
            private final ace a;
            private final acf b;

            {
                this.a = this;
                this.b = acfVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.k();
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        c();
        for (int i = 0; i < this.c.size(); i++) {
            acf acfVar = this.c.get(i).get();
            if (acfVar != null) {
                acfVar.k();
            }
        }
    }
}
