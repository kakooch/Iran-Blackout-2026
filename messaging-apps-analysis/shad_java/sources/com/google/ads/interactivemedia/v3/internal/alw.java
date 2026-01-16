package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.List;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alw extends amh implements AdsManager {
    private List<Float> g;
    private ank h;

    /* JADX WARN: Multi-variable type inference failed */
    alw(String str, ane aneVar, BaseDisplayContainer baseDisplayContainer, ContentProgressProvider contentProgressProvider, List list, SortedSet sortedSet, anr anrVar, Context context, boolean z) throws AdError {
        super(str, aneVar, baseDisplayContainer, anrVar, context, z);
        this.g = list;
        if (sortedSet != null && !sortedSet.isEmpty()) {
            if (contentProgressProvider == null) {
                throw new AdError(AdError.AdErrorType.PLAY, AdError.AdErrorCode.PLAYLIST_NO_CONTENT_TRACKING, "Unable to handle cue points, no content progress provider configured.");
            }
            this.f = new anu(contentProgressProvider);
            amm ammVar = new amm(aneVar, sortedSet, str);
            this.d = ammVar;
            this.f.a(ammVar);
            this.f.c();
        }
        ank ankVar = new ank(str, aneVar, this, baseDisplayContainer);
        this.h = ankVar;
        addAdErrorListener(ankVar);
        aneVar.j(this.h, str);
    }

    private final void l() {
        if (this.e) {
            return;
        }
        this.e = true;
        e(amw.destroy);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.amh, com.google.ads.interactivemedia.v3.internal.anc
    public final void a(anb anbVar) {
        AdEvent.AdEventType adEventType = anbVar.a;
        AdEvent.AdEventType adEventType2 = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int iOrdinal = adEventType.ordinal();
        if (iOrdinal == 0) {
            super.a(anbVar);
            this.h.f();
            l();
            super.d();
            return;
        }
        if (iOrdinal == 6) {
            this.h.i();
            this.h.e();
        } else if (iOrdinal == 14) {
            this.h.i();
        } else if (iOrdinal == 15) {
            this.h.h(anbVar.b);
        }
        super.a(anbVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public final void b(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        this.h.j(resizeAndPositionVideoMsgData);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public final void c() {
        this.h.k();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void clicked() {
        this.a.n(new amx(amv.adsManager, amw.click, this.b));
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void destroy() {
        anu anuVar = this.f;
        if (anuVar != null) {
            anuVar.d();
        }
        l();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void discardAdBreak() {
        e(amw.discardAdBreak);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final List<Float> getAdCuePoints() {
        return this.g;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.e ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.h.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.amh, com.google.ads.interactivemedia.v3.api.BaseManager
    public final void init(AdsRenderingSettings adsRenderingSettings) {
        super.init(adsRenderingSettings);
        this.h.c(this.c.getDisableUi());
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return this.h.g();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void pause() {
        e(amw.pause);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void requestNextAdBreak() {
        if (this.f != null) {
            this.a.n(new amx(amv.contentTimeUpdate, amw.contentTimeUpdate, this.b, com.google.ads.interactivemedia.v3.impl.data.bo.create(this.f.e())));
            e(amw.requestNextAdBreak);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void resume() {
        e(amw.resume);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void skip() {
        e(amw.skip);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManager
    public final void start() {
        e(amw.start);
    }
}
