package com.google.ads.interactivemedia.v3.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class q extends BroadcastReceiver {
    final /* synthetic */ r a;

    q(r rVar) {
        this.a = rVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        KeyguardManager keyguardManager;
        if (intent == null) {
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            r.f(this.a, true);
            return;
        }
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            r.f(this.a, false);
        } else {
            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode()) {
                return;
            }
            r.f(this.a, false);
        }
    }
}
