package com.google.android.exoplayer2t;

import android.content.Context;
import android.net.wifi.WifiManager;

/* loaded from: classes.dex */
final class WifiLockManager {
    private boolean enabled;
    private boolean stayAwake;
    private WifiManager.WifiLock wifiLock;

    public WifiLockManager(Context context) {
    }

    public void setStayAwake(boolean z) {
        this.stayAwake = z;
        updateWifiLock();
    }

    private void updateWifiLock() {
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock == null) {
            return;
        }
        if (this.enabled && this.stayAwake) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
