package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class o extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private float c;
    private final w d;
    private final ek e;

    public o(Handler handler, Context context, ek ekVar, w wVar, byte[] bArr, byte[] bArr2) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.e = ekVar;
        this.d = wVar;
    }

    private final float c() {
        int streamVolume = this.b.getStreamVolume(3);
        int streamMaxVolume = this.b.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = streamVolume / streamMaxVolume;
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private final void d() {
        this.d.e(this.c);
    }

    public final void a() {
        this.c = c();
        d();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void b() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float fC = c();
        if (fC != this.c) {
            this.c = fC;
            d();
        }
    }
}
