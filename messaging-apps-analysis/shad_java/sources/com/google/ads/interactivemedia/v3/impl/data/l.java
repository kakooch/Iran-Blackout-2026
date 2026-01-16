package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.arx;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class l extends e {
    private Integer bitrate;
    private Boolean disableUi;
    private Boolean enableFocusSkipButton;
    private Boolean enablePreloading;
    private Integer loadVideoTimeout;
    private arn<String> mimeTypes;
    private Double playAdsAfterTime;
    private arx<UiElement> uiElements;

    l() {
    }

    private l(f fVar) {
        this.bitrate = Integer.valueOf(fVar.bitrate());
        this.mimeTypes = fVar.mimeTypes();
        this.uiElements = fVar.uiElements();
        this.enablePreloading = Boolean.valueOf(fVar.enablePreloading());
        this.enableFocusSkipButton = Boolean.valueOf(fVar.enableFocusSkipButton());
        this.playAdsAfterTime = Double.valueOf(fVar.playAdsAfterTime());
        this.disableUi = Boolean.valueOf(fVar.disableUi());
        this.loadVideoTimeout = Integer.valueOf(fVar.loadVideoTimeout());
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    public f build() {
        Integer num = this.bitrate;
        String strConcat = BuildConfig.FLAVOR;
        if (num == null) {
            strConcat = BuildConfig.FLAVOR.concat(" bitrate");
        }
        if (this.enablePreloading == null) {
            strConcat = String.valueOf(strConcat).concat(" enablePreloading");
        }
        if (this.enableFocusSkipButton == null) {
            strConcat = String.valueOf(strConcat).concat(" enableFocusSkipButton");
        }
        if (this.playAdsAfterTime == null) {
            strConcat = String.valueOf(strConcat).concat(" playAdsAfterTime");
        }
        if (this.disableUi == null) {
            strConcat = String.valueOf(strConcat).concat(" disableUi");
        }
        if (this.loadVideoTimeout == null) {
            strConcat = String.valueOf(strConcat).concat(" loadVideoTimeout");
        }
        if (strConcat.isEmpty()) {
            return new m(this.bitrate.intValue(), this.mimeTypes, this.uiElements, this.enablePreloading.booleanValue(), this.enableFocusSkipButton.booleanValue(), this.playAdsAfterTime.doubleValue(), this.disableUi.booleanValue(), this.loadVideoTimeout.intValue());
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setBitrate(int i) {
        this.bitrate = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setDisableUi(boolean z) {
        this.disableUi = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setEnableFocusSkipButton(boolean z) {
        this.enableFocusSkipButton = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setEnablePreloading(boolean z) {
        this.enablePreloading = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setLoadVideoTimeout(int i) {
        this.loadVideoTimeout = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setMimeTypes(List<String> list) {
        this.mimeTypes = list == null ? null : arn.l(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setPlayAdsAfterTime(double d) {
        this.playAdsAfterTime = Double.valueOf(d);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.e
    e setUiElements(Set<UiElement> set) {
        this.uiElements = set == null ? null : arx.j(set);
        return this;
    }
}
