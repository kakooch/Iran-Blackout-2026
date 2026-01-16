package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;

/* renamed from: io.appmetrica.analytics.impl.h3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2579h3 implements ApplicationStateObserver {
    public final /* synthetic */ C2603i3 a;

    public C2579h3(C2603i3 c2603i3) {
        this.a = c2603i3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
    public final void onApplicationStateChanged(ApplicationState applicationState) {
        C2603i3 c2603i3 = this.a;
        c2603i3.getClass();
        if (applicationState == ApplicationState.VISIBLE) {
            try {
                BillingMonitor billingMonitor = c2603i3.a;
                if (billingMonitor != null) {
                    billingMonitor.onSessionResumed();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
