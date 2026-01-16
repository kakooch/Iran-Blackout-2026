package io.sentry.android.core;

import android.app.Activity;
import android.graphics.Bitmap;
import io.sentry.C3091b;
import io.sentry.L2;
import io.sentry.Y2;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class ScreenshotEventProcessor implements io.sentry.D {
    private final SentryAndroidOptions a;
    private final Y b;
    private final io.sentry.android.core.internal.util.m c = new io.sentry.android.core.internal.util.m(io.sentry.android.core.internal.util.g.b(), 2000, 3);

    public ScreenshotEventProcessor(SentryAndroidOptions sentryAndroidOptions, Y y) {
        this.a = (SentryAndroidOptions) io.sentry.util.u.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.b = (Y) io.sentry.util.u.c(y, "BuildInfoProvider is required");
        if (sentryAndroidOptions.isAttachScreenshot()) {
            io.sentry.util.o.a("Screenshot");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ byte[] e(Bitmap bitmap) {
        return io.sentry.android.core.internal.util.w.d(bitmap, this.a.getLogger());
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, io.sentry.I i) {
        final Bitmap bitmapC;
        if (!l2.A0()) {
            return l2;
        }
        if (!this.a.isAttachScreenshot()) {
            this.a.getLogger().c(Y2.DEBUG, "attachScreenshot is disabled.", new Object[0]);
            return l2;
        }
        Activity activityB = C3062l0.c().b();
        if (activityB != null && !io.sentry.util.m.i(i)) {
            boolean zA = this.c.a();
            this.a.getBeforeScreenshotCaptureCallback();
            if (zA || (bitmapC = io.sentry.android.core.internal.util.w.c(activityB, this.a.getThreadChecker(), this.a.getLogger(), this.b)) == null) {
                return l2;
            }
            i.m(C3091b.a(new Callable() { // from class: io.sentry.android.core.J0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.e(bitmapC);
                }
            }, "screenshot.png", "image/png", false));
            i.k("android:activity", activityB);
        }
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, io.sentry.I i) {
        return c;
    }
}
