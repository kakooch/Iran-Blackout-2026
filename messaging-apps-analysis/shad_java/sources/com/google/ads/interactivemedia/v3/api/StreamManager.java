package com.google.ads.interactivemedia.v3.api;

import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface StreamManager extends BaseManager {
    double getContentTimeForStreamTime(double d);

    List<CuePoint> getCuePoints();

    CuePoint getPreviousCuePointForStreamTime(double d);

    String getStreamId();

    double getStreamTimeForContentTime(double d);

    void replaceAdTagParameters(Map<String, String> map);
}
