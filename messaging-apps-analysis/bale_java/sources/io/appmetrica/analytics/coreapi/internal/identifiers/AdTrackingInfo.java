package io.appmetrica.analytics.coreapi.internal.identifiers;

/* loaded from: classes3.dex */
public class AdTrackingInfo {
    public final String advId;
    public final Boolean limitedAdTracking;
    public final Provider provider;

    public enum Provider {
        GOOGLE,
        HMS,
        YANDEX
    }

    public AdTrackingInfo(Provider provider, String str, Boolean bool) {
        this.provider = provider;
        this.advId = str;
        this.limitedAdTracking = bool;
    }

    public String toString() {
        return "AdTrackingInfo{provider=" + this.provider + ", advId='" + this.advId + "', limitedAdTracking=" + this.limitedAdTracking + '}';
    }
}
