package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class e {
    public abstract f build();

    abstract e setBitrate(int i);

    abstract e setDisableUi(boolean z);

    abstract e setEnableFocusSkipButton(boolean z);

    abstract e setEnablePreloading(boolean z);

    abstract e setLoadVideoTimeout(int i);

    abstract e setMimeTypes(List<String> list);

    abstract e setPlayAdsAfterTime(double d);

    abstract e setUiElements(Set<UiElement> set);
}
