package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zzfi;

/* loaded from: classes3.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzfi a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        if (this.a == null) {
            this.a = new zzfi();
        }
        zzfi.zzb(context, intent);
    }
}
