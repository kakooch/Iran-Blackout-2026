package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeChangeListener;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class X2 extends SafeRunnable {
    public final /* synthetic */ BatteryInfo a;
    public final /* synthetic */ Y2 b;

    public X2(Y2 y2, BatteryInfo batteryInfo) {
        this.b = y2;
        this.a = batteryInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Z2 z2 = this.b.a;
        ChargeType chargeType = this.a.chargeType;
        ChargeType chargeType2 = Z2.d;
        synchronized (z2) {
            Iterator it = z2.c.iterator();
            while (it.hasNext()) {
                ((ChargeTypeChangeListener) it.next()).onChargeTypeChanged(chargeType);
            }
        }
    }
}
