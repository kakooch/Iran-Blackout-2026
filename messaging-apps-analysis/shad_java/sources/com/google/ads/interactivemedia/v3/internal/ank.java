package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ank implements aoa, alm {
    private final AdDisplayContainer a;
    private final VideoAdPlayer b;
    private final alw c;
    private final ane d;
    private final String e;
    private final aob f;
    private final aln g;
    private final arh<amv, AdMediaInfo> h = arh.p();
    private boolean i = false;

    public ank(String str, ane aneVar, alw alwVar, AdDisplayContainer adDisplayContainer) throws AdError {
        this.a = adDisplayContainer;
        VideoAdPlayer player = adDisplayContainer.getPlayer();
        this.b = player;
        this.c = alwVar;
        this.d = aneVar;
        this.e = str;
        this.f = new aob(aneVar.b(), adDisplayContainer.getAdContainer());
        aln alnVar = new aln(this);
        this.g = alnVar;
        player.addCallback(alnVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alm
    public final void a(amw amwVar, AdMediaInfo adMediaInfo, Object obj) {
        amv amvVar = this.h.j().get(adMediaInfo);
        if (amvVar != null) {
            this.d.n(new amx(amvVar, amwVar, this.e, obj));
            return;
        }
        String strValueOf = String.valueOf(amwVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 113);
        sb.append("The adMediaInfo for the ");
        sb.append(strValueOf);
        sb.append(" event is not active. This may occur if callbacks are triggered after the ad is unloaded.");
        yy.d(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alm
    public final void b(amv amvVar, amw amwVar) {
        this.d.n(new amx(amvVar, amwVar, "*"));
    }

    public final void c(boolean z) {
        this.i = z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aoa
    public final void d(amv amvVar, amw amwVar, com.google.ads.interactivemedia.v3.impl.data.bf bfVar) {
        AdMediaInfo adMediaInfo = this.h.get(amvVar);
        amw amwVar2 = amw.activate;
        int iOrdinal = amwVar.ordinal();
        if (iOrdinal != 33) {
            if (iOrdinal == 42) {
                if (bfVar == null || bfVar.videoUrl == null) {
                    this.c.f(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
                    return;
                }
                this.g.a();
                AdMediaInfo adMediaInfo2 = new AdMediaInfo(bfVar.videoUrl);
                com.google.ads.interactivemedia.v3.impl.data.d dVar = bfVar.adPodInfo;
                if (dVar == null) {
                    dVar = null;
                }
                this.h.put(amvVar, adMediaInfo2);
                this.b.loadAd(adMediaInfo2, dVar);
                return;
            }
            if (iOrdinal != 71) {
                if (iOrdinal == 51) {
                    this.b.pauseAd(adMediaInfo);
                    return;
                } else {
                    if (iOrdinal != 52) {
                        return;
                    }
                    this.b.playAd(adMediaInfo);
                    this.g.a();
                    return;
                }
            }
        }
        this.b.stopAd(adMediaInfo);
        this.h.remove(amvVar);
    }

    public final void e() {
        this.g.b();
    }

    public final void f() {
        yy.c("Destroying NativeVideoDisplay");
        this.f.b();
        this.b.removeCallback(this.g);
        this.b.release();
    }

    public final boolean g() {
        return this.b instanceof aoi;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.b.getAdProgress();
    }

    final void h(com.google.ads.interactivemedia.v3.impl.data.c cVar) {
        if (this.i && cVar.canDisableUi()) {
            cVar.setUiDisabled(true);
            return;
        }
        cVar.setUiDisabled(false);
        if (cVar.isLinear()) {
            this.f.a();
        }
    }

    final void i() {
        this.f.b();
    }

    final void j(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.b instanceof ResizablePlayer)) {
            yy.f("Video player does not support resizing.");
            return;
        }
        if (!yy.b(this.a, resizeAndPositionVideoMsgData)) {
            yy.f("Creative resize parameters were not within the containers bounds.");
            return;
        }
        int width = this.a.getAdContainer().getWidth();
        int height = this.a.getAdContainer().getHeight();
        int iIntValue = resizeAndPositionVideoMsgData.x().intValue();
        int iIntValue2 = resizeAndPositionVideoMsgData.width().intValue();
        int iIntValue3 = resizeAndPositionVideoMsgData.y().intValue();
        ((ResizablePlayer) this.b).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - iIntValue) - iIntValue2, (height - iIntValue3) - resizeAndPositionVideoMsgData.height().intValue());
    }

    final void k() {
        VideoAdPlayer videoAdPlayer = this.b;
        if (videoAdPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoAdPlayer).resize(0, 0, 0, 0);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        i();
    }
}
