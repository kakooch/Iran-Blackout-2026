package io.appmetrica.analytics.coreapi.internal.identifiers;

/* loaded from: classes3.dex */
public class AdvertisingIdsHolder {
    private final AdTrackingInfoResult a;
    private final AdTrackingInfoResult b;
    private final AdTrackingInfoResult c;

    public AdvertisingIdsHolder() {
        this(new AdTrackingInfoResult(), new AdTrackingInfoResult(), new AdTrackingInfoResult());
    }

    public AdTrackingInfoResult getGoogle() {
        return this.a;
    }

    public AdTrackingInfoResult getHuawei() {
        return this.b;
    }

    public AdTrackingInfoResult getYandex() {
        return this.c;
    }

    public String toString() {
        return "AdvertisingIdsHolder{mGoogle=" + this.a + ", mHuawei=" + this.b + ", yandex=" + this.c + '}';
    }

    public AdvertisingIdsHolder(AdTrackingInfoResult adTrackingInfoResult, AdTrackingInfoResult adTrackingInfoResult2, AdTrackingInfoResult adTrackingInfoResult3) {
        this.a = adTrackingInfoResult;
        this.b = adTrackingInfoResult2;
        this.c = adTrackingInfoResult3;
    }
}
