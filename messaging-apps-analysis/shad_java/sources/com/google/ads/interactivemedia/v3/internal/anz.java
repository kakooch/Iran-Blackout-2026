package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anz implements VideoStreamPlayer.VideoStreamPlayerCallback, aoa, ant {
    private VideoStreamPlayer a;
    private ane b;
    private final anw c;
    private boolean d;
    private aob e;
    private final String f;
    private String g;
    private final StreamDisplayContainer h;
    private anu i;

    public anz(String str, ane aneVar, anw anwVar, StreamDisplayContainer streamDisplayContainer, String str2) throws AdError {
        this.d = false;
        VideoStreamPlayer videoStreamPlayer = streamDisplayContainer.getVideoStreamPlayer();
        this.a = videoStreamPlayer;
        if (videoStreamPlayer == null) {
            throw new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Server-side ad insertion player was not provided.");
        }
        this.c = anwVar;
        this.f = str;
        this.b = aneVar;
        this.g = str2;
        this.d = false;
        this.h = streamDisplayContainer;
        this.i = null;
        this.i = new anu(videoStreamPlayer);
        this.e = null;
        this.e = new aob(aneVar.b(), streamDisplayContainer.getAdContainer());
    }

    private final void o(amw amwVar, Object obj) {
        this.b.n(new amx(amv.videoDisplay1, amwVar, this.f, obj));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ant
    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (!this.d) {
            o(amw.start, com.google.ads.interactivemedia.v3.impl.data.bt.builder().volumePercentage(this.a.getVolume()).build());
            this.d = true;
        }
        o(amw.timeupdate, com.google.ads.interactivemedia.v3.impl.data.bo.create(videoProgressUpdate));
    }

    public final void b() {
        yy.c("Destroying StreamVideoDisplay");
        this.a.removeCallback(this);
        this.a = null;
        this.b = null;
        anu anuVar = this.i;
        if (anuVar != null) {
            anuVar.d();
            this.i.b(this);
        }
        this.i = null;
        this.e.b();
    }

    public final void c() {
        this.a.onAdBreakStarted();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aoa
    public final void d(amv amvVar, amw amwVar, com.google.ads.interactivemedia.v3.impl.data.bf bfVar) {
        String str;
        amw amwVar2 = amw.activate;
        int iOrdinal = amwVar.ordinal();
        if (iOrdinal != 44) {
            if (iOrdinal == 51) {
                this.a.pause();
                return;
            } else {
                if (iOrdinal != 52) {
                    return;
                }
                this.a.resume();
                return;
            }
        }
        if (bfVar == null || bfVar.streamUrl == null) {
            this.c.f(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
            return;
        }
        int i = 0;
        this.d = false;
        this.i.c();
        String string = bfVar.streamUrl;
        if (string != null && (str = this.g) != null && str.length() != 0) {
            String strTrim = this.g.trim();
            String string2 = BuildConfig.FLAVOR;
            String strReplaceAll = strTrim.replaceAll("\\s+", BuildConfig.FLAVOR);
            if (strReplaceAll.charAt(0) == '?') {
                strReplaceAll = strReplaceAll.substring(1);
            }
            if (strReplaceAll.length() != 0) {
                Map<String, String> mapA = yy.a(Uri.parse(string));
                HashMap map = new HashMap();
                Uri.Builder builderBuildUpon = Uri.parse(string).buildUpon();
                builderBuildUpon.clearQuery();
                Map<String, String> mapA2 = yy.a(Uri.parse(strReplaceAll.length() != 0 ? "http://www.dom.com/path?".concat(strReplaceAll) : new String("http://www.dom.com/path?")));
                map.putAll(mapA2);
                if (!mapA.isEmpty()) {
                    for (String str2 : mapA.keySet()) {
                        if (!mapA2.containsKey(str2)) {
                            map.put(str2, mapA.get(str2));
                        }
                    }
                }
                if (map.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : map.entrySet()) {
                        String str3 = (String) entry.getKey();
                        String str4 = (String) entry.getValue();
                        sb.append(str3);
                        sb.append("=");
                        sb.append(str4);
                        if (i < map.size() - 1) {
                            sb.append("&");
                        }
                        i++;
                    }
                    string2 = sb.toString();
                }
                builderBuildUpon.encodedQuery(string2);
                string = builderBuildUpon.build().toString();
            }
        }
        this.a.loadUrl(string, bfVar.subtitles);
    }

    public final void e() {
        this.a.onAdBreakEnded();
        k();
    }

    public final void f() {
        this.a.onAdPeriodStarted();
    }

    public final void g() {
        this.a.onAdPeriodEnded();
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.a.getContentProgress();
    }

    public final void h(long j) {
        this.a.seek(j);
    }

    public final void i() {
        this.a.addCallback(this);
    }

    final void j(com.google.ads.interactivemedia.v3.impl.data.c cVar) {
        if (cVar.isLinear()) {
            this.e.a();
        }
    }

    final void k() {
        this.e.b();
    }

    public final void l(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.a instanceof ResizablePlayer)) {
            yy.f("Stream player does not support resizing.");
            return;
        }
        if (!yy.b(this.h, resizeAndPositionVideoMsgData)) {
            yy.f("Video resize parameters were not within the container bounds.");
            return;
        }
        int width = this.h.getAdContainer().getWidth();
        int height = this.h.getAdContainer().getHeight();
        int iIntValue = resizeAndPositionVideoMsgData.x().intValue();
        int iIntValue2 = resizeAndPositionVideoMsgData.width().intValue();
        int iIntValue3 = resizeAndPositionVideoMsgData.y().intValue();
        ((ResizablePlayer) this.a).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - iIntValue) - iIntValue2, (height - iIntValue3) - resizeAndPositionVideoMsgData.height().intValue());
    }

    public final void m() {
        VideoStreamPlayer videoStreamPlayer = this.a;
        if (videoStreamPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoStreamPlayer).resize(0, 0, 0, 0);
        }
    }

    public final void n() {
        this.i.a(this);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onContentComplete() {
        this.b.n(new amx(amv.adsLoader, amw.contentComplete, "*"));
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onPause() {
        o(amw.pause, null);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onResume() {
        o(amw.play, null);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onUserTextReceived(String str) {
        o(amw.timedMetadata, any.create(str));
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onVolumeChanged(int i) {
        o(amw.volumeChange, com.google.ads.interactivemedia.v3.impl.data.bt.builder().volumePercentage(i).build());
    }
}
