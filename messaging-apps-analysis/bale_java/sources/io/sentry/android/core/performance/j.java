package io.sentry.android.core.performance;

import android.view.Window;

/* loaded from: classes3.dex */
public class j extends io.sentry.android.core.internal.gestures.j {
    private final Runnable b;

    public j(Window.Callback callback, Runnable runnable) {
        super(callback);
        this.b = runnable;
    }

    @Override // io.sentry.android.core.internal.gestures.j, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.b.run();
    }
}
