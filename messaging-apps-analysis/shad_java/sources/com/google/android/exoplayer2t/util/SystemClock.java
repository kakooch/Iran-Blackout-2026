package com.google.android.exoplayer2t.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class SystemClock implements Clock {
    protected SystemClock() {
    }

    @Override // com.google.android.exoplayer2t.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2t.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2t.util.Clock
    public HandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
