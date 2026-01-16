package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import io.reactivex.FlowableEmitter;

/* loaded from: classes3.dex */
final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {
    private FlowableEmitter<String> emitter;

    FiamAnalyticsConnectorListener(FlowableEmitter<String> flowableEmitter) {
        this.emitter = flowableEmitter;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i, Bundle bundle) {
        if (i == 2) {
            this.emitter.onNext(bundle.getString("events"));
        }
    }
}
