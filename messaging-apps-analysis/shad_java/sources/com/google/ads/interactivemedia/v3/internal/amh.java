package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.BaseManager;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class amh implements BaseManager, anc, aol {
    protected final ane a;
    protected final String b;
    protected amm d;
    protected anu f;
    private final Context i;
    private com.google.ads.interactivemedia.v3.impl.data.c j;
    private AdProgressInfo k;
    private ali l;
    private anr m;
    private aom n;
    protected boolean e = false;
    private final List<AdEvent.AdEventListener> g = new ArrayList(1);
    private final amo h = new amo();
    protected AdsRenderingSettings c = new com.google.ads.interactivemedia.v3.impl.data.g();

    protected amh(String str, ane aneVar, BaseDisplayContainer baseDisplayContainer, anr anrVar, Context context, boolean z) throws AdError {
        this.b = str;
        this.a = aneVar;
        this.i = context;
        ali aliVar = new ali(str, aneVar, baseDisplayContainer.getAdContainer());
        this.l = aliVar;
        aliVar.a(z);
        if (anrVar == null) {
            anrVar = null;
        } else {
            anrVar.e(str);
            anrVar.d(baseDisplayContainer.getAdContainer());
            addAdEventListener(anrVar);
            addAdErrorListener(anrVar);
            amg amgVar = (amg) baseDisplayContainer;
            Iterator<FriendlyObstruction> it = amgVar.b().iterator();
            while (it.hasNext()) {
                anrVar.g(it.next());
            }
            amgVar.c(anrVar);
        }
        this.m = anrVar;
        aneVar.f(this, str);
        this.l.b();
        Application applicationH = yy.h(context);
        if (applicationH != null) {
            aom aomVar = new aom(applicationH);
            this.n = aomVar;
            aomVar.a(this);
        }
    }

    private final void l(AdErrorEvent adErrorEvent) {
        this.k = null;
        f(adErrorEvent);
    }

    private final boolean m() {
        return this.c.getFocusSkipButtonWhenAvailable();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.google.ads.interactivemedia.v3.internal.anb r6) {
        /*
            r5 = this;
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = r6.a
            com.google.ads.interactivemedia.v3.impl.data.c r1 = r6.b
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r2 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            int r2 = r0.ordinal()
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L62
            r3 = 24
            if (r2 == r3) goto L62
            r3 = 5
            if (r2 == r3) goto L55
            r3 = 6
            if (r2 == r3) goto L48
            r3 = 20
            if (r2 == r3) goto L45
            r3 = 21
            if (r2 == r3) goto L40
            switch(r2) {
                case 13: goto L34;
                case 14: goto L62;
                case 15: goto L24;
                default: goto L23;
            }
        L23:
            goto L64
        L24:
            if (r1 == 0) goto L28
            r5.j = r1
        L28:
            boolean r1 = r5.m()
            if (r1 == 0) goto L64
            java.lang.String r1 = r5.b
            r5.g(r1)
            goto L64
        L34:
            boolean r1 = r5.m()
            if (r1 == 0) goto L64
            java.lang.String r1 = r5.b
            r5.g(r1)
            goto L64
        L40:
            com.google.ads.interactivemedia.v3.api.AdProgressInfo r1 = r6.e
            r5.k = r1
            goto L64
        L45:
            r5.j = r1
            goto L64
        L48:
            com.google.ads.interactivemedia.v3.internal.anu r1 = r5.f
            if (r1 == 0) goto L4f
            r1.c()
        L4f:
            com.google.ads.interactivemedia.v3.internal.ali r1 = r5.l
            r1.e()
            goto L64
        L55:
            com.google.ads.interactivemedia.v3.internal.anu r1 = r5.f
            if (r1 == 0) goto L5c
            r1.d()
        L5c:
            com.google.ads.interactivemedia.v3.internal.ali r1 = r5.l
            r1.d()
            goto L64
        L62:
            r5.k = r4
        L64:
            java.util.Map<java.lang.String, java.lang.String> r6 = r6.c
            com.google.ads.interactivemedia.v3.internal.all r1 = new com.google.ads.interactivemedia.v3.internal.all
            com.google.ads.interactivemedia.v3.impl.data.c r2 = r5.j
            r1.<init>(r0, r2, r6)
            java.util.List<com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener> r6 = r5.g
            java.util.Iterator r6 = r6.iterator()
        L73:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r2 = r6.next()
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener r2 = (com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener) r2
            r2.onAdEvent(r1)
            goto L73
        L83:
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.COMPLETED
            if (r0 == r6) goto L8d
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.SKIPPED
            if (r0 != r6) goto L8c
            goto L8d
        L8c:
            return
        L8d:
            r5.j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.amh.a(com.google.ads.interactivemedia.v3.internal.anb):void");
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.h.a(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void addAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.g.add(adEventListener);
    }

    protected void d() {
        anr anrVar = this.m;
        if (anrVar != null && anrVar.f()) {
            Log.d("IMASDK", "OMID ad session ended on BaseManager destroy.");
        }
        anu anuVar = this.f;
        if (anuVar != null) {
            anuVar.d();
        }
        this.g.clear();
        this.h.c();
        this.l.c();
        this.a.l(this.b);
        this.j = null;
        aom aomVar = this.n;
        if (aomVar != null) {
            aomVar.b();
        }
    }

    protected final void e(amw amwVar) {
        this.a.n(new amx(amv.adsManager, amwVar, this.b));
    }

    final void f(AdErrorEvent adErrorEvent) {
        this.h.d(adErrorEvent);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void focus() {
        g(this.b);
    }

    protected final void g(String str) {
        if (yy.g(this.i, this.a.c())) {
            this.a.b().requestFocus();
            this.a.n(new amx(amv.userInteraction, amw.focusUiElement, str));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public AdProgressInfo getAdProgressInfo() {
        return this.k;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public Ad getCurrentAd() {
        return this.j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public void h(AdError.AdErrorType adErrorType, int i, String str) {
        l(new alk(new AdError(adErrorType, i, str)));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.anc
    public void i(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str) {
        l(new alk(new AdError(adErrorType, adErrorCode, str)));
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void init() {
        init(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aol
    public void j() {
        this.a.n(new amx(amv.adsManager, amw.appBackgrounding, this.b));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aol
    public void k() {
        this.a.n(new amx(amv.adsManager, amw.appForegrounding, this.b));
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.h.b(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void removeAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.g.remove(adEventListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void init(AdsRenderingSettings adsRenderingSettings) {
        if (adsRenderingSettings != null) {
            this.c = adsRenderingSettings;
        }
        HashMap map = new HashMap();
        map.put("adsRenderingSettings", com.google.ads.interactivemedia.v3.impl.data.f.builder(this.c).build());
        anu anuVar = this.f;
        if (anuVar != null) {
            VideoProgressUpdate videoProgressUpdateE = anuVar.e();
            if (!videoProgressUpdateE.equals(VideoProgressUpdate.VIDEO_TIME_NOT_READY)) {
                double currentTime = videoProgressUpdateE.getCurrentTime();
                StringBuilder sb = new StringBuilder(68);
                sb.append("AdsManager.init -> Setting contentStartTime ");
                sb.append(currentTime);
                Log.d("IMASDK", sb.toString());
                map.put("contentStartTime", Double.valueOf(currentTime));
            }
        }
        this.a.n(new amx(amv.adsManager, amw.init, this.b, map));
    }
}
