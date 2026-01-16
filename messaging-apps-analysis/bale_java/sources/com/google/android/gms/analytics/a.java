package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

/* loaded from: classes3.dex */
final class a implements Runnable {
    final /* synthetic */ BroadcastReceiver.PendingResult a;

    a(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.a = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.a;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
