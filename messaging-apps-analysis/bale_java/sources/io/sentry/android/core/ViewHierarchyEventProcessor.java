package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import io.sentry.C3091b;
import io.sentry.ILogger;
import io.sentry.L2;
import io.sentry.Y2;
import ir.nasim.AbstractC18350oW3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ViewHierarchyEventProcessor implements io.sentry.D {
    private final SentryAndroidOptions a;
    private final io.sentry.android.core.internal.util.m b = new io.sentry.android.core.internal.util.m(io.sentry.android.core.internal.util.g.b(), 2000, 3);

    public ViewHierarchyEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.a = (SentryAndroidOptions) io.sentry.util.u.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            io.sentry.util.o.a("ViewHierarchy");
        }
    }

    private static void e(View view, io.sentry.protocol.I i, List list) {
        if (view instanceof ViewGroup) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                throw null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(childCount);
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    io.sentry.protocol.I i3 = i(childAt);
                    arrayList.add(i3);
                    e(childAt, i3, list);
                }
            }
            i.m(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AtomicReference atomicReference, View view, List list, CountDownLatch countDownLatch, ILogger iLogger) {
        try {
            atomicReference.set(h(view, list));
            countDownLatch.countDown();
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    public static io.sentry.protocol.H g(Activity activity, final List list, io.sentry.util.thread.a aVar, final ILogger iLogger) {
        if (activity == null) {
            iLogger.c(Y2.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.c(Y2.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        final View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            iLogger.c(Y2.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Failed to process view hierarchy.", th);
        }
        if (aVar.a()) {
            return h(viewPeekDecorView, list);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference(null);
        activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.a1
            @Override // java.lang.Runnable
            public final void run() {
                ViewHierarchyEventProcessor.f(atomicReference, viewPeekDecorView, list, countDownLatch, iLogger);
            }
        });
        if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
            return (io.sentry.protocol.H) atomicReference.get();
        }
        return null;
    }

    public static io.sentry.protocol.H h(View view, List list) {
        ArrayList arrayList = new ArrayList(1);
        io.sentry.protocol.H h = new io.sentry.protocol.H("android_view_system", arrayList);
        io.sentry.protocol.I i = i(view);
        arrayList.add(i);
        e(view, i, list);
        return h;
    }

    private static io.sentry.protocol.I i(View view) {
        io.sentry.protocol.I i = new io.sentry.protocol.I();
        i.p(io.sentry.android.core.internal.util.j.a(view));
        try {
            i.o(io.sentry.android.core.internal.gestures.i.b(view));
        } catch (Throwable unused) {
        }
        i.t(Double.valueOf(view.getX()));
        i.u(Double.valueOf(view.getY()));
        i.s(Double.valueOf(view.getWidth()));
        i.n(Double.valueOf(view.getHeight()));
        i.l(Double.valueOf(view.getAlpha()));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            i.r("visible");
        } else if (visibility == 4) {
            i.r("invisible");
        } else if (visibility == 8) {
            i.r("gone");
        }
        return i;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, io.sentry.I i) {
        io.sentry.protocol.H hG;
        if (!l2.A0()) {
            return l2;
        }
        if (!this.a.isAttachViewHierarchy()) {
            this.a.getLogger().c(Y2.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return l2;
        }
        if (io.sentry.util.m.i(i)) {
            return l2;
        }
        boolean zA = this.b.a();
        this.a.getBeforeViewHierarchyCaptureCallback();
        if (!zA && (hG = g(C3062l0.c().b(), this.a.getViewHierarchyExporters(), this.a.getThreadChecker(), this.a.getLogger())) != null) {
            i.o(C3091b.c(hG));
        }
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, io.sentry.I i) {
        return c;
    }
}
