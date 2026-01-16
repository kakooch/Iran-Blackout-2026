package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.CuePoint;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamManager;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anw extends amh implements StreamManager {
    private final String g;
    private List<CuePoint> h;
    private anz i;

    anw(String str, ane aneVar, StreamDisplayContainer streamDisplayContainer, String str2, anr anrVar, Context context, String str3, boolean z) throws AdError {
        super(str, aneVar, streamDisplayContainer, anrVar, context, z);
        this.h = new ArrayList();
        this.g = str3;
        anz anzVar = new anz(str, aneVar, this, streamDisplayContainer, str2);
        this.i = anzVar;
        anzVar.i();
        addAdErrorListener(this.i);
        aneVar.j(this.i, str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.amh, com.google.ads.interactivemedia.v3.internal.anc
    public final void a(anb anbVar) {
        AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int iOrdinal = anbVar.a.ordinal();
        if (iOrdinal == 3) {
            this.i.k();
        } else if (iOrdinal == 4) {
            this.h = anbVar.d;
        } else if (iOrdinal == 14) {
            double d = anbVar.f;
            StringBuilder sb = new StringBuilder(54);
            sb.append("Seek time when ad is skipped: ");
            sb.append(d);
            Log.i("IMASDK", sb.toString());
            this.i.h(Math.round(anbVar.f * 1000.0d));
        } else if (iOrdinal != 15) {
            switch (iOrdinal) {
                case 23:
                    this.i.c();
                    break;
                case 24:
                    this.i.e();
                    break;
                case 25:
                    this.i.f();
                    break;
                case 26:
                    this.i.g();
                    break;
            }
        } else {
            this.i.j(anbVar.b);
        }
        super.a(anbVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public final void b(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        this.i.l(resizeAndPositionVideoMsgData);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public final void c() {
        this.i.m();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void destroy() {
        e(amw.contentComplete);
        this.e = true;
        this.i.b();
        d();
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.e ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.i.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final double getContentTimeForStreamTime(double d) {
        double endTime = d;
        for (CuePoint cuePoint : this.h) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            if (d >= cuePoint.getEndTime()) {
                endTime -= cuePoint.getEndTime() - cuePoint.getStartTime();
            } else if (d < cuePoint.getEndTime() && d > cuePoint.getStartTime()) {
                endTime -= d - cuePoint.getStartTime();
            }
        }
        return endTime;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final List<CuePoint> getCuePoints() {
        return Collections.unmodifiableList(this.h);
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final CuePoint getPreviousCuePointForStreamTime(double d) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.h) {
            if (cuePoint2.getStartTime() < d) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final String getStreamId() {
        return this.g;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final double getStreamTimeForContentTime(double d) {
        double endTime = d;
        double startTime = 0.0d;
        double endTime2 = 0.0d;
        for (CuePoint cuePoint : this.h) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            startTime += cuePoint.getStartTime() - endTime2;
            if (startTime > d) {
                return endTime;
            }
            endTime += cuePoint.getEndTime() - cuePoint.getStartTime();
            endTime2 = cuePoint.getEndTime();
        }
        return endTime;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.amh, com.google.ads.interactivemedia.v3.api.BaseManager
    public final void init(AdsRenderingSettings adsRenderingSettings) {
        super.init(adsRenderingSettings);
        anz anzVar = this.i;
        this.c.getDisableUi();
        anzVar.n();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final void replaceAdTagParameters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("adTagParameters", map);
        this.a.n(new amx(amv.adsManager, amw.replaceAdTagParameters, this.b, map2));
    }
}
