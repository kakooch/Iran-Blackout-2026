package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import ir.nasim.En8;
import ir.nasim.Fn8;

/* loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements En8 {
    private Fn8 c;

    @Override // ir.nasim.En8
    public void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.c == null) {
            this.c = new Fn8(this);
        }
        this.c.a(context, intent);
    }
}
