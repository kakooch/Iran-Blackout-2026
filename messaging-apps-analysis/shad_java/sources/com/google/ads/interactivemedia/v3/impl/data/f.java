package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.aps;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.arx;

/* compiled from: IMASDK */
@aps(a = m.class)
/* loaded from: classes.dex */
public abstract class f {
    public static e builder(AdsRenderingSettings adsRenderingSettings) {
        g gVar = (g) adsRenderingSettings;
        l lVar = new l();
        lVar.setBitrate(gVar.getBitrateKbps());
        lVar.setDisableUi(gVar.getDisableUi());
        lVar.setEnablePreloading(gVar.getEnablePreloading());
        lVar.setEnableFocusSkipButton(gVar.getFocusSkipButtonWhenAvailable());
        lVar.setLoadVideoTimeout(gVar.getLoadVideoTimeout());
        lVar.setMimeTypes(gVar.getMimeTypes());
        lVar.setPlayAdsAfterTime(gVar.getPlayAdsAfterTime());
        lVar.setUiElements(gVar.getUiElements());
        return lVar;
    }

    public abstract int bitrate();

    public abstract boolean disableUi();

    public abstract boolean enableFocusSkipButton();

    public abstract boolean enablePreloading();

    public abstract int loadVideoTimeout();

    public abstract arn<String> mimeTypes();

    public abstract double playAdsAfterTime();

    abstract e toBuilder();

    public abstract arx<UiElement> uiElements();
}
