package ir.nasim;

import android.animation.TimeInterpolator;
import android.os.SystemClock;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.Ys, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9151Ys {
    private View a;
    private Runnable b;
    private float c;
    private float d;
    private boolean e;
    private long f;
    private long g;
    private TimeInterpolator h;
    private boolean i;
    private long j;
    private float k;

    public C9151Ys(View view) {
        this.f = 0L;
        this.g = 200L;
        this.h = InterpolatorC12631ew1.f;
        this.a = view;
        this.e = true;
    }

    public float a() {
        return this.c;
    }

    public long b() {
        return this.g;
    }

    public float c(float f) {
        return d(f, false);
    }

    public float d(float f, boolean z) {
        if (z || this.g <= 0 || this.e) {
            this.d = f;
            this.c = f;
            this.i = false;
            this.e = false;
        } else if (Math.abs(this.d - f) > 1.0E-4f) {
            this.i = true;
            this.d = f;
            this.k = this.c;
            this.j = SystemClock.elapsedRealtime();
        }
        if (this.i) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            float fA = AbstractC22000uV3.a(((jElapsedRealtime - this.j) - this.f) / this.g, 0.0f, 1.0f);
            if (jElapsedRealtime - this.j >= this.f) {
                TimeInterpolator timeInterpolator = this.h;
                if (timeInterpolator == null) {
                    this.c = AbstractC21455b.T0(this.k, this.d, fA);
                } else {
                    this.c = AbstractC21455b.T0(this.k, this.d, timeInterpolator.getInterpolation(fA));
                }
            }
            if (fA >= 1.0f) {
                this.i = false;
            } else {
                View view = this.a;
                if (view != null) {
                    view.invalidate();
                }
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
        return this.c;
    }

    public float e(boolean z) {
        return d(z ? 1.0f : 0.0f, false);
    }

    public float f(boolean z, boolean z2) {
        return d(z ? 1.0f : 0.0f, z2);
    }

    public void g(long j) {
        this.g = j;
    }

    public C9151Ys(View view, long j, TimeInterpolator timeInterpolator) {
        this.f = 0L;
        this.g = 200L;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
        this.a = view;
        this.g = j;
        this.h = timeInterpolator;
        this.e = true;
    }

    public C9151Ys(View view, long j, long j2, TimeInterpolator timeInterpolator) {
        this.f = 0L;
        this.g = 200L;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
        this.a = view;
        this.f = j;
        this.g = j2;
        this.h = timeInterpolator;
        this.e = true;
    }

    public C9151Ys(Runnable runnable, long j, TimeInterpolator timeInterpolator) {
        this.f = 0L;
        this.g = 200L;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
        this.b = runnable;
        this.g = j;
        this.h = timeInterpolator;
        this.e = true;
    }

    public C9151Ys(float f, View view) {
        this.f = 0L;
        this.g = 200L;
        this.h = InterpolatorC12631ew1.f;
        this.a = view;
        this.d = f;
        this.c = f;
        this.e = false;
    }

    public C9151Ys(float f, View view, long j, long j2, TimeInterpolator timeInterpolator) {
        this.f = 0L;
        this.g = 200L;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
        this.a = view;
        this.d = f;
        this.c = f;
        this.f = j;
        this.g = j2;
        this.h = timeInterpolator;
        this.e = false;
    }

    public C9151Ys(float f, Runnable runnable, long j, long j2, TimeInterpolator timeInterpolator) {
        this.f = 0L;
        this.g = 200L;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
        this.b = runnable;
        this.d = f;
        this.c = f;
        this.f = j;
        this.g = j2;
        this.h = timeInterpolator;
        this.e = false;
    }
}
