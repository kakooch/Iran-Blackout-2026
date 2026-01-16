package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* loaded from: classes2.dex */
final class c {
    private final ViewPager2 a;
    private final e b;
    private final RecyclerView c;
    private VelocityTracker d;
    private int e;
    private float f;
    private int g;
    private long h;

    c(ViewPager2 viewPager2, e eVar, RecyclerView recyclerView) {
        this.a = viewPager2;
        this.b = eVar;
        this.c = recyclerView;
    }

    private void a(long j, int i, float f, float f2) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.h, j, i, f, f2, 0);
        this.d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void c() {
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.d = VelocityTracker.obtain();
            this.e = ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    boolean b() {
        if (this.b.i()) {
            return false;
        }
        this.g = 0;
        this.f = 0;
        this.h = SystemClock.uptimeMillis();
        c();
        this.b.m();
        if (!this.b.k()) {
            this.c.stopScroll();
        }
        a(this.h, 0, 0.0f, 0.0f);
        return true;
    }

    boolean d() {
        if (!this.b.j()) {
            return false;
        }
        this.b.o();
        VelocityTracker velocityTracker = this.d;
        velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.e);
        if (this.c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.a.p();
        return true;
    }

    boolean e(float f) {
        if (!this.b.j()) {
            return false;
        }
        float f2 = this.f - f;
        this.f = f2;
        int iRound = Math.round(f2 - this.g);
        this.g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.a.getOrientation() == 0;
        int i = z ? iRound : 0;
        int i2 = z ? 0 : iRound;
        float f3 = z ? this.f : 0.0f;
        float f4 = z ? 0.0f : this.f;
        this.c.scrollBy(i, i2);
        a(jUptimeMillis, 2, f3, f4);
        return true;
    }

    boolean f() {
        return this.b.j();
    }
}
