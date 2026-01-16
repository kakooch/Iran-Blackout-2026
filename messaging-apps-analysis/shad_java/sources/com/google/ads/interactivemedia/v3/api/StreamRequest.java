package com.google.ads.interactivemedia.v3.api;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface StreamRequest {

    /* compiled from: IMASDK */
    public enum StreamFormat {
        DASH,
        HLS
    }

    void forceExperimentId(Integer num);

    Map<String, String> getAdTagParameters();

    String getApiKey();

    String getAssetKey();

    String getAuthToken();

    String getContentSourceId();

    String getContentUrl();

    Integer getForcedExperimentId();

    StreamFormat getFormat();

    String getManifestSuffix();

    String getStreamActivityMonitorId();

    Boolean getUseQAStreamBaseUrl();

    Object getUserRequestContext();

    String getVideoId();

    void setAdTagParameters(Map<String, String> map);

    void setAuthToken(String str);

    void setContentUrl(String str);

    void setFormat(StreamFormat streamFormat);

    void setManifestSuffix(String str);

    void setStreamActivityMonitorId(String str);

    void setUseQAStreamBaseUrl(Boolean bool);

    void setUserRequestContext(Object obj);
}
