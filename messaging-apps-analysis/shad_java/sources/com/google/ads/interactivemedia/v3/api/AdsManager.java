package com.google.ads.interactivemedia.v3.api;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface AdsManager extends BaseManager {
    void clicked();

    void discardAdBreak();

    List<Float> getAdCuePoints();

    void pause();

    @Deprecated
    void requestNextAdBreak();

    void resume();

    void skip();

    void start();
}
