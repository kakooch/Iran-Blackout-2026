package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.wifi.WifiManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class eu {
    private final WifiManager a;
    private WifiManager.WifiLock b;
    private boolean c;
    private boolean d;

    public eu(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private final void c() {
        WifiManager.WifiLock wifiLock = this.b;
        if (wifiLock == null) {
            return;
        }
        wifiLock.release();
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
