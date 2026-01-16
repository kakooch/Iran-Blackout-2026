package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.api.CuePoint;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anb {
    public final AdEvent.AdEventType a;
    public final com.google.ads.interactivemedia.v3.impl.data.c b;
    public Map<String, String> c;
    public List<CuePoint> d;
    AdProgressInfo e;
    public double f;

    public anb(AdEvent.AdEventType adEventType, com.google.ads.interactivemedia.v3.impl.data.c cVar) {
        this.a = adEventType;
        this.b = cVar;
    }

    public final boolean equals(Object obj) {
        return auj.c(this, obj, new String[0]);
    }

    public final int hashCode() {
        return aul.b(this, new String[0]);
    }
}
