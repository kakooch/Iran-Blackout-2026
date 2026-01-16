package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import io.sentry.android.core.Y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class q implements ViewTreeObserver.OnDrawListener {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final AtomicReference b;
    private final Runnable c;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(q.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private q(View view, Runnable runnable) {
        this.b = new AtomicReference(view);
        this.c = runnable;
    }

    private static boolean c(View view) {
        return view.getViewTreeObserver().isAlive() && view.isAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Window window, Window.Callback callback, Runnable runnable, Y y) {
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView != null) {
            window.setCallback(callback);
            g(viewPeekDecorView, runnable, y);
        }
    }

    public static void f(Activity activity, final Runnable runnable, final Y y) {
        final Window window = activity.getWindow();
        if (window != null) {
            View viewPeekDecorView = window.peekDecorView();
            if (viewPeekDecorView != null) {
                g(viewPeekDecorView, runnable, y);
            } else {
                final Window.Callback callback = window.getCallback();
                window.setCallback(new io.sentry.android.core.performance.j(callback != null ? callback : new io.sentry.android.core.internal.gestures.b(), new Runnable() { // from class: io.sentry.android.core.internal.util.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.e(window, callback, runnable, y);
                    }
                }));
            }
        }
    }

    public static void g(View view, Runnable runnable, Y y) {
        q qVar = new q(view, runnable);
        if (y.d() >= 26 || c(view)) {
            view.getViewTreeObserver().addOnDrawListener(qVar);
        } else {
            view.addOnAttachStateChangeListener(qVar.new a());
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View view = (View) this.b.getAndSet(null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.sentry.android.core.internal.util.p
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.a.d(view);
            }
        });
        this.a.postAtFrontOfQueue(this.c);
    }
}
