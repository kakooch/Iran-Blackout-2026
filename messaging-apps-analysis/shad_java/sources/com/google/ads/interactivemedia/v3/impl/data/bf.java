package com.google.ads.interactivemedia.v3.impl.data;

import android.util.Log;
import com.google.ads.interactivemedia.v3.internal.auj;
import com.google.ads.interactivemedia.v3.internal.aul;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class bf {
    public double adBreakDuration;
    public String adBreakTime;
    public List<Float> adCuePoints;
    public c adData;
    public double adPeriodDuration;
    public d adPodInfo;
    public int adPosition;
    public long adTimeUpdateMs;
    public double bufferedTime;
    public Map<String, CompanionData> companions;
    public List<av> cuepoints;
    public double currentTime;
    public double duration;
    public int errorCode;
    public String errorMessage;
    public String eventId;
    public String innerError;
    public SortedSet<Float> internalCuePoints;
    public String ln;
    public be logData;
    public String m;
    public boolean monitorAppLifecycle;
    public String n;
    public bh networkRequest;
    public String queryId;
    public ResizeAndPositionVideoMsgData resizeAndPositionVideo;
    public double seekTime;
    public String streamId;
    public String streamUrl;
    public List<HashMap<String, String>> subtitles;
    public int totalAds;
    public String url;
    public String vastEvent;
    public String videoUrl;

    public boolean equals(Object obj) {
        return auj.c(this, obj, new String[0]);
    }

    public int hashCode() {
        return aul.b(this, new String[0]);
    }

    public String toString() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        sb.append("JavaScriptMsgData[");
        for (Field field : bf.class.getFields()) {
            try {
                Object obj = field.get(this);
                sb.append(field.getName());
                sb.append(":");
                sb.append(obj);
                sb.append(",");
            } catch (IllegalAccessException e) {
                Log.e("IMASDK", "IllegalAccessException occurred", e);
            } catch (IllegalArgumentException e2) {
                Log.e("IMASDK", "IllegalArgumentException occurred", e2);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
