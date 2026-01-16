package io.sentry.android.core.internal.gestures;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.C3155n3;
import io.sentry.O3;

/* loaded from: classes3.dex */
public final class h extends j {
    private final Window.Callback b;
    private final g c;
    private final GestureDetectorCompat d;
    private final C3155n3 e;
    private final b f;

    class a implements b {
        a() {
        }
    }

    interface b {
        default MotionEvent a(MotionEvent motionEvent) {
            return MotionEvent.obtain(motionEvent);
        }
    }

    public h(Window.Callback callback, Context context, g gVar, C3155n3 c3155n3) {
        this(callback, new GestureDetectorCompat(context, gVar, new Handler(Looper.getMainLooper())), gVar, c3155n3, new a());
    }

    private void b(MotionEvent motionEvent) {
        this.d.a(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.c.o(motionEvent);
        }
    }

    public Window.Callback a() {
        return this.b;
    }

    public void c() {
        this.c.q(O3.CANCELLED);
    }

    @Override // io.sentry.android.core.internal.gestures.j, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            try {
                b(this.f.a(motionEvent));
            } finally {
                try {
                } finally {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    h(Window.Callback callback, GestureDetectorCompat gestureDetectorCompat, g gVar, C3155n3 c3155n3, b bVar) {
        super(callback);
        this.b = callback;
        this.c = gVar;
        this.e = c3155n3;
        this.d = gestureDetectorCompat;
        this.f = bVar;
    }
}
