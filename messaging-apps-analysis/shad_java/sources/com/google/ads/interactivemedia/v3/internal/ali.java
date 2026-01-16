package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.ViewCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ali implements amz {
    private final ane a;
    private final String b;
    private final View c;
    private final alg d;
    private alf e;
    private Activity f;
    private boolean g;

    public ali(String str, ane aneVar, View view) {
        alh alhVar = new alh(null);
        this.b = str;
        this.a = aneVar;
        this.c = view;
        this.d = alhVar;
        this.f = null;
        this.e = null;
        this.g = false;
    }

    private static int n(int i, float f) {
        return (int) Math.ceil(i / f);
    }

    private static com.google.ads.interactivemedia.v3.impl.data.as o(com.google.ads.interactivemedia.v3.impl.data.as asVar, float f) {
        com.google.ads.interactivemedia.v3.impl.data.ar arVarBuilder = com.google.ads.interactivemedia.v3.impl.data.as.builder();
        arVarBuilder.left(n(asVar.left(), f));
        arVarBuilder.top(n(asVar.top(), f));
        arVarBuilder.height(n(asVar.height(), f));
        arVarBuilder.width(n(asVar.width(), f));
        return arVarBuilder.build();
    }

    private final DisplayMetrics p() {
        return this.c.getContext().getResources().getDisplayMetrics();
    }

    final void a(boolean z) {
        this.g = z;
    }

    public final void b() {
        this.a.h(this, this.b);
    }

    public final void c() {
        this.a.i(this.b);
    }

    public final void d() {
        Application applicationH;
        if (!this.g || (applicationH = yy.h(this.c.getContext())) == null) {
            return;
        }
        alf alfVar = new alf(this);
        this.e = alfVar;
        applicationH.registerActivityLifecycleCallbacks(alfVar);
    }

    public final void e() {
        alf alfVar;
        Application applicationH = yy.h(this.c.getContext());
        if (applicationH == null || (alfVar = this.e) == null) {
            return;
        }
        applicationH.unregisterActivityLifecycleCallbacks(alfVar);
    }

    public final com.google.ads.interactivemedia.v3.impl.data.b f(String str, String str2, String str3) {
        double d;
        com.google.ads.interactivemedia.v3.impl.data.as asVarO = o(com.google.ads.interactivemedia.v3.impl.data.as.builder().locationOnScreenOfView(this.c).build(), p().density);
        Rect rect = new Rect();
        boolean globalVisibleRect = this.c.getGlobalVisibleRect(rect);
        IBinder windowToken = this.c.getWindowToken();
        if (!globalVisibleRect || windowToken == null || !this.c.isShown()) {
            rect.set(0, 0, 0, 0);
        }
        com.google.ads.interactivemedia.v3.impl.data.ar arVarBuilder = com.google.ads.interactivemedia.v3.impl.data.as.builder();
        arVarBuilder.left(rect.left);
        arVarBuilder.top(rect.top);
        arVarBuilder.height(rect.height());
        arVarBuilder.width(rect.width());
        com.google.ads.interactivemedia.v3.impl.data.as asVarO2 = o(arVarBuilder.build(), p().density);
        boolean zIsAttachedToWindow = ViewCompat.isAttachedToWindow(this.c);
        boolean z = (this.c.getGlobalVisibleRect(new Rect()) && this.c.isShown()) ? false : true;
        AudioManager audioManager = (AudioManager) this.c.getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager != null) {
            double streamVolume = audioManager.getStreamVolume(3);
            double streamMaxVolume = audioManager.getStreamMaxVolume(3);
            Double.isNaN(streamVolume);
            Double.isNaN(streamMaxVolume);
            d = streamVolume / streamMaxVolume;
        } else {
            d = 0.0d;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.google.ads.interactivemedia.v3.impl.data.a aVarBuilder = com.google.ads.interactivemedia.v3.impl.data.b.builder();
        aVarBuilder.queryId(str);
        aVarBuilder.eventId(str2);
        aVarBuilder.appState(str3);
        aVarBuilder.nativeTime(jCurrentTimeMillis);
        aVarBuilder.nativeVolume(d);
        aVarBuilder.nativeViewAttached(zIsAttachedToWindow);
        aVarBuilder.nativeViewHidden(z);
        aVarBuilder.nativeViewBounds(asVarO);
        aVarBuilder.nativeViewVisibleBounds(asVarO2);
        return aVarBuilder.build();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.amz
    public final void g(String str, String str2) {
        this.a.n(new amx(amv.activityMonitor, amw.viewability, this.b, f(str, str2, BuildConfig.FLAVOR)));
    }
}
