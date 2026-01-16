package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import ir.nasim.AbstractC18815pI3;

/* loaded from: classes2.dex */
final class M0 {
    private final WifiManager a;
    private WifiManager.WifiLock b;
    private boolean c;
    private boolean d;

    public M0(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.b;
        if (wifiLock == null) {
            return;
        }
        if (this.c && this.d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            WifiManager wifiManager = this.a;
            if (wifiManager == null) {
                AbstractC18815pI3.k("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
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
