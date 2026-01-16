package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class afi implements Choreographer.FrameCallback, Handler.Callback {
    private static final afi b = new afi();
    public volatile long a = -9223372036854775807L;
    private final Handler c;
    private final HandlerThread d;
    private Choreographer e;
    private int f;

    private afi() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.d = handlerThread;
        handlerThread.start();
        Handler handlerN = aeu.n(handlerThread.getLooper(), this);
        this.c = handlerN;
        handlerN.sendEmptyMessage(0);
    }

    public static afi a() {
        return b;
    }

    public final void b() {
        this.c.sendEmptyMessage(1);
    }

    public final void c() {
        this.c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a = j;
        this.e.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.e = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            int i2 = this.f + 1;
            this.f = i2;
            if (i2 == 1) {
                this.e.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        int i3 = this.f - 1;
        this.f = i3;
        if (i3 == 0) {
            this.e.removeFrameCallback(this);
            this.a = -9223372036854775807L;
        }
        return true;
    }
}
