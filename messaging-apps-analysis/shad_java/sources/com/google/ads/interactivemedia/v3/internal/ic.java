package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ic extends AudioTrack.StreamEventCallback {
    final /* synthetic */ id a;

    ic(id idVar) {
        this.a = idVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        ary.q(audioTrack == this.a.a.r);
        if (this.a.a.o == null || !this.a.a.R) {
            return;
        }
        this.a.a.o.c();
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        ary.q(audioTrack == this.a.a.r);
        if (this.a.a.o == null || !this.a.a.R) {
            return;
        }
        this.a.a.o.c();
    }
}
