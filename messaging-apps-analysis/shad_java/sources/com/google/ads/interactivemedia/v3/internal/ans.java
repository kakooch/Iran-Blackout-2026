package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ans {
    private final Handler a;

    public ans(Handler handler) {
        this.a = handler;
    }

    protected final void a() {
        this.a.removeMessages(1);
    }

    protected final void b() {
        this.a.sendEmptyMessage(0);
    }

    protected final void c() {
        Handler handler = this.a;
        handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 2));
    }

    protected final void d(long j) {
        this.a.sendEmptyMessageDelayed(1, j);
    }
}
