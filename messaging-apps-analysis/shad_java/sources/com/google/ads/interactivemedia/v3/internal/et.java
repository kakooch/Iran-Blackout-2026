package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class et {
    private final PowerManager a;
    private PowerManager.WakeLock b;
    private boolean c;
    private boolean d;

    public et(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private final void c() {
        PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock == null) {
            return;
        }
        wakeLock.release();
    }

    public final void a(boolean z) {
        this.c = false;
        c();
    }

    public final void b(boolean z) {
        this.d = z;
        c();
    }
}
