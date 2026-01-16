package io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/servicecomponents/batteryinfo/ChargeTypeProvider;", "", "Lio/appmetrica/analytics/coreapi/internal/servicecomponents/batteryinfo/ChargeTypeChangeListener;", "listener", "Lir/nasim/rB7;", "registerChargeTypeListener", "(Lio/appmetrica/analytics/coreapi/internal/servicecomponents/batteryinfo/ChargeTypeChangeListener;)V", "Lio/appmetrica/analytics/coreapi/internal/servicecomponents/batteryinfo/ChargeType;", "getChargeType", "()Lio/appmetrica/analytics/coreapi/internal/servicecomponents/batteryinfo/ChargeType;", "chargeType", "", "getBatteryLevel", "()Ljava/lang/Integer;", "batteryLevel", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface ChargeTypeProvider {
    Integer getBatteryLevel();

    ChargeType getChargeType();

    void registerChargeTypeListener(ChargeTypeChangeListener listener);
}
