package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.arx;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class m extends f {
    private final int bitrate;
    private final boolean disableUi;
    private final boolean enableFocusSkipButton;
    private final boolean enablePreloading;
    private final int loadVideoTimeout;
    private final arn<String> mimeTypes;
    private final double playAdsAfterTime;
    private final arx<UiElement> uiElements;

    private m(int i, arn<String> arnVar, arx<UiElement> arxVar, boolean z, boolean z2, double d, boolean z3, int i2) {
        this.bitrate = i;
        this.mimeTypes = arnVar;
        this.uiElements = arxVar;
        this.enablePreloading = z;
        this.enableFocusSkipButton = z2;
        this.playAdsAfterTime = d;
        this.disableUi = z3;
        this.loadVideoTimeout = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public int bitrate() {
        return this.bitrate;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public boolean disableUi() {
        return this.disableUi;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public boolean enableFocusSkipButton() {
        return this.enableFocusSkipButton;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public boolean enablePreloading() {
        return this.enablePreloading;
    }

    public boolean equals(Object obj) {
        arn<String> arnVar;
        arx<UiElement> arxVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.bitrate == fVar.bitrate() && ((arnVar = this.mimeTypes) != null ? arnVar.equals(fVar.mimeTypes()) : fVar.mimeTypes() == null) && ((arxVar = this.uiElements) != null ? arxVar.equals(fVar.uiElements()) : fVar.uiElements() == null) && this.enablePreloading == fVar.enablePreloading() && this.enableFocusSkipButton == fVar.enableFocusSkipButton() && Double.doubleToLongBits(this.playAdsAfterTime) == Double.doubleToLongBits(fVar.playAdsAfterTime()) && this.disableUi == fVar.disableUi() && this.loadVideoTimeout == fVar.loadVideoTimeout()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.bitrate ^ 1000003) * 1000003;
        arn<String> arnVar = this.mimeTypes;
        int iHashCode = (i ^ (arnVar == null ? 0 : arnVar.hashCode())) * 1000003;
        arx<UiElement> arxVar = this.uiElements;
        return ((((((((((iHashCode ^ (arxVar != null ? arxVar.hashCode() : 0)) * 1000003) ^ (true != this.enablePreloading ? 1237 : 1231)) * 1000003) ^ (true != this.enableFocusSkipButton ? 1237 : 1231)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.playAdsAfterTime) >>> 32) ^ Double.doubleToLongBits(this.playAdsAfterTime)))) * 1000003) ^ (true == this.disableUi ? 1231 : 1237)) * 1000003) ^ this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public int loadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public arn<String> mimeTypes() {
        return this.mimeTypes;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public double playAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    e toBuilder() {
        return new l(this);
    }

    public String toString() {
        int i = this.bitrate;
        String strValueOf = String.valueOf(this.mimeTypes);
        String strValueOf2 = String.valueOf(this.uiElements);
        boolean z = this.enablePreloading;
        boolean z2 = this.enableFocusSkipButton;
        double d = this.playAdsAfterTime;
        boolean z3 = this.disableUi;
        int i2 = this.loadVideoTimeout;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 213 + strValueOf2.length());
        sb.append("AdsRenderingSettingsData{bitrate=");
        sb.append(i);
        sb.append(", mimeTypes=");
        sb.append(strValueOf);
        sb.append(", uiElements=");
        sb.append(strValueOf2);
        sb.append(", enablePreloading=");
        sb.append(z);
        sb.append(", enableFocusSkipButton=");
        sb.append(z2);
        sb.append(", playAdsAfterTime=");
        sb.append(d);
        sb.append(", disableUi=");
        sb.append(z3);
        sb.append(", loadVideoTimeout=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.f
    public arx<UiElement> uiElements() {
        return this.uiElements;
    }
}
