package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class id {
    final /* synthetic */ ie a;
    private final Handler b = new Handler();
    private final AudioTrack.StreamEventCallback c = new ic(this);

    public id(ie ieVar) {
        this.a = ieVar;
    }

    public final void a(AudioTrack audioTrack) {
        Handler handler = this.b;
        handler.getClass();
        audioTrack.registerStreamEventCallback(ib.a(handler), this.c);
    }

    public final void b(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.c);
        this.b.removeCallbacksAndMessages(null);
    }
}
