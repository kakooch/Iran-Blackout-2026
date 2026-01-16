package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Message;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class afe implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
    final /* synthetic */ aff a;
    private final Handler b;

    public afe(aff affVar, MediaCodec mediaCodec) {
        this.a = affVar;
        Handler handlerL = aeu.l(this);
        this.b = handlerL;
        mediaCodec.setOnFrameRenderedListener(this, handlerL);
    }

    private final void a(long j) {
        aff affVar = this.a;
        if (this != affVar.b) {
            return;
        }
        if (j == Long.MAX_VALUE) {
            affVar.ax();
            return;
        }
        try {
            affVar.W(j);
        } catch (bn e) {
            this.a.ai(e);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        a(aeu.R(message.arg1, message.arg2));
        return true;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (aeu.a >= 30) {
            a(j);
        } else {
            this.b.sendMessageAtFrontOfQueue(Message.obtain(this.b, 0, (int) (j >> 32), (int) j));
        }
    }
}
