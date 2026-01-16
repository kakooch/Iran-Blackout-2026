package org.linphone.core.tools.service;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public final class AndroidDispatcher {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    private AndroidDispatcher() {
    }

    public static void dispatchOnUIThread(Runnable runnable) {
        sHandler.post(runnable);
    }

    public static void dispatchOnUIThreadAfter(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static void removeFromUIThreadDispatcher(Runnable runnable) {
        sHandler.removeCallbacks(runnable);
    }
}
