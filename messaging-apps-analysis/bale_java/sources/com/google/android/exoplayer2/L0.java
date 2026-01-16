package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
import ir.nasim.AbstractC18815pI3;

/* loaded from: classes2.dex */
final class L0 {
    private final PowerManager a;
    private PowerManager.WakeLock b;
    private boolean c;
    private boolean d;

    public L0(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void c() {
        PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock == null) {
            return;
        }
        if (this.c && this.d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            PowerManager powerManager = this.a;
            if (powerManager == null) {
                AbstractC18815pI3.k("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.c = z;
        c();
    }

    public void b(boolean z) {
        this.d = z;
        c();
    }
}
