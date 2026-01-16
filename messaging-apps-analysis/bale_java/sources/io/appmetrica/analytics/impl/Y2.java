package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;

/* loaded from: classes3.dex */
public final class Y2 implements Consumer {
    public final /* synthetic */ Z2 a;

    public Y2(Z2 z2) {
        this.a = z2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.a.getClass();
        BatteryInfo batteryInfoA = Z2.a(intent);
        this.a.b = batteryInfoA;
        if (chargeType != batteryInfoA.chargeType) {
            this.a.a.execute(new X2(this, batteryInfoA));
        }
    }
}
